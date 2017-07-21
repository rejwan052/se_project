package com.se.Controller;

import com.se.Domain.Business.Course;
import com.se.Domain.Business.Student;
import com.se.Domain.Business.Teacher;
import com.se.Repository.Jpa.CourseRepository;
import com.se.Repository.Jpa.StudentRepository;
import com.se.Service.Business.CourseSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

/**
 * Created by clevo on 2017/7/20.
 */
@Controller
@RequestMapping("/manage/course")
public class CourseController {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CourseSerivce courseSerivce;

    @RequestMapping("/create")
    public ResponseEntity<?> create(@RequestParam int roomId,@RequestParam(value="adminClassId",required = false) Long adminClassId,@RequestParam (value = "virtualClassId",required = false) Long virtualClassId,
                                    @RequestParam Long teacherId,@RequestParam int periodId,@RequestParam int subjectId,@RequestParam int weekday) {
        Course course = courseSerivce.create(roomId,adminClassId,virtualClassId,teacherId,periodId,subjectId,weekday);
                return ResponseEntity.ok(course);
    }
    @RequestMapping("/update")
    public ResponseEntity<?> update(@RequestParam Long courseId,@RequestParam int roomId,@RequestParam Long adminClassId,@RequestParam Long virtualClassId,
                                    @RequestParam Long teacherId,@RequestParam int periodId,@RequestParam int subjectId,@RequestParam int weekday) {
        Course course = courseSerivce.update(courseId,roomId,adminClassId,virtualClassId,teacherId,periodId,subjectId,weekday);
        return ResponseEntity.ok(course);
    }
    @RequestMapping("/delete")
    public void delete(@RequestParam Long courseId){
         courseSerivce.delete(courseId);
         return;
    }
    @RequestMapping("/findByAdminClass")
    public String findByAdminClass(@RequestParam String adminClasses,Model model){
        List<Course> courseList =courseSerivce.findByAdminClass(adminClasses);
    model.addAttribute("courses",courseList);
    return "manage/course";
    }
    @RequestMapping("/findByStudentId")
    public String findByStudent(@RequestParam String studentUsername,Model model){
        List<Course> courseList = courseSerivce.findByStudentname(studentUsername);
        model.addAttribute("courses",courseList);
        return "/base/timetable";
    }

}