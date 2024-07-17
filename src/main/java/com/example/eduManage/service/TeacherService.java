package com.example.eduManage.service;

import com.example.eduManage.model.Course;
import com.example.eduManage.model.Teacher;
import com.example.eduManage.repository.TeacherRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    TeacherRepositoryI teacherRepositoryI;

    public List<Teacher> getAll() {
        return teacherRepositoryI.findAll();
    }

    public Teacher save(Teacher object){
        return teacherRepositoryI.save(object);
    }

    public Optional<Teacher> getById(long id){
        return teacherRepositoryI.findById(id);
    }

    public void deleteById(long id){
        teacherRepositoryI.deleteById(id);
    }

    public void deleteAll(){
        teacherRepositoryI.deleteAll();
    }
}
