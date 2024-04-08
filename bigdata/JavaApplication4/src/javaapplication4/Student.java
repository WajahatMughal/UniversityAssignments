/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

/**
 *
 * @author admin
 */
public class Student {
       private int age;
       private String department;
       private String grade;
       private String module;
       private int id;
       private String name;
       private String sex;
       private double marks;
public Student(){
}
public Student(int id, String name,String sex,int age, String grade,String module, double marks) {
        this.id = id;
        this.name = name;
        this.sex=sex;
        this.age=age;
        this.grade = grade;
        this.marks = marks;
}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
 public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
}
