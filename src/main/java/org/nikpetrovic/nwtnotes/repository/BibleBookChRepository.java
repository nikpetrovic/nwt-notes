/**
 * 
 */
package org.nikpetrovic.nwtnotes.repository;

import org.nikpetrovic.nwtnotes.entities.BibleBook;
import org.nikpetrovic.nwtnotes.entities.BibleBookCh;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nikolapetrovic
 * @created Jan 2, 2015
 *
 */
public interface BibleBookChRepository extends
	JpaRepository<BibleBookCh, Integer> {
    BibleBookCh findFirstByBibleBookOrderByChNoDesc(BibleBook bibleBook);
}
