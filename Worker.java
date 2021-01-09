package com.student.tasks;

public class Worker extends Person implements IPrintable, IHours {
    private int hours;
    private String position;

    public Worker(String name, int hours, String position) {
        super(name);
        this.hours = hours;
        this.position = position;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void print () {
        System.out.printf("name: %s\n",getName());
        System.out.println("worker");
        System.out.printf("working hours: %d\n", getHours());
        System.out.printf("position: %s\n", getPosition());
        System.out.println("______________________");
    }

    public int hoursinCollege () {
        return getHours();
    }
}
