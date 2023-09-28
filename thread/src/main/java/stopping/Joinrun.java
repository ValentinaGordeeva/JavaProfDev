package stopping;

public class Joinrun implements Runnable{
    @Override public void run() {
        // Устанавливаем максимальный приоритет
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        System.out.println("Поток:" + Thread.currentThread().getName());
        try { Thread.sleep(4000);
        } catch (InterruptedException e) { e.printStackTrace();
        }
        System.out.println("Поток законил:" + Thread.currentThread().getName());
    }
}