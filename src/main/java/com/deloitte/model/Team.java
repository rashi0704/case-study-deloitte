/**
 * 
 */
package com.deloitte.model;

import java.util.List;

/**
 * @author rkumari
 *
 */
public class Team {
	private int teamNumber;
	
	private List<Program> programs;
	
	public Team(int teamNumber, List<Program> programs){
		this.teamNumber=teamNumber;
		this.programs=programs;
	}
	
	@Override
	public String toString() {
		return "Team " + teamNumber;
	}

	public List<Program> getPrograms() {
		return programs;
	}

	public void setPrograms(List<Program> programs) {
		this.programs = programs;
	}

	
}
