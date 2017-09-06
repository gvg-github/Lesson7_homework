
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.logging.Logger;

public class RunTests {

//    private static final Logger logger = new Logger();

    public static void main(String[] args) {

        start(TestsForMainClass1.class);

        start("TestsForMainClass2");

        start(TestsForMainClass3.class);

//        start("TestsForMain");

    }

    public static void start(Class classForTest) {
        runTestsFoClass(classForTest);
    }

    public static void start(String className) {
        Class classForTest = null;
        try {
            classForTest = Class.forName(className);
            runTestsFoClass(classForTest);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Method> sortForLevel(ArrayList<Method> list) {
        int j, lev;
        for (int i = 1; i < list.size(); i++) {
            Method temp = list.get(i);
            lev = (list.get(i)).getAnnotation(Test.class).level();
            j = i;
            while (j > 0 && (list.get(j - 1)).getAnnotation(Test.class).level() <= lev) {
                list.set(j, list.get(j - 1));
                --j;
            }
            list.set(j, temp);
        }
        return list;
    }

    public static void runTestsFoClass(Class classT) {

        Method[] metodsT = classT.getDeclaredMethods();
        if (metodsT.length == 0) {
            System.out.println("Not find tests metods!");
            return;
        }
        ArrayList<Method> methodA = new ArrayList<>();
        ArrayList<Method> methodB = new ArrayList<>();
        ArrayList<Method> methodT = new ArrayList<>();

        for (Method method : metodsT) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                methodB.add(method);
            } else if (method.getAnnotation(AfterSuite.class) != null) {
                methodA.add(method);
            } else if (method.getAnnotation(Test.class) != null) {
                int lev = method.getAnnotation(Test.class).level();
                if (lev < 0 || lev > 10) continue;
                methodT.add(method);
            }
        }

        if (methodB.size() > 1 && methodA.size() > 1) {
            throw new RuntimeException("Find same metods!");
        }

        Object obj = null;
        try {
            obj = classT.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        if (methodB.size() != 0) {
            try {
                methodB.get(0).invoke(obj, null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        if (methodT.size() != 0) {
            methodT = sortForLevel(methodT);
            for (int i = 0; i < methodT.size(); i++) {
                try {
                    methodT.get(i).invoke(obj, null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        if (methodA.size() != 0) {
            try {
                methodA.get(0).invoke(obj, null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
