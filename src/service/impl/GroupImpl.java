package service.impl;

import Models.Group;
import db.DataBase;
import service.GroupAble;

import java.util.Arrays;
import java.util.Scanner;

public class GroupImpl implements GroupAble {
    @Override
    public Group[] addGroup() {
        Scanner scanner = new Scanner(System.in);
        Group group = new Group();
        while (true) {
            try {
                System.out.print("Жаны группага ат жазыныз: ");
                String groupName = scanner.nextLine();
                if (checkingUniqueness(groupName).equalsIgnoreCase("1") && groupName.length() > 2) {
                    group.setGroupName(groupName);
                    break;
                } else {
                    throw new Exception("туура эмес жаздыныз");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Группанын суроттомосуну жазыныз: ");
                group.setGroupDescription(scanner.nextLine());
                if (group.getGroupDescription().length() >= 4) {
                    break;
                } else {
                    throw new Exception("туура эмес жаздыныз");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        group.setId(MyGeneratorId.Generator());
        DataBase.groups = Arrays.copyOf(DataBase.groups, DataBase.groups.length + 1);
        DataBase.groups[DataBase.groups.length - 1] = group;
        System.out.println(group);
        System.out.println("Группа ийгиликтуу кошулду!");
        return DataBase.groups;
    }

    @Override
    public void getGroupByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Группанын атын Жазыныз: ");
        String nameGroup = scanner.nextLine();
        for (int i = 0; i < DataBase.groups.length; i++) {
            if (nameGroup.equalsIgnoreCase(DataBase.groups[i].getGroupName())) {
                System.out.println(DataBase.groups[i]);
            }
        }
    }

    @Override
    public void upDateGroupName() {
        System.out.print("Группанын атын Жазыныз: ");
        String nameGroup = new Scanner(System.in).nextLine();
        for (int i = 0; i < DataBase.groups.length; i++) {
            if (nameGroup.equalsIgnoreCase(DataBase.groups[i].getGroupName())) {
                System.out.print("Группага жаны ат жазыныз: ");
                String groupName = new Scanner(System.in).nextLine();
                if (checkingUniqueness(groupName).equalsIgnoreCase("1")) {
                    DataBase.groups[i].setGroupName(groupName);
                    if (DataBase.groups[i].getGroupName().length() > 2) {
                        System.out.println(DataBase.groups[i]);
                        System.out.println("Группанын аты ийгиликтуу озгорду");
                    }
                } else System.out.println("Кайталап жазганы болбойт");
            }
        }
    }

    @Override
    public Group[] deleteGroup() {
        System.out.print("Группанын атын Жазыныз: ");
        String nameGroup = new Scanner(System.in).nextLine();
        for (int i = 0; i < DataBase.groups.length; i++) {
            if (DataBase.groups[i].getGroupName().equalsIgnoreCase(nameGroup)) {
                for (int j = i; j < DataBase.groups.length - 1; j++) {
                    DataBase.groups[j] = DataBase.groups[j + 1];
                }
            }
        }
        System.out.println("Группа ийгиликтуу очурулду!!!");
        return Arrays.copyOf(DataBase.groups, DataBase.groups.length - 1);
    }


    private static String checkingUniqueness(String name) {
        for (int i = 0; i < DataBase.groups.length; i++) {
            if (name.equalsIgnoreCase(DataBase.groups[i].getGroupName())) {
                return "0";
            }
        }
        return "1";
    }
}
