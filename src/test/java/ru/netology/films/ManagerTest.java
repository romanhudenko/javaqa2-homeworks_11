package ru.netology.films;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    @Test
    public void addFilmsPositive() {
        String[] testData = {"Бладшот", "Вперёд", "Джентельмены"};
        Manager manager = new Manager();
        manager.addFilm(testData[0]);
        manager.addFilm(testData[1]);
        manager.addFilm(testData[2]);
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(testData, actual);
    }

    @Test
    public void emptyManagerFindAll() {
        Manager manager = new Manager();
        Assertions.assertArrayEquals(null, manager.findAll());
    }

    @Test
    public void findLastDefault() {
        Manager manager = new Manager();
        String[] testData = {
                "Бладшот",
                "Вперёд",
                "Джентельмены",
                "Бладшот",
                "Вперёд",
                "Джентельмены",
                "Бладшот",
                "Вперёд",
                "Джентельмены",
                "Бладшот",
                "Вперёд",
                "Джентельмены"
        };
        String[] expected = {
                "Джентельмены",
                "Вперёд",
                "Бладшот",
                "Джентельмены",
                "Вперёд",
                "Бладшот",
                "Джентельмены",
                "Вперёд",
                "Бладшот",
                "Джентельмены"
        };
        for (String name : testData) {
            manager.addFilm(name);
        }
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastNonDefault() {
        Manager manager = new Manager(5);
        String[] testData = {
                "Бладшот",
                "Вперёд",
                "Джентельмены",
                "Бладшот",
                "Вперёд",
                "Джентельмены",
                "Бладшот",
                "Вперёд",
                "Джентельмены",
                "Бладшот",
                "Вперёд",
                "Джентельмены"
        };
        String[] expected = {
                "Джентельмены",
                "Вперёд",
                "Бладшот",
                "Джентельмены",
                "Вперёд"
        };
        for (String name : testData) {
            manager.addFilm(name);
        }
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}
