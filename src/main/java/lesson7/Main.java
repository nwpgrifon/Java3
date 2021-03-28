package lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    private static Object obj;

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        start(TestClass.class);
    }


    public static void start(Class className) throws InvocationTargetException, IllegalAccessException {

        ArrayList<Method> testMethods = new ArrayList<>();

        try {
            obj = className.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        Method beforeSuite = null;
        Method afterSuite = null;

        for (Method method : className.getDeclaredMethods()) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                beforeSuite = method;
            } else if (method.getAnnotation(AfterSuite.class) != null) {
                afterSuite = method;
            } else if (method.getAnnotation(Test.class) != null) {
                testMethods.add(method);
            }
        }

        testMethods.sort(Comparator.comparingInt(i -> i.getAnnotation(Test.class).priority()));

        if (beforeSuite != null) {
            testMethods.add(0, beforeSuite);
        }

        if (afterSuite != null) {
            testMethods.add(afterSuite);
        }

        for (Method testMethod : testMethods) {
            testMethod.setAccessible(true);
            testMethod.invoke(obj);
        }

    }
}
