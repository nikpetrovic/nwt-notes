/**
 * 
 */
package org.nikpetrovic.nwtnotes.jworg;

import java.io.IOException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.nikpetrovic.nwtnotes.AppConfig;
import org.nikpetrovic.nwtnotes.entities.Bible;
import org.nikpetrovic.nwtnotes.entities.BibleBook;
import org.nikpetrovic.nwtnotes.entities.BibleBookCh;
import org.nikpetrovic.nwtnotes.entities.BibleBookCode;
import org.nikpetrovic.nwtnotes.parsing.ChapterResolver;
import org.nikpetrovic.nwtnotes.service.IBibleBookChService;
import org.nikpetrovic.nwtnotes.service.IBibleBookCodeService;
import org.nikpetrovic.nwtnotes.service.IBibleBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author nikolapetrovic
 * @created Dec 17, 2014
 *
 */
@Component
public class BookDownloader {
    private static final Log LOGGER = LogFactory.getLog(BookDownloader.class);

    @Autowired
    private AppConfig _appConfig;

    @Autowired
    private IBibleBookChService _bibleBookChService;

    @Autowired
    private IBibleBookCodeService _bibleBookCodeService;

    @Autowired
    private IBibleBookService _bibleBookService;

    public void download(String urlPattern, Bible bible, int startBookNo,
	    int startingChapter) throws IOException {
	List<BibleBookCode> bibleBookCodes = _bibleBookCodeService.findAll();
	bibleBookCodes.sort((bbc1, bbc2) -> Integer.compare(bbc1.getOrderNo(),
		bbc2.getOrderNo()));

	for (int bookNo = startBookNo; bookNo < bibleBookCodes.size() + 1; bookNo++) {
	    BibleBook bibleBook = getBibleBookByBookNoFromBible(bookNo, bible);
	    if (bibleBook == null) {
		bibleBook = getBibleBookByBookNoFromBibleBookCodes(bookNo,
			bibleBookCodes);
		bibleBook.setBible(bible);
		_bibleBookService.save(bibleBook);

		// reset startingChapter
		startingChapter = 1;
	    } else {
		BibleBookCh lastDownloadedCh = _bibleBookChService
			.findLastDownloadedByBibleBook(bibleBook);
		if (lastDownloadedCh != null) {
		    startingChapter = lastDownloadedCh.getChNo() + 1;
		} else {
		    startingChapter = 1;
		}
	    }

	    BibleBookCode bibleBookCode = bibleBookCodes.get(bookNo - 1);
	    for (int i = startingChapter; i < bibleBookCode.getChNo() + 1; i++) {
		Document document = Jsoup.connect(
			String.format(_appConfig.getBaseProcessingLink()
				+ urlPattern, bookNo, i)).get();
		ChapterResolver chRes = new ChapterResolver(document, i,
			_appConfig);
		BibleBookCh bbCh = chRes.resolve();

		bbCh.setBibleBook(bibleBook);
		_bibleBookChService.save(bbCh);

		LOGGER.debug(String.format("Downloaded: %s, %d",
			bibleBookCode.getName(), i));
	    }
	}
    }

    private BibleBook getBibleBookByBookNoFromBible(int startBookNo, Bible bible) {
	if (bible == null || bible.getBibleBooks() == null
		|| bible.getBibleBooks().size() == 0) {
	    return null;
	}

	BibleBook bibleBook = null;
	for (BibleBook bb : bible.getBibleBooks()) {
	    if (bb.getBibleBookCode().getOrderNo() == startBookNo) {
		bibleBook = bb;
		break;
	    }
	}

	return bibleBook;
    }

    private BibleBook getBibleBookByBookNoFromBibleBookCodes(int startBookNo,
	    List<BibleBookCode> bibleBookCodes) {
	BibleBook bibleBook = null;
	for (BibleBookCode bbc : bibleBookCodes) {
	    if (bbc.getOrderNo() == startBookNo) {
		bibleBook = new BibleBook();
		bibleBook.setBibleBookCode(bbc);
		break;
	    }
	}
	return bibleBook;
    }
}
