package com.deloitte.model;

import java.time.Duration;
import java.time.LocalTime;

public class ActivityDay {
	
	private LocalTime morningStartTime;
	private LocalTime morningEndTime;
	private LocalTime eveningStartTime;
	private LocalTime eveningEndTime;
	private String endActivity;
	private LocalTime endActivityTime;
	
	public LocalTime getMorningStartTime() {
		return morningStartTime;
	}
	
	public LocalTime getMorningEndTime() {
		return morningEndTime;
	}
	
	public LocalTime getEveningStartTime() {
		return eveningStartTime;
	}
	
	public LocalTime getEveningEndTime() {
		return eveningEndTime;
	}

	public String getEndActivity() {
		return endActivity;
	}

	public LocalTime getEndActivityTime() {
		return endActivityTime;
	}

	public ActivityDay(LocalTime morningStartTime, LocalTime morningEndTime, LocalTime eveningStartTime,
			LocalTime eveningEndTime, String endActivity, LocalTime endActivityTime) {
		super();
		this.morningStartTime = morningStartTime;
		this.morningEndTime = morningEndTime;
		this.eveningStartTime = eveningStartTime;
		this.eveningEndTime = eveningEndTime;
		this.endActivity= endActivity;
		this.endActivityTime= endActivityTime;
	}
	
	public long getActivityMinutes(){
		return (Duration.between(morningStartTime, morningEndTime).getSeconds()+Duration.between(eveningStartTime, eveningEndTime).getSeconds())/60;
	}
	
}
