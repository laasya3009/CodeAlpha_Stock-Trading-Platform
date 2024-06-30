import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Stock {
    private String symbol;
    private double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class MarketData {
    private Map<String, Stock> stocks = new HashMap<>();
    private Random random = new Random();

    public MarketData() {
        // Initialize with some stocks
        stocks.put("AAPL", new Stock("AAPL", 150.0));
        stocks.put("GOOGL", new Stock("GOOGL", 2800.0));
        stocks.put("AMZN", new Stock("AMZN", 3500.0));
    }

    public void updatePrices() {
        for (Stock stock : stocks.values()) {
            double newPrice = stock.getPrice() * (0.95 + 0.1 * random.nextDouble()); // Simulate price change
            stock.setPrice(newPrice);
        }
    }

    public Stock getStock(String symbol) {
        return stocks.get(symbol);
    }

    public void printMarketData() {
        for (Stock stock : stocks.values()) {
            System.out.println(stock.getSymbol() + ": $" + stock.getPrice());
        }
    }
}
