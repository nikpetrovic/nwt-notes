/**
 * 
 */
package org.nikpetrovic.nwtnotes.parsing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.mutable.MutableInt;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.nikpetrovic.nwtnotes.AppConfig;
import org.nikpetrovic.nwtnotes.entities.BibleBookCh;
import org.nikpetrovic.nwtnotes.entities.BibleBookChItem;
import org.nikpetrovic.nwtnotes.entities.BibleBookChItemType;
import org.nikpetrovic.nwtnotes.entities.TextRun;
import org.nikpetrovic.nwtnotes.entities.TextRunReference;
import org.nikpetrovic.nwtnotes.entities.TextRunReferenceType;
import org.nikpetrovic.nwtnotes.entities.TextRunType;

/**
 * @author nikolapetrovic
 * @created Jan 1, 2015
 *
 */
public class ChapterResolver implements IResolvable<BibleBookCh> {
    private static final Log LOGGER = LogFactory.getLog(ChapterResolver.class);

    private AppConfig _appConfig;
    private int _chNo;
    private Document _doc;

    public ChapterResolver(Document doc, int chNo, AppConfig appConfig) {
	_doc = doc;
	_chNo = chNo;
	_appConfig = appConfig;
    }

    @Override
    public BibleBookCh resolve() throws IOException {
	LOGGER.info("Resolving chapter " + _chNo + "...");

	Elements divParElements = _doc.select("div.document.bible > div.par");
	MutableInt currentVerseNo = new MutableInt(0);
	int chItemCounter = 0;
	BibleBookCh bibleBookCh = new BibleBookCh();
	bibleBookCh.setChNo(_chNo);
	for (Element divParElement : divParElements) {
	    Elements parElements = divParElement.select("p").not(".s6, .s5");
	    for (Element e : parElements) {
		// new paragraph starts
		BibleBookChItem chItem = new BibleBookChItem();
		if (e.hasClass("sw")) {
		    chItem.setType(BibleBookChItemType.TITLE);
		    chItem.setOrderNo(chItemCounter++);
		} else if (e.hasClass("ss")) {
		    chItem.setType(BibleBookChItemType.SUBTITLE);
		    chItem.setOrderNo(chItemCounter++);
		} else {
		    chItem.setType(BibleBookChItemType.PARAGRAPH_TEXT);
		    chItem.setOrderNo(chItemCounter++);
		}

		chItem.setTextRuns(handleParagraphElements(e, currentVerseNo));
		bibleBookCh.addChItem(chItem);
	    }

	}

	LOGGER.info("Chapter " + _chNo + " resolved.");

	return bibleBookCh;
    }

    private List<TextRun> handleParagraphElements(Element e,
	    MutableInt currentVerseNo) throws IOException {
	List<TextRun> textRuns = new LinkedList<TextRun>();
	int textRunOrderNo = 0;
	for (Node n : e.childNodes()) {
	    TextRun textRun = null;
	    if (n instanceof Element) {
		Element el = (Element) n;
		String eIdStart = "dcv_" + _chNo + "_";
		if (el.tagName().equals("span") && el.hasAttr("id")
			&& el.attr("id").startsWith(eIdStart)) { // new verse
								 // marker
		    currentVerseNo.increment();
		    Elements verseFootnoteElements = el.select("a.fn");
		    if (verseFootnoteElements.size() > 0) {
			for (Element verseFnEl : verseFootnoteElements) {
			    resolveVerseFootnotes(textRuns, verseFnEl,
				    currentVerseNo.intValue(), textRunOrderNo++);
			}
		    }
		    int verseNoFound = Integer.parseInt(el.attr("id")
			    .substring(eIdStart.length()));
		    if (_chNo == 8 && verseNoFound == 12
			    && currentVerseNo.intValue() == 1) {
			currentVerseNo.setValue(12); // for John 8:12
		    }
		    if (currentVerseNo.intValue() != verseNoFound
			    && !(currentVerseNo.intValue() == 1 && _chNo == verseNoFound)) {
			throw new RuntimeException(
				String.format(
					"Unexpected verse number. Expected %d but found %d",
					currentVerseNo.intValue(), verseNoFound));
		    }
		    textRun = new TextRun();
		    textRun.setType(TextRunType.VERSE_MARKER);

		} else if (el.tagName().equals("br")
			|| (el.tagName().equals("span") && el.hasClass("br"))) { // new
										 // line
										 // marker
		    textRun = new TextRun();
		    textRun.setType(TextRunType.NEW_LINE);
		} else if (el.tagName().equals("a")) {
		    if (el.hasClass("mr")) {
			textRun = resolveRef(el,
				TextRunReferenceType.REFERENCED_VERSE);
		    } else if (el.hasClass("fn")) {
			textRun = resolveRef(el, TextRunReferenceType.FOOTNOTE);
		    }
		} else {
		    textRun = new TextRun();
		    textRun.setType(TextRunType.TEXT);
		    textRun.setText(el.text());
		    textRun.setFormattedText(el.outerHtml());
		}
	    } else if (n instanceof TextNode) {
		TextNode textNode = (TextNode) n;
		if (textNode.text().trim().isEmpty()
			|| textNode.text().replace("\u00a0", "").trim()
				.isEmpty()) {
		    continue;
		}
		textRun = new TextRun();
		textRun.setType(TextRunType.TEXT);
		textRun.setText(textNode.text());
	    }

	    LOGGER.info(String.format("Verse number: %d",
		    currentVerseNo.intValue()));

	    if (textRun != null) {
		textRun.setOrderNo(textRunOrderNo++);
		textRun.setVerseNo(currentVerseNo.intValue());
		textRuns.add(textRun);
	    }
	}

	return textRuns;
    }

    private void resolveVerseFootnotes(List<TextRun> textRuns, Element el,
	    int currentVerseNo, int textRunOrderNo) throws IOException {
	TextRun textRun = resolveRef(el, TextRunReferenceType.FOOTNOTE);
	textRun.setOrderNo(textRunOrderNo);
	textRun.setVerseNo(currentVerseNo);
	textRuns.add(textRun);
    }

    private TextRun resolveRef(Element el, TextRunReferenceType type)
	    throws IOException {
	String url = _appConfig.getBaseProcessingLink() + el.attr("href");
	TextRun textRun = new TextRun();
	textRun.setType(TextRunType.VERSE_REFERENCE);
	textRun.setText(el.text());
	Document doc = null;
	LOGGER.info("Resolving reference from url:" + url);
	doc = Jsoup.connect(url).get();
	LOGGER.info("Resolved");

	switch (type) {
	case REFERENCED_VERSE:
	    ReferenceResolver refRes = new ReferenceResolver(doc);
	    textRun.setTextRunReferences(refRes.resolve());
	    break;
	case FOOTNOTE:
	    FootnoteResolver footRes = new FootnoteResolver(doc);
	    List<TextRunReference> refs = new ArrayList<TextRunReference>();
	    refs.add(footRes.resolve());
	    textRun.setTextRunReferences(refs);
	default:
	    break;
	}

	return textRun;
    }
}
