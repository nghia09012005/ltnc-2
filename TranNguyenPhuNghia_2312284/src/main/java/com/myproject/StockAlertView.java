package com.myproject;

import java.util.HashMap;
import java.util.Map;

public class StockAlertView implements StockViewer {
    private double alertThresholdHigh;
    private double alertThresholdLow;
    private Map<String, Double> lastAlertedPrices = new HashMap<>(); // TODO: Stores last alerted price per stock

    public StockAlertView(double highThreshold, double lowThreshold) {
        // TODO: Implement constructor
        this.alertThresholdHigh = highThreshold;
        this.alertThresholdLow = lowThreshold;
    }

    @Override
    public void onUpdate(StockPrice stockPrice) {
        // TODO: Implement alert logic based on threshold conditions
        if(stockPrice.getAvgPrice() > this.alertThresholdHigh){
            lastAlertedPrices.put(stockPrice.getCode(), stockPrice.getAvgPrice());
            this.alertAbove(stockPrice.getCode(), stockPrice.getAvgPrice());
        }
        else if(stockPrice.getAvgPrice() < this.alertThresholdLow){
            lastAlertedPrices.put(stockPrice.getCode(), stockPrice.getAvgPrice());
            this.alertBelow(stockPrice.getCode(), stockPrice.getAvgPrice());
        }
    }

    private void alertAbove(String stockCode, double price) {
        // TODO: Call Logger to log the alert
        // Logger.notImplementedYet("alertAbove");
        Logger.logAlert(stockCode, price);
    }

    private void alertBelow(String stockCode, double price) {
        // TODO: Call Logger to log the alert
        // Logger.notImplementedYet("alertBelow");
        Logger.logAlert(stockCode, price);
    }
}
