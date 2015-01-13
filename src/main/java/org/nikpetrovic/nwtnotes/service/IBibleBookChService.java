/**
 * 
 */
package org.nikpetrovic.nwtnotes.service;

import org.nikpetrovic.nwtnotes.entities.BibleBook;
import org.nikpetrovic.nwtnotes.entities.BibleBookCh;
import org.nikpetrovic.nwtnotes.foundation.services.IGenericService;

/**
 * @author nikolapetrovic
 * @created Jan 2, 2015
 *
 */
public interface IBibleBookChService extends
	IGenericService<BibleBookCh, Integer> {
    BibleBookCh findLastDownloadedByBibleBook(BibleBook bibleBook);
}
