import java.lang.reflect.Method;

public class TestMain {

    public static void main(String[] args) {
        Test test = new Test();
        Class aClass = test.getClass();
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            try {
                long start = System.currentTimeMillis();
                Object result = method.invoke(test);
                long end = System.currentTimeMillis();
                System.out.println("[" + (end - start) + "ms] " + method.getName() + " ======> " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


