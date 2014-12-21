/**
 * 
 */
package org.nikpetrovic.nwtnotes.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author nikolapetrovic
 * @created Dec 16, 2014
 *
 */
@Entity
@Table(name = "tbl_bible_book_ch_item")
public class BibleBookChItem extends AbstractEntity<Integer> {
    private Integer _orderNo;
    private List<TextRun> _textRuns;
    private BibleBookChItemType _type;

    @Column(name = "order_no", nullable = false)
    public Integer getOrderNo() {
	return _orderNo;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "bible_book_ch_item_id")
    public List<TextRun> getTextRuns() {
	return _textRuns;
    }

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    public BibleBookChItemType getType() {
	return _type;
    }

    public void setOrderNo(Integer orderNo) {
	_orderNo = orderNo;
    }

    public void setTextRuns(List<TextRun> textRuns) {
	_textRuns = textRuns;
    }

    public void setType(BibleBookChItemType type) {
	_type = type;
    }
}
