/**
 * 
 */
package org.nikpetrovic.nwtnotes.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author nikolapetrovic
 * @created Dec 16, 2014
 *
 */
@Entity
@Table(name = "tbl_bible_book")
public class BibleBook extends AbstractEntity<Integer> {
    private Bible _bible;
    private Set<BibleBookCh> _bibleBookChs;
    private BibleBookCode _bibleBookCode;

    @ManyToOne
    public Bible getBible() {
	return _bible;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bible_book_id")
    public Set<BibleBookCh> getBibleBookChs() {
	return _bibleBookChs;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bible_book_code_id", nullable = false)
    public BibleBookCode getBibleBookCode() {
	return _bibleBookCode;
    }

    public void setBible(Bible bible) {
	_bible = bible;
    }

    public void setBibleBookChs(Set<BibleBookCh> bibleBookChs) {
	_bibleBookChs = bibleBookChs;
    }

    public void setBibleBookCode(BibleBookCode bibleBookCode) {
	_bibleBookCode = bibleBookCode;
    }
}
