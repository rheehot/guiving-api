package com.guiving.domain.vo.enums.status.web;

import com.guiving.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping("/api/v1/company")
    public ResponseEntity<?> findAll() throws Exception {
        ResponseEntity<?> result;
        try {
            result = new ResponseEntity<>(companyService.findAll(), HttpStatus.OK) ;
        }
        catch(Exception e) {
            e.printStackTrace();
            result = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT) ;
        }
        return result;
    }
}
