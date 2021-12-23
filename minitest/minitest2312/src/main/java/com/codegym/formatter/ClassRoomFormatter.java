package com.codegym.formatter;


import com.codegym.model.ClassRoom;
import com.codegym.service.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class ClassRoomFormatter implements Formatter<ClassRoom> {
    private IClassRoomService classRoomService;

    @Autowired
    public ClassRoomFormatter(IClassRoomService classRoomService) {
        this.classRoomService= classRoomService;
    }

    @Override
    public ClassRoom parse(String text, Locale locale) throws ParseException {
        Optional<ClassRoom> categoryOptional = classRoomService.findById(Long.parseLong(text));
        return categoryOptional.orElse(null);
    }

    @Override
    public String print(ClassRoom object, Locale locale) {
        return "[" + object.getId() + "," + object.getName() + "]";
    }
}
