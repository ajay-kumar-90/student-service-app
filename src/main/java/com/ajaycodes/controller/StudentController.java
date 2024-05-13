package com.ajaycodes.controller;

import com.ajaycodes.dao.StudentDao;
import com.ajaycodes.models.Book;
import com.ajaycodes.models.Student;
import com.ajaycodes.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class StudentController {

    private final StudentDao studentDao;
    private final StudentRepository studentRepository;

    public StudentController(StudentDao studentDao,
                             StudentRepository studentRepository) {
        this.studentDao = studentDao;
        this.studentRepository = studentRepository;
    }

    @PostMapping("/saveStudent")
    void saveStudent(@RequestBody Student student) {
        studentDao.save(student);
    }

    @PostMapping("/persistStudent")
    void persistStudent(@RequestBody Student student) {
        studentRepository.save(student);
    }

    @GetMapping("allStudent")
    List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @GetMapping("getStudentById/{id}")
    Student getStudent(@PathVariable Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.orElse(null);
    }

    @GetMapping("getBooksById/{id}")
    Set<Book> getBooksById(@PathVariable Long id) {
        return studentRepository.findById(id).map(Student::getBooks).orElse(null);
    }

    @GetMapping("getAllBooks")
    List<Student> getAllBooks() {
        return studentRepository.findAll();
    }
}