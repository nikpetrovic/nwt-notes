/**
 * 
 */
package org.nikpetrovic.nwtnotes.parsing;

import java.io.IOException;

/**
 * @author nikolapetrovic
 * @created Jan 1, 2015
 *
 */
public interface IResolvable<T> {
    T resolve() throws IOException;
}
