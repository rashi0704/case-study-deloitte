# case-study-deloitte
# Author
Rameshwari Kumari (rashi0704@gmail.com)
# Details
“Deloitte Digital Away Day" is an event for rewarding Deloitte digital employees.
“case-study-deloitte" is a project to help the event organisers to accommodate various activities for the Digital Away day.
It generates a day program with team details using the input file stored in the directory `src\main\resources\input.txt`.

Input format should be either of the following:
1. [task_name] [duration in minutes] e.g. "Duck Herding 60min"
2. [task_name] sprint e.g. "Salsa & Pickles sprint"

Some informations provided:
1. sprint is used for 15 minutes.
2. The employees will be divided into various teams and each team will be performing various activities
3. Morning activities start from 9am to 12 noon.
4. Evening activities starts from 1pm and ends with "Staff Motivation Presentation" which should be started by 4-5pm.
5. There needs to be no gap between each activity


Sample Input:

Duck Herding 60min
Archery 45min
Learning Magic Tricks 40min
Laser Clay Shooting 60min
Human Table Football 30min
Buggy Driving 30min
Salsa & Pickles sprint
2-wheeled Segways 45min
Viking Axe Throwing 60min
Giant Puzzle Dinosaurs 30min
Giant Digital Graffiti 60min
Cricket 2020 60min
Wine Tasting sprint
Arduino Bonanza 30min
Digital Tresure Hunt 60min
Enigma Challenge 45min
Monti Carlo or Bust 60min
New Zealand Haka 30min
Time Tracker sprint
Indiano Drizzle 45min

##technologies
* [Java] - Code base language (version 1.8)
* [Apache Maven] - Build automation tool (version 3.3.9)
* [junit] - Library for testing (version 4.11)

In the terminal and execute these commands to compile and execute:
$ mvn clean package
$ mvn exec:java


Find bellow output shown in the terminal for given example:
Deloitte Away Day: OUTPUT
Team 1
09:00 AM : Duck Herding 60min
10:00 AM : Laser Clay Shooting 60min
11:00 AM : Viking Axe Throwing 60min
01:00 PM : Giant Digital Graffiti 60min
02:00 PM : Cricket 2020 60min
03:00 PM : Digital Tresure Hunt 60min
04:00 PM : Monti Carlo or Bust 60min
05:00 PM : Staff Motivation Presentation 
Team 2
09:00 AM : Archery 45min
09:45 AM : 2-wheeled Segways 45min
10:30 AM : Enigma Challenge 45min
11:15 AM : Indiano Drizzle 45min
01:00 PM : Learning Magic Tricks 40min
01:40 PM : Human Table Football 30min
02:10 PM : Buggy Driving 30min
02:40 PM : Giant Puzzle Dinosaurs 30min
03:10 PM : Arduino Bonanza 30min
03:40 PM : New Zealand Haka 30min
04:10 PM : Salsa & Pickles sprint
04:25 PM : Wine Tasting sprint
04:40 PM : Time Tracker sprint
05:00 PM : Staff Motivation Presentation 

## Design
The classes used in this project:

com.deloitte.model
->Activity: *Class to store a activity data (name, duration)*
->ActivityDay: *Class to store configurable morning and evening start and finish time(time stored using LocalTime). Also method to return total activity minutes for one day*
->Program: *Class to store Program detail(startTime and Activity)*
->Team: *Class to store team number and list of Programs. This will be used as output*

com.deloitte.service 
com.deloitte.service.impl
->FileService: *Class with a method for reading a list of activities from a file (specific format).*
->ActivityCreatorService: *Class with a method to create the list of Teams and their Programs. This will be the output*

com.deloitte.exception
->InvalidInputException: *Returned exception when a functional or execution error occurs*
