/**
 * 
 */
package org.nikpetrovic.nwtnotes.service;

import org.nikpetrovic.nwtnotes.entities.Bible;
import org.nikpetrovic.nwtnotes.foundation.services.AbstractGenericService;
import org.nikpetrovic.nwtnotes.repository.BibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nikolapetrovic
 * @created Dec 15, 2014
 *
 */
@Service
public class BibleService extends
	AbstractGenericService<Bible, Integer, BibleRepository> implements
	IBibleService {
    @Autowired
    private BibleRepository _bibleRepository;

    @Override
    protected BibleRepository getRepository() {
	return _bibleRepository;
    }

}
