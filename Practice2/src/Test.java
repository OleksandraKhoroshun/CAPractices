import coursera.Timing;

public class Test {
    public static void main(String[] args){
        for(int N=1000; N<=128000; N*=2) {
            ua.princeton.lib.Stopwatch stopwatch = new ua.princeton.lib.Stopwatch();
            Timing.trial(N, 777280);
            double time = stopwatch.elapsedTime();
            System.out.println(time);
        }
    }
}
