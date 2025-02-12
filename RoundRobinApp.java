import java.util.Scanner;

class Process {
    int processId, burstTime, priority, waitingTime, turnAroundTime;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnAroundTime = 0;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null, tail = null;
    private int totalProcesses = 0;

    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head; // Circular Link
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head; // Maintain circular structure
        }
        totalProcesses++;
    }

    public void removeProcess(int processId) {
        if (head == null) return;

        Process temp = head, prev = null;

        if (head.processId == processId) {
            if (head == tail) {
                head = tail = null;
            } else {
                tail.next = head.next;
                head = head.next;
            }
            totalProcesses--;
            return;
        }

        do {
            prev = temp;
            temp = temp.next;
            if (temp.processId == processId) {
                prev.next = temp.next;
                if (temp == tail) tail = prev;
                totalProcesses--;
                return;
            }
        } while (temp != head);
    }

    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) return;

        int totalTime = 0;
        Process current = head;
        int[] burstRemaining = new int[totalProcesses];
        Process temp = head;
        for (int i = 0; i < totalProcesses; i++) {
            burstRemaining[i] = temp.burstTime;
            temp = temp.next;
        }

        while (true) {
            boolean done = true;
            temp = head;
            for (int i = 0; i < totalProcesses; i++) {
                if (burstRemaining[i] > 0) {
                    done = false;
                    if (burstRemaining[i] > timeQuantum) {
                        totalTime += timeQuantum;
                        burstRemaining[i] -= timeQuantum;
                    } else {
                        totalTime += burstRemaining[i];
                        temp.turnAroundTime = totalTime;
                        burstRemaining[i] = 0;
                    }
                }
                temp = temp.next;
            }
            if (done) break;
        }

        calculateWaitingTime();
    }

    private void calculateWaitingTime() {
        Process temp = head;
        while (temp != null) {
            temp.waitingTime = temp.turnAroundTime - temp.burstTime;
            temp = temp.next;
            if (temp == head) break;
        }
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        Process temp = head;
        System.out.println("Process Queue:");
        do {
            System.out.println("ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority + ", Waiting Time: " + temp.waitingTime + ", Turnaround Time: " + temp.turnAroundTime);
            temp = temp.next;
        } while (temp != head);
    }

    public void calculateAvgTimes() {
        double totalWaitingTime = 0, totalTurnAroundTime = 0;
        Process temp = head;
        do {
            totalWaitingTime += temp.waitingTime;
            totalTurnAroundTime += temp.turnAroundTime;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Average Waiting Time: " + (totalWaitingTime / totalProcesses));
        System.out.println("Average Turnaround Time: " + (totalTurnAroundTime / totalProcesses));
    }
}

public class RoundRobinApp {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        int choice, processId, burstTime, priority, timeQuantum;

        System.out.print("Enter Time Quantum: ");
        timeQuantum = scanner.nextInt();

        while (true) {
            System.out.println("\nRound Robin CPU Scheduling Menu:");
            System.out.println("1. Add Process");
            System.out.println("2. Display Processes");
            System.out.println("3. Simulate Scheduling");
            System.out.println("4. Calculate Average Times");
            System.out.println("5. Remove Process");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Process ID: ");
                    processId = scanner.nextInt();
                    System.out.print("Enter Burst Time: ");
                    burstTime = scanner.nextInt();
                    System.out.print("Enter Priority: ");
                    priority = scanner.nextInt();
                    scheduler.addProcess(processId, burstTime, priority);
                    break;
                case 2:
                    scheduler.displayProcesses();
                    break;
                case 3:
                    scheduler.simulateRoundRobin(timeQuantum);
                    break;
                case 4:
                    scheduler.calculateAvgTimes();
                    break;
                case 5:
                    System.out.print("Enter Process ID to Remove: ");
                    processId = scanner.nextInt();
                    scheduler.removeProcess(processId);
                    break;
                case 6:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
