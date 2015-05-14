/**
 * 
 */
package org.nikpetrovic.nwtnotes.parser;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.nikpetrovic.nwtnotes.AppConfig;
import org.nikpetrovic.nwtnotes.entities.BibleBookCh;
import org.nikpetrovic.nwtnotes.entities.BibleBookChItem;
import org.nikpetrovic.nwtnotes.entities.TextRun;
import org.nikpetrovic.nwtnotes.entities.TextRunReference;
import org.nikpetrovic.nwtnotes.service.IBibleBookChItemService;
import org.nikpetrovic.nwtnotes.service.IBibleBookChService;
import org.nikpetrovic.nwtnotes.service.ITextRunReferenceService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author nikolapetrovic
 * @created Jan 2, 2015
 *
 */
public class BibleBookChServiceTest extends AbstractTest {
    @Autowired
    private AppConfig _appConfig;

    @Autowired
    private IBibleBookChService _bibleBookChService;

    @Autowired
    private IBibleBookChItemService _bibleBookChItemService;

    @Autowired
    private ITextRunReferenceService _textRunReferenceService;

    @Test
    public void findByIdTest01() throws IOException {
	int bbChId = 1;
	BibleBookCh bbCh = _bibleBookChService.findById(bbChId);

	assertNotNull(bbCh);

	List<BibleBookChItem> chItems = _bibleBookChItemService
		.findByBibleBookCh(bbCh);

	assertNotNull(chItems);
    }

    @Test
    public void findTextRunReferenceByIdTest01() {
	int id = 3;
	TextRunReference textRunRef = _textRunReferenceService.findById(id);

	assertNotNull(textRunRef);
    }

    @Test
    public void findByIdTest02() throws IOException {
	int bbChId = 1;
	BibleBookCh bbCh = _bibleBookChService.findById(bbChId);

	assertNotNull(bbCh);

	List<BibleBookChItem> chItems = _bibleBookChItemService
		.findByBibleBookCh(bbCh);

	assertNotNull(chItems);

	printIt(bbCh, chItems);
    }

    private void printIt(BibleBookCh bbCh, List<BibleBookChItem> chItems) {
	for (BibleBookChItem bbchi : chItems) {
	    System.out.print("<p>");
	    if (bbchi.getTextRuns() != null) {
		for (TextRun tr : bbchi.getTextRuns()) {
		    switch (tr.getType()) {
		    case NEW_LINE:
			System.out.println();
			break;
		    case TEXT:
			System.out.print(tr.getFormattedText() != null ? tr
				.getFormattedText() : tr.getText());
			break;
		    case VERSE_MARKER:
			System.out.print(String.format(
				"<sup><b>&nbsp;%d&nbsp;</b></sup>",
				tr.getVerseNo()));
			break;
		    case VERSE_REFERENCE:
			System.out.print(String.format(
				"<sup><a href=\"#\">&nbsp;%s</a></sup>",
				tr.getText()));
			break;
		    default:
			break;
		    }
		}
	    }
	    System.out.print("</p>");
	}
	System.out.println();
    }
}
