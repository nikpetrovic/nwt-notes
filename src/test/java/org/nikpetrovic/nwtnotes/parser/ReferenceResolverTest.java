/**
 * 
 */
package org.nikpetrovic.nwtnotes.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.jsoup.nodes.Document;
import org.junit.Test;
import org.nikpetrovic.nwtnotes.entities.TextRunReference;
import org.nikpetrovic.nwtnotes.parsing.ReferenceResolver;

/**
 * @author nikolapetrovic
 * @created Jan 1, 2015
 *
 */
public class ReferenceResolverTest extends AbstractTest {
    @Test
    public void selectingReferenceResultTest01() {
	Document doc = loadTestFile("Reference_test_01_en-web-page.html");
	ReferenceResolver res = new ReferenceResolver(doc);
	List<TextRunReference> refs = res.resolve();

	assertNotNull(refs);
	assertEquals(refs.size(), 2);
	assertEquals(refs.get(0).getOrderNo(), new Integer(1));
	assertEquals(refs.get(0).getRefItems().get(0).getQuickRef(), "1_7_11");
	assertEquals(refs.get(1).getOrderNo(), new Integer(2));
	assertEquals(refs.get(1).getRefItems().get(0).getQuickRef(), "20_8_27");
	assertEquals(refs.get(1).getRefItems().get(1).getQuickRef(), "20_8_28");
    }

    @Test
    public void selectingReferenceResultTest02() {
	Document doc = loadTestFile("Reference_test_01_sr-web-page.html");
	ReferenceResolver res = new ReferenceResolver(doc);
	List<TextRunReference> refs = res.resolve();

	assertNotNull(refs);
	assertEquals(refs.size(), 2);
	assertEquals(refs.get(0).getOrderNo(), new Integer(1));
	assertEquals(refs.get(0).getRefItems().get(0).getQuickRef(), "19_33_7");
	assertEquals(refs.get(1).getOrderNo(), new Integer(2));
	assertEquals(refs.get(1).getRefItems().get(0).getQuickRef(), "61_3_5");
    }
}
