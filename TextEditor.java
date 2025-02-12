import java.util.Scanner;

class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
        this.prev = this.next = null;
    }
}

class TextEditor {
    private TextState head, tail, current;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    public void addState(String newText) {
        TextState newState = new TextState(newText);
        if (head == null) {
            head = tail = current = newState;
        } else {
            current.next = newState;
            newState.prev = current;
            current = newState;
            tail = newState;
        }

        size++;
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("No more undo available.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("No more redo available.");
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.content);
        } else {
            System.out.println("No text available.");
        }
    }
}

class TextEditorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        int choice;
        String text;

        while (true) {
            System.out.println("\nText Editor Menu:");
            System.out.println("1. Type Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current Text");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter new text: ");
                    text = scanner.nextLine();
                    editor.addState(text);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayCurrentState();
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
