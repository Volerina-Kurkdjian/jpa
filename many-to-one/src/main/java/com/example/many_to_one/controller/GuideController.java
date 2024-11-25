package com.example.many_to_one.controller;

import com.example.many_to_one.dto.GuideDto;
import com.example.many_to_one.service.guide.GuideService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/guide")
@AllArgsConstructor
public class GuideController {

    private final GuideService guideService;

    @PostMapping("/create")
    public ResponseEntity<GuideDto> createGuide(@RequestBody GuideDto guideDto){
        return ResponseEntity.status(HttpStatus.OK).body( guideService.persistGuideAlongWithStudents(guideDto));
    }

    @PostMapping("/update")
    public ResponseEntity<GuideDto> updateGuide(@RequestBody GuideDto guideDto){
        return ResponseEntity.status(HttpStatus.OK).body( guideService.updateGuide(guideDto));
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
        return new ResponseEntity<>(guideService.getGuide(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{staffId}")
    public ResponseEntity<GuideDto> deleteGuide(@PathVariable Long staffId) {
        GuideDto deletedGuide = guideService.deleteGuide(staffId);
        return ResponseEntity.ok(deletedGuide);
    }

    @GetMapping("/getFirstThree/{salary}")
    public ResponseEntity<List<GuideDto.GuideDtoProjection>> getFirstThreeGuidesBasedOnSalary(@PathVariable Integer salary){
        return new ResponseEntity<>(guideService.firstThreeSalaryGreaterThan(salary),HttpStatus.OK);
    }

}
