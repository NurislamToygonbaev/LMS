package service;

import Models.Group;
import db.DataBase;

public interface GroupAble {

    Group[] addGroup();

    void getGroupByName();

    void upDateGroupName();

    Group[] deleteGroup();


}
