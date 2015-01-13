/**
 * 
 */
package org.nikpetrovic.nwtnotes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author nikolapetrovic
 * @created Jan 1, 2015
 *
 */

@Entity
@Table(name = "tbl_text_run_reference_item")
public class TextRunReferenceItem extends AbstractEntity<Integer> {
    private String _formattedText;
    private String _quickRef;
    private String _text;

    @Lob
    @Column(name = "ref_text_formatted")
    public String getFormattedText() {
	return _formattedText;
    }

    @Column(name = "quick_ref")
    public String getQuickRef() {
	return _quickRef;
    }

    @Lob
    @Column(name = "ref_text")
    public String getText() {
	return _text;
    }

    public void setFormattedText(String formattedText) {
	_formattedText = formattedText;
    }

    public void setQuickRef(String quickRef) {
	_quickRef = quickRef;
    }

    public void setText(String text) {
	_text = text;
    }
}
