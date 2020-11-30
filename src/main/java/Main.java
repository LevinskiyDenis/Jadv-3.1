public class Main {

    public static void main(String[] args) {

        Box box = new Box();

        Runnable userTask = box::userWork;
        Runnable toyTask = box::toyWork;

        Thread userThread = new Thread(null, userTask, "Пользователь");
        Thread toyThread = new Thread(null, toyTask, "Игрушка");

        userThread.start();
        toyThread.start();

        try {
            userThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        toyThread.interrupt();
    }
}
