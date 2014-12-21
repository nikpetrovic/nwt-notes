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
@Table(name = "tbl_bible_book_code")
public class BibleBookCode extends AbstractEntity<Integer> {
    private String _code;
    private Byte _orderNo;

    @Column(name = "code", nullable = false, length = 4)
    public String getCode() {
	return _code;
    }

    @Column(name = "order_no", nullable = false)
    public Byte getOrderNo() {
	return _orderNo;
    }

    public void setCode(String code) {
	_code = code;
    }

    public void setOrderNo(Byte orderNo) {
	_orderNo = orderNo;
    }
}
