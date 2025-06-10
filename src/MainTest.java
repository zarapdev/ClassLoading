public class MainTest {


        public static void main(String[] args) {
            try {
                // ClassLoaderTest ilə yükləmə (əvvəlki metod)
                ClassLoaderTest zaqruzka = new ClassLoaderTest();
              Class<?> clazz = zaqruzka.loadClass("ForLoading");
                Object instance = clazz.newInstance();
                clazz.getMethod("test").invoke(instance);

                // İndi isə Class.forName() ilə yükləmə və initialize (static bloklar varsa işləyir)
                Class<?> clazz2 = Class.forName("ForLoading");
                Object instance2 = clazz2.newInstance();
                clazz2.getMethod("test").invoke(instance2);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


