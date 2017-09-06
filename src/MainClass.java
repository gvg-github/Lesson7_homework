import java.lang.reflect.InvocationTargetException;

public class MainClass {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        MainClass c1 = new MainClass();
        c1.findOne(new int[]{1,2,3,4});
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
