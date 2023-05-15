package com.example.program_fx_test;

import com.example.program_fx_test.entities.User;

import java.lang.reflect.Field;
import java.util.List;

public class Utils {
    public static boolean hasEmptyFields(Object object) throws IllegalAccessException {
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(object);
            if (value == null || (value instanceof String && ((String) value).isEmpty())) {
                return true;
            }
        }
        return false;
    }
}


