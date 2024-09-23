public class Pair
{
    private final int column;
    private final int row;

    public Pair(int row, int col)
    {
        this.column = col;
        this.row = row;
    }

    public int getRow()
    {
        return row;
    }

    public int getColumn()
    {
        return column;
    }
}
