package com.example.many_to_one.service.guide;

import com.example.many_to_one.dto.GuideDto;
import com.example.many_to_one.dto.StudentDto;
import com.example.many_to_one.entity.Guide;
import com.example.many_to_one.entity.Student;
import com.example.many_to_one.mapper.GuideMapper;
import com.example.many_to_one.mapper.StudentMapper;
import com.example.many_to_one.repository.GuideRepository;
import com.example.many_to_one.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GuideServiceImpl implements GuideService{

    private final GuideRepository guideRepository;

    private final GuideMapper guideMapper;

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;


    @Override
    public GuideDto persistGuideAlongWithStudents(GuideDto guideDto) {
        Guide guide=guideMapper.toGuideEntity(guideDto);
        Set<Student> students=guideMapper.toGuideEntity(guideDto).getStudents().stream().collect(Collectors.toSet());
       // guide.setStudents(students);  daca facem asa nu studentul va avea id ul guide-ului asociat

        guideRepository.save(guide);
        for(Student s:students){
            s.setGuide(guide); // daca facem asa studentul va avea id-ul guideului asociat in db

            studentRepository.save(s);//deleted CascadeType.PERSIST because the id of the Guide wasn't associated with id of Students
        }

       // guideRepository.save(guide);
        Set<StudentDto> studentDtos=students.stream().map(studentMapper::toStudentDto).collect(Collectors.toSet());
        GuideDto guideDto1=guideMapper.toGuideDto(guide);
        guideDto1.setStudents(studentDtos);
        return guideDto1;
    }

    @Override
    public GuideDto updateGuide(GuideDto guideDto) {
        Guide guide=guideMapper.toGuideEntity(guideDto);

        Set<Student> students=guideMapper.toGuideDto(guide).getStudents().stream().map(studentMapper::toEntity).collect(Collectors.toSet());


        return null;
    }

    @Override
    public GuideDto deleteGuide(Long id) {
        return null;
    }

    @Override
    public List<GuideDto> getGuides() {
        List<Guide> guides= guideRepository.findAll();

        List<GuideDto> guideDtos = guides.stream().map(guide -> { GuideDto guideDto = guideMapper.toGuideDto(guide);
            Set<Student> studentsList = studentRepository.findStudentsByGuideId(guide.getGuideId());
            Set<StudentDto> studentsListDto = studentsList.stream() .map(studentMapper::toStudentDto) .collect(Collectors.toSet());
            guideDto.setStudents(studentsListDto); return guideDto; }).collect(Collectors.toList());
        return guideDtos;
    }

//trebuie facut un query in StudentRepository care sa extraga toti Studentii in functie de guide id
    @Override
    public GuideDto getGuide(Long id) {
        Guide guide= guideRepository.findById(id).get();
        Set<Student>studentsList= studentRepository.findStudentsByGuideId(id);

        GuideDto guideDto = guideMapper.toGuideDto(guide);
        Set<StudentDto> studentDtos = studentsList.stream()
                .map(studentMapper::toStudentDto)
                .collect(Collectors.toSet());

        guideDto.setStudents(studentDtos);

        return guideDto;
    }
}
