public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin(1, "Ahmed Mostafa", "admin@school.com", "adminpass");

        Student s1 = new Student(201, "Asser Fouad", "asser@student.com", "asserpass");
        Student s2 = new Student(202, "Mohamed Mostafa", "mohamed@student.com", "mohamedpass");

        Professor p1 = new Professor(101, "Noor Ihab", "noor@prof.com", "noorpass", "Math");
        Professor p2 = new Professor(102, "Tarek Ebrahim", "tarek@prof.com", "tarekpass", "Physics");

        admin.addNewStudent(s1);
        admin.addNewStudent(s2);
        admin.addNewTeacher(p1);
        admin.addNewTeacher(p2);

        Student loggedS1 = s1.login("asser@student.com", "asserpass");
        Student loggedS2 = s2.login("mohamed@student.com", "mohamedpass");
        Professor loggedP1 = p1.login("noor@prof.com", "noorpass");
        Professor loggedP2 = p2.login("tarek@prof.com", "tarekpass");
        Admin loggedAdmin = admin.login("admin@school.com", "adminpass");

        if (loggedP1 != null && loggedP2 != null && loggedS1 != null && loggedS2 != null && loggedAdmin != null) {
            loggedP1.addTimetableEntry("Math 9AM-10AM");
            loggedP2.addTimetableEntry("Physics 10AM-11AM");
            loggedS1.addTimetableEntry("Math 9AM-10AM");
            loggedS2.addTimetableEntry("Physics 10AM-11AM");

            loggedP1.addAssignment("Homework 1");
            loggedP2.addAssignment("Project 1");
            loggedS1.addUpcomingAssignment("Homework 1");
            loggedS2.addUpcomingAssignment("Project 1");

            loggedP1.assignGrade(loggedS1, "Homework 1", 95);
            loggedP2.assignGrade(loggedS2, "Project 1", 88);

            loggedP1.sendWarning(loggedS1, "Late submission");
            loggedP2.uploadAnnouncement(loggedS2, "Project deadline extended");

            System.out.println("\n=== Admin viewing all timetables ===");
            loggedAdmin.viewAllTimetables();

            System.out.println("\n=== Student 1 Information ===");
            loggedS1.viewTimetable();
            loggedS1.viewPastGrades();
            loggedS1.viewUpcomingAssignments();
            loggedS1.viewNotifications();
            loggedS1.setAttendance(90);
            loggedS1.viewAttendance();

            System.out.println("\n=== Student 2 Information ===");
            loggedS2.viewTimetable();
            loggedS2.viewPastGrades();
            loggedS2.viewUpcomingAssignments();
            loggedS2.viewNotifications();
            loggedS2.setAttendance(85);
            loggedS2.viewAttendance();

            System.out.println("\n=== Professor 1 Information ===");
            loggedP1.viewTimetable();
            loggedP1.viewAssignments();

            System.out.println("\n=== Professor 2 Information ===");
            loggedP2.viewTimetable();
            loggedP2.viewAssignments();
        } else {
            System.out.println("Login failed for one or more users");
        }
    }
}