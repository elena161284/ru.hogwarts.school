package ru.hogwarts.school.controller;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("{id}")
    public Student getInfo(@PathVariable long id) {
        return studentService.findStudent(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student); // добали студента в список
    }
    @PutMapping()
    public Student editStudent(@RequestBody Student student) {
        return studentService.editStudent(student.getId(), student);
    }

    @DeleteMapping("{id}")
    public Student deleteStudent(@PathVariable Long id) {
        return studentService.deletedStudent(id);
    }
    @GetMapping("/byAge") // localhost:8080/student/byAge?age=15
    public Collection<Student> byAge(@RequestParam int age) {
        return studentService.filterByAge(age);
    }
}