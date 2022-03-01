import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tester {

    private static void selectionSort(int nums[][])
    {
        int n = nums.length;

        for (int i = 0; i < n-1; i++)
        {
            int min = i;
            for (int j = i+1; j < n; j++)
                if (nums[j][0] < nums[min][0])
                    min = j;

            int[] num=new int[2];
            num[0] = nums[min][0];
            num[1] = nums[min][1];

            nums[min][0] = nums[i][0];
            nums[min][1] = nums[i][1];

            nums[i][0] = num[0];
            nums[i][1] = num[1];
        }
    }

    private static void insertionSort(int nums[][])
        {
            int n = nums.length;

            for (int i = 1; i < n; i++) {

                int[] num=new int[2];
                num[0] = nums[i][0];
                num[1] = nums[i][1];

                int j = i - 1;

                while (j >= 0 && nums[j][0] > num[0]) {
                    nums[j + 1][0] = nums[j][0];
                    nums[j + 1][1] = nums[j][1];

                    j--;
                }
                nums[j + 1][0] = num[0];
                nums[j + 1][1] = num[1];
            }
        }
    private static void bubbleSort(int nums[][])
    {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (nums[j][0] > nums[j + 1][0]) {

                    int[] num=new int[2];

                    num[0] = nums[j][0];
                    num[1] = nums[j][1];

                    nums[j][0] = nums[j + 1][0];
                    nums[j][1] = nums[j + 1][1];

                    nums[j + 1][0] = num[0];
                    nums[j + 1][1] = num[1];
                }
    }

    private static void shellSort(int nums[][])
    {
        int n = nums.length;

        for (int gap = n/2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < n; i ++)
            {
                int[] num=new int[2];
                num[0]= nums[i][0];
                num[1]= nums[i][1];

                int j;
                for (j = i; j >= gap && nums[j - gap][0] > num[0]; j -= gap) {
                    nums[j][0] = nums[j - gap][0];
                    nums[j][1] = nums[j - gap][1];
                }
                nums[j][0] = num[0];
                nums[j][1] = num[1];
            }
        }
    }

    private static void merge(int nums[][], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[][] = new int[n1][2];
        int R[][] = new int[n2][2];

        for (int i = 0; i < n1; ++i) {
            L[i][0] = nums[l + i][0];
            L[i][1] = nums[l + i][1];
        }
        for (int j = 0; j < n2; ++j) {
            R[j][0] = nums[m + 1 + j][0];
            R[j][1] = nums[m + 1 + j][1];
        }

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i][0] <= R[j][0]) {
                nums[k][0] = L[i][0];
                nums[k][1] = L[i][1];
                i++;
            }
            else {
                nums[k][0] = R[j][0];
                nums[k][1] = R[j][1];
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums[k][0] = L[i][0];
            nums[k][1] = L[i][1];
            i++;
            k++;
        }

        while (j < n2) {
            nums[k][0] = R[j][0];
            nums[k][1] = R[j][1];
            j++;
            k++;
        }
    }

    private static void mergeSort(int nums[][], int l, int r)
    {
        if (l < r) {
            int m =l+ (r-l)/2;

            mergeSort(nums, l, m);
            mergeSort(nums, m + 1, r);

            merge(nums, l, m, r);
        }
    }

    private static void toString(int nums[][])
    {
        for (int i = 0; i < nums.length; ++i)
            System.out.print(nums[i][0] + " "+nums[i][1]+"\n");
    }

    private static void copy(int nums[][],int numsCopy[][]){
        for(int i=0;i<nums.length;i++){
            numsCopy[i][0]=nums[i][0];
            numsCopy[i][1]=nums[i][1];
        }
    }

    public static void main (String[] args) throws FileNotFoundException {
        String file = "File.txt";
        Scanner sc = new Scanner(new File(file));
            int n = sc.nextInt();
        int [] [] test1 = new int [n][2];
            for(int i=0;i<n;i++) {
                int first = sc.nextInt();
                int second = sc.nextInt();
                test1[i][0] = first;
                test1[i][1] = second;
            }

        System.out.println("\nArray:\n");
        toString(test1);

        System.out.println("\nShell sort(unstable):\n");
        int test1shell [] []=new int [n][2];
        copy(test1, test1shell);
        shellSort(test1shell);
        toString(test1shell);

       System.out.println("\nBubble sort(stable):\n");
        int test1bubble [] []=new int [n][2];
        copy(test1, test1bubble);
        bubbleSort(test1bubble);
        toString(test1bubble);

        System.out.println("\nInsertion sort(stable):\n");
        int test1insert [] []=new int [n][2];
        copy(test1, test1insert);
        insertionSort(test1insert);
        toString(test1insert);

        System.out.println("\nSelection sort(unstable):\n");
        int test1select [] []=new int [n][2];
        copy(test1, test1select);
        selectionSort(test1select);
        toString(test1select);

        System.out.println("\nMerge sort(stable):\n");
        int test1merge [] []=new int [n][2];
        copy(test1, test1merge);
        mergeSort(test1merge,0,test1merge.length-1);
        toString(test1merge);
    }

}
