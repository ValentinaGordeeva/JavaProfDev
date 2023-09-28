package stopping;

public class StoppedThread extends Thread {
    public void setNeedStop(boolean needStop) {
        this.needStop = needStop;
    }

    private boolean needStop;

    @Override
    public void run() {
        for (; ; ) {
            if (needStop) {
                System.out.println("needStop == true -> exiting");
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            join(); // Вызываем join() после завершения цикла
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
