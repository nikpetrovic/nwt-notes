/**
 * 
 */
package org.nikpetrovic.nwtnotes.parser;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.nikpetrovic.nwtnotes.ApplicationTests;

/**
 * @author nikolapetrovic
 * @created Jan 1, 2015
 *
 */
public class AbstractTest extends ApplicationTests {
    protected Document loadTestFile(String fileName) {
	Document doc = null;
	try {
	    doc = Jsoup.parse(AbstractTest.class.getClassLoader()
		    .getResourceAsStream(fileName), "UTF-8", "jworg");
	} catch (IOException e) {
	    throw new RuntimeException(e);
	}
	return doc;
    }
}
