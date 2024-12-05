package com.javarush.khmelov.lesson18;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class SoftReferenceExample {
    public static void main(String[] args) {
        var str = new String("Hello");
        var softRef = new SoftReference<>(str);
        // мягкая ссылка на объект "Hello"
        str = null; // Удаляем сильную ссылку
        // В любой момент система может решить
        // удалить объект из-за нехватки памяти
        // Мы можем получить объект
        // обратно из мягкой ссылки
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100000000; i++) {
            list.add("Hello" + i);
        }
        System.gc();
        var retrievedStr = softRef.get();
        if (retrievedStr != null) {
            System.out.println(retrievedStr);
        } else {
            System.out.println("Object collected GC");
        }
    }
}
