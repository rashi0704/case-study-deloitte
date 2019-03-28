package com.deloitte.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.deloitte.exception.InvalidInputException;
import com.deloitte.service.FileService;

public class FileServiceImplTest {
	
	FileService testFileService;
	
	@Before
	public void setup(){
		testFileService=new FileServiceImpl();
	}

	@Test
	public void testLoadActivitiesFromResources() {
		String fileName = "test_input.txt";
		Assert.assertNotNull(testFileService.loadActivitiesFromResources(fileName));
		
	}

	@Test(expected = InvalidInputException.class)
	public void loadTasks_wrong_1() throws InvalidInputException {
		// Given
		String fileName = "input_test_wrong_1.txt";
		testFileService.loadActivitiesFromResources(fileName);
		// Then -> exception
	}
}
