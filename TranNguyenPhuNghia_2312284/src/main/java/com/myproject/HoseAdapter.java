package com.myproject;

import java.util.ArrayList;
import java.util.List;

public class HoseAdapter implements PriceFetcher {
    private HosePriceFetchLib hoseLib;
    private List<String> stockCodes;
 
    public HoseAdapter(HosePriceFetchLib hoseLib, List<String> stockCodes) {
        // TODO: Implement constructor
        this.hoseLib = hoseLib;
        this.stockCodes = stockCodes;
    }

    @Override
    public List<StockPrice> fetch() {
        // TODO: Fetch stock data and convert it to StockPrice list
        List<StockPrice> result = new ArrayList<>();

        List<HoseData> hoselist = hoseLib.getPrices(stockCodes);
        for(HoseData it:hoselist){
            result.add(this.convertToStockPrice(it));
        }

        return result;
    }

    private StockPrice convertToStockPrice(HoseData hoseData) {
        // TODO: Convert HoseData to StockPrice
        return new StockPrice(hoseData.getStockCode(), hoseData.getPrice(), hoseData.getVolume(),hoseData.getTimestamp());
    }
}
