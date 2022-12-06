package com.tomasjuan007.javalab.spring.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanInit {

    public static void main(String[] args) throws Exception {
        String className = "com.tomasjuan007.javalab.spring.constructor.Car";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class<?> clazz = loader.loadClass(className);
        Car car1 = initByDefaultConst(clazz);
        Car car2 = initByParamConst(clazz);
        car1.introduce();
        car2.introduce();
    }

    public static Car initByDefaultConst(Class<?> clazz) throws NoSuchMethodException,
			IllegalAccessException, InvocationTargetException, InstantiationException {
        // 获取类的默认构造器对象并实例化Car
        Constructor<?> cons = clazz.getDeclaredConstructor((Class<?>[]) null);
        Car car = (Car) cons.newInstance();

        // 通过反射方法设置属性
        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "奔驰");
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "黑色");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 200);
        return car;
    }

    public static Car initByParamConst(Class<?> clazz) throws NoSuchMethodException,
			IllegalAccessException, InvocationTargetException, InstantiationException {
        // 带有参数的构造器对象
        Constructor<?> cons = clazz.getDeclaredConstructor(String.class, String.class, int.class);

        // 使用带参数的构造器对象实例化Car
        return (Car) cons.newInstance("宝马", "红色", 180);
    }

}
