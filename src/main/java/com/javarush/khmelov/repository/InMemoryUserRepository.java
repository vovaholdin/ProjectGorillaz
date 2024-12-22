package com.javarush.khmelov.repository;

import com.javarush.khmelov.entity.Role;
import com.javarush.khmelov.entity.User;
import com.javarush.khmelov.game.StatisticUser;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryUserRepository implements UserRepository<User> {

    private final Map<Long, User> map = new HashMap<>();

    public static final AtomicLong id = new AtomicLong(System.currentTimeMillis());

    public InMemoryUserRepository() {

        map.put(0L, new User("goldin@gmail.com", 0L, "Vova", "qwerty", Role.ADMIN, new StatisticUser(999, 999, 999)));

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
        entity.setStatisticUsers(new StatisticUser(0,0,0));
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
