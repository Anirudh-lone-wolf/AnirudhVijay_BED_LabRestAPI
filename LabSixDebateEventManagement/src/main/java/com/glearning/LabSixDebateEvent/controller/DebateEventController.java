package com.glearning.LabSixDebateEvent.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.glearning.LabSixDebateEvent.model.Student;
import com.glearning.LabSixDebateEvent.service.DebateEventService;

@Controller
@RequestMapping("/studentdetails")
public class DebateEventController {

	@Autowired
	private DebateEventService debateEventService;

	@RequestMapping("/list")
	public String listOfStudents(Model theModel) {

		// get Students from db
		List<Student> students = debateEventService.findAll();

		// add the list of students to the spring model
		theModel.addAttribute("Students", students);

		return "list-Students";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Student newStudent = new Student();

		theModel.addAttribute("Student", newStudent);

		return "Student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") long theId, Model theModel) {

		// get the Student from the service
		Student updateStudent = debateEventService.findById(theId);

		// set Student as a model attribute to pre-populate the form
		theModel.addAttribute("Student", updateStudent);

		// send over to our form
		return "Student-form";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("studentId") long id, @RequestParam("FirstName") String firstName,
			@RequestParam("LastName") String lastname, @RequestParam("Course") String course,
			@RequestParam("Country") String country) {

		System.out.println(id);
		Student saveStudent;
		if (id != 0) {
			saveStudent = debateEventService.findById(id);
			saveStudent.setFirstName(firstName);
			saveStudent.setLastName(lastname);
			saveStudent.setCourse(course);
			saveStudent.setCountry(country);
		} else
			saveStudent = new Student(firstName, lastname, course, country);
		// save the Student
		debateEventService.save(saveStudent);

		// use a redirect to prevent duplicate submissions
		return "redirect:/studentdetails/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") long theId) {

		// delete the Student
		debateEventService.deleteById(theId);

		// redirect to /studentdetails/list
		return "redirect:/studentdetails/list";

	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

}
