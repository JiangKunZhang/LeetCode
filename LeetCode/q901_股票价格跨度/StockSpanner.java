package q901_股票价格跨度;

import java.util.Stack;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/15 14:28
 */
public class StockSpanner {
    private Stack<Integer> stackPrice;
    private Stack<Integer> stackDay;
    public StockSpanner() {
        stackPrice = new Stack<>();
        stackDay = new Stack<>();
    }

    public int next(int price) {
        int w = 1;
        while (!stackPrice.empty() && stackPrice.peek() <= price) {
            stackPrice.pop();
            w += stackDay.pop();
        }
        stackPrice.push(price);
        stackDay.push(w);
        return w;
    }
}
