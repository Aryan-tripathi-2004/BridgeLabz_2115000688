import java.util.*; 

class PairWithGivenSum{
    public static boolean checkPair(int arr[],int sum){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            if(map.containsKey(sum-arr[i])){
                return true;
            }else{
                map.put(arr[i],i);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,5,6,4};
        int sum = 6;
        System.out.println(checkPair(arr,sum));
    }
}