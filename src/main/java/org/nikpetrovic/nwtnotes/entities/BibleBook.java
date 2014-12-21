/**
 * 
 */
package org.nikpetrovic.nwtnotes.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author nikolapetrovic
 * @created Dec 16, 2014
 *
 */
@Entity
@Table(name = "tbl_bible_book")
public class BibleBook extends AbstractEntity<Integer> {
    private Set<BibleBookCh> _bibleBookChs;
    private BibleBookCode _bibleBookCode;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bible_book_id")
    public Set<BibleBookCh> getBibleBookChs() {
	return _bibleBookChs;
    }

    @OneToOne
    @JoinColumn(name = "bible_book_code_id", nullable = false)
    public BibleBookCode getBibleBookCode() {
	return _bibleBookCode;
    }

    public void setBibleBookChs(Set<BibleBookCh> bibleBookChs) {
	_bibleBookChs = bibleBookChs;
    }

    public void setBibleBookCode(BibleBookCode bibleBookCode) {
	_bibleBookCode = bibleBookCode;
    }
}
