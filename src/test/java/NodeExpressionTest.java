import com.calculator.application.model.NodeExpression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NodeExpressionTest {
    @Test
    public void calculateNodeSimple(){
        NodeExpression nodeExpression = new NodeExpression(5.0);
        assertEquals( 5.0, nodeExpression.calculate(), "Test failed: node with value 5.0 should calculate to 5.0");
    }

    @Test
    public void calculateBasicOperations(){
        NodeExpression nodeExpressionSum = new NodeExpression('+', new NodeExpression(5.0), new NodeExpression(12.0));
        assertEquals(17, nodeExpressionSum.calculate(), "Test failed: sum of nodes must be calculated to 17.0");

        NodeExpression nodeExpressionSub = new NodeExpression('-', new NodeExpression(5.0), new NodeExpression(12.0));
        assertEquals(-7, nodeExpressionSub.calculate(), "Test failed: sub of nodes must be calculated to -7.0");

        NodeExpression nodeExpressionMult = new NodeExpression('*', new NodeExpression(5.0), new NodeExpression(12.0));
        assertEquals(60, nodeExpressionMult.calculate(), "Test failed: multiplication of nodes must be calculated to 60.0");

        NodeExpression nodeExpressionDiv = new NodeExpression('/', new NodeExpression(5.0), new NodeExpression(2.0));
        assertEquals(2.5, nodeExpressionDiv.calculate(), "Test failed: division of nodes must be calculated to 2.5");
    }

    @Test
    public void calculateDivToZero(){
        NodeExpression nodeExpression = new NodeExpression('/', new NodeExpression(5.0), new NodeExpression(0));
        assertThrows(ArithmeticException.class, nodeExpression::calculate, "Test failed: division by 0 must throw ArithmeticsException");
    }
}
