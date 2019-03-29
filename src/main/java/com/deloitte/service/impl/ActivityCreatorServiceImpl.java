package com.deloitte.service.impl;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.deloitte.exception.InvalidInputException;
import com.deloitte.model.Activity;
import com.deloitte.model.ActivityDay;
import com.deloitte.model.Program;
import com.deloitte.model.Team;
import com.deloitte.service.ActivityCreatorService;

public class ActivityCreatorServiceImpl implements ActivityCreatorService {

	/**
	 * Method to generate a list of teams and programs of that team from the
	 * given activity and the configured Activity day details
	 * 
	 * @param List of Activity and ActivityDay
	 * @return List of Team
	 * @throws InvalidInputException
	 */
	@Override
	public List<Team> createActivitiesForDay(List<Activity> activities, ActivityDay activityDay)
			throws InvalidInputException {
		List<Team> teams = new ArrayList<>();
		try {
			//get total activity durations
			int totalDuration = activities.stream().mapToInt(activity -> activity.getDuration()).sum();
			//calculate number of teams needed
			int numberOfTeams = (int) Math.ceil(totalDuration / (float) activityDay.getActivityMinutes());
			//sort the activities
			List<Activity> orderedActivities = activities.stream()
					.sorted((t1, t2) -> t2.getDuration() - t1.getDuration()).collect(Collectors.toList());

			//create list of programs for each team
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
						if (!endstartTime.plusMinutes(activity.getDuration())
								.isAfter(activityDay.getEveningEndTime())) {
							programs.add(new Program(endstartTime, activity));
							orderedActivitiesItr.remove();
							endstartTime = endstartTime.plusMinutes(activity.getDuration());
						}
					}
				}
				//adding the end activity
				programs.add(
						new Program(
								endstartTime.isBefore(activityDay.getEndActivityTime())
										? activityDay.getEndActivityTime() : endstartTime,
						new Activity(activityDay.getEndActivity(), null)));
				teams.add(new Team(i, programs));
			}
		} catch (Exception e) {
			throw new InvalidInputException("Exception while creating activities for day. " + e.getMessage());
		}
		return teams;
	}

}
