package com.tomasjuan007.javalab.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflectExtendType {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        getClassObject();
        System.out.println("-----------------------------------");
        Class<?> classType = ExtendType.class;
        getFields(classType);
        System.out.println("-----------------------------------");
        getMethods(classType);
        System.out.println("-----------------------------------");
        getConstructors(classType);
        System.out.println("-----------------------------------");
        getParameterTypes(classType);
    }

    public static void getClassObject() throws ClassNotFoundException {
        // 获取类对象
        Boolean var1 = true;
        Class<?> classType2 = var1.getClass();
        System.out.println(classType2);

        Class<?> classType4 = Field.class;
        System.out.println(classType4);

        Class<?> classType5 = Class.forName("java.lang.Boolean");
        System.out.println(classType5);

        Class<?> classType3 = Boolean.TYPE;
        System.out.println(classType3);
    }

    private static void getFields(Class<?> classType) {
        // 获取类的Fields
        System.out.println("Fields:");
        // 使用getFields获取属性
        Field[] fields = classType.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }

        System.out.println("DeclaredFields:");
        // 使用getDeclaredFields获取属性
        fields = classType.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f);
        }
    }

    private static void getMethods(Class<?> classType) {
        // 获取类的Methods
        System.out.println("Methods:");
        // 使用getMethods获取函数
        Method[] methods = classType.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        System.out.println("DeclaredMethods:");
        // 使用getDeclaredMethods获取函数
        methods = classType.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
    }

    private static void getConstructors(Class<?> classType) {
        // 获取类的Constructors
        System.out.println("Constructors:");
        // 使用getConstructors获取构造器
        Constructor<?>[] constructors = classType.getConstructors();
        for (Constructor<?> m : constructors) {
            System.out.println(m);
        }

        System.out.println("DeclaredConstructors:");
        // 使用getDeclaredConstructors获取构造器
        constructors = classType.getDeclaredConstructors();
        for (Constructor<?> m : constructors) {
            System.out.println(m);
        }
    }

    private static void getParameterTypes(Class<?> classType) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Method[] methods = classType.getMethods();

        for (Method m : methods) {
            if (m.getParameterTypes().length > 0) {
                System.out.println(m.getName() + ":");
                for (Class<?> paramType : m.getParameterTypes()) {
                    System.out.print(paramType.getName() + " ");
                }
                System.out.println();
            }
        }

        System.out.println();

        for (Method m : methods) {
            if (m.getName().equals("getIntExtendField")) {
                Object o = classType.getDeclaredConstructors()[0].newInstance();
                m.invoke(o);
            }
        }
    }
}
