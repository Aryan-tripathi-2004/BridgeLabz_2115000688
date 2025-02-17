class Fibonacci{
    private static int recursive(int n){
        if(n<=1) return 0;
        return recursive(n-1)+recursive(n-2);
    }
    private static void iterartive(int n){
        int first = 0;
        int second = 1;
        int third;

        for(int i=2;i<=n;i++){
            third = first + second;
            first = second;
            second = third;
        }
    }
    private static void compare(int n){
        System.out.println("compare for range "+n);

        double startTime = System.currentTimeMillis();
        recursive(n);
        double endTime = System.currentTimeMillis();
        System.out.println("recursion: "+(endTime-startTime)+" ms.");

        startTime = System.currentTimeMillis();
        iterartive(n);
        endTime = System.currentTimeMillis();
        System.out.println("iteration: "+(endTime-startTime)+" ms.");
        System.out.println();
    }

    public static void main(String args[]){
        compare(10);
        compare(30);
        compare(50);
    }
}