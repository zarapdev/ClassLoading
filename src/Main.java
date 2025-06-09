import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ClassLoaderTest classLoaderTest = new ClassLoaderTest();
        Class<?> forloading = classLoaderTest.findClass("ForLoading");
        Object o = forloading.getDeclaredConstructor().newInstance();
        forloading.getMethod("test").invoke(o);

    }

}