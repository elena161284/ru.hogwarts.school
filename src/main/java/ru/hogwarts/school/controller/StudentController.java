package ru.hogwarts.school.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/student/id")
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
    @PutMapping
    public Student editStudent(@RequestBody Student student) {
        return studentService.editStudent(student);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id) {
        studentService.deletedStudent(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/byAge") // localhost:8080/student/byAge?age=15
    public Collection<Student> byAge(@RequestParam int age) {
        return studentService.filterByAge(age);
    }
    @GetMapping("/byName")
    public  Collection<Student> byName(@RequestParam String name) {
        return studentService.filterByName(name);
    }
    @GetMapping("/byAll")
    public Collection<String> byAll (){
        return studentService.filterAllStudent();
    }
}