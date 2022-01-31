package com.example.managementsystem.service;


import com.example.managementsystem.DTO.CoursesDto;
import com.example.managementsystem.entity.Courses;
import com.example.managementsystem.entity.Students;
import com.example.managementsystem.repository.CoursesRepository;
import com.example.managementsystem.repository.ErrorRepo;
import com.example.managementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService
{
    @Autowired
    private CoursesRepository courserepo;

    @Autowired
    private StudentRepository studrepo;

    @Autowired
    private ErrorRepo errorRepo;

    @Autowired
    private ErrorService errorService;

    public List<Courses> getCourses()
    {
        return courserepo.findAll();
    }

    public String addCourse( Courses courses)
    {
        courserepo.save(courses);
        return "Course Added";
    }
    
    public Optional<Courses> getCourseById(Long courseId){
    	return courserepo.findById(courseId);
    }
    
    public String addStudentToCourse(Long studentId, Long courseId) {

        if(courserepo.findById(courseId).isPresent()){
            if(studrepo.findById(studentId).isPresent()){
                Courses course = courserepo.getById(courseId);
                Students student = studrepo.getById(studentId);
                if(!course.enrolledStudents.contains(student)){
                    course.enrollStudent(student);
                    courserepo.save(course);
                    return "Data Added";
                }
                return errorService.DATAEXIST();
            }
        }

        return errorService.BADREQUEST();

    }
    public String deleteStudentFromCourse(Long studentId, Long courseId){

        if(!courserepo.findById(courseId).isEmpty()){
            if(!studrepo.findById(studentId).isEmpty()){
                Courses course = courserepo.getById(courseId);
                Students student = studrepo.getById(studentId);
                course.deleteStudent(student);
                courserepo.save(course);
                return "Student removed From the course";
            }
        }

        return errorRepo.getById(400L).getName();

    }


    public List<CoursesDto> getAllCourses() {
        List<CoursesDto> courseDtos = new ArrayList<>();
        List<Courses> courses = courserepo.findAll();
        courses.forEach(course -> {
            CoursesDto courseDto = mapEntityToDto(course);
            courseDtos.add(courseDto);
        });
        return courseDtos;
    }

    public CoursesDto getAllCoursesByid(Long id) {
        Courses courseDto = courserepo.getById(id);
        return mapEntityToDto(courseDto);
    }

    private CoursesDto mapEntityToDto(Courses course) {
        CoursesDto responseDto = new CoursesDto();
        responseDto.setCourseName(course.getCourseName());
        responseDto.setCourseId(course.getCourseId());
        responseDto.setCourseFee(course.getCourseFee());
        responseDto.setMonths(course.getMonths());
        responseDto.setEnrolledStudents(course.getEnrolledStudents().stream().map(Students::getStudentName).collect(Collectors.toSet()));
        return responseDto;
    }
}
