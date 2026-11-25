package com.ajitmohs.rnd.amm.com.ajitmohs.rnd.ammall.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringDecodeEncode {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.size(); i++) {
            sb.append(strs.get(i).length());
            sb.append('#');
            sb.append(strs.get(i));
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list  = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        

        char[] charArray = str.toCharArray();
        StringBuilder numBuilder = new StringBuilder();
        StringBuilder wordBuilder = new StringBuilder();
        int count = 0;
        for(int i = 0; i < charArray.length; i++) { // 10#WELCOMEHIM
            // till the time next # is not found, pointer is on a number
            if(!String.valueOf(charArray[i]).equals("#")) {
                numBuilder.append(charArray[i]);
                continue;
            } else {
                count = Integer.parseInt(numBuilder.toString());
                i++;
            }
            for(int j = i; j < i+count; j++) {
                wordBuilder.append(charArray[j]);
            }
            i += count-1;
            list.add(wordBuilder.toString());
            numBuilder = new StringBuilder();
            wordBuilder = new StringBuilder();
        }


        return list;
    }

    public static void main(String[] args) {
        StringDecodeEncode stringDecodeEncode = new StringDecodeEncode();
        List<String> list = new ArrayList<>();
        list.add("#HelloHelloHello");
        list.add("World");
        list.add("Java#");

        String encodedString = stringDecodeEncode.encode(list);
        System.out.println("Encoded: " + encodedString);

        List<String> decodedList = stringDecodeEncode.decode(encodedString);
        System.out.println("Decoded: " + decodedList);
    }
}
