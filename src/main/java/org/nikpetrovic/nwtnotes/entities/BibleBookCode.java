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
@Table(name = "tbl_bible_book_code")
public class BibleBookCode extends AbstractEntity<Integer> {
    private int _chNo;
    private String _name;
    private int _orderNo;
    private String _shortName;

    public BibleBookCode() {
    }

    public BibleBookCode(String shortName, String name, int chNo, int orderNo) {
	_shortName = shortName;
	_name = name;
	_chNo = chNo;
	_orderNo = orderNo;
    }

    @Column(name = "ch_no", nullable = false)
    public int getChNo() {
	return _chNo;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
	return _name;
    }

    @Column(name = "order_no", nullable = false)
    public int getOrderNo() {
	return _orderNo;
    }

    @Column(name = "short_name", nullable = false)
    public String getShortName() {
	return _shortName;
    }

    public void setChNo(int chNo) {
	_chNo = chNo;
    }

    public void setName(String name) {
	_name = name;
    }

    public void setOrderNo(int orderNo) {
	_orderNo = orderNo;
    }

    public void setShortName(String shortName) {
	_shortName = shortName;
    }

}