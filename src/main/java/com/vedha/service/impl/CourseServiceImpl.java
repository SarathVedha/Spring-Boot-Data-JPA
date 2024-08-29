package com.vedha.service.impl;

import com.vedha.dto.Course;
import com.vedha.entity.CourseEntity;
import com.vedha.repository.CourseRepository;
import com.vedha.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final ModelMapper modelMapper;

    private final CourseRepository courseRepository;

    @Override
    public Course saveCourse(Course course) {

        CourseEntity map = modelMapper.map(course, CourseEntity.class);
        CourseEntity save = courseRepository.save(map);

        return modelMapper.map(save, Course.class);
    }
}
