package service.impl;

import Models.Lesson;
import db.DataBase;
import service.LessonAble;

import java.util.Arrays;
import java.util.Scanner;

public class LessonImpl implements LessonAble {

    @Override
    public void addLesson() {
        Scanner scanForSTR = new Scanner(System.in);
        System.out.print("Группанын атын Жазыныз: ");
        String groupName = scanForSTR.nextLine();
        for (int i = 0; i < DataBase.groups.length; i++) {
            if (DataBase.groups[i].getGroupName().equalsIgnoreCase(groupName)) {
                Lesson lesson = new Lesson();
                lesson.setId(MyGeneratorId.GeneratorForLesson());
                while (true) {
                    System.out.print("Сабактын атын жазыныз: ");
                    String nameLesson = scanForSTR.nextLine();
                    try {
                        if (nameLesson.length() >= 3) {
                            lesson.setNameLesson(nameLesson);
                            break;
                        } else {
                            throw new Exception("Сабактын атын туура эмес жаздыныз");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                while (true) {
                    System.out.print("Тапшырманын суроттомосуну жазыныз: ");
                    String lessonDes = scanForSTR.nextLine();
                    try {
                        if (lessonDes.length() >= 7) {
                            lesson.setDescriptionLesson(lessonDes);
                            break;
                        } else {
                            throw new Exception("Тапшырманын суроттомосуну туура эмес жаздыныз");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                DataBase.groups[i].lessons = Arrays.copyOf(DataBase.groups[i].lessons, DataBase.groups[i].lessons.length + 1);
                DataBase.groups[i].lessons[DataBase.groups[i].lessons.length - 1] = lesson;
                System.out.println("Сабак ийгиликтуу кошулду!");
            }
        }
    }

    @Override
    public void getAllLesson() {
        System.out.print("Сабактын атын Жазыныз: ");
        String nameLessons = new Scanner(System.in).nextLine();
        for (int i = 0; i < DataBase.groups.length; i++) {
            for (int j = 0; j < DataBase.groups[i].lessons.length; j++) {
                if (DataBase.groups[i].lessons[j].getNameLesson().equalsIgnoreCase(nameLessons)) {
                    System.out.println(DataBase.groups[i].lessons[j]);
                }
            }
        }
    }

    @Override
    public void getAllLessonByGroupName() {
        System.out.print("Группанын атын Жазыныз: ");
        String nameGroup = new Scanner(System.in).nextLine();
        for (int i = 0; i < DataBase.groups.length; i++) {
            if (DataBase.groups[i].getGroupName().equalsIgnoreCase(nameGroup)) {
                System.out.println(Arrays.toString(DataBase.groups[i].lessons));
            }
        }
    }

    @Override
    public void deleteLessonById() {
        System.out.print("Сабактын ID син Жазыныз: ");
        long idScan = new Scanner(System.in).nextLong();
        for (int i = 0; i < DataBase.groups.length; i++) {
            for (int j = i; j < DataBase.groups[i].lessons.length - 1; j++) {
                if (DataBase.groups[i].lessons[j].getId() == idScan) {
                    DataBase.groups[i].lessons[j] = DataBase.groups[i].lessons[j + 1];
                }
            }
            System.out.println("Сабак ийгиликтуу очурулду!");
            DataBase.groups[i].setLessons(Arrays.copyOf(DataBase.groups[i].lessons, DataBase.groups[i].lessons.length - 1));
        }
    }
}
