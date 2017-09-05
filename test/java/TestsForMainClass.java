//package Users\l.ganina\Desktop\Валерий\java\Lesson7\test\java;

import java.lang.annotation.Annotation;

public class TestsForMainClass {

    private static MainClass testClass;

    @BeforeSuite
    public void before() {
        testClass = new MainClass();
        System.out.println("Tests starts!");
    }

    @AfterSuite
    public void after() {
        System.out.println("Tests complete!");
    }

    @Test(level = 10)
    public void testFindOneOne() {
        System.out.println("Test 1 complete: " + (false == testClass.findOne(new int[]{2, 3, 4})));
    }

    @Test(level = 9)
    public void testFindOneTwo() {
        System.out.println("Test 2 complete: " + (true == testClass.findOne(new int[]{1, 2, 3, 4})));
    }

    @Test(level = 7)
    public void testFindOneThree() {
        System.out.println("Test 3 complete: " + (false == testClass.findOne(new int[0])));
    }

    @Test
    public void testFindOneFor() {
        System.out.println("Test 4 complete: " + (false == testClass.findOne(new int[]{1})));
    }
}
