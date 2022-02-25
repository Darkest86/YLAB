public class Lec2 {
    
    public static class Person
    {
        String name;
        int age;
    }

    public static class Woman extends Person
    {
        String secondName;
    }

    public class Rectangle
    {
        int x, y, width, height;
    }

    public static class Cat
    {
        Person owner;
        Rectangle territory;
        int age;
        String name;
    }
    
    public static class Dog extends Cat
    {
        String ownerPhoneNumber;
    }

    public static class Fish extends Cat
    {
        float aquaVolume;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Exercise 1:");
        ex1();
        System.out.println();
        System.out.println("Exercise 2:");
        ex2();
        System.out.println();
        System.out.println("Exercise 3:");
        ex3();
    }

    //Paragraph 3
    public static void ex1()
    {
        //Part 1
        Cat myCat = new Cat();
        Cat notMyCat = new Cat();

        //Part 2
        Dog dog1 = new Dog();
        dog1.name = "Max";
        Dog dog2 = new Dog();
        dog2.name = "Bella";
        Dog dog3 = new Dog();
        dog3.name = "Jack";
        
        //Part 3
        System.out.println("Мне так плохо! Хочу, чтобы все умерли!");
    }
    
    //Paragraph 5
    //Тоже нет информации какие строки вообще есть, чтобы после комментирования на экран вывелось число 19
    public static void ex2()
    {
        //Part 1
        //Условно закомментированая строка1
        /* 
        Условно
        Закомментированные
        Строки
        */
        System.out.println(19);

        //Part 2
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Cat cat4 = new Cat();
        Cat cat5 = new Cat();
        Cat cat6 = new Cat();
        Cat cat7 = new Cat();
        Cat cat8 = new Cat();
        Cat cat9;
        Cat cat10;

        //Part 3
        Cat wCat = new Cat();
        Dog wDog = new Dog();
        Fish wFish = new Fish();
        Woman she = new Woman();

        wCat.owner = she;
        wDog.owner = she;
        wFish.owner = she;
        
    }

    //Paragraph 8
    public static void ex3()
    {
        int[] a = {2, 7, -1, -6};
        System.out.println("4 numbers is:");
        for (int i = 0; i < 4; i++)
        {
            System.out.print(a[i]);
            System.out.print(' ');
        }

        System.out.print('\n' + "Min from first 2 is - " + fMin(a[0], a[1]) + '\n');
        System.out.print("Min from first 3 is - " + fMin(a[0], a[1], a[2]) + '\n');
        System.out.print("Min from all is - " + fMin(a[0], a[1], a[2], a[3]) + '\n');
        
        String testString = "Test string for multiplication";
        System.out.println("3 lines:");
        tripleStringOut(testString);
        System.out.println("1 line:");
        tripleStringOutInLine(testString);
    }

    //Min2
    public static int fMin(int a, int b)
    {
        if (a > b)
            return b;
        else
            return a;
    }

    //Max2
    public static int fMax(int a, int b)
    {
        if (a > b)
            return b;
        else
            return a;
    }

    //Min3
    public static int fMin(int a, int b, int c)
    {
        if (a > b)
            if (b > c)
                return c;
            else
                return b;
        else
            if (a > c)
                return c;
            else
                return a;
    }

    //Min4
    public static int fMin(int a, int b, int c, int d)
    {
        return fMin(fMin(a, b), fMin(c, d));
    }

    //3 Lines text
    public static void tripleStringOut(String s)
    {
        System.out.println(s);
        System.out.println(s);
        System.out.println(s);
    }

    //3 Copy in 1 line
    public static void tripleStringOutInLine(String s)
    {
        System.out.println(s + ' ' + s + ' ' + s);
    }
}
