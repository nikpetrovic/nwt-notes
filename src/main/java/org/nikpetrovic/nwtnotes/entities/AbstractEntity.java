/**
 * 
 */
package org.nikpetrovic.nwtnotes.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author nikolapetrovic
 * @created Dec 16, 2014
 *
 */
@MappedSuperclass
public class AbstractEntity<T extends Serializable> implements IIdentity<T> {
    private T _id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Override
    public T getId() {
	return _id;
    }

    @Override
    public void setId(T id) {
	_id = id;
    }

}
