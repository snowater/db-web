/*
 * @(#) StudentDaoImpl.java 2016年1月25日
 * 
 * Copyright 2013 NetEase.com, Inc. All rights reserved.
 */
package com.snow.db.web.base.student;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @author hzwanghuiqi
 * @version 2016年1月25日
 */
@Repository(value = "studentDao")
public class StudentDaoImpl extends SqlSessionDaoSupport implements StudentDao {

    // 因为mybatis-spring-1.2.0中取消了自动注入SqlSessionFactory 和 SqlSessionTemplate
    // 可能是为了解决多数据源的问题，取消了自动注入，因此需要手工注入
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
    
    @Override
    public Student queryById(String id) {
        return (Student) this.getSqlSession().selectOne("selectById", id);
    }

    @Override
    public List<Student> queryAllStudent() {
        List<Student> list = this.getSqlSession().selectList("selectAllStudent");
        return list;
    }

    @Override
    public void insertStudent(Student student) {
        this.getSqlSession().insert("insertSelective", student);
    }

    @Override
    public void updateStduent(Student student) {
        this.getSqlSession().update("updateSelective", student);
    }

    @Override
    public void deleteStudent(String id) {
        this.getSqlSession().delete("deleteById", id);
    }

}
