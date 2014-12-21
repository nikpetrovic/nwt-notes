/**
 * 
 */
package org.nikpetrovic.nwtnotes.parser;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author nikolapetrovic
 * @created Dec 17, 2014
 *
 */
public class HtmlParserTest {
    private static Document doc;

    @BeforeClass
    public static void setUp() {
	try {
	    doc = Jsoup.parse(HtmlParserTest.class.getClassLoader()
		    .getResourceAsStream("Genesis_1-web-page.html"), "UTF-8",
		    "jworg");
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	assertNotNull(doc);
    }

    @Test
    public void findFootnoteTest() {
	Elements documentDiv = doc.select("div.document.bible");

	System.out.println();
    }
}
