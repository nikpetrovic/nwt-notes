/**
 * 
 */
package org.nikpetrovic.nwtnotes.service;

import org.nikpetrovic.nwtnotes.entities.Bible;
import org.nikpetrovic.nwtnotes.entities.BibleBook;
import org.nikpetrovic.nwtnotes.foundation.services.IGenericService;

/**
 * @author nikolapetrovic
 * @created Jan 7, 2015
 *
 */
public interface IBibleBookService extends IGenericService<BibleBook, Integer> {
    BibleBook findLastDownloadedByBible(Bible bible);
}
