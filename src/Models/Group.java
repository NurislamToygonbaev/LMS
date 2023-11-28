package Models;

import java.util.Arrays;

public class Group {
    private long id;
    private String GroupName;
    private String GroupDescription;
    public Lesson[] lessons = new Lesson[0];
    public Student[] students = new Student[0];


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }

    public String getGroupDescription() {
        return GroupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        GroupDescription = groupDescription;
    }

    public Lesson[] getLessons() {
        return lessons;
    }

    public void setLessons(Lesson[] lessons) {
        this.lessons = lessons;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group: " + "\n" +
                "id =                   " + id + "\n" +
                "GroupName =            " + GroupName + "\n" +
                "GroupDescription =     " + GroupDescription + "\n" +
                "lessons =              " + Arrays.toString(lessons) + "\n" +
                "students =             " + Arrays.toString(students) + "\n\n";
    }
}
