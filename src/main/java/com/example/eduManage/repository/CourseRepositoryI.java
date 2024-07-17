package com.example.eduManage.repository;

import com.example.eduManage.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepositoryI extends JpaRepository<Course,Long> {

}
