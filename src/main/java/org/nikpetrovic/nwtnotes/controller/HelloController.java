/**
 * 
 */
package org.nikpetrovic.nwtnotes.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nikolapetrovic
 * @created Dec 15, 2014
 *
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping("/")
    public String world() {
	return "Hello World from Spring!";
    }
}
