/**
 * 
 */
package org.nikpetrovic.nwtnotes.repository;

import org.nikpetrovic.nwtnotes.entities.Bible;
import org.nikpetrovic.nwtnotes.entities.BibleBook;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nikolapetrovic
 * @created Jan 7, 2015
 *
 */
public interface BibleBookRepository extends JpaRepository<BibleBook, Integer> {
    BibleBook findFirstByBibleOrderByBibleBookCode_OrderNoAsc(Bible bible);
}
