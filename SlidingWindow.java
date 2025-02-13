import java.util.*;

class slidingWindow{
    public static int[] slidingWindow(int arr[],int k){
        Deque<Integer> dq = new LinkedList<>();
        int nums[] = new int[arr.length-k+1];
        int max = Integer.MIN_VALUE;
        int index = 0;

        int i=0;
        for(;i<k;i++){
            dq.addLast(arr[i]);
            max = Math.max(max,arr[i]);
        }

        nums[index++] = max;

        for(int j=i;j<arr.length;j++){
            int num = dq.removeFirst();
            dq.addLast(arr[j]);
            if(num==max){
                max = Integer.MIN_VALUE;
                for(i=0;i<dq.size();i++){
                    num = dq.removeFirst();
                    max = Math.max(max,num);
                    dq.addLast(num);
                }
            }else if(arr[j]>max){
                max = arr[j];
            }
            
            nums[index++] = max; 
        }

        return nums;
    }
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6,7};
        int k = 3;

        System.out.println(Arrays.toString(slidingWindow(arr,k)));
    }
}