package com.se.Controller;

import com.se.Repository.Jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by clevo on 2017/7/20.
 */
@Controller
@RequestMapping(value="/api/resource")
public class ApiResourceController {
    @Autowired
    PeriodRepository periodRepository;
    @Autowired
    AdminClassRepository adminClassRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    VirtualClassRepository virtualClassRepository;
    
    @RequestMapping("/period")
    public ResponseEntity<?> period(){
        return ResponseEntity.ok(periodRepository.findAll());
    }
}
