package com.springsorting;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mysort")
public class MySort implements SortAlgorithm {
    @Override
    public int[] sort(int[] numbers) {
        System.out.println("MySort");
        int n = numbers.length;

        for (int i = 0; i < n - 1; i++) {
            int low=i;
            for (int j = i+1; j < n - i - 1; j++) {
                if (numbers[j] < numbers[low]) {
                    low=j;
                }
            }
            int temp=number[i];
            number[i]=number[low];
            numbers[low]=temp;
        }
        return numbers;
    }
}