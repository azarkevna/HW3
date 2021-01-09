package com.student.tasks;

public class ProfessorInstructor extends Instructor implements IProfessorInstructor, IPrintable, ICourse, IHours {
    Professor professor;



    public ProfessorInstructor(String name, int professorHours, String professorCourselist, int instructorHours, String instructorCourselist) {
        super(name,instructorHours,instructorCourselist);
        professor = new Professor(name,professorHours,professorCourselist);
    }

    public void print () {
        System.out.printf("name: %s\n",getName());
        System.out.println("professor");
        System.out.printf("course list: %s\n",  professor.getCourse_list());
        System.out.printf("teaching hours: %d\n", professor.getHours());
        System.out.println("instructor");
        System.out.printf("course list: %s\n",  getCourse_list());
        System.out.printf("teaching hours: %d\n", getHours());
        System.out.println("______________________");
    }

    public int hoursinCollege () {
        return getHours()+ professor.getHours();
    }

    public int teachingLoad () {
        return getHours()+professor.getHours();
    }
}
