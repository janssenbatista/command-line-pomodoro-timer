import java.util.Scanner;

public class App {

    private static int workTimeCount;
    private static int breakTime;
    private static int breakTimeCount;
    private static int longBreakTimeCount;
    private static int minutes;
    private static int seconds;
    private static final Scanner scn = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        int option = 0;

        while (option != -1) {
            System.out.println("What would you like to do??\n" +
                    " 1 - WORK TIME\n" +
                    " 2 - BREAK TIME\n" +
                    " 3 - LONG BREAK TIME\n" +
                    "-1 - STOP");
            option = scn.nextInt();
            switch (option) {
                case 1:
                    runWorkTime();
                    break;
                case 2:
                    runBreakTime();
                    break;
                case 3:
                    runLongBreakTime();
                    break;
                case -1:
                    break;
            }
        }

        scn.close();
        System.out.println("Amount of work time: " + workTimeCount);
        System.out.println("Amount of break time: " + breakTimeCount);
        System.out.println("Amount of long break time" + longBreakTimeCount);

    }

    public static void runWorkTime() throws InterruptedException {
        int workTime = 25 * 60 * 1000;
        minutes = workTime / 60 / 1000 % 60;
        System.out.println("====== work time =======");
        while (workTime > 0) {
            System.out.format("%02d:%02d\n", minutes, seconds);
            Thread.sleep(1000);
            workTime -= 1000;
            minutes = (workTime / 60 / 1000) % 60;
            seconds = (workTime / 1000) % 60;
        }
        workTimeCount++;
    }

    public static void runBreakTime() throws InterruptedException {
        breakTime = 5 * 60 * 1000;
        minutes = breakTime / 60 / 1000 % 60;
        System.out.println("====== long break time =======");
        while (breakTime > 0) {
            System.out.format("%02d:%02d\n", minutes, seconds);
            Thread.sleep(1000);
            breakTime -= 1000;
            minutes = (breakTime / 60 / 1000) % 60;
            seconds = (breakTime / 1000) % 60;
        }
        breakTimeCount++;
    }

    public static void runLongBreakTime() throws InterruptedException {
        int longBreakTime = 14 * 60 * 1000;
        minutes = longBreakTime / 60 / 1000 % 60;
        System.out.println("====== long break time =======");
        while (longBreakTime > 0) {
            System.out.format("%02d:%02d\n", minutes, seconds);
            Thread.sleep(1000);
            longBreakTime -= 1000;
            minutes = breakTime / 60 / 1000 % 60;
            seconds = breakTime / 1000 % 60;
        }
        longBreakTimeCount++;
    }

}
