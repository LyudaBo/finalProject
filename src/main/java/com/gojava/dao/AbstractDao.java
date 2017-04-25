package com.gojava.dao;

import com.gojava.model.WithId;

import java.util.Optional;
import java.util.Set;

/**
 * Created by root on 24.04.2017.
 */
public abstract class AbstractDao<T extends WithId> implements DAO<T>{

    private Set<T> EntitiesRepository;
    private final String FILE_NAME;

    public AbstractDao(String file_name) {
        FILE_NAME = file_name;
    }

    public void add(T t) {
        EntitiesRepository = getAll();
        EntitiesRepository.add(t);
        UtilsFile.writeFile(FILE_NAME, EntitiesRepository);
    }

    public void update(T t) {
        EntitiesRepository = getAll();
        T room = findById(t.getId());
        EntitiesRepository.remove(room);
        EntitiesRepository.add(t);
        UtilsFile.writeFile(FILE_NAME, EntitiesRepository);
    }

    public void delete(T t) {
        //t.setDelete(true);
        update(t);
        UtilsFile.writeFile(FILE_NAME, EntitiesRepository);
    }

    public T findById(long id) {
        Optional<T> room1 = getAll().stream().filter(room -> room.getId() == id ).findFirst();
        return room1.get();
    }

    public Set<T> getAll() {
        EntitiesRepository = UtilsFile.readFile(FILE_NAME);
        return EntitiesRepository;
    }
}
