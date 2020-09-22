package java3.homeworkseven;

public class TestClassOne {

    @BeforeSuite
    void firstMethod() {
        System.out.println("RUN TestClassOne->firstMethod");;
    }

    @Test
    protected void test1() {
        System.out.println("RUN TestClassOne->test1");
    }

    @Test(value = 3)
    private void test2() {
        System.out.println("RUN TestClassOne->test2");
    }
    @Test(value = 9)
    public void test3() {
        System.out.println("RUN TestClassOne->test3");
    }


    @AfterSuite
    public void lastMethod() {
        System.out.println("RUN TestClassOne->lastMethod");
    }
}
