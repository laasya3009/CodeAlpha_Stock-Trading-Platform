import java.util.HashMap;
import java.util.Map;

class Portfolio1 {
    private Map<String, Integer> holdings = new HashMap<>();
    private double cash;

    public Portfolio1(double initialCash) {
        this.cash = initialCash;
    }

    public void buyStock(Stock stock, int quantity) {
        double totalCost = stock.getPrice() * quantity;
        if (totalCost <= cash) {
            cash -= totalCost;
            holdings.put(stock.getSymbol(), holdings.getOrDefault(stock.getSymbol(), 0) + quantity);
            System.out.println("Bought " + quantity + " shares of " + stock.getSymbol());
        } else {
            System.out.println("Not enough cash to buy " + quantity + " shares of " + stock.getSymbol());
        }
    }

    public void sellStock(Stock stock, int quantity) {
        int currentHolding = holdings.getOrDefault(stock.getSymbol(), 0);
        if (quantity <= currentHolding) {
            cash += stock.getPrice() * quantity;
            holdings.put(stock.getSymbol(), currentHolding - quantity);
            System.out.println("Sold " + quantity + " shares of " + stock.getSymbol());
        } else {
            System.out.println("Not enough shares to sell " + quantity + " of " + stock.getSymbol());
        }
    }

    public void printPortfolio1(MarketData marketData) {
        System.out.println("Cash: $" + cash);
        for (Map.Entry<String, Integer> entry : holdings.entrySet()) {
            Stock stock = marketData.getStock(entry.getKey());
            System.out.println(entry.getKey() + ": " + entry.getValue() + " shares @ $" + stock.getPrice() + " each");
        }
    }
}
