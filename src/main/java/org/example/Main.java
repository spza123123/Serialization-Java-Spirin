package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("Alex", 21, 4.80d);

        FileOutputStream outputStream = new FileOutputStream("DATA.bin");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(student);

        try (FileInputStream fileInputStream = new FileInputStream("DATA.bin");) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            student = (Student) objectInputStream.readObject();
        }
        System.out.println(student.getName());
        System.out.println(student.getAge());
        System.out.println(student.getGPA());
        /*
        GPA не выводился из-за модификации "transient" и не сохраняются при сериализации объекта и не могут быть переданы по сети.
         "Transient" используется, для временных данных или для полей, которые не имеют смысла сохранять при сериализации.
         */
    }
}