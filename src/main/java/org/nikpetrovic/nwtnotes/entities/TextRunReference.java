/**
 * 
 */
package org.nikpetrovic.nwtnotes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * @author nikolapetrovic
 * @created Dec 17, 2014
 *
 */
@Entity
@Table(name = "tbl_text_run_reference")
public class TextRunReference extends AbstractEntity<Integer> {
    private Integer _orderNo;
    private TextRunReferenceType _type;

    @Column(name = "order_no")
    public Integer getOrderNo() {
	return _orderNo;
    }

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    public TextRunReferenceType getType() {
	return _type;
    }

    public void setOrderNo(Integer orderNo) {
	_orderNo = orderNo;
    }

    public void setType(TextRunReferenceType type) {
	_type = type;
    }
}
