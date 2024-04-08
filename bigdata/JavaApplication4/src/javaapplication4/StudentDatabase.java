/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StudentDatabase {
    public static List<Student> getStudents(){
        
     
      return  Stream.of(new Student(101,"Depika","Female",16,"A","Math",80),
              new Student(109,"Peter","Male",17,"B","Computer",45),
              new Student(102,"Mak","Male",17,"A","Math",85),
              new Student(103,"Kat","Female",16,"A","Computer",90),
              new Student(104,"Jon","Male",18,"C","Math",25),
              new Student(105,"Dev","Male",18,"C","Math",25),
               new Student(106,"Sam","Male",19,"A","Life science",85),
                new Student(107,"Katrina","Male",18,"C","Math",25),
                 new Student(108,"Dev","Male",18,"C","Math",25),
                  new Student(109,"Jonk","Female",17,"a","Computer",80),
                   new Student(110,"Lobi","Male",18,"B","Math",45))
                        .collect(Collectors.toList()); 
    }
}