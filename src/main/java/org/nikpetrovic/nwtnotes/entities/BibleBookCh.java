/**
 * 
 */
package org.nikpetrovic.nwtnotes.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
    private List<BibleBookChItem> _bibleBookChItems;
    private Integer _orderNo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bible_book_ch_id")
    public List<BibleBookChItem> getBibleBookChItems() {
	return _bibleBookChItems;
    }

    @Column(name = "order_no", nullable = false)
    public Integer getOrderNo() {
	return _orderNo;
    }

    public void setBibleBookChItems(List<BibleBookChItem> bibleBookChItems) {
	_bibleBookChItems = bibleBookChItems;
    }

    public void setOrderNo(Integer orderNo) {
	_orderNo = orderNo;
    }
}
