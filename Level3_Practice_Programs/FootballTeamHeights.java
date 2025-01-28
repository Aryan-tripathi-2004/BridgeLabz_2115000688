public class FootballTeamHeights {

    public static int[] generateRandomHeights(int size) {
        int[] heights = new int[size];
        for (int i = 0; i < size; i++) {
            heights[i] = (int) (Math.random() * 101) + 150;
        }
        return heights;
    }

    public static int findSum(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }

    public static double findMean(int[] heights) {
        return (double) findSum(heights) / heights.length;
    }

    public static int findShortest(int[] heights) {
        int shortest = heights[0];
        for (int height : heights) {
            shortest = Math.min(shortest, height);
        }
        return shortest;
    }

    public static int findTallest(int[] heights) {
        int tallest = heights[0];
        for (int height : heights) {
            tallest = Math.max(tallest, height);
        }
        return tallest;
    }

    public static void main(String[] args) {
        int[] heights = generateRandomHeights(11);

        System.out.println("Heights of players in the team:");
        for (int height : heights) {
            System.out.println(height + " cms");
        }

        double meanHeight = findMean(heights);
        int shortestHeight = findShortest(heights);
        int tallestHeight = findTallest(heights);

        System.out.println("\nMean Height: " + meanHeight + " cms");
        System.out.println("Shortest Height: " + shortestHeight + " cms");
        System.out.println("Tallest Height: " + tallestHeight + " cms");
    }
}
