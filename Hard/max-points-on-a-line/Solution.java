import java.util.Collections;
import java.util.HashMap;

// Take a point and calculate the gradient to other points
// If the gradient is same they should be on the same line
// From google: gradient = (y2-y1) / (x2 - x1)
class Solution {
    int maxPointsOnStraightLine = 0;

    public int maxPoints(int[][] points) {
        if (points.length == 1){
            return 1;
        }

        for (int[] point1 : points) {
            // record occurance of same gradients
            HashMap<Double, Integer> gradientMap = new HashMap<>();

            for (int[] point2 : points) {
                if (point1 != point2) {
                    double gradient = calculateGradient(point1, point2);
                    if (gradientMap.containsKey(gradient)) {
                        gradientMap.replace(gradient, gradientMap.get(gradient) + 1);
                    } else {
                        // always have 2 points on a line at the start
                        gradientMap.put(gradient, 2);
                    }

                }
            }
            int maxPointsForCurrentPoint = Collections
                    .max(gradientMap.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getValue();
            updateMax(maxPointsForCurrentPoint);
        }

        return maxPointsOnStraightLine;
    }

    // double does not throw error when divided by zero. Returns POSITIVE_INFINITY
    // or NEGATIVE_INFINITY
    private double calculateGradient(int[] point1, int[] point2) {
        return (double) (point2[1] - point1[1]) / (double) (point2[0] - point1[0]);
    }

    private void updateMax(int value) {
        if (value > maxPointsOnStraightLine) {
            maxPointsOnStraightLine = value;
        }
    }
}
