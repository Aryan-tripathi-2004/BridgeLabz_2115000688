import java.util.Random;

public class StudentScores {
    public static void main(String[] args) {
        int numberOfStudents = 5;
        int[][] scores = generateRandomScores(numberOfStudents);
        double[][] results = calculateResults(scores);
        displayScorecard(results);
    }

    public static int[][] generateRandomScores(int numberOfStudents) {
        Random random = new Random();
        int[][] scores = new int[numberOfStudents][3];
        for (int i = 0; i < numberOfStudents; i++) {
            scores[i][0] = random.nextInt(100);
            scores[i][1] = random.nextInt(100);
            scores[i][2] = random.nextInt(100);
        }
        return scores;
    }

    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][4];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            results[i][0] = total;
            results[i][1] = average;
            results[i][2] = percentage;
        }
        return results;
    }

    public static void displayScorecard(double[][] results) {
        System.out.println("Scorecard:");
        System.out.println("Total\tAverage\tPercentage");
        for (double[] result : results) {
            System.out.printf("%.2f\t%.2f\t%.2f\n", result[0], result[1], result[2]);
        }
    }
}
