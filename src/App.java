import java.util.Scanner;

public class App {

    private static int workTimeCount;
    private static int breakTimeCount;
    private static int longBreakTimeCount;
    private static final Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {

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
                    runTime(Time.WORK_TIME, "work time");
                    workTimeCount++;
                    break;
                case 2:
                    runTime(Time.BREAK_TIME, "break time");
                    breakTimeCount++;
                    break;
                case 3:
                    runTime(Time.LONG_BREAK_TIME, "long break time");
                    longBreakTimeCount++;
                    break;
                case -1:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.err.println("Invalid option. Try again!");
            }
        }

        scn.close();
        System.out.println("Amount of work time: " + workTimeCount);
        System.out.println("Amount of break time: " + breakTimeCount);
        System.out.println("Amount of long break time: " + longBreakTimeCount);

    }

    public static void runTime(Time time, String message)  {
        int timeValue = time.value * 60 * 1000;
        int minutes = timeInMinutes(timeValue) % 60;
        int seconds = timeInSeconds(timeValue) % 60;
        System.out.println("====== " + message + " =======");
        while (timeValue > 0) {
            System.out.format("%02d:%02d\n", minutes, seconds);
            try {
                Thread.sleep(1000);
                System.out.println("\033[H\033[2J");
                System.out.flush();
                timeValue -= 1000;
                minutes = timeInMinutes(timeValue) % 60;
                seconds = timeInSeconds(timeValue) % 60;
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static int timeInMinutes(int time) {
        return time / 60 / 1000;
    }

    private static int timeInSeconds(int time) {
        return time / 1000;
    }

}
