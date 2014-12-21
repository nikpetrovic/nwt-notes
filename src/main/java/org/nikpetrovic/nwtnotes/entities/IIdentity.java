/**
 * 
 */
package org.nikpetrovic.nwtnotes.entities;

import java.io.Serializable;

/**
 * @author nikolapetrovic
 * @created Dec 16, 2014
 *
 */
public interface IIdentity<T extends Serializable> {
    T getId();

    void setId(T id);
}
