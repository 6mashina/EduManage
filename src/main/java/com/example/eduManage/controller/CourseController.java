package com.example.eduManage.controller;


import com.example.eduManage.dto.CourseRequest;
import com.example.eduManage.model.Course;
import com.example.eduManage.model.Teacher;
import com.example.eduManage.service.CourseService;
import com.example.eduManage.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    @Autowired
    TeacherService teacherService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/create")
    public ResponseEntity<Course> createCourse(@RequestBody CourseRequest courseRequest) {
        try {

            Teacher teacher = teacherService.getById(courseRequest.getTeacherId())
                    .orElseThrow(() -> new RuntimeException("Teacher not found"));
            Course _course = courseService.save(Course.builder()
                    .name(courseRequest.getName())
                    .description(courseRequest.getDescription())
                    .teacher(teacher)
                    .build());
            return new ResponseEntity<>(_course, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Course>> getAllCourses() {
        try {
            List<Course> courses = courseService.getAll();
            if (courses.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(courses, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") long id) {
        Optional<Course> course = courseService.getById(id);
        return course.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).
                orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") long id,
                                               @RequestBody CourseRequest course) {
        try {

            Optional<Course> _course = courseService.getById(id);
            Teacher teacher = teacherService.getById(course.getTeacherId())
                    .orElseThrow(() -> new RuntimeException("Teacher not found"));
            if (_course.isPresent()) {
                Course updateCourse = _course.get();
                updateCourse.setName(course.getName());
                updateCourse.setDescription(course.getDescription());
                updateCourse.setTeacher(teacher);
                return new ResponseEntity<>(courseService.save(updateCourse), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("id") long id) {
        try {
            courseService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllCourses() {
        try {
            courseService.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
