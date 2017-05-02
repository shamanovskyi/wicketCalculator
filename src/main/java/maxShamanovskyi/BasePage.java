package maxShamanovskyi;


import org.apache.wicket.markup.html.WebPage;

import java.math.BigDecimal;
import java.math.RoundingMode;

class BasePage extends WebPage {

    enum Operation {
        none("") {
            @Override
            BigDecimal action(BigDecimal a, BigDecimal b) {
                return BigDecimal.ZERO;
            }
        }, plus("+") {
            @Override
            BigDecimal action(BigDecimal a, BigDecimal b) {
                return a.add(b);
            }
        }, minus("-") {
            @Override
            BigDecimal action(BigDecimal a, BigDecimal b) {
                return a.subtract(b);
            }
        }, multiply("*") {
            @Override
            BigDecimal action(BigDecimal a, BigDecimal b) {
                return a.multiply(b);
            }
        }, divided("/") {
            @Override
            BigDecimal action(BigDecimal a, BigDecimal b) {
                return a.divide(b, 4, RoundingMode.HALF_UP);
            }
        };

        private String symbol;
        abstract BigDecimal action(BigDecimal a, BigDecimal b);

        Operation(String s) {
            symbol = s;
        }

        public String getSymbol() {
            return symbol;
        }
    }
}

