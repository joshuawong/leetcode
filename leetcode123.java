public class Solution {
    public int maxProfit(int[] prices) {
        // use 4 variable to represent first buy, first sell, second buy and second sell
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;
        for(int price : prices){
            if(buy1 < 0 - price)
                buy1 = -price;
            if(sell1 < buy1 + price)
                sell1 = buy1 + price;
            if(buy2 < sell1 - price)
                buy2 = sell1 - price;
            if(sell2 < buy2 + price)
                sell2 = buy2 + price;
        }
        return sell2;
    }
}
