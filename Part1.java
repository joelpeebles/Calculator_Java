// Class Part1 converts a string (full of integers) to the int[] representation of such string

public class Part1 {
	
	protected int convert(char letter)
	{
		int converted = 0;
		converted = letter - '0';
		return converted;
	}
	
	public int convertStringToInt(String inboundString)
	{
		int newNumber = 0;
		for(int elem = 0; elem < inboundString.length(); elem++)
		{
			if(Character.isDigit(inboundString.charAt(elem)))
			{
				if(elem > 0)
				{
					newNumber *= 10;
				}
				newNumber += convert(inboundString.charAt(elem));
				//System.out.println("converted charcter " + inboundString.charAt(elem) + " to integer " + convert(inboundString.charAt(elem)));
			}
			else
			{
				System.out.println(inboundString.charAt(elem) + " is not an integer");
			}
		}
		
		return newNumber;
	}
}
