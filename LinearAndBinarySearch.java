class LinearAndBinarySearch{
    private static void compare(int n){
        System.out.println("Compare linear and binary search for "+n+" array size.");
       
        int arr[] = new int[n];
        int target = n-38;

        for(int i=0;i<arr.length;i++){
            arr[i] = i;
        }

        double startTime = System.nanoTime();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target) break;
        }
        double endTime = System.nanoTime();

        System.out.println("Time taken by linear search: "+((endTime-startTime)/100000)+ "ms.");

        int left = 0, right = arr.length-1;

        startTime = System.nanoTime();
        while(left<=right){
            int mid = left+(right-left)/2;

            if(arr[mid]==target) break;
            else if(arr[mid]>target) right = mid-1;
            else left = mid+1;

        }
        endTime = System.nanoTime();

        System.out.println("Time taken by binary search: "+((endTime-startTime)/100000)+ "ms.");
        System.out.println();
    }
    public static void main(String args[]){
        compare(1000);
        compare(10000);
        compare(1000000);
    }
}