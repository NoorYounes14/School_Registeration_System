import java.util.ArrayList;

public class Professor extends User {

    private String department;
    private ArrayList<String> timetable;
    private ArrayList<String> assignments;
    private static ArrayList<Professor> allProfessors = new ArrayList<>(); //static because it belongs to class not obj

    public Professor(int id, String name, String email, String password, String department) {
        super(id, name, email, password);
        this.department = department;
        this.timetable = new ArrayList<>();
        this.assignments = new ArrayList<>();
        allProfessors.add(this);
    }

    public void viewTimetable() {
        System.out.println("Professor Timetable:");
        if (timetable.isEmpty()) {
            System.out.println("No timetable available.");
        } else {
            for (String session : timetable) {
                System.out.println("- " + session);
            }
        }
    }

    public void addTimetableEntry(String entry) {
        timetable.add(entry);
    }

    public void viewAssignments() {
        System.out.println("Assignments:");
        if (assignments.isEmpty()) {
            System.out.println("No assignments available.");
        } else {
            for (String assignment : assignments) {
                System.out.println("- " + assignment);
            }
        }
    }

    public void addAssignment(String assignment) {
        assignments.add(assignment);
    }

    public void assignGrade(Student student, String assignmentTitle, int grade) {
        student.addPastGrade(assignmentTitle, grade);
        System.out.println("Grade assigned to " + student.getName()
                + " | Assignment: " + assignmentTitle
                + " | Grade: " + grade);
    }

    public void sendWarning(Student student, String reason) {
        student.addNotification("Warning from " + getName() + ": " + reason);
        System.out.println("Warning sent to " + student.getName());
    }

    public void uploadAnnouncement(Student student, String message) {
        student.addNotification("Announcement from " + getName() + ": " + message);
        System.out.println("Announcement uploaded.");
    }

    @Override
    public Professor login(String email, String password) {
        for (Professor p : allProfessors) {
            if (p.getEmail().equals(email) && p.getPassword().equals(password)) {
                return p;
            }
        }
        return null;
    }

    public static ArrayList<Professor> getAllProfessors() {
        return allProfessors;
    }
}