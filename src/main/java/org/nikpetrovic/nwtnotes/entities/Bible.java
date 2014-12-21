/**
 * 
 */
package org.nikpetrovic.nwtnotes.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author nikolapetrovic
 * @created Dec 16, 2014
 *
 */
@Entity
@Table(name = "tbl_bible")
public class Bible extends AbstractEntity<Integer> {
    private Set<BibleBook> _bibleBooks;
    private String _description;
    private Language _language;
    private String _title;
    private String _year;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bible_id")
    public Set<BibleBook> getBibleBooks() {
	return _bibleBooks;
    }

    @Lob
    @Column(name = "description")
    public String getDescription() {
	return _description;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "language_id")
    public Language getLanguage() {
	return _language;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
	return _title;
    }

    @Column(name = "year")
    public String getYear() {
	return _year;
    }

    public void setBibleBooks(Set<BibleBook> bibleBooks) {
	_bibleBooks = bibleBooks;
    }

    public void setDescription(String description) {
	_description = description;
    }

    public void setLanguage(Language language) {
	_language = language;
    }

    public void setTitle(String title) {
	_title = title;
    }

    public void setYear(String year) {
	_year = year;
    }
}
