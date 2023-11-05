public interface StockObserver {
    void update();
}


class StockDisplay implements StockObserver {
    private final StockMarket stockMarket;
    private final String symbol;

    public StockDisplay(StockMarket stockMarket, String symbol) {
        this.stockMarket = stockMarket;
        this.symbol = symbol;
    }

    @Override
    public void update() {
        double price = stockMarket.getStockPrice(symbol);
        System.out.println("Stock: " + symbol + " - Price: " + price);
    }
}