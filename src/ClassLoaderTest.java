import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest extends ClassLoader {
    private byte[] loadClassData(String className) throws IOException {
        String fileName = className + ".class";  // məsələn: "ForLoading.class"
        System.out.println("Trying to load: " + fileName); // Debug üçün

        InputStream inputStream = new FileInputStream(fileName);
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        inputStream.close();
        return buffer;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] classBytes = loadClassData("ForLoading");
            return defineClass(name, classBytes, 0, classBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Could not load class " + name, e);
        }
    }
}
