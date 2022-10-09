package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Course;
import com.example.demo.service.ICourseService;

@RestController
public class MyController {
	@Autowired
	private ICourseService service;

	/*
	 * @GetMapping("/home") public String home() { return
	 * "Welcome to REST Application"; }
	 */
	
	//get the courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		
		return this.service.getCourses();
	}
	
	//Get single course
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable Long courseId) {

		return this.service.getCourse(courseId);
	}
	
	// Add course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		
		return this.service.addCourse(course);
	}
	
	//update course using put method
	@PutMapping("/course")
	public Course updateCourse(@RequestBody Course course) {
		
		return this.service.updateCourse(course);
	}
	
	//Delete the course
	@DeleteMapping("/course/{cId}")
	public ResponseEntity<HttpStatus> removeCourseById(@PathVariable String cId) {
		try {
			this.service.deleteCourseById(Long.parseLong(cId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
