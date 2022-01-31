package com.example.managementsystem.controller;

import java.util.*;

import com.example.managementsystem.DTO.CoursesDto;
import com.example.managementsystem.entity.*;
import com.example.managementsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class MainController 
{
	@Autowired
	private StudentService studservice;
	
	@Autowired
	private DepartmentService deptservice;

	@Autowired
	private CourseService courseService;

	@Autowired
	private ErrorService errorService;

	@Autowired
	private BankDetailService bankDetailService;
	
	
	//STUDENT CONTROLLER *********************************************************************************************

	@GetMapping("/students/getall")
	public List<Students> getStud()
	{
		return studservice.getStudents();
	}
	@GetMapping("students/get/{id}")
	public Optional<Students> getbyStudId(@PathVariable("id") Long studentId)
	{
		return studservice.getStudentById(studentId);
	}
	@PostMapping(path = "students/add/")
	public String addStud(@RequestBody Students students)
	{
		return studservice.addStudents(students);
	}

	@PatchMapping("students/update/{id}")
	public String updateStud(@PathVariable("id") Long studentId, @RequestBody Students students)
	{
		return studservice.updateStudents(studentId,students);
	}

	@DeleteMapping("students/delete/{id}")
	public String deleteStud(@PathVariable("id") Long studentId){return studservice.deleteStudents(studentId);}





	//STUDENTPROFILE CONTROLLER ****************************************************************************************

	@PostMapping("studentprofile/add")
	public String addStudentProfile( @RequestBody Student_profile student_profile)
	{
		return studservice.addStudentsProfile(student_profile);
	}

	@GetMapping("studentprofile/getall")
	public List<Student_profile> getStudProf()
	{
		return studservice.getStudentProfile();
	}

	@GetMapping("studentprofile/get/{id}")
	public Optional<Student_profile> getStudProfByStudId(@PathVariable("id") Long studentId)
	{
		return studservice.getStudProfByStudId(studentId);
	}

	@PatchMapping("studentprofile/update/{id}")
	public String updateStudProf(@PathVariable("id") Long id, @RequestBody Student_profile student_profile)
	{
		return studservice.updateSTudProf(id, student_profile);
	}

	@DeleteMapping("studentprofile/delete/{id}")
	public String deleteStudProfByID(@PathVariable("id") Long studentId)
	{
		return studservice.deleteStudProfById(studentId);
	}
	
	//DEPARTMENT CONTROLLER ********************************************************************************************

	@GetMapping("/departments/getall")
	public List<Departments> getDept()
	{
		return deptservice.getDepartments();
	}
	@PostMapping("departments/add")
	public String addDept(@RequestBody Departments departments)
	{
		return deptservice.addDepartment(departments);
	}
	@GetMapping("departments/get/{id}")
	public Optional<Departments> getbyDeptId(@PathVariable("id") Long id)
	{
		return deptservice.getDepartmentById(id);
	}



	// COURSE CONTROLLER **********************************************************************************************

	@GetMapping("courses/getall")
	public List<CoursesDto> getCourse()
	{
		return courseService.getAllCourses();
	}

	@PostMapping("courses/add")
	public String addCourse(@RequestBody Courses course)
	{
		return courseService.addCourse(course);
	}

	@GetMapping("courses/get/{id}")
	public CoursesDto getCourseById(@PathVariable("id") Long courseId){
		return courseService.getAllCoursesByid(courseId);
	}

	@PutMapping("/students/{studentId}/{courseIdArr}")
	public String enrollcoursetostudent(@PathVariable Long studentId, @PathVariable Long courseIdArr){
			 return  courseService.addStudentToCourse(studentId, courseIdArr);
	}

	@DeleteMapping("/students/{studentId}/{courseId}")
	public String deletecoursefromstudent(@PathVariable Long studentId, @PathVariable Long courseId){
		return courseService.deleteStudentFromCourse(studentId, courseId);
	}


	// ERROR TABLE CONTROLLER *****************************************************************************************

	@GetMapping("/Error")
	public List<ErrorTable> getError(){
		return errorService.viewError();
	}

	@GetMapping("/Error/{id}")
	public Optional<ErrorTable> getErrorByID(@PathVariable Long id){
		return errorService.viewErrorByID(id);
	}

	@PostMapping("/Error")
	public String createError(@RequestBody ErrorTable errorTable){
		return errorService.createError(errorTable);
	}

	@PutMapping("/Error/{id}")
	public String updateerror(@PathVariable Long id, @RequestBody ErrorTable errorTable){
		return errorService.updateError(id,errorTable);
	}

	@DeleteMapping("/Error/{id}")
	public String deleteError(@PathVariable Long id){
		return errorService.deleteErrorByID(id);
	}


	// BANK DETAILS CONTROLLER ****************************************************************************************

	@GetMapping("/bank")
	public List<BankDetails> g(){
		return bankDetailService.getdetails();
	}

	@PostMapping("/bank")
	public String ip(@RequestBody BankDetails bankDetails){
		return bankDetailService.postdetails(bankDetails);
	}

	@PutMapping("/bank/{id}")
	public String up(@PathVariable Long id, @RequestBody BankDetails bankDetails){
		return bankDetailService.putdetails(id,bankDetails);
	}

	@DeleteMapping("/bank/{id}")
	public String de(@PathVariable Long id){
		return bankDetailService.deletedetails(id);
	}
}
