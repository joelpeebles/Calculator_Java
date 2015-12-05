
public class Project01 {

	public static void main(String[] args) {
		
		boolean evaluate_expressions = true;
		SemanticAnalyzer sas = new SemanticAnalyzer("17.0 + 17.17 - 0.17 * 1.7 / 7.1 ");
//		SemanticAnalyzer sas = new SemanticAnalyzer("(17.0 + 17.17 - 0.17 * 1.7 / 7.1) ");
//		SemanticAnalyzer sas = new SemanticAnalyzer("17.0 + 17.17 - (* 0.17 1.7) / 7.1 ");
		System.out.println("result is: " + ((Double)sas.value()).doubleValue());

//		SyntaxAnalyzer sa = new SyntaxAnalyzer();
//		sa.evaluate("17.0 + 17.17 - 0.17 * 1.7 / 7.1 ");
//		//sa.printReport();

//		LexicalAnalyzer la = new LexicalAnalyzer("17.0 + 17.17 - 0.17 * 1.7 / 7.1 ");
//		Token myToken1 = new Token();
//		Token myToken2 = new Token();
//		Token myToken3 = new Token();
//		Token myToken4 = new Token();
//		Token myToken5 = new Token();
//		Token myToken6 = new Token();
//		Token myToken7 = new Token();
//		Token myToken8 = new Token();
//		Token myToken9 = new Token();
//		Token myToken10 = new Token();
//		if(la.get_token(myToken1))
//		{
//			System.out.println("token1: " + myToken1.value);
//		}
//		if(la.get_token(myToken2))
//		{
//			System.out.println("token2: " + myToken2.value);
//		}
//		if(la.get_token(myToken3))
//		{
//			System.out.println("token3: " + myToken3.value);
//		}
//		if(la.get_token(myToken4))
//		{
//			System.out.println("token4: " + myToken4.value);
//		}
//		if(la.get_token(myToken5))
//		{
//			System.out.println("token5: " + myToken5.value);
//		}
//		if(la.get_token(myToken6))
//		{
//			System.out.println("token6: " + myToken6.value);
//		}
//		if(la.get_token(myToken7))
//		{
//			System.out.println("token7: " + myToken7.value);
//		}
//		if(la.get_token(myToken8))
//		{
//			System.out.println("token8: " + myToken8.value);
//		}
//		if(la.get_token(myToken9))
//		{
//			System.out.println("token9: " + myToken9.value);
//		}
//		if(la.get_token(myToken10))
//		{
//			System.out.println("token9: " + myToken10.value);
//		}
		
//		Part1 part1 = new Part1();
//		int convertedInteger = part1.convertStringToInt("1234567890");
//		int anotherConvertedInteger = part1.convertStringToInt("1627384950");
//		System.out.println("converted integer: " + convertedInteger);
//		System.out.println("another converted integer: " + anotherConvertedInteger);
		
//		Part2 part2 = new Part2();
//		String inputStringA = ("17");
//		String inputStringB = ("17.");
//		String inputStringC = (".17");
//		String inputStringD = ("17.17");
//		String inputStringE = ("17e17");
//		double convertedDoubleA = part2.convertStringToDouble(inputStringA);
//		double convertedDoubleB = part2.convertStringToDouble(inputStringB);
//		double convertedDoubleC = part2.convertStringToDouble(inputStringC);
//		double convertedDoubleD = part2.convertStringToDouble(inputStringD);
//		double convertedDoubleE = part2.convertStringToDouble(inputStringE);
//		
//		String errorMessage = " is not in the correct format";
//		if(convertedDoubleA >= 0)
//		{
//			System.out.println("convertedDoubleA: " + convertedDoubleA);
//		}
//		else
//		{
//			System.out.println(inputStringA + errorMessage);
//		}
//		if(convertedDoubleB >= 0)
//		{
//			System.out.println("convertedDoubleB: " + convertedDoubleB);
//		}
//		else
//		{
//			System.out.println(inputStringB + errorMessage);
//		}
//		if(convertedDoubleC >= 0)
//		{
//			System.out.println("convertedDoubleC: " + convertedDoubleC);
//		}
//		else
//		{
//			System.out.println(inputStringC + errorMessage);
//		}
//		if(convertedDoubleD >= 0)
//		{
//			System.out.println("convertedDoubleD: " + convertedDoubleD);
//		}
//		else
//		{
//			System.out.println(inputStringD + errorMessage);
//		}
//		if(convertedDoubleE >= 0)
//		{
//			System.out.println("convertedDoubleE: " + convertedDoubleE);
//		}
//		else
//		{
//			System.out.println(inputStringE + errorMessage);
//		}
	}

}
