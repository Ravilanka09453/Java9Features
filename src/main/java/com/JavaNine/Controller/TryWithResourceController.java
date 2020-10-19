package com.JavaNine.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.JavaNine.MyResource;

/**
 * 
 * Deals with try with resource concept in java 7 and now in java 9
 *
 */

@RestController
public class TryWithResourceController {

	/**
	 * In Java 7 resource object to be created in try statement and no need to close
	 * resource using final block it will be taken care automatically.
	 * 
	 * @param id
	 */

	@GetMapping("/jseven/{id}")
	public void inJavaSeven(@PathVariable("id") int id) {
		try (MyResource res = new MyResource(id)) {
			res.process();
		} catch (Exception ex) {
			System.out.println("Halding" + ex);
		}
	}

	/**
	 * In Java9-resource object is instantiated outside the try block, However it
	 * must be final or effectively final for this to compile This bcz compiler must
	 * be sure which close method to call
	 * 
	 * @param id
	 */

	@GetMapping("/jeight/{id}")
	public void inJavaEight(@PathVariable("id") int id) {
		MyResource res = new MyResource(id);
		try (res) {
			res.process();
		} catch (Exception ex) {
			System.out.println("Halding" + ex);
		}

	}

}
