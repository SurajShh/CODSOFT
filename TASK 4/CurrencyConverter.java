import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class CurrencyConverter {
    private static final String API_KEY = "YOUR_API_KEY_HERE";

    public static double getExchangeRate(String baseCurrency, String targetCurrency) throws IOException {
        String url = "https://open.er-api.com/v6/latest/" + baseCurrency + "?apikey=" + API_KEY;
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        JSONObject jsonResponse = new JSONObject(response.toString());
        JSONObject rates = jsonResponse.getJSONObject("rates");
        return rates.getDouble(targetCurrency);
    }

    public static double convertCurrency(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }

    public static void main(String[] args) {
        try {
            // Example usage
            String baseCurrency = "USD";
            String targetCurrency = "EUR";
            double amount = 100.0;

            double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
            double convertedAmount = convertCurrency(amount, exchangeRate);

            System.out.println(amount + " " + baseCurrency + " is equivalent to " + convertedAmount + " " + targetCurrency);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

