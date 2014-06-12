package org.stevez.roman;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;


public class RomanNumeral {

  
	private TreeMap<Integer,String> factors;

	public RomanNumeral() {
		   factors = createFactorsMap();	
	}
	
	 private  TreeMap<Integer,String> createFactorsMap() {
			
			List<Object[]> _mFactors = Arrays.asList(new Object[][]{
					{1000,"M"},
					{900,"CM"},
					{500, "D"},
					{400, "CD"},
					{100,"C"},
					{90, "XC"},
					{50, "L"},
					{40,"XL"},
					{10,"X"},
					{9,"IX"},
					{5,"V"},
					{4,"IV"},
					{1,"I"}
					
			}
			);
	         
	        TreeMap<Integer,String> map = new TreeMap<Integer,String>();
	         
	        for(Object[] obj : _mFactors) {
				Integer factor = (Integer)obj[0];
				String value = (String)obj[1];
				map.put(factor, value);
			}
	        return map;
     }
	 
	 
	public String convertToRoman(int arabic) {
		
		if(arabic == 0) {
			return "";
		}
		else {
			int factor = findNextLargestFactor(arabic);
			return factors.get(factor) + convertToRoman(arabic - factor);
		}
		
	}
	
    public String iterativeConvertToRoman(int arabic) {
		
		StringBuffer roman = new StringBuffer();
		
		while(arabic > 0) {
			int factor = findNextLargestFactor(arabic);
			roman.append(factors.get(factor));
			arabic -= factor;
		}
		
		return roman.toString();
	}
	
    
	private int findNextLargestFactor(int arabic) {
		
		int largestFactor = 0; 
		
		for(Integer key : factors.descendingKeySet()) {
			if(arabic >= key) {
				largestFactor = key;
				break;
			}
		}
		
		return largestFactor;
	
	}
	
	
	

}
