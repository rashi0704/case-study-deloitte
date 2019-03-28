/**
 * 
 */
package com.deloitte.model;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author rkumari
 *
 */
public class Program {
	
	private LocalTime startTime;
	
	private Activity activity;
	
	public Program( LocalTime startTime, Activity activity) {
		super();
		this.activity = activity;
		this.startTime = startTime;
	}

	@Override
	public String toString() {
		return  startTime.format(DateTimeFormatter.ofPattern("hh:mm a")) + " : " + activity;
	}

}
