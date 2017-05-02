package maxShamanovskyi;


import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.model.PropertyModel;
import java.math.BigDecimal;


public class CalculatorPage extends BasePage {
    private BigDecimal curr;
    private BigDecimal input;
    private Operation operation;
    private String symbol;

    public CalculatorPage() {
        input = BigDecimal.ZERO;
        curr = BigDecimal.ZERO;
        operation = Operation.none;
        symbol = operation.getSymbol();
        add(new CalculatorForm("form"));
    }


    private class CalculatorForm extends Form{

        CalculatorForm(String id) {
            super(id);
            add(new Label("display", new PropertyModel(CalculatorPage.this, "curr")));
            add(new Label("text", new PropertyModel(CalculatorPage.this, "symbol")));
            add(new TextField("input", new PropertyModel(CalculatorPage.this, "input")));
            add(new Button("clear") {
                @Override
                public void onSubmit() {
                    curr = BigDecimal.ZERO;
                    input = BigDecimal.ZERO;
                    operation = Operation.none;
                    symbol = operation.getSymbol();
                }
            });
            add(new Button("eq") {
                @Override
                public void onSubmit() {
                    apply();
                }
            });
            add(new OperationButton("plus", Operation.plus));
            add(new OperationButton("minus", Operation.minus));
            add(new OperationButton("multiply", Operation.multiply));
            add(new OperationButton("divided", Operation.divided));
        }
    }

    private void apply() {
        if (operation != Operation.none) {
            curr = operation.action(curr, input);
            operation = Operation.none;
            input = BigDecimal.ZERO;
            symbol = operation.getSymbol();
        }
    }

    private class OperationButton extends Button {
        private Operation op;

        OperationButton(String id, Operation op) {
            super(id);
            this.op = op;
        }

        @Override
        public void onSubmit() {
            if(curr.equals(BigDecimal.ZERO)){
                curr = input;
            }
            operation = op;
            symbol = operation.getSymbol();
            input = BigDecimal.ZERO;
        }
    }




}


