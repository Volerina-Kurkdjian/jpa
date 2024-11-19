package com.example.Spring.Data.Overview.service.guide;

import com.example.Spring.Data.Overview.dto.guide.GuideDto;
import com.example.Spring.Data.Overview.dto.student.StudentDto;
import com.example.Spring.Data.Overview.mapper.GuideMapper;
import com.example.Spring.Data.Overview.mapper.StudentMapper;
import com.example.Spring.Data.Overview.model.Guide;
import com.example.Spring.Data.Overview.model.Student;
import com.example.Spring.Data.Overview.repository.GuideRepository;
import com.example.Spring.Data.Overview.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GuideServiceImpl implements GuideService {

    @Autowired
    private final GuideRepository guideRepository;
    @Autowired
    private final GuideMapper guideMapper;
    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final StudentMapper studentMapper;


    @Override
    public GuideDto persistGuideAlongWithStudents(GuideDto guideDto) {

        Guide guide = guideMapper.convertToEntity(guideDto);
        Set<StudentDto> studentDtoSet = guide.getStudents().stream().map(studentMapper::convertStudentToDto).collect(Collectors.toSet());
        guideRepository.save(guide);

        /** How to get a StackOverflow Exception
         *  // First, save the guide (parent)
         guideRepository.save(guide);
         // Save each student and set the guide for each student
         for (Student student : guide.getStudentList()) {
         student.setGuide(guide);
         studentRepository.save(student);
         }
         */

        GuideDto guideDto1=guideMapper.convertToDto(guide);
        guideDto1.setStudentList(studentDtoSet);//add the set of students to the Guide DTO
        return guideDto1;
    }



    @Override
    public GuideDto updateGuide(String staffId) {
        return null;
    }

    @Override
    public GuideDto deleteGuide(String staffId) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<GuideDto> getGuides() {
       List<Guide> list= guideRepository.findAll();
        return list.stream().map(guideMapper::convertToDto).collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    @Override
    public GuideDto getGuide(Long id) {
        Guide guide = guideRepository.findById(id).get();
        // Force the loading of the studentList
        Set<Student> students = studentRepository.findStudentsByGuideId(guide.getGuideId());
        students.size(); // Access the size to initialize the lazy-loaded collection return
//        guide.setStudents(students);  ---> gives an error
        Set<StudentDto> studentDtoSet=students.stream().map(studentMapper::convertStudentToDto).collect(Collectors.toSet());
        GuideDto guideDto=guideMapper.convertToDto(guide);
        guideDto.setStudentList(studentDtoSet);
        return guideDto;
    }

    public GuideDto getGuideSecond(Long id) {
        Guide guide = guideRepository.findById(id).get();
        // Convert Guide entity to GuideDto
        GuideDto guideDto = guideMapper.convertToDto(guide);

        return guideDto;
    }
}
