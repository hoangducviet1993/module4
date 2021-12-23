package com.codegym.controller;

import com.codegym.model.ClassRoom;
import com.codegym.model.Student;
import com.codegym.service.IClassRoomService;
import com.codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassRoomService classRoomService;

    @ModelAttribute("classRooms")
    public Iterable<ClassRoom> classRooms() {
        return classRoomService.findAll();
    }

    @GetMapping("")
    public String showList(Model model, String key, @PageableDefault(value = 3, sort = "score") Pageable pageable) {
        Page<Student> students;
        if (key != null) {
            students = studentService.findByNameContaining(key, pageable);
        } else {
            students = studentService.findAll(pageable);
        }
        model.addAttribute("students", students);
        model.addAttribute("key", key);
        return "/student/list";
    }
    @GetMapping("score-greater-than-8")
    public String showListScoreGreaterThan8(Model model, String key, @PageableDefault(value = 10, sort = "score") Pageable pageable) {
        Page<Student> students;
        if (key != null) {
            students = studentService.findByNameContaining(key, pageable);
        } else {
            students = studentService.findNameByOrderScoreGreaterThan8(pageable);
        }
        model.addAttribute("students", students);
        model.addAttribute("key", key);
        return "/student/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable Long id) {
        Optional<Student> student = studentService.findById(id);
        if (student.isPresent()) {
            model.addAttribute("student", student);
            return "/student/edit";
        } else {
            return "/error.404";
        }
    }

    @PostMapping("edit")
    public String updateStudent(Model model, Student student) {
        studentService.save(student);
        model.addAttribute("student", student);
        model.addAttribute("message", "Student updated successfully");
        return "/student/edit";
    }
}
