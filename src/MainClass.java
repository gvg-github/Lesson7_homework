import java.lang.reflect.InvocationTargetException;

public class MainClass {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        RunTests.start(new TestsForMainClass().getClass());
        RunTests.start("TestsForMainClass");
    }

    public boolean findOne(int[] a) {

        boolean b = false;
        if (a.length == 0) return b;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                b = true;
                break;
            }
        }
        return b;
    }


}
