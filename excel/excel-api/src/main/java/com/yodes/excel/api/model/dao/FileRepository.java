package com.yodes.excel.api.model.dao;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.util.Assert;

public interface FileRepository {

	/**
	 * Save a file input stream and return the file id. Once the file has been uploaded it will close the input stream
	 * 
	 * @param fileInputstream
	 *            not null and exists
	 * @param fileName
	 *            name of the file to store
	 * @return file unique id
	 * @throws IOException
	 */
	String save(InputStream fileInputstream, String fileName) throws IOException;

	/**
	 * Delete any file that matches passed fileLocation. {@link Assert} fileLocation is not null
	 * 
	 * @param fileId
	 *            unique id
	 */
	void delete(String fileId);

	/**
	 * Delete any file that matches passed fileLocation. {@link Assert} fileLocation is not null
	 * 
	 * @param fileId
	 *            unique id
	 */
	InputStream findOne(String fileId);

}
