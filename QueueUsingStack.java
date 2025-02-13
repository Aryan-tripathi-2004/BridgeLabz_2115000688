import java.util.*;

class Queue{
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void enqueue(int data){
        s1.push(data);
        System.out.println("Your data "+data+" stored in queue.");
    }

    public void dequeue(){
        if(s2.isEmpty()){
            if(s1.isEmpty()){
                System.out.println("Queue is Empty.");
                return;
            }
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }

        int data = s2.pop();
        System.out.println("Value "+data+" is coming out of queue.");
    }
}
public class QueueUsingStack{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue q = new Queue();

        int choice = 0;
        do{
            System.out.println("Enter 1 for Enqueue: ");
            System.out.println("Enter 2 for dequeue: ");
            System.out.println("Enter 3 for Exit: ");
            choice =sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter value: ");
                    int data = sc.nextInt();
                    q.enqueue(data);
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
                
        }while(choice!=3);
    }
}