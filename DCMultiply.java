
/*
 * The “Divide and Conquer” algorithm design paradigm is a very useful and widely applicable technique.
 * We will see a variety of problems to which it can be fruitfully applied. The high-level idea is just
 * to split a given problem up into smaller pieces, and the solve the smaller pieces, often recursively.
 */

/**
 * How can we apply Divide and Conquer to integer multiplication? Lets try splitting up the numbers.
 * For example, if we were multiplying 1234 × 5678, we could express this as ((12 · 100) + 34) · ((56 · 100) + 78).
 * In general, if we are multiplying two n-digit numbers x and y, we can write x = 10n/2 ·a+b and y = 10n/2 ·c+d. So
 * x·y = (10n/2a+b)·(10n/2c+d) = 10nac+10n/2(ad+bc)+bd.
 * Now we can split this problem into four subproblems, where each subproblem is similar to the original problem,
 * but with half the digits. This gives rise to a recursive algorithm.
 */
public class DCMultiply {


    public static int divideAndConquer(int x, int y) {
        int length = getLength(x);
        if ((x >= 0 && x <= 9) && (y >= 0 && y <= 9)) {
            return x * y;
        }
        return (int) (Math.pow(10, length) * generateFirst(x) * generateFirst(y)
                + Math.pow(10, length / 2) * (generateFirst(x) * generateSecond(y) + generateSecond(x) * generateFirst(y))
                + generateSecond(x) * generateSecond(y));
    }

    private static int getLength(int number) {
        int length = 0;
        while (!(number <= 9)) {
            number = number % 10;
            length = 1;
        }
        return length + 1;
    }


    private static int generateFirst(int number) {
        int length = getLength(number);
        if (length % 2 == 0) {
            return number / (int) (Math.pow(10, length / 2));
        }
        return number / (int) (Math.pow(10, length / 2 + 1));
    }

    private static int generateSecond(int number) {
        int length = getLength(number);
        if (length % 2 == 0) {
            return (int) (number % (Math.pow(10, (length / 2))));
        }
        return (int) (number % Math.pow(10, (length / 2 + 1)));
    }


    public static void main(String[] args) {
        int a = 10;
        int b = 9;
        System.out.println(divideAndConquer(a, b));
        System.out.println(a * b);
        if (a * b == divideAndConquer(a, b)) {
            System.out.println("Congratulations!!");
        } else {
            System.out.println("Oh no, your code is wrong!");
        }
    }


}


