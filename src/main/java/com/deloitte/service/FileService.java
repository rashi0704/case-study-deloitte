/**
 * 
 */
package com.deloitte.service;

import java.util.List;

import com.deloitte.exception.InvalidInputException;
import com.deloitte.model.Activity;

/**
 * @author rkumari
 *
 */
public interface FileService {
	List<Activity> loadActivitiesFromResources(String fileName) throws InvalidInputException ;

}
