package HW_7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ClassTest {

    public static <T> void start (Class<T> c) {
        testing(c);
    }

    public static <T> void testing(Class<T> c) {
        ClassTest classTest;
        try {
            classTest = (ClassTest) c.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Method before = null;
        Method after = null;
        Method[] methods = c.getMethods();
        List<Method> testingMethods = new ArrayList<>();

        for (Method m : methods ) {
            if (m.getAnnotation(BeforeSuite.class) != null) {
                if (before != null) {
                    throw new RuntimeException();
                }
                before = m;
            } else if (m.getAnnotation(AfterSuite.class) != null) {
                if (after != null) {
                    throw new RuntimeException();
                }
                after = m;
            } else if (m.getAnnotation(Test.class) != null) {
                testingMethods.add(m);
            }
        }

            try {
                if (before != null) {
                    System.out.println(before.getAnnotation(BeforeSuite.class).description());
                    before.invoke(classTest);
                }
                for (Method tm : testingMethods) {
                    System.out.println(tm.getAnnotation(Test.class).description());
                    tm.invoke(classTest);
                }
                if (after != null) {
                    System.out.println(after.getAnnotation(AfterSuite.class).description());
                    after.invoke(classTest);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


    }

    @BeforeSuite
    public void before() {
        System.out.println("Самый первый метод.");
    }

    @Test
    public void test1() {
        System.out.println("Первый.");
    }

    @Test
    public void test2() {
        System.out.println("Второй.");
    }

    @Test
    public void test3() {
        System.out.println("Третий.");
    }

    @AfterSuite
    public void after() {
        System.out.println("Последний метод.");
    }

}
