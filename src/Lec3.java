import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Lec3 {
    public static void main(String[] args) throws Exception {
        System.out.println("Exercise 1:");     
        ex1();
        System.out.println("Exercise 2:");     
        ex2();
        System.out.println("Exercise 3:");     
        ex3();
    }

    public static class gameUnit
    {
        int maxHp, cost;
        float def, speed, atk;
    }

    public static class Zerg extends gameUnit
    {
        ArrayList<String> abilities;
    }

    public static class Protoss extends gameUnit
    {
        int techLvl;
    }

    public static class Terran extends gameUnit
    {
        float atkRange;
    }

    //Paragraph 4
    public static void ex1()
    {
        //Part 1
        System.out.println("Part 1:");
        System.out.println("OCTOBER 24 1994");
        System.out.println();
        
        //Part 2
        //Снова нет примера в условии
        int a = 8;
        int b = 5;
        int c = 10;
        System.out.println("Part 2:");
        System.out.println((b + a * c) * c);
        System.out.println();

        //Part 3 Уникальные имена переменных или всё таки имя в класс и менять его?
        Zerg viper = new Zerg();
        Zerg corruptor = new Zerg();
        Zerg roach = new Zerg();
        Zerg broodLord = new Zerg();
        Zerg ravager = new Zerg();
        Zerg infestor = new Zerg();
        Zerg mutalisk = new Zerg();
        Zerg hydralisk = new Zerg();
        Zerg larva = new Zerg();
        Zerg locust = new Zerg();

        Protoss adept = new Protoss();
        Protoss oracle = new Protoss();
        Protoss sentry = new Protoss();
        Protoss stalker = new Protoss();
        Protoss colossus = new Protoss();

        Terran thor = new Terran();
        Terran viking = new Terran();
        Terran marauder = new Terran();
        Terran ghost = new Terran();
        Terran liberator = new Terran();
        Terran marine = new Terran();
        Terran reaper = new Terran();
        Terran raven = new Terran();
        Terran hellbat = new Terran();
        Terran hellion = new Terran();
        Terran cyclone = new Terran();
        Terran battlecruiser = new Terran();

        //Part 4
        long mult = 1;
        for (int i = 2; i < 11; i++)
            mult *= i;
        System.out.println("Part 4:");
        System.out.println(mult);
        System.out.println();

        //Part 5
        long sum = 0;
        System.out.println("Part 4:");
        for (int i = 1; i < 11; i++)
        {
            sum += i;
            System.out.println(sum);
        }
        System.out.println();
    }

    //Paragraph 6
    public static void ex2()
    {
        //Part 1
        String[] s = new String[3];
        s[0] = "Мама";
        s[1] = "Мыла";
        s[2] = "Раму";
        System.out.println("Part 1:");
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (j != i)
                {
                    for (int k = 0; k < 3; k++)
                    {
                        if (k != j && k != i)
                        {
                            System.out.println(s[i]+s[j]+s[k]);
                            break;
                        }
                    }
                }
            }
        }
        System.out.println();

        //Part 2
        System.out.println("Part 2:");
        for (int i = 1; i < 11; i++)
        {
            for (int j = 1; j < 11; j++)
            {
                System.out.print(i*j);
                System.out.print('\t');
            }
            System.out.println();
        }
        System.out.println();

        //Part 3
        class colorOnTheRainbow
        {
            String color;
            colorOnTheRainbow(String s)
            {
                color = s;
                System.out.print(color);
            }            
        }
        System.out.println("Part 3:");
        colorOnTheRainbow red = new colorOnTheRainbow("R");
        colorOnTheRainbow orange = new colorOnTheRainbow("O");
        colorOnTheRainbow yellow = new colorOnTheRainbow("Y");
        colorOnTheRainbow green = new colorOnTheRainbow("G");
        colorOnTheRainbow blue = new colorOnTheRainbow("B");
        colorOnTheRainbow indigo = new colorOnTheRainbow("I");
        colorOnTheRainbow violet = new colorOnTheRainbow("V");
        System.out.println();
        System.out.println();

        //Part 4
        System.out.println("Part 4:");
        System.out.println("It\'s Windows path: \"C:\\Program Files\\Java\\jdk1.7.0\\bin\"");
        System.out.println("It\'s Java string: \\\"C:\\\\Program Files\\\\Java\\\\jdk1.7.0\\\\bin\\\"");
        System.out.println();

        //Part 5
        System.out.println("Part 5:");
        String jap = "日本語"; 
        System.out.println(jap);
        System.out.println();
    }

    //Paragraph 8
    public static void ex3()
    {
        //Part 1
        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println("Part 1:");
        {
            System.out.println("Input name:");
            String name = scanner.nextLine();
            System.out.println("Input years:");
            int years = Integer.parseInt(scanner.nextLine());
            System.out.println(name + " захватит мир через " + years + " лет. Му-ха-ха!");
        }
        System.out.println();
        
        //Part 2
        System.out.println("Part 2:");
        {
            System.out.println("Input name:");
            String name = scanner.nextLine();
            System.out.println("Input number 1:");
            int num1 = Integer.parseInt(scanner.nextLine());
            System.out.println("Input number 2:");
            int num2 = Integer.parseInt(scanner.nextLine());
            System.out.println(name + " получает " + num1 + " через " + num2 + " лет.");
        }
        System.out.println();

        //Part 3
        System.out.println("Part 3:");
        {
            System.out.println("Input name:");
            String name = scanner.nextLine();
            System.out.println(name + " зарабатывает $5,000. Ха-ха-ха!");
        }
        System.out.println();

        //Part 4
        System.out.println("Part 3:");
        {
            System.out.println("Input name 1:");
            String name1 = scanner.nextLine();
            System.out.println("Input name 2:");
            String name2 = scanner.nextLine();
            System.out.println(name1 + " проспонсировал " + name2 + ", и она стала известной певицей.");
        }
        System.out.println();

        //Part 5
        System.out.println("Part 3:");
        {
            System.out.println("Input name 1:");
            String name1 = scanner.nextLine();
            System.out.println("Input name 2:");
            String name2 = scanner.nextLine();
            System.out.println("Input name 3:");
            String name3 = scanner.nextLine();
            System.out.println(name1 + " + " + name2 + " + " + name3 + " = Чистая любовь, да-да!");
        }
        scanner.close();
        System.out.println();
    }
}
