package com.java.learning.multithreading.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.java.learning.multithreading.exception.MultiThreadException;


/**
 * This is the Util Class for the IO Files
 * @author pawank
 *
 */
public class IOUtils {
	
	public static final Logger log = Logger.getLogger(IOUtils.class);
	
	/**
	 * Write the stream content to a file
	 * @param fileName
	 * @param document
	 * @throws MultiThreadException 
	 */
	public static final void writeToFile(String fileName, Stream<String> document) throws MultiThreadException{
		log.info(" writeToFile() Stream:  Writing the file : "+fileName);
		try {
			Files.write(Paths.get(fileName),(Iterable<String>) document::iterator);
			log.info(" writeToFile() Stream: Successfully completed in writing the file : "+fileName);
		} catch (IOException e) {
			log.error("writeToFile() Stream:  Error while writing the file : "+fileName+"\n"
					+e.getMessage());
			throw new MultiThreadException(e.getMessage());
		}
		
	}
	
	/**
	 * Write the stream content to a file
	 * @param fileName
	 * @param document
	 * @throws MultiThreadException 
	 */
	public static final void writeToFile(String fileName, Stream<String> document, StandardOpenOption option) throws MultiThreadException{
		log.info(" writeToFile() Stream:  Writing the file : "+fileName);
		try {
			Files.write(Paths.get(fileName),(Iterable<String>) document::iterator,option);
			log.info(" writeToFile() Stream: Successfully completed in writing the file : "+fileName);
		} catch (IOException e) {
			log.error("writeToFile() Stream:  Error while writing the file : "+fileName+"\n"
					+e.getMessage());
			throw new MultiThreadException(e.getMessage());
		}
		
	}
	
	
	/**
	 * Write the string content to a file
	 * @param fileName
	 * @param document
	 * @throws MultiThreadException 
	 */
	public static void writeToFile(String fileName, String document) throws MultiThreadException{
		log.info("Writing the file : "+fileName);
		try {
			Files.write(Paths.get(fileName), document.getBytes());
			log.info(" writeToFile() Stream: Successfully completed in writing the file : "+fileName);
		} catch (IOException e) {
			log.error("writeToFile() Stream:  Error while writing the file : "+fileName+e.getMessage());
			throw new MultiThreadException(e.getMessage());
		}
		
	}

}
