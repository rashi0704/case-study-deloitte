package com.deloitte.service.impl;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.deloitte.model.Activity;
import com.deloitte.model.ActivityDay;
import com.deloitte.model.Program;
import com.deloitte.model.Team;
import com.deloitte.service.ActivityCreatorService;

public class ActivityCreatorServiceImpl implements ActivityCreatorService {

	@Override
	public List<Team> createActivitiesForDay(List<Activity> activities, ActivityDay activityDay) {
		int totalDuration = activities.stream().mapToInt(activity -> activity.getDuration()).sum();
		int numberOfTeams= (int) Math.ceil(totalDuration / (float)activityDay.getActivityMinutes());
		List<Team> teams = new ArrayList<>();
		List<Activity> orderedActivities = activities.stream().sorted((t1, t2) -> t2.getDuration() - t1.getDuration())
				.collect(Collectors.toList());

		for (int i = 1; i <= numberOfTeams; i++) {
			List<Program> programs = new ArrayList<>();
			Iterator<Activity> orderedActivitiesItr = orderedActivities.iterator();
			LocalTime startTime = activityDay.getMorningStartTime();
			LocalTime endstartTime = activityDay.getEveningStartTime();
			while (orderedActivitiesItr.hasNext()) {
				Activity activity = orderedActivitiesItr.next();
				if (!startTime.plusMinutes(activity.getDuration()).isAfter(activityDay.getMorningEndTime())) {
					programs.add(new Program(startTime, activity));
					orderedActivitiesItr.remove();
					startTime = startTime.plusMinutes(activity.getDuration());
				} else {
					if (!endstartTime.plusMinutes(activity.getDuration()).isAfter(activityDay.getEveningEndTime())) {
						programs.add(new Program(endstartTime, activity));
						orderedActivitiesItr.remove();
						endstartTime = endstartTime.plusMinutes(activity.getDuration());
					}
				}
			}
			programs.add(new Program(endstartTime, new Activity("Staff Motivation Presentation", null)));
			teams.add(new Team(i, programs));
		}
		return teams;
	}

}
