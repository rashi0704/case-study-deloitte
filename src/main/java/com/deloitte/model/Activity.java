/**
 * 
 */
package com.deloitte.model;

/**
 * @author rkumari
 *
 */
public class Activity {
	
	public final static String SPRINT = "sprint";
	public final static String REGEX="^[a-zA-Z0-9][a-zA-Z0-9& -]* (([0-9]+min)|sprint)$";

	private String name;

	private Integer duration;

	public Activity(String name, Integer duration) {
		this.name = name;
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}


	@Override
	public String toString() {
		return  new StringBuilder(name).append(" " ).append(duration!=null?(duration==15?SPRINT:duration+"min"):"").toString();
	}


}
