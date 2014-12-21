/**
 * 
 */
package org.nikpetrovic.nwtnotes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author nikolapetrovic
 * @created Dec 16, 2014
 *
 */
@Entity
@Table(name = "tbl_language")
public class Language extends AbstractEntity<Integer> {
    private String _code;

    @Column(name = "code", length = 10, nullable = false, unique = true)
    public String getCode() {
	return _code;
    }

    public void setCode(String code) {
	_code = code;
    }

}
