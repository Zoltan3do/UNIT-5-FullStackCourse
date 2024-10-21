package com.example.demo.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
// utilizzo di lombok per autogenerare lo scheletro di una classe
public abstract class Student {

    protected String name, surname;

    public abstract void answersQuestion();


}
