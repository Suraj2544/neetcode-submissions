class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canEat(piles, h, mid)) {
                right = mid;      // try smaller k
            } else {
                left = mid + 1;  // need bigger k
            }
        }

        return left; // ✅ after loop ends
    }

    private boolean canEat(int[] piles, int h, int k) {
        long hours = 0;

        for (int pile : piles) {
            hours += (pile + k - 1) / k; // ceil division

            if (hours > h) return false; // early exit
        }

        return hours <= h;
    }
}