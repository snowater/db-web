/*
 * @(#) StudentServiceImpl.java 2016年1月25日
 * 
 * Copyright 2013 NetEase.com, Inc. All rights reserved.
 */
package com.snow.db.web.base.student;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


/**
 * @author hzwanghuiqi
 * @version 2016年1月25日
 */
@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public Student queryById(String id) {
        return studentDao.queryById(id);
    }

    @Override
    public List<Student> queryAllStudent() {
        return studentDao.queryAllStudent();
    }

    @Override
    public void insertStudent(Student student) {
        studentDao.insertStudent(student);
    }

    @Override
    public void updateStduent(Student student) {
        studentDao.updateStduent(student);
    }

    @Override
    public void deleteStudent(String id) {
        studentDao.deleteStudent(id);
    }

}
