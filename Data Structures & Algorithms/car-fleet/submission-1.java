
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }
        
        // Sort cars by position descending (closest to target first)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        
        int fleets = 0;
        double lastTime = -1.0;
        
        for (double[] car : cars) {
            double currentTime = car[1];
            // If this car takes more time than the fleet in front, it's a new fleet
            if (currentTime > lastTime) {
                fleets++;
                lastTime = currentTime;
            }
        }
        
        return fleets;
    }
}