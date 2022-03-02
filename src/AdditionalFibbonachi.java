import java.util.ArrayList;
import java.util.Scanner;

public class AdditionalFibbonachi
{
    public static long fiboR(int n)
    {
        if (n <= 1)
            return n;
        return fiboR(n - 1) + fiboR(n - 2);
    }

    public static long fiboARF(int n)
    {
        long[] array = new long[n + 2];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < n; i++)
            array[i] = array[i - 1] + array[i - 2];
        return array[n-1];
    }

    public static long fiboARLM(int n)
    {
        long[] array = new long[2];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < n; i++)
            array[i % 2] += array[(i - 1) % 2];
        return array[(n - 1) % 2];
    }

    public static long fiboSave(int n)
    {
        if (n <= savedFib.size())
            return savedFib.get(n-1);
        else
        {
            while (savedFib.size() < n)
                savedFib.add(savedFib.get(savedFib.size() - 2) + savedFib.get(savedFib.size() - 1));
            return savedFib.get(n-1);
        }
    }

    static ArrayList<Long> savedFib = new ArrayList<Long>();
    
    public static void menu()
    {
        System.out.println("Choose Fibbonachi method:");
        System.out.println("1. Reccurent");
        System.out.println("2. Array of N elements");
        System.out.println("3. Array of 2 elements");
        System.out.println("4. External array for cashe");
        System.out.println("5. Exit");
    }

    public static void main(String[] args) throws Exception {
        savedFib.add((long) 0);
        savedFib.add((long) 1);
        menu();
        Scanner scan = new Scanner(System.in);
        int x  = Integer.parseInt(scan.nextLine());
        //long start1, end1;
        
        while (x !=5)
        {
            System.out.println("Input Fibbonachi number:");
            int z  = Integer.parseInt(scan.nextLine());
            switch (x)
            {
                case 1:
                    System.out.println("Reccurent:");
                    //start1 = System.nanoTime();
                    System.out.println(fiboR(z - 1));
                    //end1 = System.nanoTime();
                    //System.out.println("Time in nano:");
                    //System.out.println(end1-start1);
                    System.out.println();
                    menu();
                    x  = Integer.parseInt(scan.nextLine());
                    break;
                case 2:
                    System.out.println("Array for every element:");
                    //start1 = System.nanoTime();
                    System.out.println(fiboARF(z));
                    //end1 = System.nanoTime();
                    //System.out.println("Time in nano:");
                    //System.out.println(end1-start1);
                    System.out.println();
                    menu();
                    x  = Integer.parseInt(scan.nextLine());
                    break;
                case 3:
                    System.out.println("Array 2 elements only:");
                    //start1 = System.nanoTime();
                    System.out.println(fiboARLM(z));
                    //end1 = System.nanoTime();
                    //System.out.println("Time in nano:");
                    //System.out.println(end1-start1);
                    System.out.println();
                    menu();
                    x  = Integer.parseInt(scan.nextLine());
                    break;
                case 4:
                    System.out.println("Saved in external array");
                    //start1 = System.nanoTime();
                    System.out.println(fiboSave(z));
                    //end1 = System.nanoTime();
                    //System.out.println("Time in nano:");
                    //System.out.println(end1-start1);
                    System.out.println();
                    menu();
                    x  = Integer.parseInt(scan.nextLine());
                break;
            }
        }
        scan.close();
    }
}