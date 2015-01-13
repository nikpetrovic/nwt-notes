/**
 * 
 */
package org.nikpetrovic.nwtnotes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author nikolapetrovic
 * @created Jan 2, 2015
 *
 */
@Configuration
@PropertySource("classpath:nwt-notes.properties")
public class AppConfig {
    private String _baseProcessingLink;
    private String _deBiblePattern;
    private String _enBibleUrlPattern;
    private String _srBiblePattern;

    public String getBaseProcessingLink() {
	return _baseProcessingLink;
    }

    public String getDeBiblePattern() {
	return _deBiblePattern;
    }

    public String getEnBibleUrlPattern() {
	return _enBibleUrlPattern;
    }

    public String getSrBiblePattern() {
	return _srBiblePattern;
    }

    @Value("${app.jworg.baseprocessinglink}")
    public void setBaseProcessingLink(String baseProcessingLink) {
	_baseProcessingLink = baseProcessingLink;
    }

    @Value("${app.jworg.urlpattern.de}")
    public void setDeBiblePattern(String deBiblePattern) {
	_deBiblePattern = deBiblePattern;
    }

    @Value("${app.jworg.urlpattern.en}")
    public void setEnBibleUrlPattern(String enBibleUrlPattern) {
	_enBibleUrlPattern = enBibleUrlPattern;
    }

    @Value("${app.jworg.urlpattern.sr}")
    public void setSrBiblePattern(String srBiblePattern) {
	_srBiblePattern = srBiblePattern;
    }
}
