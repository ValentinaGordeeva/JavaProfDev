package stopping;

public class ThreadJoin extends Thread{
    public static void main(String[] args) {
        Thread thread = new Thread(new Joinrun(), "thread 1");

        thread.start();

        try {
            thread.join(); // Ожидаем завершения потока
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
