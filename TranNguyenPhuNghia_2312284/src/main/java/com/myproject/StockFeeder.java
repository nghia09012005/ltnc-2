package com.myproject;

import java.util.*;

public class StockFeeder {
    private List<Stock> stockList = new ArrayList<>();
    private Map<String, List<StockViewer>> viewers = new HashMap<>();
    private static StockFeeder instance = null;

    // TODO: Implement Singleton pattern
    private StockFeeder() {}

    public static StockFeeder getInstance() {
        // TODO: Implement Singleton logic
        if(instance == null){
            instance = new StockFeeder();
        }
        return instance;
    }

    public void addStock(Stock stock) {
        // TODO: Implement adding a stock to stockList
        if(this.stockList.contains(stock)){
            return ;
        }
        this.stockList.add(stock);
        this.viewers.put(stock.getCode(),new ArrayList<StockViewer>());
    }

    public void registerViewer(String code, StockViewer stockViewer) {
        // TODO: Implement registration logic, including checking stock existence
        if(!this.viewers.containsKey(code) || this.viewers.get(code).contains(stockViewer) ){
            Logger.errorRegister(code);
        }
        else {
            this.viewers.computeIfPresent(code, (k,v) ->
                {
                    v.add(stockViewer);
                    return v;
                }
            );
        }

    }    

    public void unregisterViewer(String code, StockViewer stockViewer) {
        // TODO: Implement unregister logic, including error logging
        if(!this.viewers.containsKey(code) || !this.viewers.get(code).contains(stockViewer)){
            Logger.errorUnregister(code);
        }
        else {
            this.viewers.computeIfPresent(code, (k,v) ->
                    {
                        v.remove(stockViewer);
                        return v;
                    }
            );
        }
    }

    public void notify(StockPrice stockPrice) {
        // TODO: Implement notifying registered viewers about price updates
        this.viewers.computeIfPresent(stockPrice.getCode(),
                (k,v)->
                {
                    for(StockViewer it:v){
                        it.onUpdate(stockPrice);
                    }
                    return v;
                }
                );

    }
}
