/**
 * 
 */
package org.nikpetrovic.nwtnotes.foundation.services;

import java.io.Serializable;
import java.util.List;

/**
 * @author nikolapetrovic
 * @created Nov 27, 2014
 *
 */
public interface IGenericService<T, ID extends Serializable> {
    public T create(T entity);

    public List<T> findAll();

    public T findById(ID id);
}
