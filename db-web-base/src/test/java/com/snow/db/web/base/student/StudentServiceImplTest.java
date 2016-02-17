/*
 * @(#) StudentServiceImplTest.java 2016/01/26
 * 
 * Copyright 2013 NetEase.com, Inc. All rights reserved.
 */
package com.snow.db.web.base.student;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.snow.db.web.base.AbstractUnitTest;

/**
 * @author hzwanghuiqi
 * @version 2016/01/26
 */
public class StudentServiceImplTest extends AbstractUnitTest {
    
    @Resource
    private StudentService studentService;

    @Test
    public void testInsertStudent() {
        Student student = new Student("100", "aaa", 20, 'F');
        studentService.insertStudent(student);
    }

    @Test
    public void testQueryById() {
        Student student = studentService.queryById("100");
        // Assert.assertEquals("aaa", student.getName());
    }

    @Test
    public void testQueryAllStudent() {
        List<Student> list = null;
        list = studentService.queryAllStudent();
        // Assert.assertEquals(1, list.size());
        for (Student student : list) {
            student.display();
        }
    }

    @Test
    public void testUpdateStudent() {
        Student student = new Student("100", "bbb", 20, 'F');
        studentService.updateStduent(student);
    }

    @Test
    public void testDeleteStudent() {
        studentService.deleteStudent("100");
    }
    
    
}
