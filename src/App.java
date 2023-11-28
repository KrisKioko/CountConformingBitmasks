import java.util.Scanner;


class Solution {
    public static int solution(int A, int B, int C) {
        int setBitsA = findSetBits(A);
        int setBitsB = findSetBits(B);
        int setBitsC = findSetBits(C);

        int conformingIntegers = (1 << setBitsA) + (2 << setBitsB) + (3 << setBitsC) - 1;

        return conformingIntegers;
    }

    private static int findSetBits(int num) {
        int count = 0;

        while (num > 0) {
            count += (num & 1);
            num >>= 1;
        }
        return count;
    }

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