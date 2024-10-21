package com.example.demo;

import com.example.demo.entities.BackEndStudent;
import com.example.demo.entities.FrontEndStudent;
import com.example.demo.entities.Interviewer;
import com.example.demo.entities.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        //----------------------Metodo tradizionale--------------------------------
//        BackEndStudent aldo  = new BackEndStudent("Aldo","Baglio");
//        Interviewer i = new Interviewer(aldo);
//        i.askQuestion();
//        aldo.answersQuestion();

        //-------------------Metodo con i beans-----------------------------------
        // Per poter accedere ai beans devo prima avere un riferimento al context.

        //1. Ottengo un riferimento al context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeansConf.class);

        //2. Leggo i beans dal context e li uso: o tramite nome del bean o tramite il tipo del bean
        Student s = context.getBean(Student.class); // per tipo
        FrontEndStudent fs = (FrontEndStudent) context.getBean("feS"); // per nome
        System.out.println(fs);

        Interviewer i = context.getBean(Interviewer.class);
        System.out.println(i);

        //3. Chiudo il context
        context.close();

    }

}
