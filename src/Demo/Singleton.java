package Demo;

public class Singleton {
    private Singleton() {

    }

    private static class LazyHolder {
        static final Singleton INSTANCE = new Singleton();
        static
        {
            System.out.println("LazyHolder.<clinit>");
        }
    }

    public static Object getInsance(boolean fag) {
        if (fag) return new LazyHolder[2];
        return LazyHolder.INSTANCE;
    }

    public static void main(String[] args) {
        getInsance(true);
        System.out.println("----");
        getInsance(false);
    }

}
