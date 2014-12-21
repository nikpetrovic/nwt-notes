/**
 * 
 */
package org.nikpetrovic.nwtnotes.service;

import org.nikpetrovic.nwtnotes.entities.Bible;
import org.nikpetrovic.nwtnotes.foundation.services.AbstractGenericService;
import org.nikpetrovic.nwtnotes.repository.BibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author nikolapetrovic
 * @created Dec 15, 2014
 *
 */
@Service
public class BibleService extends
	AbstractGenericService<Bible, Integer, JpaRepository<Bible, Integer>>
	implements IBibleService {
    @Autowired
    private BibleRepository _bibleRepository;

    @Override
    protected JpaRepository<Bible, Integer> getRepository() {
	return _bibleRepository;
    }

}
