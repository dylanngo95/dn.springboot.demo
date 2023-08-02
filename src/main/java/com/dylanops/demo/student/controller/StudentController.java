package com.dylanops.demo.student.controller;

import com.dylanops.demo.student.entity.Student;
import com.dylanops.demo.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/add")
    public Student add(@RequestBody @Validated Student student) {
        return studentService.save(student);
    }

    @GetMapping("/get/{id}")
    public Student get(@PathVariable Integer id) {
        return studentService.get(id).get();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        studentService.delete(id);
        return "done";
    }
}
