package com.student.tasks;

public class Student extends Person implements IPrintable, ILearning, IHours{
    private int hours;
    private String [] course_list;

    public Student(String name, int hours, String course_list) {
        super(name);
        this.hours = hours;
        this.course_list = course_list.split(" ");
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getCourse_list() {
        return String.join(" ",course_list);
    }

    public void setCourse_list(String[] course_list) {
        this.course_list = course_list;
    }

    public void print () {
        System.out.printf("name: %s\n",getName());
        System.out.println("student");
        System.out.printf("course list: %s\n",  getCourse_list());
        System.out.printf("study hours: %d\n", getHours());
        System.out.println("______________________");
    }

    public int hoursinCollege () {
        return getHours();
    }
}
