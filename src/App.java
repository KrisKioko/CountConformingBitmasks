import java.util.Scanner;


class Solution {
    public static int zeros(int N) {
        // This variable will be used to keep count of the bits in the binary representation of 'N'
        int conformingIntegers = 0;

        for (int i = 0; i < 30; i++) {
            // Checks if the least significant bit is '0' and if so it is increased by 1
            if (N % 2 == 0) {
                conformingIntegers++;
            }
            N >>= 1;    // The value of 'N' is right-shifted by '1' effectively moving to the next bit
        }
        return conformingIntegers;    // The method returns the count of zero bits in the binary representation of integer 'N'
    }

    // This method takes integer 'N' as a parameter and returns '2^zeros(N)'
    public static int countConformingIntegers(int N) {
        return 1 << zeros(N);    // This line uses the left-shift operator to calculate '2^zeros(N)'
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

