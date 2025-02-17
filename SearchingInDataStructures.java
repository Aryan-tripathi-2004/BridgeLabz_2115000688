import java.util.*; 

class SearchingInDataStructures{
    private static void compare(int n){
        int target = n-38;

        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = i;
        }
        double startTime = System.currentTimeMillis();
        for(int i=0;i<n;i++){
            if(arr[i]==target) break;
        }
        double endTime = System.currentTimeMillis();
        System.out.println("Array: "+(endTime-startTime)+" ms");

        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<n;i++){
            map.put(i,1);
        }
        startTime = System.currentTimeMillis();
        map.containsKey(target);
        endTime = System.currentTimeMillis();
        System.out.println("Map: "+(endTime-startTime)+" ms");

        TreeMap<Integer,Integer> treeMap = new TreeMap();
        for(int i=0;i<n;i++){
            treeMap.put(i,1);
        }
        startTime = System.currentTimeMillis();
        treeMap.containsKey(target);
        endTime = System.currentTimeMillis();
        System.out.println("TreeMap: "+(endTime-startTime)+" ms");

        System.out.println();

    }
    public static void main(String args[]){
        compare(1000);
        compare(100000);
        compare(1000000);
    }
}