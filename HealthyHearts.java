import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {
        
        //Get age
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your age?");
        int age = scan.nextInt();

        //work out max heart rate and if it is a healthy heart
        int maxHeartBeat = 220 - age;
        int maxTargetHeartBeat = (int) (Math.round(maxHeartBeat * 0.85));
        int minTargetHeartBeat = (int) (Math.round(maxHeartBeat * 0.5));

        System.out.println("Your maximum heart rate should be " + maxHeartBeat + " beats per minute");
        System.out.println("Your target HR Zone is " + minTargetHeartBeat + " - " + maxTargetHeartBeat + " beats per minute");

        scan.close();
    }
}