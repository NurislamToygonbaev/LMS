package service;

import Models.Admin;

public interface AdminAble {

    Admin login(Admin admin);

    Admin changePassword(Admin admin);
}
