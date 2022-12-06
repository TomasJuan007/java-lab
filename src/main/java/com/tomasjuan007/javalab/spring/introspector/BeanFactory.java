package com.tomasjuan007.javalab.spring.introspector;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BeanFactory {

    private final Map<String, Object> beanMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BeanFactory factory = new BeanFactory();
        factory.init("Spring/config.xml");
        JavaBean javaBean = (JavaBean) factory.getBean("javaBean");
        System.out.println("userName=" + javaBean.getUserName());
        System.out.println("password=" + javaBean.getPassword());
    }

    public void init(String xml) throws DocumentException,
            ClassNotFoundException, IntrospectionException, InstantiationException,
            IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream ins = classloader.getResourceAsStream(xml);

        SAXReader reader = new SAXReader();
        Document doc = reader.read(ins);
        Element root = doc.getRootElement();

        Element foo;
        for (Iterator<Element> iterator = root.elementIterator("bean"); iterator.hasNext(); ) {
            foo = iterator.next();
            Attribute id = foo.attribute("id");
            Attribute cls = foo.attribute("class");
            String idText = id.getText();
            String clsText = cls.getText();

            Class<?> bean = Class.forName(clsText);
            Constructor<?> constructor = bean.getDeclaredConstructor((Class<?>[]) null);
            Object obj = constructor.newInstance();

            java.beans.BeanInfo info = java.beans.Introspector.getBeanInfo(bean);
            java.beans.PropertyDescriptor[] pds = info.getPropertyDescriptors();

            Element foo2;
            for (Iterator<Element> ite = foo.elementIterator("property"); ite.hasNext(); ) {
                foo2 = ite.next();
                Attribute name = foo2.attribute("name");
                Element value = foo2.element("value");
                String nameText = name.getText();
                String valueText = value.getText();

                for (java.beans.PropertyDescriptor pd : pds) {
                    if (pd.getName().equalsIgnoreCase(nameText)) {
                        Method mSet = pd.getWriteMethod();
                        mSet.invoke(obj, valueText);
                    }
                }
            }

            beanMap.put(idText, obj);
        }
    }

    public Object getBean(String beanName) {
        return beanMap.get(beanName);
    }
}
