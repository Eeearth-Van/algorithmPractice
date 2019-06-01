package BestTimeToBuyAndSellStockII;

/**
 * @program: wy
 * @package:
 * @description:
 * @author: Kevin
 * @create: 2019-05-30 08:46
 **/
public class Solution122 {
    public int maxProfit(int[] prices) {
        int result = 0;
        for(int i = 0; i<prices.length-1;i++){
            if(prices[i+1]-prices[i]>0){
                result +=prices[i+1]-prices[i];
            }
        }
        return result;
    }
}
