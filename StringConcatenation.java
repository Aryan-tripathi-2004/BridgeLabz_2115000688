import java.util.*;

class StringConcatenation{
    public static void concat(int n){
        System.out.println("Compare for size: "+n);

        String s = new String();
        long startTime = System.currentTimeMillis();
        for(int i=0;i<n;i++){
            s += 'a';
        }
        long endTime = System.currentTimeMillis();
        System.out.println("String: "+(endTime-startTime)+" ms.");

        StringBuilder sb = new StringBuilder();
        startTime = System.currentTimeMillis();
        for(int i=0;i<n;i++){
            sb.append('a');
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder: "+(endTime-startTime)+" ms.");

        StringBuffer sbf = new StringBuffer();
        startTime = System.currentTimeMillis();
        for(int i=0;i<n;i++){
            sbf.append('a');
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer: "+(endTime-startTime)+" ms.");

        System.out.println();
    }
    public static void main(String args[]){
        concat(1000);
        concat(10000);
        concat(1000000);
    }
}