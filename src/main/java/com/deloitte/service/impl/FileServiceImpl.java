/**
 * 
 */
package com.deloitte.service.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.deloitte.exception.InvalidInputException;
import com.deloitte.model.Activity;
import com.deloitte.service.FileService;

/**
 * @author rkumari
 *
 */
public class FileServiceImpl implements FileService {

	/**
	 * Method to generate a list of activity from the given file
	 * 
	 * @param fileName File name
	 * @return List of Activity
	 * @throws InvalidInputException
	 */
	public List<Activity> loadActivitiesFromResources(String fileName) throws InvalidInputException {
		List<Activity> tasks = new ArrayList<>();
		try {
			Path path = Paths.get(this.getClass().getClassLoader().getResource(fileName).toURI());
			Files.lines(path).forEach(line -> {
				if (Pattern.matches(Activity.REGEX, line)) {
					Integer duration = this.getMinutes(line.substring(line.lastIndexOf(" ") + 1));
					tasks.add(new Activity(line.substring(0, line.lastIndexOf(" ")), duration));
				} else {
					throw new InvalidInputException(
							"FileServiceImpl:loadActivitiesFromResources: File line " + line + " is invalid");
				}
			});
		} catch (Exception ex) {
			throw new InvalidInputException(
					"FileServiceImpl:loadActivitiesFromResources: problem with loading activity from file:"
							+ ex.getLocalizedMessage());
		}
		return tasks;
	}

	/**
	 * Method to convert sprint to minutes
	 * 
	 * @param value String
	 * @return Integer value of given string
	 * @throws InvalidInputException
	 */
	private Integer getMinutes(String value) throws InvalidInputException {
		Integer result = 0;
		if (Activity.SPRINT.equals(value))
			result = 15;
		else
			result = Integer.valueOf(value.substring(0, value.length() - 3));

		if (result <= 0 || result > 60) {
			throw new InvalidInputException("FileServiceImpl:getMinutes: invalid activity duration: " + result);
		}
		return result;
	}

}
