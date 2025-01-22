public class ProfitPercentage {
    public static void main(String[] args) {
        int costPrice = 129, sellingPrice = 191;
        int profit = sellingPrice - costPrice;
        double profitPercent = ((double)profit/costPrice)*100;
        System.out.println("The Cost Price is INR "+costPrice+" and Selling Price is INR "+sellingPrice+"\r\n" + 
                        "The Profit is INR "+profit+" and the Profit Percentage is "+profitPercent);
    }
}
