package com.example.demo.entities;

public class Interviewer {
    private Student student;
    public Interviewer(Student s){
        this.student = s;
    }

    public void askQuestion(){
        System.out.println("Ciao " +  this.student );
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Interviewer{" +
                "student=" + student +
                '}';
    }
}
