/**
 * 
 */
package org.nikpetrovic.nwtnotes;

import java.util.Locale;

/**
 * @author nikolapetrovic
 * @created Jan 12, 2015
 *
 */
public class TestMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	for (Locale l : Locale.getAvailableLocales()) {
	    System.out.println(String.format("%s, %s, %s", l.toLanguageTag(), l.getDisplayLanguage(), l.getDisplayName()));
	}
    }

}
