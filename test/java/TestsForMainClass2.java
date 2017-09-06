
import java.lang.annotation.Annotation;

public class TestsForMainClass2 {

    private static MainClass testClass;

    @Test
    public void testFindOneOne() {
//        System.out.println("-------------------------Tests2 starts!");
        testClass = new MainClass();
        System.out.println("Test 1: " + (false == testClass.findOne(new int[]{2, 3, 4})));
    }

    @Test (level = 9)
    public void testFindOneTwo() {
        testClass = new MainClass();
        System.out.println("Test 2: " + (true == testClass.findOne(new int[]{1, 2, 3, 4})));
    }

    @Test(level = 6)
    public void testFindOneThree() {
        testClass = new MainClass();
        System.out.println("Test 3: " + (false == testClass.findOne(new int[0])));
//        System.out.println("-------------------------Tests2 ends!");
    }

    @Test(level = 7)
    public void testFindOneFor() {
        testClass = new MainClass();
        System.out.println("Test 4: " + (false == testClass.findOne(new int[]{1})));
    }
}
