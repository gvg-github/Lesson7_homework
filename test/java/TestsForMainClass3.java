
import java.lang.annotation.Annotation;

public class TestsForMainClass3 {

    private static MainClass testClass;

    @BeforeSuite
    public void before() {
        testClass = new MainClass();
        System.out.println("-------------------------Tests3 starts!");
    }

//    @AfterSuite
//    public void after1() {
//        System.out.println("-------------------------Tests complete!");
//    }
//
//    @BeforeSuite
//    public void before1() {
//        testClass = new MainClass();
//        System.out.println("-------------------------Tests3 starts!");
//    }

    @AfterSuite
    public void after() {
        System.out.println("-------------------------Tests3 ends!");
    }

    @Test
    public void testFindOneOne() {
        System.out.println("Test 1: " + (false == testClass.findOne(new int[]{2, 3, 4})));
    }

    @Test
    public void testFindOneTwo() {
        System.out.println("Test 2: " + (true == testClass.findOne(new int[]{1, 2, 3, 4})));
    }

    @Test
    public void testFindOneThree() {
        System.out.println("Test 3: " + (false == testClass.findOne(new int[0])));
    }

    @Test
    public void testFindOneFor() {
        System.out.println("Test 4: " + (false == testClass.findOne(new int[]{1})));
    }
}
