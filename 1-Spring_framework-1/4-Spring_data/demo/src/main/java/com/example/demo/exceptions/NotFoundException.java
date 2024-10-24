package com.example.demo.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(long id){
        super("La risorsa con id " + id + " non è stata trovata!");
    }
}
