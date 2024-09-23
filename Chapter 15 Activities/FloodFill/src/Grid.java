import java.util.Stack;

public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
    private Stack<Pair> squares = new Stack<>();

    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
        int count = 0;
        squares.push(new Pair(row, column));
        while (!(squares.isEmpty()))
        {
            Pair curr = squares.pop();
            int r = curr.getRow();
            int c = curr.getColumn();
            if (pixels[r][c] == 0)
            {
                count++;
                pixels[r][c] = count;
            }
            if (r - 1 >= 0)
                if (pixels[r - 1][c] == 0)
                    squares.push(new Pair(r - 1, c));
            if (c + 1 < SIZE)
                if (pixels[r][c + 1] == 0)

                    squares.push(new Pair(r, c + 1));
            if (r + 1 < SIZE)
                if (pixels[r + 1][c] == 0)
                    squares.push(new Pair(r + 1, c));
            if (c - 1 >= 0)
                if (pixels[r][c - 1] == 0)
                    squares.push(new Pair(r, c - 1));
        }
        for (int[] y : pixels)
        {
            for (Integer x : y)
                System.out.print(x + " ");
            System.out.println();
        }
    }

    @Override
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
