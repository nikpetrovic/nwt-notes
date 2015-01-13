/**
 * 
 */
package org.nikpetrovic.nwtnotes.parser;

import java.io.IOException;
import java.util.List;

import org.jsoup.nodes.Document;
import org.junit.Test;
import org.nikpetrovic.nwtnotes.AppConfig;
import org.nikpetrovic.nwtnotes.entities.Bible;
import org.nikpetrovic.nwtnotes.entities.BibleBook;
import org.nikpetrovic.nwtnotes.entities.BibleBookCh;
import org.nikpetrovic.nwtnotes.entities.BibleBookCode;
import org.nikpetrovic.nwtnotes.parsing.ChapterResolver;
import org.nikpetrovic.nwtnotes.service.IBibleBookChService;
import org.nikpetrovic.nwtnotes.service.IBibleBookCodeService;
import org.nikpetrovic.nwtnotes.service.IBibleBookService;
import org.nikpetrovic.nwtnotes.service.IBibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @author nikolapetrovic
 * @created Jan 1, 2015
 *
 */
public class ChapterResolverTest extends AbstractTest {
    @Autowired
    private AppConfig _appConfig;

    @Autowired
    private IBibleBookCodeService _bibleBookCodeService;

    @Autowired
    private IBibleBookService _bibleBookService;

    @Autowired
    private IBibleService _bibleService;

    @Autowired
    private IBibleBookChService _bibleBookChService;

    @Test
    public void selectParagraphsTest01() throws IOException {
	Document doc = loadTestFile("Genesis_1_en-web-page.html");
	ChapterResolver res = new ChapterResolver(doc, 1, _appConfig);
	BibleBookCh resolve = res.resolve();

	Assert.notNull(resolve);
    }

    @Test
    public void selectParagraphsTest02() throws IOException {
	Document doc = loadTestFile("Genesis_36_sr-web-page.html");
	ChapterResolver res = new ChapterResolver(doc, 36, _appConfig);
	BibleBookCh resolve = res.resolve();

	Assert.notNull(resolve);
    }

    @Test
    public void selectParagraphsTest03() throws IOException {
	Document doc = loadTestFile("Psalms_117_en-web-page.html");
	ChapterResolver res = new ChapterResolver(doc, 117, _appConfig);
	BibleBookCh resolve = res.resolve();

	Assert.notNull(resolve);
    }

    @Test
    public void selectParagraphsTest04() throws IOException {
	Document doc = loadTestFile("Matthew_27_en-web-page.html");
	ChapterResolver res = new ChapterResolver(doc, 27, _appConfig);
	BibleBookCh bbCh = res.resolve();

	Assert.notNull(bbCh);
    }

    @Test
    public void selectParagraphsTest05() throws IOException {
	Document doc = loadTestFile("Jeremiah_10_en-web-page.html");
	ChapterResolver res = new ChapterResolver(doc, 10, _appConfig);
	BibleBookCh bbCh = res.resolve();

	Assert.notNull(bbCh);
    }

    @Test
    public void selectParagraphsTest06() throws IOException {
	Document doc = loadTestFile("John_8_en-web-page.html");
	ChapterResolver res = new ChapterResolver(doc, 8, _appConfig);
	BibleBookCh bbCh = res.resolve();

	Assert.notNull(bbCh);
    }
    
    @Test
    public void selectParagraphsTest07() throws IOException {
	Document doc = loadTestFile("Psalms_119_en-web-page.html");
	ChapterResolver res = new ChapterResolver(doc, 119, _appConfig);
	BibleBookCh resolve = res.resolve();

	Assert.notNull(resolve);
    }

//    @Test
//    public void selectParagraphsTest08() throws IOException {
//	Document doc = loadTestFile("Job_42_sr-web-page.html");
//	ChapterResolver res = new ChapterResolver(doc, 42, _appConfig);
//	BibleBookCh bbCh = res.resolve();
//
//	Assert.notNull(bbCh);
//	int bookNo = 18;
//	Bible bible = _bibleService.findById(2);
//	BibleBook bibleBook = getBibleBookByBookNoFromBible(bookNo, bible);
//
//	bbCh.setBibleBook(bibleBook);
//	_bibleBookChService.save(bbCh);
//    }
//
//    private BibleBook getBibleBookByBookNoFromBible(int startBookNo, Bible bible) {
//	if (bible == null || bible.getBibleBooks() == null
//		|| bible.getBibleBooks().size() == 0) {
//	    return null;
//	}
//
//	BibleBook bibleBook = null;
//	for (BibleBook bb : bible.getBibleBooks()) {
//	    if (bb.getBibleBookCode().getOrderNo() == startBookNo) {
//		bibleBook = bb;
//		break;
//	    }
//	}
//
//	return bibleBook;
//    }

}
