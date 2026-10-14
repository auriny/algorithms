package acmp.task869;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public void getBoatCount() {
        try (Scanner sc = new Scanner(new File("INPUT.TXT"));
             FileWriter fr = new FileWriter("OUTPUT.TXT")) {

            int people = sc.nextInt();
            int cap = sc.nextInt();

            int[] weight = new int[people];
            for (int i = 0; i < people; i++) {
                weight[i] = sc.nextInt();
            }

            Arrays.sort(weight);

            int boats = 0;

            int left = 0;
            int right = people - 1;

            while (left <= right) {
                if (weight[left] + weight[right] <= cap) {
                    boats++;
                    left++;
                    right--;
                } else {
                    boats++;
                    right--;
                }
            }

            fr.write(String.valueOf(boats));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
