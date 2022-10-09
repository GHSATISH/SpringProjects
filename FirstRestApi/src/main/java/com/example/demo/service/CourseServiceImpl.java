package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseRepository;
import com.example.demo.model.Course;

@Service
public class CourseServiceImpl implements ICourseService {

	@Autowired
	private CourseRepository repository;

	// List<Course> list;

	public CourseServiceImpl() {

		/*
		 * list = new ArrayList<>(); list.add(new Course(11111, "Java",
		 * "this is a technology coures")); list.add(new Course(22222, ".Net",
		 * "this is a UI technology coures"));
		 */

	}

	@Override
	public List<Course> getCourses() {

		return repository.findAll();

	}

	@Override
	public Course getCourse(long courseId) {

		/*
		 * Course c = null; for (Course course : list) { if (course.getId() == courseId)
		 * { c = course; break; } }
		 */
		return repository.findById(courseId).get();
	}

	@Override
	public Course addCourse(Course course) {
		// list.add(course);
		repository.save(course);

		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		/*
		 * list.forEach(e->{ if(e.getId()==course.getId()) {
		 * e.setTitle(course.getTitle()); e.setDesc(course.getDesc()); } });
		 */

		repository.save(course);
		return course;
	}

	@Override
	public void deleteCourseById(Long id) {

		// list=this.list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());

		// Course entity = repository.getOne(id);
		// repository.delete(entity);
		repository.deleteById(id);
	}
}
