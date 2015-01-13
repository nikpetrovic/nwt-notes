/**
 * 
 */
package org.nikpetrovic.nwtnotes.parsing;

import java.util.LinkedHashMap;
import java.util.Map;

import org.nikpetrovic.nwtnotes.entities.BibleBookCode;

/**
 * @author Nikola
 * 
 */
public class BibleContext {
    private static Map<String, BibleBookCode> _bibleBookChaptersMap = new LinkedHashMap<String, BibleBookCode>() {
	{
	    put("ge", new BibleBookCode("ge", "Genesis", 50, 1));
	    put("ex", new BibleBookCode("ex", "Exodus", 40, 2));
	    put("le", new BibleBookCode("le", "Leviticus", 27, 3));
	    put("nu", new BibleBookCode("nu", "Numbers", 36, 4));
	    put("de", new BibleBookCode("de", "Deuteronomy", 34, 5));
	    put("jos", new BibleBookCode("jos", "Joshua", 24, 6));
	    put("jg", new BibleBookCode("jg", "Judges", 21, 7));
	    put("ru", new BibleBookCode("ru", "Ruth", 4, 8));
	    put("1sa", new BibleBookCode("1sa", "1 Samuel", 31, 9));
	    put("2sa", new BibleBookCode("2sa", "2 Samuel", 24, 10));
	    put("1ki", new BibleBookCode("1ki", "1 Kings", 22, 11));
	    put("2ki", new BibleBookCode("2ki", "2 Kings", 25, 12));
	    put("1ch", new BibleBookCode("1ch", "1 Chronicles", 29, 13));
	    put("2ch", new BibleBookCode("2ch", "2 Chronicles", 36, 14));
	    put("ezr", new BibleBookCode("ezr", "Ezra", 10, 15));
	    put("ne", new BibleBookCode("ne", "Nehemiah", 13, 16));
	    put("es", new BibleBookCode("es", "Esther", 10, 17));
	    put("job", new BibleBookCode("job", "Job", 42, 18));
	    put("ps", new BibleBookCode("ps", "Psalms", 150, 19));
	    put("pr", new BibleBookCode("pr", "Proverbs", 31, 20));
	    put("ec", new BibleBookCode("ec", "Ecclesiastes", 12, 21));
	    put("ca", new BibleBookCode("ca", "Song of Solomon", 8, 22));
	    put("isa", new BibleBookCode("isa", "Isaiah", 66, 23));
	    put("jer", new BibleBookCode("jer", "Jeremiah", 52, 24));
	    put("la", new BibleBookCode("la", "Lamentations", 5, 25));
	    put("eze", new BibleBookCode("eze", "Ezekiel", 48, 26));
	    put("da", new BibleBookCode("da", "Daniel", 12, 27));
	    put("ho", new BibleBookCode("ho", "Hosea", 14, 28));
	    put("joe", new BibleBookCode("joe", "Joel", 3, 29));
	    put("am", new BibleBookCode("am", "Amos", 9, 30));
	    put("ob", new BibleBookCode("ob", "Obadiah", 1, 31));
	    put("jon", new BibleBookCode("jon", "Jonah", 4, 32));
	    put("mic", new BibleBookCode("mic", "Micah", 7, 33));
	    put("na", new BibleBookCode("na", "Nahum", 3, 34));
	    put("hab", new BibleBookCode("hab", "Habakkuk", 3, 35));
	    put("zep", new BibleBookCode("zep", "Zephaniah", 3, 36));
	    put("hag", new BibleBookCode("hag", "Haggai", 2, 37));
	    put("zec", new BibleBookCode("zec", "Zechariah", 14, 38));
	    put("mal", new BibleBookCode("mal", "Malachi", 4, 39));
	    put("mt", new BibleBookCode("mt", "Matthew", 28, 40));
	    put("mr", new BibleBookCode("mr", "Mark", 16, 41));
	    put("lu", new BibleBookCode("lu", "Luke", 24, 42));
	    put("joh", new BibleBookCode("joh", "John", 21, 43));
	    put("ac", new BibleBookCode("ac", "Acts", 28, 44));
	    put("ro", new BibleBookCode("ro", "Romans", 16, 45));
	    put("1co", new BibleBookCode("1co", "1 Corinthians", 16, 46));
	    put("2co", new BibleBookCode("2co", "2 Corinthians", 13, 47));
	    put("ga", new BibleBookCode("ga", "Galatians", 6, 48));
	    put("eph", new BibleBookCode("eph", "Ephesians", 6, 49));
	    put("php", new BibleBookCode("php", "Philippians", 4, 50));
	    put("col", new BibleBookCode("col", "Colossians", 4, 51));
	    put("1th", new BibleBookCode("1th", "1 Thessalonians", 5, 52));
	    put("2th", new BibleBookCode("2th", "2 Thessalonians", 3, 53));
	    put("1ti", new BibleBookCode("1ti", "1 Timothy", 6, 54));
	    put("2ti", new BibleBookCode("2ti", "2 Timothy", 4, 55));
	    put("tit", new BibleBookCode("tit", "Titus", 3, 56));
	    put("phm", new BibleBookCode("phm", "Philemon", 1, 57));
	    put("heb", new BibleBookCode("heb", "Hebrews", 13, 58));
	    put("jas", new BibleBookCode("jas", "James", 5, 59));
	    put("1pe", new BibleBookCode("1pe", "1 Peter", 5, 60));
	    put("2pe", new BibleBookCode("2pe", "2 Peter", 3, 61));
	    put("1jo", new BibleBookCode("1jo", "1 John", 5, 62));
	    put("2jo", new BibleBookCode("2jo", "2 John", 1, 63));
	    put("3jo", new BibleBookCode("3jo", "3 John", 1, 64));
	    put("jude", new BibleBookCode("jude", "Jude", 1, 65));
	    put("re", new BibleBookCode("re", "Revelation", 22, 66));
	}
    };

    public static Map<String, BibleBookCode> getBibleBookChaptersMap() {
	return _bibleBookChaptersMap;
    }

}
