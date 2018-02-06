package com.java.learning.multithreading.split;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.java.learning.multithreading.exception.MultiThreadException;
import com.java.learning.multithreading.utils.Constants;
import com.java.learning.multithreading.utils.IOUtils;

/**
 * Use fork and join to process the data and write to file
 * 
 * @author pawank
 *
 */
public class RecursiveForkFiles extends RecursiveAction {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(RecursiveForkFiles.class);

	private Supplier<Stream<String>> lines;

	private int firstLine;

	private int limit;

	public RecursiveForkFiles(Supplier<Stream<String>> lines, int firstLine, int limit) {
		this.lines = lines;
		this.firstLine = firstLine;
		this.limit = limit;
	}

	@Override
	protected void compute() {
		log.info("Entering into the compute method for the line number :" + firstLine);
		List<RecursiveForkFiles> forks = new LinkedList<>();
		long lineCount = lines.get().count();
		String fileName = Constants.SPLIT_LINES_OUTPUT.split(Constants.SPLIT_LINES_OUTPUT_DELIM)[0];
		String fileExt = Constants.SPLIT_LINES_OUTPUT.split(Constants.SPLIT_LINES_OUTPUT_DELIM)[1];

		if (lineCount <= limit) {
			log.info("Started Writing the file :" + fileName + "_" + firstLine / limit + fileExt);
			try {
				IOUtils.writeToFile(fileName + "_" + firstLine / limit + fileExt, lines.get());
			} catch (MultiThreadException e) {
				log.error("Error while writing the file: " + fileName + "_" + firstLine / limit + fileExt);
			}

		} else {
			log.info("Splitting the objects");
			for (int i = 0; i <= lineCount; i = i + limit) {
				final int j = i;
				Supplier<Stream<String>> steam = () -> lines.get().skip(j).limit(limit);
				forks.add(new RecursiveForkFiles(steam, i, limit));
			}
			log.info("Forking all the messages");
			for (RecursiveForkFiles action : forks) {
				action.fork();
			}
			log.info("joining all the messages");
			for (RecursiveForkFiles action : forks) {
				action.join();
			}
		}
		log.info("Existing from the compute method for the line number :" + firstLine);
	}

}
