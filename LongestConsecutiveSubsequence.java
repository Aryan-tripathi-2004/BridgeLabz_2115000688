import java.util.*;

class LongestConsecutiveSubsequence{
    public static int checkSubsequence(int nums[]){
        HashMap<Integer,Integer> map = new HashMap();
        int maxLength = 0;

        for(int num : nums){
            map.put(num,1);
        }

        for(int num : nums){
            int number = num;
            int length = 0;
            while(map.containsKey(number)){
                length++;
                maxLength = Math.max(maxLength,length);
                number++;
            }
        }

        return maxLength;
    }
    public static void main(String args[]){
        int arr[] = {1,100,2,4,6,5};
        System.out.println(checkSubsequence(arr));
    }
}