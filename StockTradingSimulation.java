import java.util.Scanner;

public class StockTradingSimulation {
    public static void main(String[] args) {
        MarketData marketData = new MarketData();
        Portfolio1 portfolio = new Portfolio1(10000.0);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMarket Data:");
            marketData.printMarketData();

            System.out.println("\nYour Portfolio:");
            portfolio.printPortfolio1(marketData);

            System.out.println("\nChoose an action: [1] Buy [2] Sell [3] Update Prices [4] Exit");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Enter stock symbol to buy:");
                String symbol = scanner.next();
                System.out.println("Enter quantity to buy:");
                int quantity = scanner.nextInt();
                Stock stock = marketData.getStock(symbol);
                if (stock != null) {
                    portfolio.buyStock(stock, quantity);
                } else {
                    System.out.println("Stock symbol not found.");
                }
            } else if (choice == 2) {
                System.out.println("Enter stock symbol to sell:");
                String symbol = scanner.next();
                System.out.println("Enter quantity to sell:");
                int quantity = scanner.nextInt();
                Stock stock = marketData.getStock(symbol);
                if (stock != null) {
                    portfolio.sellStock(stock, quantity);
                } else {
                    System.out.println("Stock symbol not found.");
                }
            } else if (choice == 3) {
                marketData.updatePrices();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
