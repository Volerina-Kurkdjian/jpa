package com.example.Spring.Data.Overview.controller;


import com.example.Spring.Data.Overview.dto.guide.GuideDto;
import com.example.Spring.Data.Overview.dto.student.StudentDto;
import com.example.Spring.Data.Overview.dto.student.StudentResponse;
import com.example.Spring.Data.Overview.service.guide.GuideService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guide")
@AllArgsConstructor
public class GuideController {

    @Autowired
    GuideService guideService;

    @PostMapping("/create")
    public ResponseEntity<GuideDto> createGuide(@RequestBody GuideDto guideDto){
        return ResponseEntity.status(HttpStatus.OK).body( guideService.persistGuideAlongWithStudents(guideDto));
    }

    @GetMapping("/getGuides")
    public ResponseEntity<List<GuideDto>> getGuides(){
        return new ResponseEntity<>(guideService.getGuides(),HttpStatus.OK);
    }

    @GetMapping("/getGuide/{id}")
    public ResponseEntity<GuideDto> getGuide(@PathVariable Long id){
        return new ResponseEntity<>(guideService.getGuide(id),HttpStatus.OK);
    }

    @GetMapping("/getGuideLast/{id}")
    public ResponseEntity<GuideDto> getGuideLast(@PathVariable Long id){
        return new ResponseEntity<>(guideService.getGuideSecond(id),HttpStatus.OK);
    }

}
