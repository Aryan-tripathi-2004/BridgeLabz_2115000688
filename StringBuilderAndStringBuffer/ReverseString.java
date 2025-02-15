class ReverseString{
    public static String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
    public static void main(String[] args) {
        String s = "hello";
        System.err.println(reverse(s));
    }
}