package com.javarush.khmelov.repository;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryTextRepository {
    private static final AtomicLong id = new AtomicLong();
    private final HashMap<Long, String> texts = new HashMap<>();
    public InMemoryTextRepository() {

    }

}
