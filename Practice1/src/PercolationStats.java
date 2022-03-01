
public class PercolationStats {
    //екземпляр класу протікання
    private Percolation p;
    //кількість експериментів
    private int expCount;
    //кількість відкритих клітинок, при яких система протікає поділена на розмір сітки
    private static double [] thresholds;

    // проведемо T окремих експериментів в N на N матриці
    public PercolationStats(int N, int T){
        if (N <= 0 || T<=0) throw new IllegalArgumentException("N <= 0 || T<=0");
        expCount=T;
        thresholds = new double [expCount];
        for(int x=0;x<expCount;x++){
            p= new Percolation(N);
            while(!p.percolates()){
                int i = ua.princeton.lib.StdRandom.uniform(1, N + 1);
                int j = ua.princeton.lib.StdRandom.uniform(1, N + 1);

                if(!p.isOpened(i,j)){
                    p.open(i,j);
                }
            }
            double threshold = (double)p.getOpenedCount()/(N*N);
            thresholds[x]=threshold;
        }
    }

    // рахує середнє
    public double mean(){
        return ua.princeton.lib.StdStats.mean(thresholds);
    }

    // рахує відхилення
    public double stddev(){
        return ua.princeton.lib.StdStats.stddev(thresholds);
    }



    // запускаємо експерименти і рахуємо відповідні значення середнє, відхилення, інтервал довіри, та виводимо на екран
    public static void main(String[] args){
            int N = 1000;
            int T = 200;
            PercolationStats ps = new PercolationStats(N, T);

        double s = 1.96 * ps.stddev()/ Math.sqrt(T);
        double low = ps.mean() - s;
        double high = ps.mean() + s;

            System.out.println("% java PercolationStats "+N+" "+T);
            ua.princeton.lib.StdOut.println("mean = " + ps.mean());
            ua.princeton.lib.StdOut.println("stddev = " + ps.stddev());
            System.out.println("95% confidence interval = " + low + ", " + high);
        }

}

