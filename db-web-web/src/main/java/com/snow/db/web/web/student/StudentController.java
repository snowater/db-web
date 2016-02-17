/*
 * @(#) StudentsController.java 2016年1月29日
 * 
 * Copyright 2013 NetEase.com, Inc. All rights reserved.
 */
package com.snow.db.web.web.student;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.snow.db.web.base.student.Student;
import com.snow.db.web.base.student.StudentService;


/**
 * @author hzwanghuiqi
 * @version 2016年1月29日
 */
@Controller(value = "studentController")
@RequestMapping("/modules/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping(value = "/queryStudent.json", method = RequestMethod.POST)
    @ResponseBody
    public List<Student> searchStudent(@RequestBody Student student) {
        student.display();
        List<Student> list = studentService.queryAllStudent();
        return list;
    }


}
