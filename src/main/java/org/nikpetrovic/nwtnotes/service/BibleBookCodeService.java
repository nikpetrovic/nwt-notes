/**
 * 
 */
package org.nikpetrovic.nwtnotes.service;

import org.nikpetrovic.nwtnotes.entities.BibleBookCode;
import org.nikpetrovic.nwtnotes.foundation.services.AbstractGenericService;
import org.nikpetrovic.nwtnotes.repository.BibleBookCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nikolapetrovic
 * @created Jan 6, 2015
 *
 */
@Service
public class BibleBookCodeService extends
	AbstractGenericService<BibleBookCode, Integer, BibleBookCodeRepository>
	implements IBibleBookCodeService {
    @Autowired
    private BibleBookCodeRepository _bibleBookCodeRepository;

    @Override
    protected BibleBookCodeRepository getRepository() {
	return _bibleBookCodeRepository;
    }

}
