/**
 * 
 */
package org.nikpetrovic.nwtnotes.parsing;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.nikpetrovic.nwtnotes.entities.TextRunReference;
import org.nikpetrovic.nwtnotes.entities.TextRunReferenceItem;
import org.nikpetrovic.nwtnotes.entities.TextRunReferenceType;

/**
 * @author nikolapetrovic
 * @created Jan 1, 2015
 *
 */
public class ReferenceResolver implements IResolvable<List<TextRunReference>> {
    private static final Log LOGGER = LogFactory
	    .getLog(ReferenceResolver.class);

    private Document _doc;

    public ReferenceResolver(Document doc) {
	_doc = doc;
    }

    @Override
    public List<TextRunReference> resolve() {
	Elements elements = _doc.select("div.caption, div.result");
	List<TextRunReference> references = new LinkedList<TextRunReference>();
	int refNo = 0;
	for (int i = 0; i < elements.size(); i = i + 2) {
	    Element caption = elements.get(i);
	    Element result = elements.get(i + 1);
	    if (caption.className().equals("caption")
		    && result.className().equals("result")) {
		String url = caption.select("a").attr("href");
//		LOGGER.info("Resolving reference url: " + url);
//		if (url.split("/").length < 10) {
//		    continue;
//		}
		String bookNo = url.split("/")[9];

		TextRunReference ref = new TextRunReference();
		ref.setType(TextRunReferenceType.REFERENCED_VERSE);
		ref.setOrderNo(refNo);

		Elements spans = result.select("span[id^=dcv_]");
		for (Element span : spans) {
		    String quickRef = bookNo
			    + "_"
			    + span.id().substring("dcv_".length(),
				    span.id().length());
		    TextRunReferenceItem refItem = new TextRunReferenceItem();
		    refItem.setQuickRef(quickRef);
		    ref.addItem(refItem);
		}

		references.add(ref);
		refNo++;
	    }
	}

	return references;
    }

}
