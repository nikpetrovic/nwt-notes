/**
 * 
 */
package org.nikpetrovic.nwtnotes.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author nikolapetrovic
 * @created Dec 17, 2014
 *
 */
@Entity
@Table(name = "tbl_text_run")
public class TextRun extends AbstractEntity<Integer> {
    private Integer _orderNo;
    private String _text;
    private List<TextRunReference> _textRunReferences;

    @Column(name = "order_no")
    public Integer getOrderNo() {
	return _orderNo;
    }

    @Lob
    @Column(name = "text")
    public String getText() {
	return _text;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "text_run_id")
    public List<TextRunReference> getTextRunReferences() {
	return _textRunReferences;
    }

    public void setOrderNo(Integer orderNo) {
	_orderNo = orderNo;
    }

    public void setText(String text) {
	_text = text;
    }

    public void setTextRunReferences(List<TextRunReference> textRunReferences) {
	_textRunReferences = textRunReferences;
    }

}
