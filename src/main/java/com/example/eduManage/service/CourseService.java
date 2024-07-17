package com.example.eduManage.service;

import com.example.eduManage.model.Course;
import com.example.eduManage.repository.CourseRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class CourseService  {

    @Autowired
    CourseRepositoryI courseRepositoryI;


    public List<Course> getAll() {
        return courseRepositoryI.findAll();
    }

    public Course save(Course object){
        return courseRepositoryI.save(object);
    }

    public Optional<Course> getById(long id){
        return courseRepositoryI.findById(id);
    }

    public void deleteById(long id){
        courseRepositoryI.deleteById(id);
    }

    public void deleteAll(){
        courseRepositoryI.deleteAll();
    }
}
