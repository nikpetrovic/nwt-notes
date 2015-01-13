/**
 * 
 */
package org.nikpetrovic.nwtnotes.service;

import org.nikpetrovic.nwtnotes.entities.BibleBook;
import org.nikpetrovic.nwtnotes.entities.BibleBookCh;
import org.nikpetrovic.nwtnotes.foundation.services.AbstractGenericService;
import org.nikpetrovic.nwtnotes.repository.BibleBookChRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nikolapetrovic
 * @created Jan 2, 2015
 *
 */
@Service
public class BibleBookChService
	extends
	AbstractGenericService<BibleBookCh, Integer, JpaRepository<BibleBookCh, Integer>>
	implements IBibleBookChService {
    @Autowired
    private BibleBookChRepository _bibleBookChRepository;

    @Override
    protected BibleBookChRepository getRepository() {
	return _bibleBookChRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public BibleBookCh findLastDownloadedByBibleBook(BibleBook bibleBook) {
	return _bibleBookChRepository
		.findFirstByBibleBookOrderByChNoDesc(bibleBook);
    }
}
