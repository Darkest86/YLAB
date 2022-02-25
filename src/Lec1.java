public class Lec1 {
    public static void main(String[] args) throws Exception {
        
        System.out.println("Exercise 1:");     
        ex1();
        System.out.println();
        System.out.println("Exercise 2:");
        ex2();
        System.out.println("Exercise 3:");
        ex3();
        System.out.println();
        System.out.println("Exercise 4:");
        ex4();
    }

    //Paragraph 4
    public static void ex1()
    {
        //Part 1
        String name1 = "TestName";
        String name2 = "Subject0";
        String name3 = "Diego";
        System.out.println("Part 1:");
        System.out.println("Name 1 is " + name1);
        System.out.println("Name 2 is " + name2);
        System.out.println("Name 3 is " + name3);
        System.out.println();

        //Part 2
        System.out.println("Part 2:");
        for (int i = 0; i < 10; i++)
            System.out.println("Когда я вырасту, то хочу быть паровым экскаватором!");
        System.out.println();
        
        //Part 3
        System.out.println("Part 3:");
        //System.out.println("Happy New Year");
        System.out.println("Happy New Year"); /*Uncommented*/
    }

    //Paragraph 5
    public static void ex2()
    {
        int s = 0, t = 0, x = 0;
        s = 5;
        t = 6;
        x = 7;
        System.out.println("s = " + s);
        System.out.println("t = " + t);
        System.out.println("x = " + x);
        System.out.println();
    }

    //Paragraph 6
    public static void ex3()
    {
        //Part 1
        System.out.println("Part 1:");
        System.out.println("Меня зовут Амиго.");
        System.out.println();
        System.out.println("Я согласен на зарплату $10/месяц в первый год.");
        System.out.println("Я согласен на зарплату $20/месяц во второй год.");
        System.out.println("Я согласен на зарплату $30/месяц в третий год.");
        System.out.println("Я согласен на зарплату $40/месяц в четвертый год.");
        System.out.println("Я согласен на зарплату $50/месяц в пятый год.");
        System.out.println();
        System.out.println("Спасибо за щедрость, друг Риша!");
        System.out.println();
        //Part 2 (edited text)
        System.out.println("Part 2:");
        System.out.println("Меня зовут Амиго.");
        System.out.println();
        System.out.println("Я согласен на зарплату $800/месяц в первый год.");
        System.out.println("Я согласен на зарплату $1500/месяц во второй год.");
        System.out.println("Я согласен на зарплату $2200/месяц в третий год.");
        System.out.println("Я согласен на зарплату $2700/месяц в четвертый год.");
        System.out.println("Я согласен на зарплату $3200/месяц в пятый год.");
        System.out.println();
        System.out.println("Поцелуй мой блестящий металлический зад!");
    }

    //Paragraph 8
    //Нет примера для первых двух условий задания, поэтому напишу по своему видению
    public static void ex4()
    {
        String s1 = "Nothing ";
        //String s2 = "is";     commented unused
        String s3 = "just ";
        //String s4 = "only";   commented unused
        //String s5 = "trust";  commented unused
        String s6 = "personal";
        String s7 = "business.";
        String s8 = ", ";       //Условно добавленная недостающая переменная
        String s9 = "it's ";    //Условно добавленная недостающая переменная
        
        System.out.println("Part 1:");
        System.out.println(s1 + s6 + s8 + s9 + s3 + s7);
        System.out.println();
        System.out.println("Part 3:");
        for (int i = 0; i < 16; i++)
            System.out.println("Слава Роботам! Убить всех человеков!");
    }
}
