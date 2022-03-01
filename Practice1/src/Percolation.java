public class Percolation {
    // створюємо матрицю N-на-N, з усіма заблокованими об’єктами
    public Percolation(int N){
        grid = new boolean [N][N];
        bottom = N*N+1;
        length=N;
        uf = new WeightedQuickUnionUF(N*N+2);
    }
    //рахуємо і повертаємо кількість відкритих комірок
    public int getOpenedCount(){ return openedCount; }
    // відкрити об’єкт (row i, column j) якщо він ще не відкритий
    public void open(int i, int j){
        if (!isOpened(i, j)) {
            openedCount++;
            grid[i-1][j-1 ] = true;

            if (i == 1) uf.union(index(i, j), top);

            if (i == length) uf.union(index(i, j), bottom);


            if (i > 1 && isOpened(i - 1, j)) uf.union(index(i, j), index(i - 1, j));

            if (i < length && isOpened(i + 1, j)) uf.union(index(i, j), index(i + 1, j));

            if (j > 1 && isOpened(i, j - 1)) uf.union(index(i, j), index(i, j - 1));

            if (j < length && isOpened(i, j + 1)) uf.union(index(i, j), index(i, j + 1));
        }
    }
    // чи відкитий об’єкт (row i, column j)?
    public boolean isOpened(int i, int j){ return grid[i-1][j-1];}
    // чи протікає система?
    public boolean percolates(){
        return uf.connected(top,bottom);
    }
    //конвертує значення з двовимірного масиву в значення одновимірного
    public int index(int i,int j){ return length*(i-1)+j; }

    private WeightedQuickUnionUF uf;
    //масив, який репрезентує сітку N на N
    private boolean[][] grid;
    //верхній вузел
    private int top = 0;
    //нижній вузел
    private int bottom;
    //довжина сітки N
    private int length;
    //кількість відкритих клітинок
    private int openedCount = 0;
}

