import com.calculator.application.model.CalculatorModel;
import com.calculator.application.model.NodeExpression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculationModelTest {

    @Test
    public void calculateExpression(){
        NodeExpression nodeExpression = CalculatorModel.buildExpressionTree("(8-6)*2+3*2-8/4");
        assertEquals(8.0, nodeExpression.calculate(), "Test failed: calculation gave an incorrect value");
    }

    @Test
    public void countBrackets(){
        String expression = "(8-6)*2+(3*2-8/4";
        assertThrows(IllegalArgumentException.class, () -> CalculatorModel.buildExpressionTree(expression));
    }
}
