package com.example.eduManage.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseRequest {
    private String name;
    private String description;
    private Long teacherId;
}
