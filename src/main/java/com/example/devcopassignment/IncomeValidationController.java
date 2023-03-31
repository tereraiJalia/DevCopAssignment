package com.example.devcopassignment;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncomeValidationController {

    @PostMapping("/validate")
    public ResponseEntity<String> validateRegularAmount(@Valid @RequestBody RegularAmount regularAmount){

        return ResponseEntity.ok("Amount is valid");
    }
}
