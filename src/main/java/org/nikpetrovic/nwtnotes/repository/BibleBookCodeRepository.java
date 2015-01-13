/**
 * 
 */
package org.nikpetrovic.nwtnotes.repository;

import org.nikpetrovic.nwtnotes.entities.BibleBookCode;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nikolapetrovic
 * @created Jan 6, 2015
 *
 */
public interface BibleBookCodeRepository extends
	JpaRepository<BibleBookCode, Integer> {

}
