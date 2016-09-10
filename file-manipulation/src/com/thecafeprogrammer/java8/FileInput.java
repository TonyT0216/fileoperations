package com.thecafeprogrammer.java8;

/**
 * This Interface gives this program more flexibility in dealing with user input.
 * 
 * readFile(String) and readFileInReverse(String) refers to the Java 7 methodology that I'm personally used to.
 * streamFile(String) and streamFileInReverse(String) refers to Java 8 methodology that I picked up recently.
 * @author Tony Toscano
 *
 */
public interface FileInput {
	
	void readFile(String fileName);
	void readFileInReverse(String fileName);
	void streamFile(String fileName);
	void streamFileInReverse(String fileName);
	
}
