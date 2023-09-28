public class Starvation {
    public static void main(String[] args) {
        final Object resource = new Object();

        Thread lowPriorityThread = new Thread(() -> {
            synchronized (resource) {
                System.out.println("Низкоприоритетная нить: Получила доступ к ресурсу");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread highPriorityThread = new Thread(() -> {
            synchronized (resource) {
                System.out.println("Высокоприоритетная нить: Получила доступ к ресурсу");
            }
        });

        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);
        highPriorityThread.setPriority(Thread.MAX_PRIORITY);

        lowPriorityThread.start();
        highPriorityThread.start();
    }
}
