package com.java.learning.multithreading.split;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

/**
 * Split the huge file to no of small files
 * @author pawank
 *
 */
public class SplitFile {
	
	private static final Logger log = Logger.getLogger(SplitFile.class);
	
	public void splitOperation(String fileName, int limit){
		log.info("Process the file : "+ fileName + "\n"
				+ "Each file should be with "+limit+ " lines.");
		Path path = Paths.get(fileName);

		// Java 8: Stream class
		//use supplier as we need to re-use this at many places
		Supplier<Stream<String>> lines = () -> {
			try {
				return Files.lines(path, StandardCharsets.UTF_8);
			} catch (Exception e) {
				log.error("Error reading the file :"+fileName);
			}
			return null;
		};
		if (lines.get() != null){
			ForkJoinPool pool = new ForkJoinPool(6);
			RecursiveForkFiles refk = new RecursiveForkFiles(lines, 0, limit);
			pool.invoke(refk);
			log.info("Successfully completed the split operation");
		}
		
	}

}
