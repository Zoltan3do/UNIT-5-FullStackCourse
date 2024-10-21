package com.example.demo.entities;

public class FrontEndStudent  extends Student{
    public FrontEndStudent(String name, String surname) {
        super(name, surname);
    }

    @Override
    public void answersQuestion() {
        System.out.println("Ciao sono uno studente front end");
    }

    @Override
    public String toString() {
        return "FrontEndStudent{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
