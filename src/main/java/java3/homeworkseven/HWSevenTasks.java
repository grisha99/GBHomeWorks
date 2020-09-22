package java3.homeworkseven;

import java.lang.reflect.InvocationTargetException;

public class HWSevenTasks {

    public static void startTests() {

        TesterClass tc = new TesterClass();
        try {
            tc.start(TestClassOne.class);
            tc.start("java3.homeworkseven.TestClassTwo");
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
