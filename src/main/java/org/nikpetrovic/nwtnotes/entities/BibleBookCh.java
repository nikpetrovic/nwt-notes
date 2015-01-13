/**
 * 
 */
package org.nikpetrovic.nwtnotes.entities;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "tbl_bible_book_ch")
public class BibleBookCh extends AbstractEntity<Integer> {
    private BibleBook _bibleBook;
    private List<BibleBookChItem> _bibleBookChItems;
    private Integer _chNo;

    public void addChItem(BibleBookChItem item) {
	if (_bibleBookChItems == null) {
	    _bibleBookChItems = new LinkedList<BibleBookChItem>();
	}

	_bibleBookChItems.add(item);
    }

    @ManyToOne
    @JoinColumn(name = "bible_book_id")
    public BibleBook getBibleBook() {
	return _bibleBook;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bible_book_ch_id")
    public List<BibleBookChItem> getBibleBookChItems() {
	return _bibleBookChItems;
    }

    @Column(name = "ch_no", nullable = false)
    public Integer getChNo() {
	return _chNo;
    }

    public void setBibleBook(BibleBook bibleBook) {
	_bibleBook = bibleBook;
    }

    public void setBibleBookChItems(List<BibleBookChItem> bibleBookChItems) {
	_bibleBookChItems = bibleBookChItems;
    }

    public void setChNo(Integer chNo) {
	_chNo = chNo;
    }
}
