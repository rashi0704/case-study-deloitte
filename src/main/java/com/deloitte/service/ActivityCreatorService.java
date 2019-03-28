package com.deloitte.service;

import java.util.List;

import com.deloitte.model.Activity;
import com.deloitte.model.ActivityDay;
import com.deloitte.model.Team;

public interface ActivityCreatorService {

	List<Team> createActivitiesForDay(List<Activity> activity, ActivityDay activityDay);
	
	

}
