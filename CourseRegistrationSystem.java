import java.util.ArrayList;
import java.util.Scanner;

//Class to represent a Course with details like code, title, capacity, etc.
class Course
{
private String code;
private String title;
private String description;
private int capacity;
private String schedule;
private int registeredStudents;

public Course(String code, String title, String description, int capacity, String schedule)
{
this.code = code;
this.title = title;
this.description = description;
this.capacity = capacity;
this.schedule = schedule;
this.registeredStudents = 0;
}
public String getCode()
{
return code;
}
public String getTitle()
{
return title;
}
public String getDescription()
{
return description;
}
public int getAvailableSlots()
{
return capacity - registeredStudents;
}
public boolean isFull()
{
return registeredStudents >= capacity;
}
public void registerStudent()
{
if (!isFull())
{
registeredStudents++;
}
}
public void removeStudent()
{
if (registeredStudents > 0)
{
registeredStudents--;
}
}
public String getSchedule()
{
return schedule;
}
public void displayCourseDetails()
{
System.out.println(code + " - " + title + "\nDescription: " + description);
System.out.println("Capacity: " + capacity + " | Registered: " + registeredStudents + " | Available: " + getAvailableSlots());
System.out.println("Schedule: " + schedule + "\n");
}
}

//Class to represent a Student with details like studentID, name, and registered courses.
class Student
{
private String studentID;
private String name;
private ArrayList<Course> registeredCourses;
public Student(String studentID, String name)
{
this.studentID = studentID;
this.name = name;
this.registeredCourses = new ArrayList<>();
}
public String getStudentID()
{
return studentID;
}
public String getName()
{
return name;
}
public void registerForCourse(Course course)
{
if (!course.isFull() && !registeredCourses.contains(course))
{
registeredCourses.add(course);
course.registerStudent();
System.out.println("Successfully registered for " + course.getTitle());
}
else
{
System.out.println("Course is full or already registered.");
}
}
public void dropCourse(Course course)
{
if (registeredCourses.contains(course))
{
registeredCourses.remove(course);
course.removeStudent();
System.out.println("Successfully dropped " + course.getTitle());
}
else
{
System.out.println("You are not registered in this course.");
}
}
public void listRegisteredCourses()
{
System.out.println("\n" + name + "'s Registered Courses:");
if (registeredCourses.isEmpty())
{
System.out.println("No courses registered.");
}
else
{
for (Course course : registeredCourses)
{
System.out.println(course.getCode() + " - " + course.getTitle());
}
}
System.out.println();
}
}

//Main class to run the Course Registration System
public class CourseRegistrationSystem
{
public static void main(String[] args)
{
Scanner scanner = new Scanner(System.in);

//Initialize some courses
ArrayList<Course> courses = new ArrayList<>();
courses.add(new Course("CS101", "Cyber Security", "Learn about protecting systems, networks, programs from digital attacks", 30, "MWF 10:00-11:30 AM"));
courses.add(new Course("CS102", "Data Structures & Algorithms", "Learn ways for organizing and manipulating data to solve problems", 25, "TTh 1:00-2:30 PM"));
courses.add(new Course("CS103", "Intro to Java Programming", "To learn Basic Java coding skills", 20, "MWF 2:00-3:00 PM"));

//Initialize a student
Student student = new Student("S123", "Shreya");
int choice;
do
{
System.out.println("\n--- Course Registration System ---");
System.out.println("1. View Available Courses");
System.out.println("2. Register for a Course");
System.out.println("3. Drop a Course");
System.out.println("4. View Registered Courses");
System.out.println("5. Exit");
System.out.print("Enter your choice: ");
choice = scanner.nextInt();
scanner.nextLine();// Consume the newline
switch (choice)
{
case 1:
// List available courses
System.out.println("\nAvailable Courses:");
for (Course course : courses)
{
course.displayCourseDetails();
}
break;
case 2:
// Register for a course
System.out.print("Enter course code to register: ");
String courseCode = scanner.nextLine();
Course courseToRegister = findCourseByCode(courses, courseCode);
if (courseToRegister != null)
{
student.registerForCourse(courseToRegister);
}
else
{
System.out.println("Course not found.");
}
break;
case 3:
// Drop a course
System.out.print("Enter course code to drop: ");
String courseToDropCode = scanner.nextLine();
Course courseToDrop = findCourseByCode(courses, courseToDropCode);
if (courseToDrop != null)
{
student.dropCourse(courseToDrop);
}
else
{
System.out.println("Course not found.");
}
break;
case 4:
// View registered courses
student.listRegisteredCourses();
break;
case 5:
System.out.println("Exiting the system. Goodbye!");
break;
default:
System.out.println("Invalid choice. Please try again.");
}
}
while (choice != 5);
scanner.close();
}

//Helper function to find a course by its code
public static Course findCourseByCode(ArrayList<Course> courses, String code)
{
for (Course course : courses)
{
if (course.getCode().equalsIgnoreCase(code))
{
return course;
}
}
return null;
}
} 






 


   
 

 

 