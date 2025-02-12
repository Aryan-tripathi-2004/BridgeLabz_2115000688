import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskSchedulerList {
    private Task head = null;
    private Task tail = null;

    public void addAtBeginning(Task task) {
        if (head == null) {
            head = tail = task;
            tail.next = head;
        } else {
            task.next = head;
            head = task;
            tail.next = head;
        }
    }

    public void addAtEnd(Task task) {
        if (head == null) {
            head = tail = task;
            tail.next = head;
        } else {
            tail.next = task;
            tail = task;
            tail.next = head;
        }
    }

    public void addAtPosition(Task task, int position) {
        if (position <= 0) {
            addAtBeginning(task);
            return;
        }
        Task temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
            if (temp == head) break;
        }
        if (temp == null || temp.next == head) {
            addAtEnd(task);
        } else {
            task.next = temp.next;
            temp.next = task;
        }
    }

    public void removeTask(int taskId) {
        if (head == null) return;
        Task temp = head, prev = null;
        if (head.taskId == taskId) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            return;
        }
        do {
            prev = temp;
            temp = temp.next;
            if (temp.taskId == taskId) {
                prev.next = temp.next;
                if (temp == tail) tail = prev;
                return;
            }
        } while (temp != head);
    }

    public void viewAndMoveNext() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Current Task: " + head.taskName + " (Priority: " + head.priority + ")");
        head = head.next;
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Found Task: " + temp.taskName + " (Task ID: " + temp.taskId + ")");
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No tasks found with priority " + priority);
    }
}

public class TaskScheduler {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static Task takeTaskInput() {
        System.out.print("Enter Task ID: ");
        int taskId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Task Name: ");
        String taskName = scanner.nextLine();
        System.out.print("Enter Priority: ");
        int priority = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Due Date: ");
        String dueDate = scanner.nextLine();
        return new Task(taskId, taskName, priority, dueDate);
    }

    public static void main(String[] args) {
        TaskSchedulerList scheduler = new TaskSchedulerList();
        int choice, position, priority, taskId;

        while (true) {
            System.out.println("\nTask Scheduler Menu:");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Specific Position");
            System.out.println("4. Remove Task by Task ID");
            System.out.println("5. View Current Task and Move to Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search Task by Priority");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scheduler.addAtBeginning(takeTaskInput());
                    break;

                case 2:
                    scheduler.addAtEnd(takeTaskInput());
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    position = scanner.nextInt();
                    Task task = takeTaskInput();
                    scheduler.addAtPosition(task, position);
                    break;

                case 4:
                    System.out.print("Enter Task ID to Remove: ");
                    taskId = scanner.nextInt();
                    scheduler.removeTask(taskId);
                    break;

                case 5:
                    scheduler.viewAndMoveNext();
                    break;

                case 6:
                    scheduler.displayTasks();
                    break;

                case 7:
                    System.out.print("Enter Priority to Search: ");
                    priority = scanner.nextInt();
                    scheduler.searchByPriority(priority);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
