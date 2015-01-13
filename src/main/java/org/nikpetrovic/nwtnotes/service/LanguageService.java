/**
 * 
 */
package org.nikpetrovic.nwtnotes.service;

import org.nikpetrovic.nwtnotes.entities.Language;
import org.nikpetrovic.nwtnotes.foundation.services.AbstractGenericService;
import org.nikpetrovic.nwtnotes.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nikolapetrovic
 * @created Jan 6, 2015
 *
 */
@Service
public class LanguageService extends
	AbstractGenericService<Language, Integer, LanguageRepository> implements
	ILanguageService {
    @Autowired
    private LanguageRepository _languageRepository;

    @Override
    protected LanguageRepository getRepository() {
	return _languageRepository;
    }

}
