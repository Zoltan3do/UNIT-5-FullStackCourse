package com.example.demo.entities;

public class FullStackStudent  extends Student{
    public FullStackStudent(String name, String surname) {
        super(name, surname);
    }

    @Override
    public void answersQuestion() {
        System.out.println("Ciao sono uno studente full stack");

    }

    @Override
    public String toString() {
        return "FullStackStudent{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
