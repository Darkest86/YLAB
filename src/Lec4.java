import java.util.Scanner;

public class Lec4 {
    public static void main(String[] args) throws Exception {
        System.out.println("Exercise 1:");
        ex1();
        System.out.println("Exercise 2:");
        ex2();
        System.out.println("Exercise 3:");
        ex3();
        System.out.println("Exercise 4:");
        ex4();
        System.out.println("Exercise 5:");
        addEx();
    }
    public static Scanner scan = new Scanner(System.in);
    //Paragraph 2
    public static class Cat
    {
        

        //Part 1
        private String name;
        public void setName(String name)
        {
            this.name = name;
        }

        //Part 2
        private static int catsCount = 0;
        public static void addNewCat()
        {
            catsCount++;
        }     

        public Cat()
        {
            addNewCat();
        }

        //Part 3
        public static void setCatsCount(int catsCount)
        {
            Cat.catsCount = catsCount;
        }

        //Part 4
        private String fullName;
        public void setName(String firstName, String lastName)
        {
            String fullName = firstName + ' ' + lastName;
            this.fullName = fullName;
        }
    }   

    public static class btree
    {
        btree left, right, parent;
        Integer number;

        public btree()
        {
            this.left = null;
            this.right = null;
            this.parent = null;
            this.number = null;
        }

        public void fromHighToLow(btree node)
        {
            if (node.right != null)
                fromHighToLow(node.right);
            System.out.print(node.number);
            System.out.print(' ');
            if (node.left != null)
                fromHighToLow(node.left);
            
        }
    }

    //Part 5
    public static void ex1() 
    {
        Cat cat1 = new Cat();
        System.out.println("New cat created. Count = " + Cat.catsCount);
        cat1.setName("Salem");
        System.out.println("Cat1 name is " + cat1.name);
        cat1.setName("Salem", "Saberhage");
        System.out.println("Cat1 full name is " + cat1.fullName);
        Cat cat2 = new Cat();
        System.out.println("New cat created. Count = " + Cat.catsCount);
        Cat.setCatsCount(41);
        System.out.println("Cats count set to " + Cat.catsCount);
        Cat cat3 = new Cat();
        System.out.println("New cat created. Count = " + Cat.catsCount);
        System.out.println();
    }

    //Paragraph 6
    public static void ex2()
    {
        //Part 1
        System.out.println("Part 1:");
        int a[] = new int[2];
        System.out.println("Enter number 1:");
        a[0] = Integer.parseInt(scan.nextLine());
        System.out.println("Enter number 2:");
        a[1] = Integer.parseInt(scan.nextLine());
        if (a[0] >= a[1])
            System.out.println("Number " + a[1] + " the least");
        else
            System.out.println("Number " + a[0] + " the least");
        System.out.println();

        //Part 2
        System.out.println("Part 2:");
        int b[] = new int[4];
        for (int i = 0; i < 4; i++)
        {
            System.out.println("Enter number " + (i + 1) + ':');
            b[i] = Integer.parseInt(scan.nextLine());
        }
        if (b[0] >= b[1])
            if (b[2] >= b[3])
                if (b[0] >= b[2])
                    System.out.println("Number " + b[0] + " is maximal");
                else
                    System.out.println("Number " + b[2] + " is maximal");
            else
                if (b[0] >= b[3])
                    System.out.println("Number " + b[0] + " is maximal");
                else
                    System.out.println("Number " + b[3] + " is maximal");
        else
            if (b[2] >= b[3])
                if (b[1] >= b[2])
                    System.out.println("Number " + b[1] + " is maximal");
                else
                    System.out.println("Number " + b[2] + " is maximal");
            else
                if (b[1] >= b[3])
                    System.out.println("Number " + b[1] + " is maximal");
                else
                    System.out.println("Number " + b[3] + " is maximal");
        System.out.println();
        
        //Part 3
        //Можно сделать и просто массивом с сортировкой
        System.out.println("Part 3:");
        var c = new btree();
        for (int i = 0; i < 3; i++)
        {
            var mover = c;
            System.out.println("Enter number " + (i + 1) + ':');
            if (c.number == null)
                c.number = Integer.parseInt(scan.nextLine());
            else
            {
                var temp = new btree();
                temp.number = Integer.parseInt(scan.nextLine());
                while(true)
                {
                    if (mover.number < temp.number)
                    {
                        if (mover.right == null)
                        {
                            temp.parent = mover;
                            mover.right = temp;
                            break;
                        }
                        else
                            mover = mover.right;
                    }
                    else
                    {
                        if (mover.left == null)
                        {
                            temp.parent = mover;
                            mover.left = temp;
                            break;
                        }
                        else
                            mover = mover.left;
                    }
                }
            }
        }
        c.fromHighToLow(c);
        System.out.println();

        //Part 4
        System.out.println("Part 4:");
        System.out.println("Input name 1:");
        String name1 = scan.nextLine();
        System.out.println("Input name 2:");
        String name2 = scan.nextLine();

        if (name1.equals(name2))
            System.out.println("Имена идентичны");
        else
            if (name1.length() == name2.length())
                System.out.println("Длины имён равны");
        System.out.println();

        //Part 5 && Part 6
        System.out.println(("Parts 5 && 6:"));
        System.out.println("Input name:");
        String name3 = scan.nextLine();
        System.out.println("Input age:");
        int age3 = Integer.parseInt(scan.nextLine());
        if (age3 < 18)
            System.out.println("Подрасти ещё");
        if (age3 > 20)
            System.out.println("И 18-ти достаточно");
        System.out.println();
    }
    
    //Paragraph 10
    public static void ex3()
    {
        //Part 1
        System.out.println("Part 1:");
        int i = 1;
        while (i < 11)
        {
            System.out.println(i);
            i++;
        }
        System.out.println();

        //Part 2
        System.out.println("Part 2:");
        i = 10;
        while (i > 0)
        {
            System.out.println(i);
            i--;
        }
        System.out.println();

        //Part 3
        System.out.println("Part 3:");
        System.out.println("Input string");
        String loopString = scan.nextLine();
        System.out.println("Input number of strings");
        int lSNumber = Integer.parseInt(scan.nextLine());
        i = 0;
        while (i < lSNumber)
        {
            System.out.println(loopString);
            i++;
        }
        System.out.println();

        //Part 4
        System.out.println("Part 4:");
        i = 0;
        while (i < 10)
        {
            int j = 0;
            while (j < 10)
            {
                System.out.print('S');
                j++;
            }
            System.out.println();
            i++;
        }
        System.out.println();

        //Part 5
        System.out.println("Part 5:");
        i = 1;
        while (i < 11)
        {
            int j = 1;
            while (j < 11)
            {
                System.out.print(i*j);
                System.out.print(' ');
                j++;
            }
            System.out.println();
            i++;
        }
        System.out.println();
    }

    //Paragraph 13
    public static void ex4()
    {
        //Part 1
        System.out.println("Part 1:");
        for (int i = 2; i < 101; i+=2)
            System.out.println(i);
        System.out.println();
        
        //Part 2
        System.out.println("Part 2:");
        System.out.println("Input N:");
        int n = Integer.parseInt(scan.nextLine());
        System.out.println("Input M:");
        int m = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
                System.out.print('8');
            System.out.println();
        }
        System.out.println();


        //Part 3
        System.out.println("Part 3:");
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j <= i; j++)
                System.out.print('8');
            System.out.println();
        }
        System.out.println();

        //Part 4
        System.out.println("Part 4:");
        for (int i = 0; i < 10; i++)
            System.out.print('8');
        System.out.println();
        System.out.println();
        for (int j = 0; j <= 10; j++)
            System.out.println('8');
        System.out.println();

        //Part 5
        System.out.println("Part 5:");
        System.out.println("Enter name:");
        String name = scan.nextLine();
        for (int i = 0; i < 10; i++)
            System.out.println(name + " любит меня.");
        System.out.println();
    }

    //Paragraph 16
    public static void addEx() 
    {
        //Part 1
        System.out.println("Part 1:");
        for (int i = 0; i < 100; i++)
            System.out.println("Я никогда не буду работать за копейки. Амиго");
        System.out.println();

        //Part 2
        System.out.println("Part 2:");
        int a[] = new int[3];
        int minIndex = 0, maxIndex = 0;
        for (int i = 0; i < 3; i++)
        {
            System.out.println("Input number " + (i + 1));
            a[i] = Integer.parseInt(scan.nextLine());
            if (a[i] > a[maxIndex])
                maxIndex = i;
            if (a[i] < a[minIndex])
                minIndex = i;
        }
        for (int i = 0; i < 3; i++)
            if (i != maxIndex && i != minIndex)
                System.out.println("Medium number is " + a[i]);
        System.out.println();

        //Part 3
        System.out.println("Part 3:");
        long sum = 0;
        int temp = 0;
        System.out.println("Input numbers for sum until -1");
        do
        {
            temp = Integer.parseInt(scan.nextLine());
            sum+= temp;
        } while (temp != -1);
        System.out.println("Summary is " + sum);
        System.out.println();

        //Part 4
        System.out.println("Part 4:");
        System.out.println("Input name:");
        String name = scan.nextLine();
        System.out.println("Input year of birth:");
        int y = Integer.parseInt(scan.nextLine());
        System.out.println("Input month of birth:");
        int m = Integer.parseInt(scan.nextLine());
        System.out.println("Input day of birth:");
        int d = Integer.parseInt(scan.nextLine());
        System.out.println("Меня зовут " + name);
        System.out.println("Я родился " + d + "." + m + "." + y);
        System.out.println();
    }
}