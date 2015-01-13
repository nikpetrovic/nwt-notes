/**
 * 
 */
package org.nikpetrovic.nwtnotes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nikpetrovic.nwtnotes.entities.Bible;
import org.nikpetrovic.nwtnotes.entities.BibleBook;
import org.nikpetrovic.nwtnotes.entities.BibleBookCh;
import org.nikpetrovic.nwtnotes.entities.BibleBookCode;
import org.nikpetrovic.nwtnotes.entities.Language;
import org.nikpetrovic.nwtnotes.jworg.BookDownloader;
import org.nikpetrovic.nwtnotes.parsing.BibleContext;
import org.nikpetrovic.nwtnotes.service.IBibleBookChService;
import org.nikpetrovic.nwtnotes.service.IBibleBookCodeService;
import org.nikpetrovic.nwtnotes.service.IBibleBookService;
import org.nikpetrovic.nwtnotes.service.IBibleService;
import org.nikpetrovic.nwtnotes.service.ILanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author nikolapetrovic
 * @created Jan 2, 2015
 *
 */
@Component
public class SetupBean {
    private static final String AVAILABLE_LANGS[] = { "en-US", "sr-RS", "de-DE" };

    private static final Log LOGGER = LogFactory.getLog(SetupBean.class);

    @Autowired
    private AppConfig _appConfig;

    @Autowired
    private IBibleBookChService _bibleBookChService;

    @Autowired
    private IBibleBookCodeService _bibleBookCodeService;

    @Autowired
    private IBibleBookService _bibleBookService;

    @Autowired
    private IBibleService _bibleService;

    @Autowired
    private BookDownloader _bookDownloader;

    @Autowired
    private ILanguageService _languageService;

    @PostConstruct
    public void init() {
	LOGGER.info("################ INITIALIZATION STARTED ###################");

	initializeLanguages();

	initializeBibleBookCodes();

//	int attempts = 0;
//	while (attempts < 20) {
	    try {
//		LOGGER.debug("Attempt: " + attempts + 1);
		downloadBibles();
	    } catch (IOException e) {
//		LOGGER.error("Error downloading bible(s).", e);
//		attempts++;
	    }
//	}

	LOGGER.info("############### INITIALIZATION FINISHED ###################");
    }

    private void downloadBibleIfNecessary(Language language,
	    List<Bible> downloadedBibles) throws IOException {
	boolean noDownloadedBooks = downloadedBibles == null
		|| downloadedBibles.size() == 0;
	int startCh = 1;
	int startBookNo = 1;
	Bible bible = null;
	if (!noDownloadedBooks) {
	    bible = getBibleByLanguage(language, downloadedBibles);
	    if (bible != null) {
		BibleBook lastDownloadedBook = getLastDownloadedBibleBook(bible);
		if (lastDownloadedBook != null) {
		    startBookNo = lastDownloadedBook.getBibleBookCode()
			    .getOrderNo();
		    BibleBookCh lastDownloadedCh = _bibleBookChService
			    .findLastDownloadedByBibleBook(lastDownloadedBook);
		    if (lastDownloadedCh != null) {
			startCh = lastDownloadedCh.getChNo() + 1;
		    }
		}
	    }
	}

	if (bible == null) {
	    bible = getBible(language);
	    bible = _bibleService.save(bible);
	}

	LOGGER.info(String
		.format("Trying to download chapter %d of the book %d for language %s.",
			startCh, startBookNo, language.getDisplayName()));

	_bookDownloader.download(getUrlPattern(language), bible, startBookNo,
		startCh);
    }

    private void downloadBibles() throws IOException {
	List<Language> availableLangs = _languageService.findAll();
	List<Bible> downloadedBibles = _bibleService.findAll();
	for (Language lang : availableLangs) {
	    downloadBibleIfNecessary(lang, downloadedBibles);
	}
    }

    private Bible getBible(Language language) {
	if (language.getCode().contains("en")) {
	    Bible bible = new Bible();
	    bible.setLanguage(language);
	    bible.setYear("2013");
	    bible.setTitle("New World Translation");
	    bible.setDescription("New World Translation");
	    return bible;
	} else if (language.getCode().contains("sr")) {
	    Bible bible = new Bible();
	    bible.setLanguage(language);
	    bible.setYear("2006");
	    bible.setTitle("Превод Нови свет");
	    bible.setDescription("Превод Нови свет (bi12)");
	    return bible;
	} else if (language.getCode().contains("de")) {
	    Bible bible = new Bible();
	    bible.setLanguage(language);
	    bible.setYear("1986");
	    bible.setTitle("Studienbibel");
	    bible.setDescription("Studienbibel (Rbi8)");
	    return bible;
	}
	return null;
    }

    private Bible getBibleByLanguage(Language language,
	    List<Bible> downloadedBibles) {
	for (Bible bible : downloadedBibles) {
	    if (bible.getLanguage().equals(language)) {
		return bible;
	    }
	}

	return null;
    }

    private BibleBook getLastDownloadedBibleBook(Bible bible) {
	return _bibleBookService.findLastDownloadedByBible(bible);
    }

    private String getUrlPattern(Language language) {
	if (language.getCode().contains("en")) {
	    return _appConfig.getEnBibleUrlPattern();
	} else if (language.getCode().contains("sr")) {
	    return _appConfig.getSrBiblePattern();
	} else if (language.getCode().contains("de")) {
	    return _appConfig.getDeBiblePattern();
	}
	return null;
    }

    private void initializeBibleBookCodes() {
	LOGGER.info("--------------- BIBLE BOOK CODES INITIALIZATION STARTED ---------------");

	List<BibleBookCode> allbbcodes = _bibleBookCodeService.findAll();
	if (allbbcodes == null || allbbcodes.size() == 0) {
	    _bibleBookCodeService.saveAll(BibleContext
		    .getBibleBookChaptersMap().values());
	}

	LOGGER.info("--------------- BIBLE BOOK CODES INITIALIZATION FINISHED ---------------");
    }

    private void initializeLanguages() {
	LOGGER.info("--------------- LANGUAGE INITIALIZATION STARTED ---------------");
	List<Language> allLangs = _languageService.findAll();
	if (allLangs == null || allLangs.size() == 0) {
	    List<Language> languages = new ArrayList<Language>();
	    for (String avLang : AVAILABLE_LANGS) {
		Locale loc = Locale.forLanguageTag(avLang);
		Language l = new Language();
		l.setCode(loc.toLanguageTag());
		l.setLanguageName(loc.getDisplayLanguage());
		l.setDisplayName(loc.getDisplayName());
		languages.add(l);
	    }

	    _languageService.saveAll(languages);
	}

	LOGGER.info("--------------- LANGUAGE INITIALIZATION FINISHED ---------------");
    }
}
