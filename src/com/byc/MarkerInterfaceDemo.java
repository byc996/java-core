package com.byc;

import java.lang.reflect.Method;

interface MarkerInterface {

}

class Person {
    public void teach() {
    }
}

class Teacher extends Person implements MarkerInterface {
    @Override
    public void teach() {
        System.out.println("Teacher teach...");
    }
}

class Student extends Person {
    @Override
    public void teach() {
        System.out.println("Student teach...");
    }
}


public class MarkerInterfaceDemo {

    public static void callTeach(Person person) {
        Class<?> teacherClass = person.getClass();
        Method declaredMethod = null;
        try {
            declaredMethod = teacherClass.getDeclaredMethod("teach");
            if (person instanceof MarkerInterface) {
                declaredMethod.invoke(person);
            } else {
                throw new RuntimeException("Object is not an instance of MarkerInterface");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        callTeach(teacher);
        Student student = new Student();
        callTeach(student);
    }
}
