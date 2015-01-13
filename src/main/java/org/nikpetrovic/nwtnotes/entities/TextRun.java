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
    private String _formattedText;
    private Integer _orderNo;
    private String _text;
    private List<TextRunReference> _textRunReferences;
    private TextRunType _type;
    private Integer _verseNo;

    @Lob
    @Column(name = "text_formatted")
    public String getFormattedText() {
	return _formattedText;
    }

    @Column(name = "order_no", nullable = false)
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

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    public TextRunType getType() {
	return _type;
    }

    @Column(name = "verse_no")
    public Integer getVerseNo() {
	return _verseNo;
    }

    public void setFormattedText(String formattedText) {
	_formattedText = formattedText;
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

    public void setType(TextRunType type) {
	_type = type;
    }

    public void setVerseNo(Integer verseNo) {
	_verseNo = verseNo;
    }

}
