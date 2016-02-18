/*
 * @(#) Student.java 2016年1月25日
 * 
 * Copyright 2013 NetEase.com, Inc. All rights reserved.
 */
package com.snow.db.web.base.student;

import java.io.Serializable;

/**
 * @author hzwanghuiqi
 * @version 2016年1月25日
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 1199268619808650245L;

    private String id;
    private String name;
    private int age;
    private char gender; // 'F' = female 'M' = male

    public Student() {}

    public Student(String id, String name, int age, char gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public char getGender() {
        return gender;
    }

    public void display() {
        System.out.println(id + " " + name + " " + age + " " + gender);
    }
}
