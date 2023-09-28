package stopping;

public class ThreadStop {
    public static void main (String[] args) throws InterruptedException {

        StoppedThread stopped = new StoppedThread();

        System.out.println("после создания, до запуска => " + stopped.getState());


        //запуск нити, но это не run()!!!!
        stopped.start();

        System.out.println("после запуска, до завершения => " + stopped.getState());

        //мы не дождемся завершения так как цикл бесконечен
        //stopped.join();

        stopped.setNeedStop(true);
        stopped.join();

        System.out.println("после завершения => " + stopped.getState());


        StoppedThread stopped2 = new StoppedThread();

        System.out.println("после создания, до запуска stopped2 => " + stopped2.getState());


        //запуск нити, но это не run()!!!!
        stopped2.start();

        System.out.println("после запуска, до завершения stopped2 => " + stopped2.getState());

        //мы не дождемся завершения так как цикл бесконечен
        //stopped2.join();

//        stopped2.setNeedStop(true);
        //останавливаем через stop - но это не рекомендуется, объясняется в самом методе, лучше через переменную
        stopped2.stop();
        stopped2.join();

        System.out.println("после завершения stopped2 => " + stopped2.getState());

    }
}
