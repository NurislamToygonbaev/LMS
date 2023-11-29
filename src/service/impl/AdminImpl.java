package service.impl;

import Models.Admin;
import service.AdminAble;

import java.util.Scanner;

public class AdminImpl implements AdminAble {


    @Override
    public Admin login(Admin admin) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Логин жазыныз: ");
        String email = scanner.nextLine();
        System.out.print("Пароль жазыныз: ");
        String password = scanner.nextLine();
        try {
        if (email.equals(admin.getEmail()) && password.equals(admin.getPassword())){
            return admin;
        }
        else {
            throw new Exception("Туура эмес логин же пароль");
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Admin changePassword(Admin admin) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Логин жазыныз: ");
        String log = scanner.nextLine();
        if (log.endsWith("@outlook.com")){
            if (log.equals(admin.getEmail())){
                System.out.print("Жаны пароль жазыныз: ");
                String pass = scanner.nextLine();
                if (pass.length() > 7) {
                    admin.setPassword(pass);
                    System.out.println("Парол ийгиликтуу озгортулду!");
                } else System.out.println("7 символдон кем болбоосу керек");
            }
        } else System.out.println("Туура эмес логин!");
        return admin;
    }
}
