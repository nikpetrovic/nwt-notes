/**
 * 
 */
package org.nikpetrovic.nwtnotes.repository;

import java.util.List;

import org.nikpetrovic.nwtnotes.entities.BibleBookCh;
import org.nikpetrovic.nwtnotes.entities.BibleBookChItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nikolapetrovic
 * @created Jan 12, 2015
 *
 */
public interface BibleBookChItemRepository extends
	JpaRepository<BibleBookChItem, Integer> {
    List<BibleBookChItem> findByBibleBookCh(BibleBookCh bibleBookCh);
}
