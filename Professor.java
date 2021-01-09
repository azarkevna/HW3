package com.student.tasks;

public class Professor extends Person implements IPrintable, ICourse, IHours{
    private int hours;
    private String [] course_list;

    public Professor(String name, int hours, String course_list) {
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
        System.out.println("professor");
        System.out.printf("course list: %s\n",  getCourse_list());
        System.out.printf("teaching hours: %d\n", getHours());
        System.out.println("______________________");
    }

    public int hoursinCollege () {
        return getHours();
    }

    public int teachingLoad () {
        return getHours();
    }
}
