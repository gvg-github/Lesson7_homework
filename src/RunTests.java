import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Logger;

public class RunTests {

//    private static final Logger logger = new Logger();

    public static void start(Class classForTest) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        System.out.println("run test at class...");
        runTestsFoClass(classForTest);
    }

    public static void start(String className) {
        try {
            Class classFromNane = Class.forName(className);
            try {
                System.out.println("run test at class name...");
                runTestsFoClass(classFromNane);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class with name: " + className + " not found!");
        }
    }

    private static void runTestsFoClass(Class classT) throws InvocationTargetException, IllegalAccessException, InstantiationException {

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
                methodT.add(method);
            }
        }

        if (methodB.size() > 1 && methodA.size() > 1) {
            throw new RuntimeException();
        }

        Object obj = classT.newInstance();
        if (methodB.size() != 0){
            methodB.get(0).invoke(obj, null);
        }
        if (methodT.size() > 0){
            for (Method method : methodT) {
                method.invoke(obj, null);
            }
        }
        if (methodA.size() != 0){
            methodA.get(0).invoke(obj, null);
        }

    }
}
