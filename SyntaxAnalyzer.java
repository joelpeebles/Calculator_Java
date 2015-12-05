import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class SyntaxAnalyzer {
	
	private Stack<Double> reverseTerm;
	private Stack<Character> reverseFactor;
	private Stack<Double> term;
	private Stack<Character> factor;
	
	public Stack<Object> sas;
	private String expressionToEval = null;
	private LexicalAnalyzer la = null;
	private Token token;
	
	double evaluate(String expression) 	// evaluate an infix expression
	{
		double retVal = 0.0;
		la = new LexicalAnalyzer(expression);
		sas = new Stack<Object>();
		token = new Token();
		
		if(la.get_token(token))
		{
			//TODO: call factor appropriately and evaluate
			while(factor(token))
			{
				System.out.println("parsed factor");
			}
		}

		return retVal;
		
	}
	
	private void performOperation(char operator)
	{
		//TODO: implement method
		double operand1 = ((Double)sas.pop()).doubleValue();
		double operand2 = ((Double)sas.pop()).doubleValue();
		switch (operator) {
		case '*':
			sas.push(new Double(operand1 * operand2));
			break;
		case '/':
			sas.push(new Double(operand1 / operand2));
			break;
		case '+':
			sas.push(new Double(operand1 + operand2));
			break;
		case '-':
			sas.push(new Double(operand1 - operand2));
			break;

		default:
			break;
		}
	}
	
	private boolean expression(Token token)	// parse infix expression
	{
		if (!term(token)) return false;			/* term */
		while ((token.classType.equalsIgnoreCase(Constants.ClassType.OPERATOR)) && ((((String)token.value).equalsIgnoreCase("+")) || (((String)token.value).equalsIgnoreCase("-")))) 
		{	/* {+ | – } */
			if (la.get_token(token) == false) return false; 	/* have C(V) - consume token */
			if (!term(token)) return false;		/* term */
			performOperation(((String)token.value).charAt(0));
		}
		return true;
	}
	
	private boolean term(Token token)		// parse infix term
	{
//		if (!term(token)) return false;			/* term */
		while ((token.classType.equalsIgnoreCase(Constants.ClassType.OPERATOR)) && ((((String)token.value).equalsIgnoreCase("*")) || (((String)token.value).equalsIgnoreCase("/")))) 
		{	/* {+ | – } */
			if (la.get_token(token) == false) return false; 	/* have C(V) - consume token */
			if (!term(token)) return false;		/* term */
		}
		return true;
	}
	
	private boolean factor(Token token)	// parse infix factor
	{
		if ((token.classType.equalsIgnoreCase(Constants.ClassType.SPECIAL)) && (((String)token.value).equalsIgnoreCase("("))) {	/* ( */
			if (la.get_token(token) == false) return (false);	/* have C(V) - consume token */
			if (!expression(token)) return (false);		/* expr */
			if ((token.classType != Constants.ClassType.SPECIAL) || (((String)token.value).equalsIgnoreCase(")"))) 
			{
				System.out.println(Constants.ErrorMessages.MISMATCHED_PAREN);
				return false;
			}
		}
		else if ((token.classType == Constants.ClassType.NUMBER) || (token.classType != Constants.ClassType.VARIABLE))
		{
			sas.push(token.value);
		}
		else
		{
			System.out.println(Constants.ErrorMessages.UNKNOWN_TERM);
			return false;
		}
		if (la.get_token(token) == false) return (false);	
		return true;
	}
}
