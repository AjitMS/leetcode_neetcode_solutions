package com.ajitmohs.rnd.amm.com.ajitmohs.rnd.ammall.controller;

import java.util.Arrays;

public class SumOfArrayExceptSelf {
    public static int[] sumExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        result[0] = 0;
        for(int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] + result[i - 1];
        }

        int sum = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] + sum;
            sum = sum + nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumExceptSelf(new int[] {5,4,6,2}))); // [48, 60, 40, 120]
    }

}
