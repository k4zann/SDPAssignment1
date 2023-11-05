public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarketImpl();

        StockObserver observer1 = new StockDisplay(stockMarket, "Apple");
        StockObserver observer2 = new StockDisplay(stockMarket, "Google");

        stockMarket.register(observer1);
        stockMarket.register(observer2);

        stockMarket.setStockPrice("Apple", 150.0);
        stockMarket.setStockPrice("Google", 2800.0);

        stockMarket.unregister(observer1);

        stockMarket.setStockPrice("Apple", 155.0);
    }
}