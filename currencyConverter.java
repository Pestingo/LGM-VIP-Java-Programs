import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CurrencyConverterServlet")
public class CurrencyConverterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double usdAmount = Double.parseDouble(request.getParameter("usdAmount"));
        String targetCurrency = request.getParameter("targetCurrency");

        double convertedAmount = convertCurrency(usdAmount, targetCurrency);

        response.setContentType("application/json");
        response.getWriter().write("{\"convertedAmount\":" + convertedAmount + "}");
    }

    private double convertCurrency(double usdAmount, String targetCurrency) {
        switch (targetCurrency.toUpperCase()) {
            case "EUR":
                return usdAmount * 0.85;
            case "GBP":
                return usdAmount * 0.74;
            case "INR":
                return usdAmount * 75.0;
            case "ZAR":
                return usdAmount * 14.5; // Update with a realistic conversion rate
            default:
                return 0.0;
        }
    }
}
