package com.javarush.khmelov.repository;

import com.javarush.khmelov.entity.Role;
import com.javarush.khmelov.entity.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryUserRepository implements UserRepository<User> {

    private final Map<Long, User> map = new HashMap<>();

    public static final AtomicLong id = new AtomicLong(System.currentTimeMillis());

    public InMemoryUserRepository() {
        map.put(0L, new User("goldin@gmail.com", 0L, "Vova", "qwerty", Role.ADMIN));

    }

    @Override
    public Collection<User> getAll() {
        return map.values();
    }

    @Override
    public Optional<User> get(long id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public void create(User entity) {
        entity.setId(id.incrementAndGet());
        update(entity);
    }

    @Override
    public void update(User entity) {
        map.put(entity.getId(), entity);
    }

    @Override
    public void delete(User entity) {
        map.remove(entity.getId());
    }
}
