package com.ajitmohs.rnd.amm.com.ajitmohs.rnd.ammall.controller;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        if(nums.length < 1) {
            return new int[0];
        }
        if(nums.length == 1) {
            return nums;
        }

        int[] result = new int[nums.length];
        result[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            result[i] = result[i-1] * nums[i-1];
        }
        int product = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * product;
            product = product * nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] {5,4,6,2}))); // [48, 60, 40, 120]
    }
}
