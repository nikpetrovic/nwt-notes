/**
 * 
 */
package org.nikpetrovic.nwtnotes.repository;

import org.nikpetrovic.nwtnotes.entities.TextRunReference;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nikolapetrovic
 * @created Jan 12, 2015
 *
 */
public interface TextRunReferenceRepository extends
	JpaRepository<TextRunReference, Integer> {

}
