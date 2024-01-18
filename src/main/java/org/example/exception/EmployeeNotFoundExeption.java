package org.example.exception;

public class EmployeeNotFoundExeption extends  RuntimeException{
    public EmployeeNotFoundExeption(String message){
        super(message);
    }
}
