import java.util.*;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private int availableSlots;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.availableSlots = capacity;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getavailableSlots() {
        return availableSlots;
    }

    public void registerStudent() {
        if (availableSlots > 0)
            availableSlots--;
        else
            System.out.println("Sorry, this course is already full.");
    }

    public void dropStudent() {
        if (availableSlots < capacity)
            availableSlots++;
        else
            System.out.println("There are no student registered for this course.");
    }
}

class Student {
    private int studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
        course.registerStudent();
    }

    public void dropCourse(Course course) {
        registeredCourses.remove(course);
        course.dropStudent();
    }
}

public class studentCourseManagement{
    public static void main(String[] args) {
        Course computerScience = new Course("CS101", "Computer Science ", "Introduction to Technology", 20,"Monday 10:00 AM");
        Course mechanicalEngineer = new Course("CS102", "Mechanical Engineering", "Introduction to Machines",15, "Wednesday 2:00 PM");
        Course civilEngineer = new Course("CS103", "Civil Engineering ","Introduction to constrution of roads",10, "Saturday 9:00 AM");  

        List<Course> availableCourses = new ArrayList<>();
        availableCourses.add(computerScience);
        availableCourses.add(mechanicalEngineer);
        availableCourses.add(civilEngineer);

        Scanner sc = new Scanner(System.in);

        System.out.println("Available Courses:");
        for (Course course : availableCourses) {
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Title: " + course.getTitle());
            System.out.println("Description: " + course.getDescription());
            System.out.println("Schedule: " + course.getSchedule());
            System.out.println("Available Slots: " + course.getavailableSlots());
            System.out.println("--------------------");
        }

        // Student registration
        System.out.print("Enter student ID: ");
        int studentID = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter student name: ");
        String studentName = sc.nextLine();

        Student student = new Student(studentID, studentName);

        System.out.print("Enter course code to register (or 'quit' to finish): ");
        String courseCode = sc.nextLine();

        while (!courseCode.equalsIgnoreCase("quit")) {
            Course selectedCourse = null;
            for (Course course : availableCourses) {
                if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                    selectedCourse = course;
                    break;
                }
            }

            if (selectedCourse != null) {
                student.registerCourse(selectedCourse);
                System.out.println("Successfully registered for course: " + selectedCourse.getTitle());
            } else {
                System.out.println("Invalid course code. Please try again.");
            }

            System.out.print("Enter course code to register (or 'quit' to finish): ");
            courseCode = sc.nextLine();
        }

        // Display registered courses for the student
        System.out.println("Registered Courses for " + student.getName() + ":");
        List<Course> registeredCourses = student.getRegisteredCourses();
        for (Course course : registeredCourses) {
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Title: " + course.getTitle());
            System.out.println("Description: " + course.getDescription());
            System.out.println("Schedule: " + course.getSchedule());
            System.out.println("--------------------");
        }

        // Student dropping course
        System.out.print("Enter course code to drop (or 'quit' to finish): ");
        courseCode = sc.nextLine();

        while (!courseCode.equalsIgnoreCase("quit")) {
            Course selectedCourse = null;
            for (Course course : registeredCourses) {
                if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                    selectedCourse = course;
                    break;
                }
            }

            if (selectedCourse != null) {
                student.dropCourse(selectedCourse);
                System.out.println("Successfully dropped course: " + selectedCourse.getTitle());
            } else {
                System.out.println("Invalid course code. Please try again.");
            }

            System.out.print("Enter course code to drop (or 'quit' to finish): ");
            courseCode = sc.nextLine();
        }

        
    }
}