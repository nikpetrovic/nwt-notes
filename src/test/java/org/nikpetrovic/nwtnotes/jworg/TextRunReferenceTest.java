/**
 * 
 */
package org.nikpetrovic.nwtnotes.jworg;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.BeforeClass;
import org.junit.Test;
import org.nikpetrovic.nwtnotes.ApplicationTests;

/**
 * @author nikolapetrovic
 * @created Dec 17, 2014
 *
 */
public class TextRunReferenceTest extends ApplicationTests {
    private static Document doc;

    @BeforeClass
    public static void setUp() {
	try {
	    doc = Jsoup.parse(TextRunReferenceTest.class.getClassLoader()
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
