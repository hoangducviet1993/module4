package com.codegym.service.impl;

import com.codegym.model.ClassRoom;
import com.codegym.repository.ClassRoomRepository;
import com.codegym.service.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ClassRoomService implements IClassRoomService {
    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Override
    public Iterable<ClassRoom> findAll() {
        return classRoomRepository.findAll();
    }

    @Override
    public Optional<ClassRoom> findById(Long id) {
        return classRoomRepository.findById(id);
    }

    @Override
    public void save(ClassRoom classRoom) {
        classRoomRepository.save(classRoom);
    }

    @Override
    public void remove(Long id) {
    classRoomRepository.deleteById(id);
    }
}
