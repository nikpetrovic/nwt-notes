/**
 * 
 */
package org.nikpetrovic.nwtnotes.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.jsoup.nodes.Document;
import org.junit.Test;
import org.nikpetrovic.nwtnotes.entities.TextRunReference;
import org.nikpetrovic.nwtnotes.parsing.FootnoteResolver;

/**
 * @author nikolapetrovic
 * @created Jan 1, 2015
 *
 */
public class FootnoteResolverTest extends AbstractTest {
    @Test
    public void resolvingFootnoteTest01() {
	Document doc = loadTestFile("Footnote_test_01_sr-web-page.html");
	FootnoteResolver res = new FootnoteResolver(doc);
	TextRunReference ref = res.resolve();

	assertNotNull(ref);
	assertEquals(ref.getRefItems().size(), 1);

	System.out.println(ref.getRefItems().get(0).getText());
    }

    @Test
    public void resolvingFootnoteTest02() {
	Document doc = loadTestFile("Footnote_Mt-27-42_en-web-page.html");
	FootnoteResolver res = new FootnoteResolver(doc);
	TextRunReference ref = res.resolve();

	assertNotNull(ref);
	assertEquals(ref.getRefItems().size(), 1);

	System.out.println(ref.getRefItems().get(0).getText());
    }
}
