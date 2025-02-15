public class Compare {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        long startTime = System.nanoTime();

        for(int i=0;i<1000000;i++){
            sb.append("hello");
        }

        long endTime = System.nanoTime();
        System.out.println("Time taken by String builder to concate 1M hello is "+ (endTime-startTime));

        StringBuffer sbf = new StringBuffer();
        startTime = System.nanoTime();

        for(int i=0;i<1000000;i++){
            sbf.append("hello");
        }

        endTime = System.nanoTime();
        System.out.println("Time taken by String buffer to concate 1M hello is "+ (endTime-startTime));

    }
}
