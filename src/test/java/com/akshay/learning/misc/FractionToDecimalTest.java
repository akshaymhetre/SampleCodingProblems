package com.akshay.learning.misc;

import org.junit.Test;

import static org.junit.Assert.*;

public class FractionToDecimalTest {
     @Test
     public void shouldWork(){
         assertEquals("-0.58(3)", new FractionToDecimal().fractionToDecimal(7, -12));
         assertEquals("0", new FractionToDecimal().fractionToDecimal(0, -5));
         assertEquals("0", new FractionToDecimal().fractionToDecimal(0, -5));
     }
}