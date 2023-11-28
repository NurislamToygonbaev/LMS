import Models.Admin;
import db.DataBase;
import service.impl.AdminImpl;
import service.impl.GroupImpl;
import service.impl.LessonImpl;
import service.impl.StudentImpl;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AdminImpl adminImpl = new AdminImpl();
        Admin admin = new Admin();
        GroupImpl groupAble = new GroupImpl();
        StudentImpl student = new StudentImpl();
        LessonImpl lesson = new LessonImpl();
        boolean isTrue = true;
        while (isTrue) {
            try {
                timeMenu();
                System.out.println("Катталган болсонуз 1 басыныз, пароль унутуп калып, озгортуу учун 2 басыныз, 3 чыгуу!");
                int buttonLog = scanner.nextInt();
                if (buttonLog == 1) {
                    if (adminImpl.login(admin) != null) {
                        System.out.println("Кош келиниз");
                        OuterLoop:
                        while (true) {
                            mainMenu();
                            switch (scanner.nextInt()) {
                                case 0 -> {break OuterLoop;}
                                case 1 -> DataBase.groups = groupAble.addGroup();
                                case 2 -> groupAble.getGroupByName();
                                case 3 -> groupAble.upDateGroupName();
                                case 4 -> System.out.println(Arrays.toString(DataBase.groups));
                                case 5 -> student.addStudent();
                                case 6 -> student.upDateStudentName();
                                case 7 -> student.findStudent();
                                case 8 -> student.getAllStudentsByGroup();
                                case 9 -> student.getALlLessonsStudent();
                                case 10 -> student.deleteStudent();
                                case 11 -> lesson.addLesson();
                                case 12 -> lesson.getAllLesson();
                                case 13 -> lesson.getAllLessonByGroupName();
                                case 14 -> lesson.deleteLessonById();
                                case 15 -> DataBase.groups = groupAble.deleteGroup();
                                default -> System.out.println("Choose right choice ");
                            }
                        }
                    }
                } else if (buttonLog == 2) {
                    adminImpl.changePassword(admin);
                } else if (buttonLog == 3) isTrue = false;
                else System.out.println("Choose right choice ");
            } catch (Exception e){
            System.err.println("Invalid input. Please enter a valid integer.");
            scanner.nextLine();
        }
        }
    }

    private static void timeMenu() {
        ZonedDateTime currentDateTime = ZonedDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm", Locale.getDefault());

        int currentHour = currentDateTime.getHour();

        if (currentHour > 4 && currentHour < 11) {
            System.out.println("Кутман тан! саат -> " + currentDateTime.format(dateTimeFormatter));
        } else if (currentHour >= 11 && currentHour < 17) {
            System.out.println("Кутман кун! саат -> " + currentDateTime.format(dateTimeFormatter));
        } else if (currentHour >= 17 && currentHour < 22) {
            System.out.println("Кутман кеч! саат -> " + currentDateTime.format(dateTimeFormatter));
        } else {
            System.out.println("Кутман тун! саат -> " + currentDateTime.format(dateTimeFormatter));
        }
    }

    private static void mainMenu() {
        System.out.println("""
                    *** Бир команда танданыз! ***
                0  -> Exit.    
                1  -> Add new group.
                2  -> Get group by name.
                3  -> Update group name.
                4  -> Get all groups.
                5  -> Add new student to group.
                6  -> Update student.
                7  -> Find student by first name.
                8  -> Get all students by group name.
                9  -> Get all student's lesson.
                10 -> Delete student by email.
                11 -> Add new lesson to group.
                12 -> Get lesson by name.
                13 -> Get all lesson by group name.
                14 -> Delete lesson by ID.
                15 -> Delete group by name.   
                """);
        System.out.print("Команда: ");
    }
}