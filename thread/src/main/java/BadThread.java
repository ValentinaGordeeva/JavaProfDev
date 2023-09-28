public class BadThread {
    static String message;
    static Object lock = new Object();

    private static class CorrectorThread
            extends Thread {

        public void run() {
            message = "Помиловать";
        }
    }

    public static void main(String args[])
            throws InterruptedException {

        for (int i=0; i<10; i++) {
            CorrectorThread correctorThread = new CorrectorThread();
            message = "Казнить";
            Thread.sleep(10);
            correctorThread.start();

            correctorThread.join();//использовать join для ожидания завершения нити

            System.out.println(message);
        }
    }
}
