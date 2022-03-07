import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Lec5 {
    public static void main(String[] args) throws Exception {
        System.out.println("Exercise 1:");
        ex1();
        System.out.println("Additional Exercise 1:");
        addEx1();
    }

    // Part 1
    public static class Cat
    { 
        int age, weight, strength;
        String name;
        
        //Part 2
        boolean fight(Cat enemy)
        {
            double k1, k2;
            if (this.age >= 9)
                k1 = Math.log(4d * (-Math.E/5) + Math.E + 1d);
            else
                k1 = Math.log((double)Math.abs(5 - this.age) * (-Math.E/5) + Math.E + 1d);
            if (enemy.age >= 9)
                k2 = Math.log(4d * (-Math.E/5) + Math.E + 1d);
            else
                k2 = Math.log((double)Math.abs(5 - enemy.age) * (-Math.E/5) + Math.E + 1d);
            
            double result = k1 * this.strength * 0.8d / Math.log10(Math.abs(5 - this.weight) + 10) - k2 * enemy.strength * 0.8d / Math.log10(Math.abs(5 - enemy.weight) + 10);
            
            if  (result >= 0)
                return true;
            else
                return false;
        }
    }

    //Part 3
    public class Dog
    {
        String name;
        int age;

        public void setName(String name)
        {
            this.name = name;
        }

        public void setAge(int age)
        {
            this.age = age;
        }

        public String getName()
        {
            return this.name;
        }

        public int getAge()
        {
            return this.age;
        }
    }

    public static void ex1()
    {
        //Part 4
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();

        cat1.name = "Rokki";
        cat1.age = 3;
        cat1.weight = 6;
        cat1.strength = 16;

        cat2.name = "Shiba";
        cat2.age = 5;
        cat2.weight = 7;
        cat2.strength = 12;

        cat3.name = "Kitty";
        cat3.age = 1;
        cat3.weight = 1;
        cat3.strength = 8;

        //Part 5
        System.out.println("Part 5:");
        if (cat1.fight(cat2))
            System.out.println(cat1.name + " won " + cat2.name);
        else
            System.out.println(cat1.name + " lose " + cat2.name);

        if (cat2.fight(cat3))
            System.out.println(cat2.name + " won " + cat3.name);
        else
            System.out.println(cat2.name + " lose " + cat3.name);
        
        if (cat3.fight(cat1))
            System.out.println(cat3.name + " won " + cat1.name);
        else
            System.out.println(cat3.name + " lose " + cat1.name);
        System.out.println();
    }

    //Exercise 2
    //Part 1
    public class Friend
    {
        String name;
        int age;
        char sex;

        public void initialize(String name)
        {
            this.name = name;
            this.age = 18;
            this.sex = 'w';
        }

        public void initialize(String name, int age)
        {
            this.name = name;
            this.age = age;
            this.sex = 'w';
        }

        public void initialize(String name, int age, char sex)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
    }

    //Part 2
    public class nonFightCat
    {
        String name, home, color;
        int age, weight;

        public void initialize(String name)
        {
            this.name = name;
            this.age = 3;
            this.weight = 2;
            this.color = "brown";
            this.home = "";
        }

        public void initialize(String name, int weight, int age)
        {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.color = "brown";
            this.home = "";
        }

        public void initialize(String name, int age)
        {
            this.name = name;
            this.age = age;
            this.weight = 2;
            this.color = "brown";
            this.home = "";
        }

        public void initialize(int weight, String color)
        {
            this.age = 3;
            this.weight = weight;
            this.color = color;
            this.home = "";
            this.name = "";
        }

        public void initialize(int weight, String color, String home)
        {
            this.age = 3;
            this.weight = weight;
            this.color = color;
            this.home = home;
            this.name = "";
        }
    }

    //Part 3
    public class iniDog
    {
        String name, color;
        int height;

        public void initialize(String name)
        {
            this.name = name;
            this.color = "brown";
            this.height = 50;
        }

        public void initialize(String name, int height)
        {
            this.name = name;
            this.height = height;
            this.color = "brown";
        }

        public void initialize(String name, int height, String color)
        {
            this.name = name;
            this.height = height;
            this.color = color;
        }
    }

    //Part 4
    public class Circle
    {
        float centerX, centerY, radius, width;
        String color;

        public void initialize(float x, float y, float r)
        {
            this.centerX = x;
            this.centerY = y;
            this.radius = r;
            this.color = "black";
            this.width = 1f;
        }

        public void initialize(float x, float y, float r, float w)
        {
            this.centerX = x;
            this.centerY = y;
            this.radius = r;
            this.color = "black";
            this.width = w;
        }

        public void initialize(float x, float y, float r, float w, String color)
        {
            this.centerX = x;
            this.centerY = y;
            this.radius = r;
            this.color = color;
            this.width = w;
        }
    }

    //Part 5
    public class Rectangle
    {
        int left, top;
        float height, width;

        public void initialize(int x, int y, float h, float w)
        {
            this.left = x;
            this.top = y;
            this.height = h;
            this.width = w;
        }

        public void initialize(int x, int y, float side)
        {
            this.left = x;
            this.top = y;
            this.height = side;
            this.width = side;
        }

        public void initialize(int x, int y)
        {
            this.left = x;
            this.top = y;
            this.height = 0;
            this.width = 0;
        }

        public void initialize(Rectangle cpy)
        {
            this.left = cpy.left;
            this.top = cpy.top;
            this.height = cpy.height;
            this.width = cpy.width;
        }

        public void initialize(float h, float w)
        {
            this.left = 0;
            this.top = 0;
            this.height = h;
            this.width = w;
        }

        public void initialize(float side)
        {
            this.left = 0;
            this.top = 0;
            this.height = side;
            this.width = side;
        }

        public void initialize(int xy, float h, float w)
        {
            this.left = xy;
            this.top = xy;
            this.height = h;
            this.width = w;
        }

        public void initialize(int xy, float side)
        {
            this.left = xy;
            this.top = xy;
            this.height = side;
            this.width = side;
        }

        public void initialize(int xy)
        {
            this.left = xy;
            this.top = xy;
            this.height = 0;
            this.width = 0;
        }

        public void initialize()
        {
            this.left = 0;
            this.top = 0;
            this.height = 0;
            this.width = 0;
        }
    }

    //Paragraph 12
    //Additional Exercise
    //Part 1
    //Класса Duck не существовало
    public static class addCat
    {
        String name, home, ownerName, ownerPhone;
        int age, weight;

        public addCat(String name, String home, String ownerName, String ownerPhone, int age, int weight)
        {
            this.name = name;
            this.home = home;
            this.ownerName = ownerName;
            this.ownerPhone = ownerPhone;
            this.age = age;
            this.weight = weight;
        }

        @Override
        public String toString() 
        {
            return "I'm a cat, my name is " + name +
                ", my owner name is " + ownerName +
                ". I'm living in home in " + home +
                " and my age is " + age + ".";
        }

    }

    public static class addDog
    {
        String name, home, ownerName, ownerPhone;
        int age, weight, height;

        public addDog(String name, String home, String ownerName, String ownerPhone, int age, int weight, int height)
        {
            this.name = name;
            this.home = home;
            this.ownerName = ownerName;
            this.ownerPhone = ownerPhone;
            this.age = age;
            this.weight = weight;
            this.height = height;
        }

        @Override
        public String toString() 
        {
            return "I'm a dog, my name is " + name +
                ", my owner name is " + ownerName +
                ". I'm living in home in " + home +
                " and my age is " + age + "." + 
                " When I'm lost please call the number " + ownerPhone;
        }
    }

    //Part 2
    public static class Man
    {
        String name, adress;
        int age;

        public Man(String name, String adress, int age)
        {
            this.adress = adress;
            this.age = age;
            this.name = name;
        }
    }

    public static class Woman
    {
        String name, adress;
        int age;

        public Woman(String name, String adress, int age)
        {
            this.adress = adress;
            this.age = age;
            this.name = name;
        }
    }

    //Part 3
    public static class Mouse
    {
        String name;
        int height, tailLength;

        public Mouse(int height, int tailLength, String name)
        {
            this.height = height;
            this.name = name;
            this.tailLength = tailLength;
        }
    }

    public static class CatMult
    {
        String name, color;
        int height;

        public CatMult(int height, String name, String color)
        {
            this.height = height;
            this.name = name;
            this.color = color;
        }
    }

    public static void addEx1()
    {
        addCat cat1 = new addCat("Tim", "Moscow", "Helen", "+7xxxxxxxxxx", 5, 3);
        addCat cat2 = new addCat("Meow", "Novosibirsk", "Alex", "+7xxxxxxxxxx", 1, 1);
        addDog dog1 = new addDog("Piggy", "New York City", "Brandon", "+16460BRANDON", 2, 6, 50);
        addDog dog2 = new addDog("Hulk", "Siberia", "Andrew", "+7xxxxxxxxxx", 5, 15, 85);
        System.out.println("Part 1:");
        System.out.println("Cat 1:");
        System.out.println(cat1.toString());
        System.out.println("Cat 2:");
        System.out.println(cat2.toString());
        System.out.println("Dog 1:");
        System.out.println(dog1.toString());
        System.out.println("Dog 2:");
        System.out.println(dog2.toString());
        System.out.println();

        Man man1 = new Man("Alex", "NYC", 25);
        Man man2 = new Man("Anton", "Moscow", 18);
        Woman woman1 = new Woman("Helen", "Moscow", 23);
        Woman woman2 = new Woman("Emily", "Washington", 32);
        System.out.println("Part 2:");
        System.out.println(man1.name + " " + man1.age + " " + man1.adress);
        System.out.println(man2.name + " " + man2.age + " " + man2.adress);
        System.out.println(woman1.name + " " + woman1.age + " " + woman1.adress);
        System.out.println(woman2.name + " " + woman2.age + " " + woman2.adress);
        System.out.println();

        Mouse jerryMouse = new Mouse(12, 5, "Jerry");
        CatMult tomCat = new CatMult(100, "Tom", "Blue");

        System.out.println("Part 4:");
        Date now = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd MM yyyy");
        System.out.println(formatForDateNow.format(now));
        System.out.println();

        int sum = 0;
        System.out.println("Part 5 (enter numbers to sum):");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        while (!str.equals("сумма"))
        {
            sum += Integer.parseInt(str);
            str = scan.nextLine();
        }
        System.out.println(sum);
        System.out.println();

        //Part 6
        int a, b;
        System.out.println("Part 1 (sum of 2):");
        System.out.println("Enter number 1:");
        a = Integer.parseInt(scan.nextLine());
        System.out.println("Enter number 2:");
        b = Integer.parseInt(scan.nextLine());
        System.out.println("Summary is " + (a + b));
        System.out.println();

        //Part 7
        int c[] = new int[5];
        int min = Integer.MAX_VALUE;
        System.out.println("Part 2 (min of 5):");
        for (int i = 0; i < 5; i++)
        {
            System.out.println("Enter number " + (i + 1) + ":");
            c[i] = Integer.parseInt(scan.nextLine());
            if (i == 0)
                min = c[i];
            else
                if (c[i] < min)
                    min = c[i];
        }
        System.out.println("Minimal is " + min);
        System.out.println();

        //Part 8
        int n;
        System.out.println("Part 3 (max of n):");
        System.out.println("Input N:");
        n = Integer.parseInt(scan.nextLine());
        int[] d = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
        {
            System.out.println("Enter number " + (i + 1) + ":");
            d[i] = Integer.parseInt(scan.nextLine());
            if (i == 0)
                max = d[i];
            else
                if (d[i] > max)
                    max = d[i];
        }
        System.out.println("Maximal is " + max);
        System.out.println();
    }
}
