package com.yodes.excel.dao;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yodes.excel.model.dao.FileRepositoryImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:test-dao-context.xml"
})
public class FileRepositoryTest {

	@Autowired
	private FileRepositoryImpl fileRepository;

	@Autowired
	private GridFsTemplate gridTemplate;

	@Before
	public void setUp() {
		gridTemplate.delete(null);
	}

	@Test
	public void testSave() throws IOException {
		File testFile = new File("target/test-classes/textfile.txt");
		String id = fileRepository.save(testFile);
		TestCase.assertNotNull(id);
	}

	@Test
	public void testAddFindAndDelete() throws IOException {
		File testFile = new File("target/test-classes/textfile.txt");
		String id = fileRepository.save(testFile);
		TestCase.assertNotNull(fileRepository.findOne(id));
		fileRepository.delete(id);
		TestCase.assertNull(fileRepository.findOne(id));
	}

}
