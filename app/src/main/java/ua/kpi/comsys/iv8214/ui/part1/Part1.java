package ua.kpi.comsys.iv8214.ui.part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class Part1 {
    private final String students = "Дмитренко Олександр - ІП-84; Матвійчук Андрій - ІВ-83; " +
            "Лесик Сергій - ІО-82; Ткаченко Ярослав - ІВ-83; Аверкова Анастасія - ІО-83; " +
            "Соловйов Даніїл - ІО-83; Рахуба Вероніка - ІО-81; Кочерук Давид - ІВ-83; " +
            "Лихацька Юлія- ІВ-82; Головенець Руслан - ІВ-83; Ющенко Андрій - ІО-82; " +
            "Мінченко Володимир - ІП-83; Мартинюк Назар - ІО-82; Базова Лідія - ІВ-81; " +
            "Снігурець Олег - ІВ-81; Роман Олександр - ІО-82; Дудка Максим - ІО-81; " +
            "Кулініч Віталій - ІВ-81; Жуков Михайло - ІП-83; Грабко Михайло - ІВ-81; " +
            "Іванов Володимир - ІО-81; Востриков Нікіта - ІО-82; Бондаренко Максим - ІВ-83; " +
            "Скрипченко Володимир - ІВ-82; Кобук Назар - ІО-81; Дровнін Павло - ІВ-83; " +
            "Тарасенко Юлія - ІО-82; Дрозд Світлана - ІВ-81; Фещенко Кирил - ІО-82; " +
            "Крамар Віктор - ІО-83; Іванов Дмитро - ІВ-82";

    private final int[] points = {12, 12, 12, 12, 12, 12, 12, 16};
    private HashMap<String, ArrayList<String>> task1;
    private HashMap<String, HashMap<String, ArrayList<Integer>>> task2;
    private HashMap<String, HashMap<String, Integer>> task3;
    private HashMap<String, Float> task4;
    private HashMap<String, ArrayList<String>> task5;

    public HashMap<String, ArrayList<String>> studentsGroups() {
        task1 = new HashMap<>();
        String[] studentGroup = students.split(";");
        for (String s : studentGroup) {
            String[] singleStudent = s.split("-");
            String student = singleStudent[0];
            String group = singleStudent[1] + "-" + singleStudent[2];
            //studentsGroups.put(group, student);
            ArrayList<String> groupStudents = task1.get(group);

            // if list does not exist create it
            if (groupStudents == null) {
                groupStudents = new ArrayList<>();
                groupStudents.add(student);
                task1.put(group, groupStudents);
            } else {
                // add if item is not already in list
                if (!groupStudents.contains(student)) groupStudents.add(student);
            }
        }
        task1.forEach((k, v) -> Collections.sort(v));
        return task1;
    }

    private int randomValue(int maxValue) {
        Random random = new Random();
        switch (random.nextInt(6)) {
            case 1:
                return (int) (maxValue * 0.7);
            case 2:
                return (int) (maxValue * 0.9);
            case 3:
            case 4:
            case 5:
                return maxValue;
            default:
                return 0;
        }
    }

    public HashMap<String, HashMap<String, ArrayList<Integer>>> studentsPoint() {
        task2 = new HashMap<>();
        task1.forEach((k, v) -> {
            HashMap<String, ArrayList<Integer>> values = new HashMap<>();
            v.forEach((s) -> {
                ArrayList<Integer> studentPoints = new ArrayList<>();
                for (int point : points) {
                    studentPoints.add(randomValue(point));
                }
                values.put(s, studentPoints);
            });
            task2.put(k, values);
        });
        return task2;
    }

    public HashMap<String, HashMap<String, Integer>> sumPoints() {
        task3 = new HashMap<>();
        task2.forEach((k, v) -> {
            HashMap<String, Integer> values = new HashMap<>();
            v.forEach((student, point) -> {
                int sum = 0;
                for (int i = 0; i < point.size(); i++) {
                    sum += point.get(i);
                }
                values.put(student, sum);
            });
            task3.put(k, values);
        });
        return task3;
    }

    public HashMap<String, Float> groupAvg() {
        task4 = new HashMap<>();
        task3.forEach((group, students) -> {
            final int[] sum = {0};
            final float[] n = {0};
            students.forEach((s, integer) -> {
                sum[0] +=integer;
                n[0]++;
            });
            task4.put(group, sum[0] / n[0]);
        });
        return task4;
    }

    public HashMap<String, ArrayList<String>> passedPerGroup() {
        task5 = new HashMap<>();
        task3.forEach((group, students) -> {
            ArrayList<String> passedStudents = new ArrayList<>();
            students.forEach((student, point) -> {
                if (point >= 60) {
                    passedStudents.add(student);
                }
            });
            task5.put(group, passedStudents);
        });
        return task5;
    }

}
