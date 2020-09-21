package java3.homeworkseven;

public class TestClassTwo {

    @BeforeSuite
    public void firstMethod() {
        System.out.println("RUN TestClassTwo->firstMethod");;
    }

    @Test(value = 7)
    public void test1() {
        System.out.println("RUN TestClassTwo->test1");
    }

    @Test(value = 3)
    public void test2() {
        System.out.println("RUN TestClassTwo->test2");
    }

    public void test3() {
        System.out.println("RUN TestClassTwo->test3");
    }


    @AfterSuite
    public void lastMethod() {
        System.out.println("RUN TestClassTwo->lastMethod");
    }
}
