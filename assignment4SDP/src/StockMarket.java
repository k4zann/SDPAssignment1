import java.util.ArrayList;
import java.util.List;

interface StockMarket {
    void register(StockObserver observer);
    void unregister(StockObserver observer);
    void notifyObservers();
    double getStockPrice(String symbol);
    void setStockPrice(String symbol, double price);
}

class StockMarketImpl implements StockMarket {
    private final List<StockObserver> observers = new ArrayList<>();
    private final java.util.Map<String, Double> stockPrices = new java.util.HashMap<>();

    @Override
    public void register(StockObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(StockObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update();
        }
    }

    @Override
    public double getStockPrice(String symbol) {
        if (stockPrices.containsKey(symbol)) {
            return stockPrices.get(symbol);
        } else {
            return 0.0;
        }
    }

    @Override
    public void setStockPrice(String symbol, double price) {
        stockPrices.put(symbol, price);
        notifyObservers();
    }
}
