package service.impl;

import Models.Gender;
import Models.Student;
import db.DataBase;
import service.StudentAble;

import java.util.Arrays;
import java.util.Scanner;

public class StudentImpl implements StudentAble {

    @Override
    public void addStudent() {
        Scanner scanForSTR = new Scanner(System.in);
        System.out.print("Группанын атын Жазыныз: ");
        String name = scanForSTR.nextLine();
        for (int i = 0; i < DataBase.groups.length; i++) {
            if (name.equalsIgnoreCase(DataBase.groups[i].getGroupName())) {
                Student student = new Student();
                student.setId(MyGeneratorId.GeneratorForStudent());
                while (true) {
                    try {
                        System.out.print("Студенттин атыны жазыныз: ");
                        student.setFirstName(scanForSTR.nextLine());
                        if (student.getFirstName().length() > 1) {
                            break;
                        } else {
                            throw new Exception("туура эмес жаздыныз");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                ;
                while (true) {
                    try {
                        System.out.print("Студенттин фамилиясыны жазыныз: ");
                        student.setLastName(scanForSTR.nextLine());
                        if (student.getLastName().length() > 1) {
                            break;
                        } else {
                            throw new Exception("туура эмес жаздыныз");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                ;
                while (true) {
                    try {
                        System.out.print("Логин жазыныз: ");
                        String log = scanForSTR.nextLine();
                        if (checkingUniqueness(log).equalsIgnoreCase("1") && log.endsWith("@gmail.com")) {
                            student.setEmail(log);
                            break;
                        } else {
                            throw new Exception("Логин ди туура эмес жаздыныз. @gmail.com камтыш керек");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                while (true) {
                    try {
                        System.out.print("Пароль жазыныз: ");
                        student.setPassword(scanForSTR.nextLine());
                        if (student.getPassword().length() >= 7) {
                            break;
                        } else {
                            throw new Exception("Пароль ду туура эмес жаздыныз. 7 символдон кем болбосун");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                ;
                while (true) {
                    System.out.print("Жынысын жазыныз: (MALE/FEMALE): ");
                    String gender = (new Scanner(System.in).next());
                    try {
                        if (gender.equalsIgnoreCase("male")) {
                            student.setGender(Gender.MALE);
                            break;
                        } else if (gender.equalsIgnoreCase("female")) {
                            student.setGender(Gender.FEMALE);
                            break;
                        } else {
                            throw new Exception("жыныс только (MALE/FEMALE) камтыш керек");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                DataBase.groups[i].students = Arrays.copyOf(DataBase.groups[i].students, DataBase.groups[i].students.length + 1);
                DataBase.groups[i].students[DataBase.groups[i].students.length - 1] = student;
                System.out.println("Студент ийгиликтуу кошулду!");
            }
        }
    }

    @Override
    public void upDateStudentName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Студенттин email жазыныз: ");
        String email = scanner.nextLine();
        for (int i = 0; i < DataBase.groups.length; i++) {
            for (int j = 0; j < DataBase.groups[i].students.length; j++) {
                if (DataBase.groups[i].students[j].getEmail().equalsIgnoreCase(email)) {
                    System.out.print("Студенттин жаны атын жазыныз: ");
                    DataBase.groups[i].students[j].setFirstName(scanner.nextLine());
                    System.out.println("Студенттин аты ийгиликтуу озгорду");
                }
            }
        }
    }

    @Override
    public void findStudent() {
        System.out.print("Студенттин атын Жазыныз: ");
        String name = new Scanner(System.in).nextLine();
        for (int i = 0; i < DataBase.groups.length; i++) {
            for (int j = 0; j < DataBase.groups[i].students.length; j++) {
                if (DataBase.groups[i].students[j].getFirstName().equalsIgnoreCase(name)) {
                    System.out.println(DataBase.groups[i].students[j]);
                }
            }
        }
    }

    @Override
    public void getAllStudentsByGroup() {
        System.out.print("Группанын атын Жазыныз: ");
        String groupName = new Scanner(System.in).nextLine();
        for (int i = 0; i < DataBase.groups.length; i++) {
            if (DataBase.groups[i].getGroupName().equalsIgnoreCase(groupName)) {
                System.out.println(Arrays.toString(DataBase.groups[i].getStudents()));
            }
        }
    }

    @Override
    public void deleteStudent() {
        System.out.print("Студенттин email жазыныз: ");
        String email = new Scanner(System.in).nextLine();
        if (email.endsWith("@gmail.com")) {
            for (int i = 0; i < DataBase.groups.length; i++) {
                for (int j = i; j < DataBase.groups[i].students.length - 1; j++) {
                    if (DataBase.groups[i].students[j].getEmail().equalsIgnoreCase(email)) {
                        DataBase.groups[i].students[j] = DataBase.groups[i].students[j + 1];
                    }
                }
                System.out.println("Студент ийгилитуу очурулду!");
                DataBase.groups[i].setStudents(Arrays.copyOf(DataBase.groups[i].students, DataBase.groups[i].students.length - 1));
            }
        } else System.out.println("туура эмес логин");
    }

    @Override
    public void getALlLessonsStudent() {
        System.out.print("Студенттин ID син Жазыныз: ");
        long nameStudent = new Scanner(System.in).nextLong();
        for (int i = 0; i < DataBase.groups.length; i++) {
            for (int j = 0; j < DataBase.groups[i].students.length; j++) {
                if (DataBase.groups[i].students[j].getId() == nameStudent) {
                    for (int k = 0; k < DataBase.groups[i].lessons.length; k++) {
                        System.out.println(DataBase.groups[i].lessons[k]);
                    }
                }
            }
        }
    }


    private static String checkingUniqueness(String name) {
        for (int i = 0; i < DataBase.groups.length; i++) {
            for (int j = 0; j < DataBase.groups[i].students.length; j++) {
                if (name.equalsIgnoreCase(DataBase.groups[i].students[j].getEmail())) {
                    return "0";
                }
            }
        }
        return "1";
    }
}
