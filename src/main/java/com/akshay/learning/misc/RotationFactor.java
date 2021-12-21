package com.akshay.learning.misc;

/*
* Rotational Cipher
One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain amount.
* Rotating a character means replacing it with another character that is a
* certain number of steps away in normal alphabetic or numerical order.
For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is "Cheud-726?".
* Every alphabetic character is replaced with the character 3 letters higher (wrapping around from Z to A),
* and every numeric character replaced with the character 3 digits higher (wrapping around from 9 to 0).
* Note that the non-alphanumeric characters remain unchanged.
*
Given a string and a rotation factor, return an encrypted string.
Signature
string rotationalCipher(string input, int rotationFactor)
Input
1 <= |input| <= 1,000,000
0 <= rotationFactor <= 1,000,000
Output
Return the result of rotating input a number of times equal to rotationFactor.
Example 1
input = Zebra-493?
rotationFactor = 3
output = Cheud-726?
* */
public class RotationFactor {
    public String rotationalCipher(String input, int rotationFactor) {
        if(rotationFactor == 0) return input;
        StringBuilder sb = new StringBuilder();
        for (char ch:
             input.toCharArray()) {
            if(Character.isDigit(ch)) {
                int digit = ch - '0';
                int res = (digit+rotationFactor)%10;
                sb.append(res);
            } else if(Character.isAlphabetic(ch)) {
                char pivot = Character.isUpperCase(ch) ? 'A' : 'a';
                int diff = ch - pivot;
                int res = (diff+rotationFactor)%26;
                char resChar = (char) (pivot + res);
                sb.append(resChar);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
