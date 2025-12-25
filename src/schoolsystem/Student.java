import java.util.ArrayList;

public class Student extends User {

    private ArrayList<String> timetable;
    private ArrayList<String> pastAssignments;
    private ArrayList<Integer> pastGrades;
    private ArrayList<String> upcomingAssignments;
    private ArrayList<String> notifications;
    private int attendance;
    private static ArrayList<Student> allStudents = new ArrayList<>(); //static because it belongs to class not obj

    public Student(int id, String name, String email, String password) {
        super(id, name, email, password);
        timetable = new ArrayList<>();
        pastAssignments = new ArrayList<>();
        pastGrades = new ArrayList<>();
        upcomingAssignments = new ArrayList<>();
        notifications = new ArrayList<>();
        attendance = 0;
        allStudents.add(this);
    }

    public void viewTimetable() {
        System.out.println("Timetable:");
        if (timetable.isEmpty()) {
            System.out.println("No timetable available.");
        } else {
            for (String t : timetable) {
                System.out.println(t);
            }
        }
    }

    public void viewPastGrades() {
        System.out.println("Past Grades:");
        if (pastAssignments.isEmpty()) {
            System.out.println("No grades available.");
        } else {
            for (int i = 0; i < pastAssignments.size(); i++) {
                System.out.println(pastAssignments.get(i) + ": " + pastGrades.get(i));
            }
        }
    }

    public void viewUpcomingAssignments() {
        System.out.println("Upcoming Assignments:");
        if (upcomingAssignments.isEmpty()) {
            System.out.println("No upcoming assignments.");
        } else {
            for (String a : upcomingAssignments) {
                System.out.println(a);
            }
        }
    }

    public void viewAttendance() {
        System.out.println("Attendance: " + attendance + "%");
    }

    public void viewNotifications() {
        System.out.println("Notifications:");
        if (notifications.isEmpty()) {
            System.out.println("No notifications.");
        } else {
            for (String n : notifications) {
                System.out.println(n);
            }
        }
    }

    public void addTimetableEntry(String entry) {
        timetable.add(entry);
    }

    public void addUpcomingAssignment(String assignment) {
        upcomingAssignments.add(assignment);
    }

    public void addPastGrade(String assignment, int grade) {
        pastAssignments.add(assignment);
        pastGrades.add(grade);
    }

    public void addNotification(String message) {
        notifications.add(message);
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    @Override
    public Student login(String email, String password) {
        for (Student s : allStudents) {
            if (s.getEmail().equals(email) && s.getPassword().equals(password)) {
                return s;
            }
        }
        return null;
    }

    public static ArrayList<Student> getAllStudents() {
        return allStudents;
    }
}