/**
 * 
 */
package org.nikpetrovic.nwtnotes.repository;

import org.nikpetrovic.nwtnotes.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nikolapetrovic
 * @created Jan 6, 2015
 *
 */
public interface LanguageRepository extends JpaRepository<Language, Integer> {

}
