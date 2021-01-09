package com.student.tasks;

public class StudentInstructor extends Instructor implements IStudentInstructor, IPrintable, ICourse, ILearning, IHours{
    Student student;

    public StudentInstructor(String name, int hoursStudent, String courseStudent, int hoursInstructor, String courseInstructor) {
        super(name,hoursInstructor,courseInstructor);
        student = new Student(name,hoursStudent, courseStudent);

    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void print () {
        System.out.printf("name: %s\n",getName());
        System.out.println("instructor");
        System.out.printf("course list: %s\n",  getCourse_list());
        System.out.printf("teaching hours: %d\n", getHours());
        System.out.println("student");
        System.out.printf("course list: %s\n",  student.getCourse_list());
        System.out.printf("study hours: %d\n", student.getHours());
        System.out.println("______________________");
    }

    public int hoursinCollege () {
        return getHours()+ student.getHours();
    }

    public int teachingLoad () {
        return getHours();
    }
}
