package task;

public class Task1 {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Старт програми!");
        int time = 0;

        Thread printThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
                System.out.println("Минуло 5 секунд!");
            }
        });
        printThread.start();

        while (true) {
            Thread.sleep(1000);
            time++;
            if (time == 1) {
                System.out.println("З моменту запуску програми минула " + time + " секунда");
            } else if (time > 1 && time < 5) {
                System.out.println("З моменту запуску програми минуло " + time + " секунди");
            } else {
                System.out.println("З моменту запуску програми минуло " + time + " секунд");
            }
        }
    }
}
