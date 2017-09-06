
import java.lang.annotation.Annotation;

public class TestsForMainClass1 {

    private static MainClass testClass;

    @BeforeSuite
    public void before() {
        testClass = new MainClass();
        System.out.println("-------------------------Tests1 starts!");
    }

    @AfterSuite
    public void after() {
        System.out.println("-------------------------Tests1 ends!");
    }

    @Test(level = 10)
    public void testFindOneOne() {
        System.out.println("Test 1: " + (false == testClass.findOne(new int[]{2, 3, 4})));
    }

    @Test
    public void testFindOneTwo() {
        System.out.println("Test 2: " + (true == testClass.findOne(new int[]{1, 2, 3, 4})));
    }

    @Test(level = 4)
    public void testFindOneThree() {
        System.out.println("Test 3: " + (false == testClass.findOne(new int[0])));
    }

    @Test(level = 7)
    public void testFindOneFor() {
        System.out.println("Test 4: " + (false == testClass.findOne(new int[]{1})));
    }
}
