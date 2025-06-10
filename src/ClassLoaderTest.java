import java.io.*;

public class ClassLoaderTest extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData;
        try {
            classData = loadClassData(name);
            return defineClass(name, classData, 0, classData.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Could not load class " + name, e);
        }
    }

    private byte[] loadClassData(String className) throws IOException {
        // className = "ForLoading", faylın tam yolunu qururuq
        String path = "out/production/ClassLoaderTask/" + className + ".class";
        InputStream input = new FileInputStream(path);
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int data;
        while ((data = input.read()) != -1) {
            buffer.write(data);
        }
        input.close();
        return buffer.toByteArray();
    }
}
