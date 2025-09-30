public class RandomWalk {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(-n - 0.5, n + 0.5);
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.enableDoubleBuffering();

        int x = 0, y = 0;
        int steps = 0;

/*    while (Math.abs(x) < n && Math.abs(y) < n) {
      StdDraw.setPenColor(StdDraw.WHITE);
      StdDraw.filledSquare(x, y, 0.45);
      double r = Math.random();
      if      (r < 0.25) x--;
      else if (r < 0.50) x++;
      else if (r < 0.75) y--;
      else if (r < 1.00) y++;
      steps++;
      StdDraw.setPenColor(StdDraw.BLUE);
      StdDraw.filledSquare(x, y, 0.45);
      StdDraw.show();
      StdDraw.pause(40);
    }*/

        int stepSize = 1;
        int stepChange = 0;
        int[] dirX = { -1, 0, 1, 0};
        int[] dirY = { 0, -1, 0, 1};
        int idx = 0;
        while (Math.abs(x) < n && Math.abs(y) < n) {
            for (int i = 0; i < stepSize; i++) {
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.filledSquare(x, y, 0.45);
                x = x + dirX[idx];
                y = y + dirY[idx];
                steps++;
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.filledSquare(x, y, 0.45);
                StdDraw.show();
                StdDraw.pause(40);
                if (!(Math.abs(x) < n && Math.abs(y) < n)) {
                    break;
                }
            }
            stepChange++;
            idx = (idx + 1) % 4;
            if (stepChange >= 2) {
                stepChange = 0;
                stepSize++;
            }
        }
        StdOut.println("Total steps = " + steps);
    }
}