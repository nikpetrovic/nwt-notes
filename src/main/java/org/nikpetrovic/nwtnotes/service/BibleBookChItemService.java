/**
 * 
 */
package org.nikpetrovic.nwtnotes.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nikpetrovic.nwtnotes.entities.BibleBookCh;
import org.nikpetrovic.nwtnotes.entities.BibleBookChItem;
import org.nikpetrovic.nwtnotes.foundation.services.AbstractGenericService;
import org.nikpetrovic.nwtnotes.repository.BibleBookChItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nikolapetrovic
 * @created Jan 12, 2015
 *
 */
@Service
public class BibleBookChItemService
	extends
	AbstractGenericService<BibleBookChItem, Integer, BibleBookChItemRepository>
	implements IBibleBookChItemService {
    private static final Log LOGGER = LogFactory
	    .getLog(BibleBookChItemService.class);

    @Autowired
    private BibleBookChItemRepository _bibleBookChItemRepository;

    @Override
    public List<BibleBookChItem> findByBibleBookCh(BibleBookCh bibleBookCh) {
	LOGGER.info(String.format(
		"Finding BibleBookChItems by BibleBookCh with id: %d",
		bibleBookCh.getId()));
	return getRepository().findByBibleBookCh(bibleBookCh);
    }

    @Override
    protected BibleBookChItemRepository getRepository() {
	return _bibleBookChItemRepository;
    }

}
