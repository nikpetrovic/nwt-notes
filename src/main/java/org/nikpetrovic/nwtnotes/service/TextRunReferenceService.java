/**
 * 
 */
package org.nikpetrovic.nwtnotes.service;

import org.nikpetrovic.nwtnotes.entities.TextRunReference;
import org.nikpetrovic.nwtnotes.foundation.services.AbstractGenericService;
import org.nikpetrovic.nwtnotes.repository.TextRunReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nikolapetrovic
 * @created Jan 12, 2015
 *
 */
@Service
public class TextRunReferenceService
	extends
	AbstractGenericService<TextRunReference, Integer, TextRunReferenceRepository>
	implements ITextRunReferenceService {
    @Autowired
    private TextRunReferenceRepository _textRunReferenceRepository;

    @Override
    protected TextRunReferenceRepository getRepository() {
	return _textRunReferenceRepository;
    }
}
