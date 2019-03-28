package com.deloitte.service.impl;

import java.time.LocalTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.deloitte.model.Activity;
import com.deloitte.model.ActivityDay;
import com.deloitte.service.ActivityCreatorService;
import com.deloitte.service.FileService;

public class ActivityCreatorServiceImplTest {

	ActivityCreatorService testActivityService;
	ActivityDay activityDay;
	List<Activity> activities;
	
	@Before
	public void setup(){
		testActivityService=new ActivityCreatorServiceImpl();
		FileService fileService=new FileServiceImpl();	
		activities = fileService.loadActivitiesFromResources("test_input.txt");
		activityDay= new ActivityDay(LocalTime.of(9, 00), LocalTime.of(12, 00), LocalTime.of(13, 00),
				LocalTime.of(17, 00));
	}

	@Test
	public void testLoadActivitiesFromResources() {
		
		Assert.assertNotNull(testActivityService.createActivitiesForDay(activities,activityDay));
		
	}

}
