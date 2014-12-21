/**
 * 
 */
package org.nikpetrovic.nwtnotes.repository;

import org.nikpetrovic.nwtnotes.entities.Bible;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nikolapetrovic
 * @created Dec 16, 2014
 *
 */
public interface BibleRepository extends JpaRepository<Bible, Integer> {

}
