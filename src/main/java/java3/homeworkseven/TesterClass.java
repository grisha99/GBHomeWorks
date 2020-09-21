package java3.homeworkseven;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class TesterClass {

    public void start(Class testedClass) throws InvocationTargetException, IllegalAccessException {
        Method beforeMethod = null;                     //  ссылка на первый метод
        List<Method> classList = new LinkedList<>();    //  список методов с аннотацией @Test
        Method afterMethod = null;                      //  ссылка на последний метод
        Object o = null;
        try {
            o = testedClass.newInstance();              // экземпляр класса для invoke
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        Method[] methods = testedClass.getDeclaredMethods();    // массив методов

        for (Method m : methods) {

            BeforeSuite bs = m.getAnnotation(BeforeSuite.class);
            if (bs != null) {
                if (beforeMethod == null) {                     // если метод с Аннотацией @BeforeSuite
                    if (!Modifier.isPublic(m.getModifiers())) {
                        m.setAccessible(true);
                    }
                    beforeMethod = m;
                } else {
                    throw new RuntimeException("Класс \"" + o.getClass().getName() + "\" содержит несколько методов с аннотациейМетодов с аннотацией BeforeSuite!");
                }
            }

            Test t = m.getAnnotation(Test.class);
            if (t != null) {                                    // если метод с Аннотацией @Test
                if (!Modifier.isPublic(m.getModifiers())) {
                    m.setAccessible(true);
                }
                classList.add(m);
            }

            AfterSuite as = m.getAnnotation(AfterSuite.class);
            if (as != null) {                                   // если есть метод с Аннотацией @AfterSuite
                if (afterMethod == null) {
                    if (!Modifier.isPublic(m.getModifiers())) {
                        m.setAccessible(true);
                    }
                    afterMethod = m;
                } else {
                    throw new RuntimeException("Класс \"" + o.getClass().getName() + "\" содержит несколько методов с аннотацией AfterSuite!");
                }
            }

        }

        if (beforeMethod != null) {
            beforeMethod.invoke(o);
        }

        classList.sort(new valueComparator());              //сортируем массив методов @Test в порядке приоритета выполнения

        for (Method element : classList) {
            element.invoke(o);
        }
        if (afterMethod != null) {
            afterMethod.invoke(o);
        }


    }

    public void start(String name) throws InvocationTargetException, IllegalAccessException {
        try {
            Class clazz = Class.forName(name);
            this.start(clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

class valueComparator implements Comparator<Method> {

    @Override
    public int compare(Method o1, Method o2) {
        return Integer.compare(o2.getAnnotation(Test.class).value(), o1.getAnnotation(Test.class).value());
    }
}
