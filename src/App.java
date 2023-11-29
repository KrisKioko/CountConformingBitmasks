import java.util.Scanner;


class Solution {
    public static int zeros(int N) {
        int conformingIntegers = 0;

        for (int i = 0; i < 30; i++) {
            if (N % 2 == 0) {
                conformingIntegers++;
            }
            N >>= 1;
        }
        return conformingIntegers;
    }

    public static int countConformingIntegers(int N) {
        return 1 << zeros(N);
    }

    public static int solution(int A, int B, int C) {
        int common = countConformingIntegers(A | B) + countConformingIntegers(A | C) + countConformingIntegers(B | C) - 1 * countConformingIntegers(A | B | C);
        return countConformingIntegers(A) + countConformingIntegers(B) + countConformingIntegers(C) - 1 * common;
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

