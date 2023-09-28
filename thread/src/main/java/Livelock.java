public class Livelock {
    public static void main(String[] args) {
        final Object resource1 = new Object();
        final Object resource2 = new Object();

        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (resource1) {
                    System.out.println("Thread 1: Заблокировал resource1");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (resource2) {
                        System.out.println("Thread 1: Заблокировал resource2");
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (resource2) {
                    System.out.println("Thread 2: Заблокировал resource2");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (resource1) {
                        System.out.println("Thread 2: Заблокировал resource1");
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
