import java.util.Scanner;


class Solution {
    public static int solution(int A, int B, int C) {
        int maxBit = 30;

        int maxCombinations = 1 << maxBit;
        int conformingIntegers = 0;

        for (int i = 0; i < maxCombinations; i++) {
            int candidate = 0;

            for (int j = 0; j < maxBit; j++) {
                int bitA = (A >> j) & 1;
                int bitB = (B >> j) & 1;
                int bitC = (C >> j) & 1;

                if (bitA == 1 || bitB == 1 || bitC == 1) {
                    candidate |= (1 << j);
                }
            }

            if ((candidate & A) == A || (candidate & B) == B || (candidate & C) == C) {
                conformingIntegers++;
            }
        }

        return conformingIntegers;
    }

    /* private static int findSetBits(int num) {
        int count = 0;

        while (num > 0) {
            count += (num & 1);
            num >>= 1;
        }
        return count;
    } */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter integer A: ");
        int A = scanner.nextInt();

        System.out.print("Enter integer B: ");
        int B = scanner.nextInt();

        System.out.print("Enter integer C: ");
        int C = scanner.nextInt();

        int result = solution(A, B, C);
        System.out.println("Number of conforming integers: " + result);
        
        scanner.close();
    }
}

