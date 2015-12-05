
public class Part2 extends Part1 {

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
					newNumber += convert(inboundString.charAt(elem));
				}
				else
				{
					if(precision > 0)
					{
						newDecimal *= 10;
					}
					newDecimal += convert(inboundString.charAt(elem));
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
				System.out.println(inboundString.charAt(elem) + " is not an integer");
				System.out.println("or multiple decimal points found");
				error = -1;
			}
		}
		
		newDecimal /= Math.pow(10, precision);
		newNumber += newDecimal;
		
		if(error == 0)
		{
			return newNumber;
		}
		else
		{
			return error;
		}
	}
}
