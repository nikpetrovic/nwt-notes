/**
 * 
 */
package org.nikpetrovic.nwtnotes.foundation.services;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nikolapetrovic
 * @created Nov 27, 2014
 *
 */
public abstract class AbstractGenericService<T, ID extends Serializable, K extends JpaRepository<T, ID>>
	implements IGenericService<T, ID> {
    private static Logger LOGGER = LoggerFactory
	    .getLogger(AbstractGenericService.class);

    @Override
    @Transactional
    public T create(T entity) {
	LOGGER.info(String.format("Creating entity: %s.", entity));
	T newEntity = getRepository().saveAndFlush(entity);
	return newEntity;
    }

    @Override
    @Transactional
    public List<T> findAll() {
	LOGGER.info("Getting all entities.");
	List<T> entities = getRepository().findAll();
	return entities;
    }

    @Override
    @Transactional
    public T findById(ID id) {
	LOGGER.info(String.format("Getting entity with id: %d.", id));
	return getRepository().findOne(id);
    }

    protected abstract K getRepository();
}
