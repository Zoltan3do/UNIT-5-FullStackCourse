package com.example.demo;

import com.example.demo.entities.BackEndStudent;
import com.example.demo.entities.FrontEndStudent;
import com.example.demo.entities.Interviewer;
import com.example.demo.entities.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration //obbligatoria per far si che la classe venga presa in considerazione all'avvio dell' app
public class BeansConf {

    @Bean // annotazione obbligatoria per far si che il metodo crei un bean
    // questi oggetti faranno parte dell'application context dall' avvio dell'applicazione se non ci sono errori
    public int getAge(){
        return 20;
    }

    @Bean(name = "aldino")// assegna un nome al bean
    @Scope("prototype") // di default è singleton che genera solo 1 istanza, invece prototype ne genera quante ne vuoi
    public Student beS(){
        return new BackEndStudent("Aldo","Baglio");
    }

    @Bean
    @Primary // primary da priorità su un bean qualora ce ne fosserò di più dello stesso tipo
    public FrontEndStudent feS(){
        return new FrontEndStudent("Aldo2","Baglio2");
    }

    @Bean
    public Interviewer i (Student s){
        return new Interviewer(s);
    }

}
