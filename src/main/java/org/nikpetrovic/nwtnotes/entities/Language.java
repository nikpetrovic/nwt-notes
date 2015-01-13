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
    private String _displayName;
    private String _languageName;

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Language other = (Language) obj;
	if (_code == null) {
	    if (other._code != null)
		return false;
	} else if (!_code.equals(other._code))
	    return false;
	return true;
    }

    @Column(name = "code", length = 32, nullable = false, unique = true)
    public String getCode() {
	return _code;
    }

    @Column(name = "display_name", nullable = false)
    public String getDisplayName() {
	return _displayName;
    }

    @Column(name = "language_name", nullable = false)
    public String getLanguageName() {
	return _languageName;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((_code == null) ? 0 : _code.hashCode());
	return result;
    }

    public void setCode(String code) {
	_code = code;
    }

    public void setDisplayName(String displayName) {
	_displayName = displayName;
    }

    public void setLanguageName(String languageName) {
	_languageName = languageName;
    }

}
