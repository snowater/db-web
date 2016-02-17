/*
 * @(#) StudentDao.java 2016年1月25日
 * 
 * Copyright 2013 NetEase.com, Inc. All rights reserved.
 */
package com.snow.db.web.base.student;

import java.util.List;

/**
 * @author hzwanghuiqi
 * @version 2016年1月25日
 */
public interface StudentDao {

    public Student queryById(String id);

    public List<Student> queryAllStudent();

    public void insertStudent(Student student);

    public void updateStduent(Student student);

    public void deleteStudent(String id);
}
