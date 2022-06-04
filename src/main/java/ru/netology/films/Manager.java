package ru.netology.films;

public class Manager {
    private final int lastFilmsLimit;
    private String[] films;

    public Manager() {
        this.lastFilmsLimit = 10;
    }

    public Manager(int lastFilmsLimit) {
        this.lastFilmsLimit = lastFilmsLimit;
    }

    public void addFilm(String name) {
        if (films == null) {
            films = new String[]{name};
        } else {
            int newLength = films.length + 1;
            String[] newFilms = new String[newLength];
            for (int i = 0; i < films.length; i++) {
                newFilms[i] = films[i];
            }
            newFilms[films.length] = name;
            films = newFilms;
        }
    }

    public String[] findAll() {
        return films;
    }

    public String[] findLast() {
        int actualCount = Math.min(lastFilmsLimit, films.length);
        String[] output = new String[actualCount];
        int counter = 0;
        for (int i = films.length - 1; i > films.length - actualCount - 1; i--) {
            output[counter] = films[i];
            counter++;
        }
        return output;
    }
}