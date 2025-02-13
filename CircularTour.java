import java.util.LinkedList;
import java.util.Queue;

class CircularTour {
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        Queue<Integer> queue = new LinkedList<>();
        int start = 0, fuelBalance = 0, totalFuel = 0, totalDistance = 0;

        for (int i = 0; i < n; i++) {
            totalFuel += petrol[i];
            totalDistance += distance[i];
        }

        if (totalFuel < totalDistance) return -1;

        for (int i = 0; i < 2 * n; i++) {
            int index = i % n;
            fuelBalance += petrol[index] - distance[index];
            queue.add(index);

            while (fuelBalance < 0 && !queue.isEmpty()) {
                int removed = queue.poll();
                fuelBalance -= petrol[removed] - distance[removed];
                start = removed + 1;
            }

            if (queue.size() == n) return start;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        System.out.println("Starting Petrol Pump: " + findStartingPoint(petrol, distance));
    }
}
