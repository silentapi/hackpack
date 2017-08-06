// Returns an array of the x and y coordinate of the intersection point of
// two lines, or null if no intersection point
public static double[] lineIntersection(double[] line1, double[] line2) {

    // Parse arguments into x,y values for each line
    double x1 = line1[0],
        y1 = line1[1],
        x2 = line1[2],
        y2 = line1[3];
    double x3 = line2[0],
        y3 = line2[1],
        x4 = line2[2],
        y4 = line2[3];

    // Calculate the denominator from the two lines
    double denominator = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);

    // Check if the two lines are parallel
    if (denominator == 0.0) return null;

    // Calculate values for UA and UB
    double ua = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3)) / denominator;
    double ub = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3)) / denominator;

    // Check to see if the two lines actually intersect
    if (ua >= 0.0 f && ua <= 1.0 f && ub >= 0.0 f && ub <= 1.0 f)
        // Get the intersection point
        return new double[] {
            x1 + ua * (x2 - x1),
                y1 + ua * (y2 - y1)
        };

    return null;
}
