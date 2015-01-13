/**
 * 
 */
package org.nikpetrovic.nwtnotes.service;

import java.util.List;

import org.nikpetrovic.nwtnotes.entities.BibleBookCh;
import org.nikpetrovic.nwtnotes.entities.BibleBookChItem;
import org.nikpetrovic.nwtnotes.foundation.services.IGenericService;

/**
 * @author nikolapetrovic
 * @created Jan 12, 2015
 *
 */
public interface IBibleBookChItemService extends
	IGenericService<BibleBookChItem, Integer> {
    List<BibleBookChItem> findByBibleBookCh(BibleBookCh bibleBookCh);
}
