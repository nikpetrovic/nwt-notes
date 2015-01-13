/**
 * 
 */
package org.nikpetrovic.nwtnotes.service;

import org.nikpetrovic.nwtnotes.entities.Bible;
import org.nikpetrovic.nwtnotes.entities.BibleBook;
import org.nikpetrovic.nwtnotes.foundation.services.AbstractGenericService;
import org.nikpetrovic.nwtnotes.repository.BibleBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nikolapetrovic
 * @created Jan 7, 2015
 *
 */
@Service
public class BibleBookService extends
	AbstractGenericService<BibleBook, Integer, BibleBookRepository>
	implements IBibleBookService {
    @Autowired
    private BibleBookRepository _bibleBookRepository;

    @Transactional(readOnly = true)
    @Override
    public BibleBook findLastDownloadedByBible(Bible bible) {
	return getRepository().findFirstByBibleOrderByBibleBookCode_OrderNoAsc(
		bible);
    }

    @Override
    protected BibleBookRepository getRepository() {
	return _bibleBookRepository;
    }

}
