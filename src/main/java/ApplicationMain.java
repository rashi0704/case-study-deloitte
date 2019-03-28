import java.time.LocalTime;
import java.util.List;

import com.deloitte.exception.InvalidInputException;
import com.deloitte.model.Activity;
import com.deloitte.model.ActivityDay;
import com.deloitte.model.Program;
import com.deloitte.model.Team;
import com.deloitte.service.ActivityCreatorService;
import com.deloitte.service.FileService;
import com.deloitte.service.impl.ActivityCreatorServiceImpl;
import com.deloitte.service.impl.FileServiceImpl;

public class ApplicationMain {

	static String INPUT = "input.txt";

	public static void main(String[] args) {

		FileService fileService = new FileServiceImpl();
		ActivityCreatorService activityCreator = new ActivityCreatorServiceImpl();
		try {

			List<Activity> activity = fileService.loadActivitiesFromResources(INPUT);
			ActivityDay activityDay = new ActivityDay(LocalTime.of(9, 00), LocalTime.of(12, 00), LocalTime.of(13, 00),
					LocalTime.of(17, 00));
			System.out.println("Deloitte Away Day:");
			for (Team team : activityCreator.createActivitiesForDay(activity, activityDay)) {
				System.out.println(team);
				for (Program program : team.getPrograms()) {
					System.out.println(program);
				}
			}
		} catch (InvalidInputException e) {
			System.out.println("There was an error creating activities:" + e.getLocalizedMessage());
		}
	}

}
