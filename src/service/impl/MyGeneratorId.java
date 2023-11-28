package service.impl;

public class MyGeneratorId {
    public static long id = 0;
    public static long idForLesson = 0;
    public static long idForStudent = 0;


    public static long Generator(){
        return (++id);
    }
    public static long GeneratorForLesson(){
        return (++idForLesson);
    }
    public static long GeneratorForStudent(){
        return (++idForStudent);
    }
}
