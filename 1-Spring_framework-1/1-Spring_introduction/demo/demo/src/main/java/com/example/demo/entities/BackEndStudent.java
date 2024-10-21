package com.example.demo.entities;

public class BackEndStudent  extends Student{
    public BackEndStudent(String name, String surname) {
        super(name, surname);
    }

    @Override
    public void answersQuestion() {
        System.out.println("Ciao sono uno studente backend");
    }

    @Override
    public String toString() {
        return "BackEndStudent{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
