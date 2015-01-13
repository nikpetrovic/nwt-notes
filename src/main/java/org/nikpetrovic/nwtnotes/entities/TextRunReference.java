/**
 * 
 */
package org.nikpetrovic.nwtnotes.entities;

import java.util.LinkedList;
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
 * @created Dec 17, 2014
 *
 */
@Entity
@Table(name = "tbl_text_run_reference")
public class TextRunReference extends AbstractEntity<Integer> {
    private Integer _orderNo;
    private List<TextRunReferenceItem> _refItems;
    private TextRunReferenceType _type;

    public void addItem(TextRunReferenceItem item) {
	if (_refItems == null) {
	    _refItems = new LinkedList<TextRunReferenceItem>();
	}

	_refItems.add(item);
    }

    @Column(name = "order_no", nullable = false)
    public Integer getOrderNo() {
	return _orderNo;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "text_run_reference_id")
    public List<TextRunReferenceItem> getRefItems() {
	return _refItems;
    }

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    public TextRunReferenceType getType() {
	return _type;
    }

    public void setOrderNo(Integer orderNo) {
	_orderNo = orderNo;
    }

    public void setRefItems(List<TextRunReferenceItem> refItems) {
	_refItems = refItems;
    }

    public void setType(TextRunReferenceType type) {
	_type = type;
    }
}
