

public class test2 {
    public static void main(String[] args) {
        System.out.println("-- Test2 : OutOfMemoryError Exception --");
        try {
            int len = Integer.MAX_VALUE;
            int largeArray[] = new int[len];
            System.out.println(len);
        } catch (OutOfMemoryError e) {
            System.out.println("JVM 空闲内存空间大小：" + Runtime.getRuntime().freeMemory() / (1024 * 1024));
            System.out.println("JVM 总内存空间大小：" + Runtime.getRuntime().totalMemory() / (1024 * 1024));
            System.out.println("最大可占用内存大小：" + Runtime.getRuntime().maxMemory() / (1024 * 1024));
            System.out.println(e.getMessage());
        } finally {
            System.gc();
        }
    }
}
