package Models;

public class Lesson {
    private long id;
    private String nameLesson;
    private String descriptionLesson;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameLesson() {
        return nameLesson;
    }

    public void setNameLesson(String nameLesson) {
        this.nameLesson = nameLesson;
    }

    public String getDescriptionLesson() {
        return descriptionLesson;
    }

    public void setDescriptionLesson(String descriptionLesson) {
        this.descriptionLesson = descriptionLesson;
    }

    @Override
    public String toString() {
        return "Lesson: \n" +
                "id =                 " + id + "\n" +
                "nameLesson =         " + nameLesson + "\n" +
                "descriptionLesson =  " + descriptionLesson + "\n\n";
    }
}
