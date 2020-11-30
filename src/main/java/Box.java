public class Box {

    volatile boolean switcher;

    final int NUMOFITERATIONS = 3;
    final int DELAY = 10000;

    public void userWork() {
        for (int i = 0; i < NUMOFITERATIONS; i++)
        {
        System.out.println(Thread.currentThread().getName() + " включил тумблер");
        switcher = true;
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void toyWork() {
        while (true) {
            if(Thread.currentThread().isInterrupted()) return;
            while (switcher) {
                switcher = false;
                System.out.println(Thread.currentThread().getName() + " выключила тумблер");
            }
        }
    }

}
