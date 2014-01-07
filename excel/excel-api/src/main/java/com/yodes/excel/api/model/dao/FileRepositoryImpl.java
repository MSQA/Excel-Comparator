package com.yodes.excel.api.model.dao;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;

@Repository("fileRepository")
public class FileRepositoryImpl implements FileRepository {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(FileRepositoryImpl.class);

	@Autowired
	private GridFsTemplate gridTemplate;

	@Override
	public String save(InputStream inputStream, String fileName) throws IOException {
		String fileId = null;
		try {
			GridFSFile response = gridTemplate.store(inputStream, fileName);
			fileId = response.getId().toString();
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug("Saved file using fileId {}", fileId);
		}
		return fileId;
	}

	@Override
	public void delete(String fileId) {
		Assert.notNull(fileId);
		gridTemplate.delete(new Query(Criteria.where("_id").is(fileId)));
	}

	@Override
	public InputStream findOne(String fileId) {
		InputStream input = null;
		GridFSDBFile gridFSDBFile = gridTemplate.findOne(new Query(Criteria.where("_id").is(fileId)));
		if (gridFSDBFile != null) {
			input = gridFSDBFile.getInputStream();
		}
		return input;
	}

}
