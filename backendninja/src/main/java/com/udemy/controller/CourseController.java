package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.entity.Course;
import com.udemy.model.CourseModel;
import com.udemy.repository.CourseJpaRepository;
import com.udemy.service.CourseService;

@Controller
@RequestMapping( "/courses" )
public class CourseController {

	private static final String COURSE_VIEW = "courses";
	
	private static final Log LOG = LogFactory.getLog( CourseController.class );
	
	@Autowired
	@Qualifier( "courseServiceImpl" )
	private CourseService courseService;
	
	@Autowired
	@Qualifier( "courseJpaRepository" )
	private CourseJpaRepository courseJpaRepository;
	
	@GetMapping( "/listcourses" )
	public ModelAndView listAllCourses(){
		
		LOG.info("Call: " + "listAllCourses()");
		
		ModelAndView mav = new ModelAndView( COURSE_VIEW );
		mav.addObject( "coursemodel", new CourseModel() );
		mav.addObject( "courses", courseService.listAllCourses() );
		return mav;
	}
	
	@PostMapping( "/addcourse" ) 
	public String addCourse( @ModelAttribute("coursemodel") CourseModel courseModel ){
		
		LOG.info("Call: " + "addCourses()" + " -- Param: " + courseModel.toString() );
		
		courseService.addCourse( getCourse( courseModel ) );
		return "redirect:/courses/listcourses";
	}
	
	@PostMapping( "/removecourse" )
	public String removeCourse( @ModelAttribute( "coursemodel" ) CourseModel courseModel )
	{
		LOG.info("Call: " + "removeCourse()" + " -- Param: " + courseModel.toString() );
		
		int courseId = getCourse( courseModel ).getId();
		courseService.removeCourse(courseId);
		
		return "redirect:/courses/listcourses";
	}
	
	@PostMapping( "/updatecourse" )
	public String updateCourse( @ModelAttribute( "coursemodel" ) CourseModel courseModel )
	{
		LOG.info("Call: " + "updateCourse()" + " -- Param: " + courseModel.toString() );
		
		courseService.updateCourse( getCourse( courseModel ) );
		
		return "redirect:/courses/listcourses";
	}
	
	
	private Course getCourse( CourseModel courseModel )
	{
		return courseJpaRepository.findByNameOrPrice( courseModel.getName(), courseModel.getPrice() );
	}
	
}
