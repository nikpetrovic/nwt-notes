/**
 * 
 */
package org.nikpetrovic.nwtnotes.foundation.services;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author nikolapetrovic
 * @created Nov 27, 2014
 *
 */
public interface IGenericService<T, ID extends Serializable> {
    List<T> findAll();

    T findById(ID id);

    T save(T entity);

    List<T> saveAll(Collection<T> entities);
}
