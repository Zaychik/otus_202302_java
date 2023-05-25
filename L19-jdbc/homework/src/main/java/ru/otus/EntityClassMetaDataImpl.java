package ru.otus;

import ru.otus.annotations.Id;
import ru.otus.jdbc.mapper.EntityClassMetaData;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EntityClassMetaDataImpl<T> implements EntityClassMetaData<T> {
    private Class<T> clazz;

    public EntityClassMetaDataImpl(Class<T> entityClass) {
        this.clazz = entityClass;
    }

    @Override
    public String getName(){
        return clazz.getSimpleName();
    }

    @Override
    public Constructor<T> getConstructor(){
        try {
            return clazz.getConstructor();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Field getIdField() {
        Field[] fields = clazz.getDeclaredFields();
        Field id = null;
        for (Field f : fields) {
            Id ann = f.getAnnotation(Id.class);
            if (ann != null) {
                id = f;
            }
        }
        return id;
    }

    @Override
    public List<Field> getAllFields() {
        Field[] fields = clazz.getDeclaredFields();
        return Arrays.stream(fields).collect(Collectors.toList());
    }

    @Override
    public List<Field> getFieldsWithoutId() {
        Field[] fields = clazz.getDeclaredFields();
        List<Field> list = new ArrayList<>();
        for (Field f : fields) {
            Id ann = f.getAnnotation(Id.class);
            if (ann == null) {
                list.add(f);
            }
        }
        return list;
    }
}
