/**
 * 
 */
package org.nikpetrovic.nwtnotes.parsing;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.nikpetrovic.nwtnotes.entities.TextRunReference;
import org.nikpetrovic.nwtnotes.entities.TextRunReferenceItem;
import org.nikpetrovic.nwtnotes.entities.TextRunReferenceType;

/**
 * @author nikolapetrovic
 * @created Jan 1, 2015
 *
 */
public class FootnoteResolver implements IResolvable<TextRunReference> {
    private Document _doc;

    public FootnoteResolver(Document doc) {
	_doc = doc;
    }

    @Override
    public TextRunReference resolve() {
	Element fElement = _doc.select("p.sf").get(0);
	TextRunReference footnote = new TextRunReference();
	footnote.setOrderNo(0);
	footnote.setType(TextRunReferenceType.FOOTNOTE);

	List<Element> elem2unwrap = new ArrayList<Element>();
	for (Node n : fElement.childNodes()) {
	    if (n instanceof Element) {
		Element e = (Element) n;
		if (e.tagName().equals("a")) {
		    elem2unwrap.add(e);
		}
	    }
	}
	for (Element e : elem2unwrap) {
	    e.unwrap();
	}

	TextRunReferenceItem refItem = new TextRunReferenceItem();
	refItem.setFormattedText(fElement.html());
	refItem.setText(fElement.text());

	footnote.addItem(refItem);

	return footnote;
    }

}
