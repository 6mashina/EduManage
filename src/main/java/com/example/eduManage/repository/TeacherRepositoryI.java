package com.example.eduManage.repository;

import com.example.eduManage.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepositoryI extends JpaRepository<Teacher, Long> {
}
