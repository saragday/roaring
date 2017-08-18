package jdk.annotation;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestAnnotation {

    @Call
    public static void print(String name, @Age int age) {
        System.out.println(name + "'s age is " + age);
    }

    @CheckAge
    @Call
    public static void toMarry(String name, @Age int age) {
        System.out.println(name + ", " + age + " is going to get married");
    }

    public static void main(String[] args) {
        Method[] methods = TestAnnotation.class.getMethods();
        String[] names = new String[] { "Helen", "Marry" };
        int[] ages = new int[] { 23, 17 };

        for (Method m : methods) {
            if (!isCall(m)) {
                continue;
            }
            for (int i = 0; i < names.length; i++) {
                if (isCheck(m)) {
                    doCheck(ages[i]);
                }

                try {
                    m.invoke(TestAnnotation.class, names[i], ages[i]);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private static boolean isCheck(Method method) {
        Annotation[] annotations = method.getDeclaredAnnotations();
        for (Annotation a : annotations) {
            if (CheckAge.class.equals(a.annotationType())) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCall(Method method) {
        Annotation[] annotations = method.getDeclaredAnnotations();
        for (Annotation a : annotations) {
            if (Call.class.equals(a.annotationType())) {
                return true;
            }
        }
        return false;
    }

    private static void doCheck(int age) {
        if (age < 18) {
            System.err.println("Error happens!!! Not allowed");
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.PARAMETER)
    @interface Age {

    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface CheckAge {

    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface Call {

    }

}
