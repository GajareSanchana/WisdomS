class Solution6 {
    
    // GCD using Euclidean Algorithm
    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // LCM function
    public long lcm(int a, int b) {
        return (a / gcd(a, b)) * (long)b;
    }

    // Example usage
    public static void main(String[] args) {
        Solution6 sol = new Solution6();

        System.out.println(sol.lcm(4, 6));         // 12
        System.out.println(sol.lcm(5, 10));        // 10
        System.out.println(sol.lcm(7, 3));         // 21
        System.out.println(sol.lcm(1, 987654321)); // 987654321
        System.out.println(sol.lcm(123456, 789012)); // 8117355456
    }
}
