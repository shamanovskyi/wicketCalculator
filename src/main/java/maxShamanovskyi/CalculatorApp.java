package maxShamanovskyi;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class CalculatorApp extends WebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return CalculatorPage.class;
    }
}
