package org.stevez.roman.test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import org.stevez.roman.RomanNumeral;

@RunWith(Parameterized.class)

public class TestParametizedRomanCase {

	 private Integer arabic;
	 private String expectedRomanString;
	 
	 private RomanNumeral roman;
	   
	
	 public TestParametizedRomanCase(Integer arabic, 
		      String expectedRoman) {
		      this.arabic = arabic;
		      this.expectedRomanString = expectedRoman;
		      roman = new RomanNumeral();
     }
	 
	
	 @Parameterized.Parameters
	   public static Collection RomanNumerals() {
	      return Arrays.asList(new Object[][] {
	         { 1, "I" },
	         { 2, "II" },
	         { 3, "III" },
	         { 4, "IV" },
	         { 5, "V" },
	         { 6, "VI" },
	         { 7, "VII" },
	         { 8, "VIII" },
	         { 9, "IX" },
	         { 10, "X" },
	         { 11, "XI" },
	         { 12, "XII" },
	         { 13, "XIII" },
	         { 14, "XIV" },
	         { 15, "XV" },
	         { 16, "XVI" },
	         { 17,  "XVII" },
	         { 18,  "XVIII" },
	         { 19,  "XIX" },
	         { 20,  "XX" },
	         { 30, "XXX"},
	         { 40, "XL"},
	         { 50, "L"},
	         { 60, "LX" },
	         { 70, "LXX" },
	         { 80, "LXXX" },
	         { 90, "XC" },
	         { 99, "XCIX" },
	         {100, "C"},
	         {200, "CC"},
	         {300, "CCC"},
	         {400, "CD"},
	         {500, "D"},
	         {600, "DC"},
	         {900, "CM"},
	         {1000, "M"},
	         {1116, "MCXVI"},
	         {1984,"MCMLXXXIV"}
	      });
	   } 
	 
	 @Test
		public void test_roman() {
		  assertEquals(expectedRomanString, roman.convertToRoman(arabic));
		}
	 
	 @Test
	 public void test_iterative_approach() {
		 assertEquals(expectedRomanString, roman.iterativeConvertToRoman(arabic));
	 }

}
