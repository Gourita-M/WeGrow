package org.example.controller;

import org.example.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.example.model.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAll(){
        return ResponseEntity.ok(departmentService.getAll());
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> addDepatment(@RequestBody Department department,
        @PathVariable Long userId
    ){
        try{
            Department departmen = departmentService.save(department, userId);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(departmen);

        }catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }

}
