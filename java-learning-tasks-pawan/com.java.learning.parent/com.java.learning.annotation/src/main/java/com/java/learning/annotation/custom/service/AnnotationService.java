package com.java.learning.annotation.custom.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.java.learning.annotation.custom.AccountValidation;
import com.java.learning.annotation.custom.ConsistencyValidation;
import com.java.learning.annotation.custom.ContactPropertiesValidation;
import com.java.learning.annotation.custom.DocumentType;
import com.java.learning.annotation.custom.impl.AccountValidationImpl;
import com.java.learning.annotation.custom.impl.ContactPropertiesValidationImpl;
import com.java.learning.annotation.model.Aadhar;
import com.java.learning.annotation.model.Bank;
import com.java.learning.annotation.model.Document;
import com.java.learning.annotation.model.PanDetails;

/**
 * Execution point for the annotation to trigger
 * 
 * @author pawank
 *
 */
public class AnnotationService {

	private static Logger log = Logger.getLogger(AnnotationService.class);

	private AccountValidationImpl accVal;

	private ContactPropertiesValidationImpl conVal;

	private Map<String, Boolean> docStatus;

	public AnnotationService() {
		log.info("Annotation service implementation ");
		accVal = new AccountValidationImpl();
		conVal = new ContactPropertiesValidationImpl();
		docStatus = new HashMap<String, Boolean>();
	}

	/**
	 * This method check for name consistency
	 * 
	 * @param documents
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public boolean consistencyCheck(List<Document> documents) throws IllegalArgumentException, IllegalAccessException {
		log.info("Checking the consistency Check");
		String chkField = "";
		for (Document doc : documents) {
			for (Annotation anno : doc.getClass().getDeclaredAnnotations()) {
				if (anno instanceof DocumentType) {
					String docName = ((DocumentType) anno).docName();
					log.info("Document Name :" + docName);
				}
			}
			Field[] fields = doc.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				if (field.isAnnotationPresent(ConsistencyValidation.class)) {

					if ("".equalsIgnoreCase(chkField)) {
						chkField = (field.get(doc) != null) ? field.get(doc).toString() : "";
					}
					if (field.get(doc) != null && chkField.equalsIgnoreCase(field.get(doc).toString())) {
						log.info("Field Name : "+field.getName());
						log.info("Field value :"+field.get(doc).toString());
						chkField = field.get(doc).toString();
					} else {
						chkField = "";
					}
				}
			}
			if ("".equalsIgnoreCase(chkField)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * This method validates the document and stores the doc status
	 * 
	 * @param documents
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public Map<String, Boolean> validateDocuments(List<Document> documents)
			throws IllegalArgumentException, IllegalAccessException {
		for (Document doc : documents) {
			String docName = "";

			for (Annotation anno : doc.getClass().getDeclaredAnnotations()) {
				if (anno instanceof DocumentType) {
					docName = ((DocumentType) anno).docName();
					log.info("Document Name :" + docName);
				}
			}
			Field[] fields = doc.getClass().getDeclaredFields();
			boolean isDocValid = true;
			for (Field field : fields) {
				field.setAccessible(true);
				boolean isValid = true;
				Annotation[] annotations = field.getAnnotations();
				log.info("Field Name :" + field.getName());
				for (Annotation annotation : annotations) {
					log.info("Annotation Name :" + annotation.annotationType().getName());
					log.info("Annotation value :" + field.get(doc));
					if (annotation instanceof AccountValidation) {
						accVal.intilize((AccountValidation) annotation);
						isValid = accVal.isValid((field.get(doc) != null) ? field.get(doc).toString() : null);
					} else if (annotation instanceof ContactPropertiesValidation) {
						conVal.intilize((ContactPropertiesValidation) annotation);
						isValid = conVal.isValid((field.get(doc) != null) ? field.get(doc).toString() : null);
					}
					if (!isValid) {
						isDocValid = false;
					}
				}
			}
			log.info("Doc Name :" + docName + " Doc Status :" + isDocValid);
			docStatus.put(docName, isDocValid);
		}

		return docStatus;

	}

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		List<Document> res = new ArrayList<Document>();
		Document bank = new Bank();
		Document pan = new PanDetails();
		Document aad = new Aadhar();

		res.add(bank);
		res.add(aad);
		res.add(pan);

		AnnotationService ann = new AnnotationService();
		Map<String, Boolean> docStatus = ann.validateDocuments(res);
		System.out.println(docStatus.keySet());
		System.out.println(docStatus.values());

	}

}
