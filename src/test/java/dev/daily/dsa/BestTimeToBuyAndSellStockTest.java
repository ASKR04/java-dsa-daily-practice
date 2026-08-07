package dev.daily.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeToBuyAndSellStockTest {
    @Test
    void returnsBestProfitWhenPriceRisesAfterLowestDay() {
        assertEquals(5, BestTimeToBuyAndSellStock.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
    }

    @Test
    void returnsZeroWhenPricesOnlyDecrease() {
        assertEquals(0, BestTimeToBuyAndSellStock.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
    }

    @Test
    void returnsZeroWhenThereIsOnlyOnePrice() {
        assertEquals(0, BestTimeToBuyAndSellStock.maxProfit(new int[] { 5 }));
    }
}

