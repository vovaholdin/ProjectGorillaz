package com.javarush.khmelov.repository;

import com.javarush.khmelov.entity.User;

import java.util.Collection;
import java.util.Optional;

public interface UserRepository<T> {

    Collection<User> getAll();

    Optional<T> get(long id);

    void create(T entity);

    void update(T entity);

    void delete(T entity);
}
