package com.deloitte.model;

import java.time.Duration;
import java.time.LocalTime;

public class ActivityDay {
	
	private LocalTime morningStartTime;
	private LocalTime morningEndTime;
	private LocalTime eveningStartTime;
	private LocalTime eveningEndTime;
	
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

	public ActivityDay(LocalTime morningStartTime, LocalTime morningEndTime, LocalTime eveningStartTime,
			LocalTime eveningEndTime) {
		super();
		this.morningStartTime = morningStartTime;
		this.morningEndTime = morningEndTime;
		this.eveningStartTime = eveningStartTime;
		this.eveningEndTime = eveningEndTime;
	}
	
	public long getActivityMinutes(){
		return (Duration.between(morningStartTime, morningEndTime).getSeconds()+Duration.between(eveningStartTime, eveningEndTime).getSeconds())/60;
	}
	
}
