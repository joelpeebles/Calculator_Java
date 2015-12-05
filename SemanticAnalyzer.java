
public class SemanticAnalyzer {
	
	double result;
	SyntaxAnalyzer sa;
	
	public SemanticAnalyzer(String expression) {
		// TODO Auto-generated constructor stub
		sa = new SyntaxAnalyzer();
		sa.evaluate(expression);
//		while(!sa.sas.empty())
//		{
//			System.out.println("" + sa.sas.pop().toString());
//		}
	}
	
	double value() // get semantic value of expression
	{
		//double retValue = 0.0;
		
		while(sa.sas.size() >= 3)
		{
			double operand1 = ((Double)sa.sas.pop()).doubleValue();
			char oper = sa.sas.pop().toString().charAt(0);
			if(processOperator(oper))
			{
				double operand2 = ((Double)sa.sas.pop()).doubleValue();
				performOperation(oper, operand1, operand2);
			}
		}
		
		return ((Double)sa.sas.pop()).doubleValue();
	}
	
	void processOperand(double value) // perform correct semantic action for operand
	{
		
	}
	
	boolean processOperator(char operator) // perform correct semantic action for operator
	{
		if(operator == '*' || operator == '/' || operator == '+' || operator == '-')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private boolean performOperation(char operator, double operand1, double operand2)
	{
		switch (operator) {
		case '*':
			result = operand1 * operand2;
			break;
		case '/':
			result = operand1 / operand2;
			break;
		case '+':
			result = operand1 + operand2;
			break;
		case '-':
			result = operand1 - operand2;
			break;

		default:
			break;
		}
		sa.sas.push(new Double(result));
		return true;
	}

}
