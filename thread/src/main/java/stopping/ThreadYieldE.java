package stopping;

public class ThreadYieldE extends Thread {
    public static void main(String[] args) {
    Thread thread1 = new Thread(new Joinrun(), "Thread 1");
    Thread thread2 = new Thread(new Joinrun(), "Thread 2");

        thread1.start();
        thread2.start();

    // Вызываем yield() в главном потоке
        Thread.yield();

    // Другой код, выполняемый после вызова yield()
        System.out.println("Главный поток завершился");
}
}
