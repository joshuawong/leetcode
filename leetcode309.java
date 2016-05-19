/*
buy[i]: buy stock in i th day
sell[i]: sell stock in i th day
cooldown: i th day cooldown
lastBuy: record the last time buy stock
lastSell: record the last time sell stock
lastCoolDown: record the last time cool down 
So, we have these equation
buy = max(lastBuy, lastCoolDown - price)
sell = max(lastSell, lastBuy + price)
cooldown = max(lastSell, lastCoolDown)
*/
public class Solution {
    public int maxProfit(int[] prices) {
        int lastSell = 0, lastBuy = Integer.MIN_VALUE, lastCoolDown = 0;
        int sell = 0, buy = 0, cooldown = 0;
        for(int price : prices){
            buy = Math.max(lastBuy, lastCoolDown - price);
            sell = Math.max(lastSell, lastBuy + price);
            cooldown = Math.max(lastSell, lastCoolDown);
            lastBuy = buy;
            lastSell = sell;
            lastCoolDown = cooldown;
        }
        return sell;
    }
}
