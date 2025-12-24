package schoolsystem;

import java.util.ArrayList;

public class Admin extends User {

    private ArrayList<Student> students;

    private ArrayList<Professor> professors;

    public Admin(int id, String name, String email, String password) {

        super(id, name, email, password);

        students = new ArrayList<>();

        professors = new ArrayList<>();

    }

    public void addNewStudent(Student student) {

        students.add(student);

        System.out.println("Student added: " + student.getName());

    }

    public void editStudent(Student student, String newname, String newEmail) {

        student.setName(newname);

        student.setEmail(newEmail);

        System.out.println("Student updated: " + student.getName());

    }

    public void addNewTeacher(Professor professor) {

        professors.add(professor);

        System.out.println("Teacher added: " + professor.getName());

    }

    public void viewAllTimetables() {

        System.out.println("Students Timetables:");

        for (Student s : students) {

            System.out.println(s.getName());

            s.viewTimetable();

        }

        System.out.println("Professors Timetables:");

        for (Professor p : professors) {

            System.out.println(p.getName());

            p.viewTimetable();

        }

    }

    public void viewTeacherTimetables() {

        for (Professor p : professors) {

            System.out.println(p.getName());

            p.viewTimetable();

        }

    }

    public ArrayList<Student> getStudents() {

        return students;

    }

    public ArrayList<Professor> getProfessors() {

        return professors;

    }

    @Override

    public Admin login(String email, String password) {

        if (getEmail().equals(email) && getPassword().equals(password)) {

            return this;

        }

        return null;

    }

}

