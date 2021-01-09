package com.student.tasks;

public class WorkerInstructor extends Instructor implements IWorkerInstructor, IPrintable, ICourse, IHours {
    Worker worker;



    public WorkerInstructor(String name, int workingHours, String position, int instructorHours, String instructorCourselist ) {
        super(name, instructorHours, instructorCourselist);
        worker = new Worker(name, workingHours, position);
    }

    public void print () {
        System.out.printf("name: %s\n",getName());
        System.out.println("worker");
        System.out.printf("working hours: %d\n", worker.getHours());
        System.out.printf("position: %s\n", worker.getPosition());
        System.out.println("instructor");
        System.out.printf("course list: %s\n",  getCourse_list());
        System.out.printf("teaching hours: %d\n", getHours());
        System.out.println("______________________");
    }

    public int hoursinCollege () {
        return getHours()+ worker.getHours();
    }

    public int teachingLoad () {
        return getHours();
    }
}
