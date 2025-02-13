import java.util.*;

class SortStack{
    public static void sort(Stack<Integer>s){
        if(!s.isEmpty()){
            int temp = s.pop();
            sort(s);
            insert(s,temp);
        }
    }

    public static void insert(Stack<Integer>s,int val){
        if(s.isEmpty() || s.peek()<=val){
            s.push(val);
            return;
        }
        int temp = s.pop();
        insert(s, val);
        s.push(temp);
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        Scanner sc = new Scanner(System.in);

        int num;

        do{
            System.out.println("Enter 1 to add Element");
            System.out.println("Enter 2 for sort the stack");
            System.out.println("Enter 3 for pop the element");
            System.out.println("Enter 4 for exit");

            num = sc.nextInt();
            
            switch(num){
                case 1:
                    System.out.println("Enter number to add in the stack: ");
                    s.push(sc.nextInt());
                    break;
                case 2:
                    sort(s); 
                    System.out.println(s); 
                    break;
                case 3:
                    System.out.println("The element "+s.pop()+" is popped out.");
                    break;
                case 4:
                    System.exit(0);
                    break; 
                default:
                    System.out.println("Invalid number.");     
            }
        }while(num!=4);
    }
}