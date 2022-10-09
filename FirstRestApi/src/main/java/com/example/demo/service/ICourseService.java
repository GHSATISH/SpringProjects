package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Course;

public interface ICourseService {

	public List<Course> getCourses();
	
	public Course getCourse(long courseId);
	public Course addCourse(Course course);
	
	public Course updateCourse(Course course);
	
	public void deleteCourseById(Long id);
}
