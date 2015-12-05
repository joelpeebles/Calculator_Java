// grammar: 
// L(V): {0,1,2,3,4,5,6,7,8,9,.}
// L(C): {I,D}
// L(P): {I:= ID | D| '.'}
//		 {D: 0..9}
//		expr ::= term [{+ | –} term]*
//		term ::= factor [{* | /} factor]* 
//		factor ::= (expr) | number 
// L(S): {D}
// token terminator is <space>

public class LexicalAnalyzer {

	double convertedDouble = 0.0;
	String expressionToParse = null;
	int currentIndex = 0;
	
	LexicalAnalyzer(String expression)	// constructor
	{
		expressionToParse = expression.replaceAll("\\s+","");
	}
	
	boolean get_token(Token token) // get next token from expression
	{
		boolean validNumber = true;
		int tokenEnd = currentIndex;
		//char tempChar = expressionToParse.substring( tokenEnd, tokenEnd+1 ).charAt(0);
		if(currentIndex >= expressionToParse.length())
		{
			return false;
		}
		if(Character.isDigit( expressionToParse.substring( tokenEnd, tokenEnd+1 ).charAt(0) ) || (expressionToParse.substring(tokenEnd, tokenEnd+1).equalsIgnoreCase("."))) // token is number
		{
			while( (tokenEnd < expressionToParse.length()) && ((Character.isDigit(expressionToParse.substring(tokenEnd, tokenEnd+1).charAt(0))  || (expressionToParse.substring(tokenEnd, tokenEnd+1).equalsIgnoreCase("."))) ))
			{
				System.out.println("char: " + expressionToParse.substring( tokenEnd, tokenEnd+1 ).charAt(0));
				tokenEnd++;
				if(tokenEnd > expressionToParse.length())
				{
					tokenEnd--;
					currentIndex++;
					break;
				}
			}
			if(expressionToParse.substring(currentIndex, tokenEnd).length() > 0)
			{
				token.value = new Double(expressionToParse.substring(currentIndex, tokenEnd));
				token.classType = Constants.ClassType.NUMBER;
				token.symbol = expressionToParse.substring(currentIndex, tokenEnd);
				currentIndex = tokenEnd;
			}
		}
		else if(expressionToParse.substring(tokenEnd, tokenEnd+1).equalsIgnoreCase("*") || expressionToParse.substring(tokenEnd, tokenEnd+1).equalsIgnoreCase("/") || expressionToParse.substring(tokenEnd, tokenEnd+1).equalsIgnoreCase("+") || expressionToParse.substring(tokenEnd, tokenEnd+1).equalsIgnoreCase("-"))
		{
			token.value = expressionToParse.substring(currentIndex, tokenEnd+1);
			token.classType = Constants.ClassType.OPERATOR;
			token.symbol = expressionToParse.substring(currentIndex, tokenEnd+1);
			currentIndex++;
		}
		else if(expressionToParse.substring(tokenEnd, tokenEnd+1).equalsIgnoreCase("(") || expressionToParse.substring(tokenEnd, tokenEnd+1).equalsIgnoreCase(")"))
		{
			token.value = expressionToParse.substring(currentIndex, tokenEnd+1);
			token.classType = Constants.ClassType.SPECIAL;
			token.symbol = expressionToParse.substring(currentIndex, tokenEnd+1);
			currentIndex++;
		}
		else
		{
			validNumber = false;
			currentIndex++;
		}
		return validNumber;
	}
	
	private int scan_number(char c) // scan a real number
	{
		int converted = 0;
		converted = c - '0';
		return converted;
	}

	public double convertStringToDouble(String inboundString)
	{
		int error = 0;
		double newNumber = 0;
		double newDecimal = 0;
		int precision = 0;
		boolean finishedInteger = false;
		boolean startedPrecision = false;
		for(int elem = 0; elem < inboundString.length(); elem++)
		{
			if(Character.isDigit(inboundString.charAt(elem)))
			{
				if(!finishedInteger)
				{
					if(elem > 0)
					{
						newNumber *= 10;
					}
					newNumber += scan_number(inboundString.charAt(elem));
				}
				else
				{
					if(precision > 0)
					{
						newDecimal *= 10;
					}
					newDecimal += scan_number(inboundString.charAt(elem));
					precision++;
				}
				//System.out.println("converted charcter " + inboundString.charAt(elem) + " to integer " + convert(inboundString.charAt(elem)));
			}
			else if(inboundString.charAt(elem) == '.' & !startedPrecision)
			{
				finishedInteger = true;
				startedPrecision = true;
			}
			else
			{
				//System.out.println(inboundString.charAt(elem) + " is not an integer");
				//System.out.println("or multiple decimal points found");
				error = -1;
			}
		}
		
		newDecimal /= Math.pow(10, precision);
		newNumber += newDecimal;
		
		if(error == 0)
		{
			return newNumber;
		}
		
		return error;
	}
}
