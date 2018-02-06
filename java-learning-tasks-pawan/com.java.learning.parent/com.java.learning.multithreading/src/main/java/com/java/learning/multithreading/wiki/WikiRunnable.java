package com.java.learning.multithreading.wiki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import com.java.learning.multithreading.exception.MultiThreadException;
import com.java.learning.multithreading.utils.Constants;
import com.java.learning.multithreading.utils.IOUtils;

/**
 * Thread used to access the url and write the content to a file
 * @author pawank
 *
 */
public class WikiRunnable implements Runnable {

	private static final Logger log = Logger.getLogger(WikiRunnable.class);

	private String word;

	public WikiRunnable(String word) {
		this.word = word;
	}

	@Override
	public void run() {
		log.info("Running the thread for word :" + word);

		try {
			URL url = new URL(Constants.WIKI_URL + word);
			log.info("Successfully call to : " + url.getPath());
			URLConnection yc = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
			JSONObject json = new JSONObject(in.readLine());
			IOUtils.writeToFile(Constants.WIKI_OUTPUT_FOLDER + word + ".txt", json.getString("extract"));
		} catch (MalformedURLException e) {
			log.error("Error while forming the wiki URL :" + e.getMessage());
		} catch (IOException e) {
			log.error("Error while reading the response from the stream :" + e.getMessage());
		} catch (JSONException e) {
			log.error("Error , reading the JSON object : " + e.getMessage());
		} catch (MultiThreadException e) {
			log.error("Error while writing to the file " + Constants.WIKI_OUTPUT_FOLDER + word + ".txt" + "\n Error : "
					+ e.getMessage());
		}

	}

}
