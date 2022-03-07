import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class AdditionalXO {
    
    public static Scanner scan = new Scanner(System.in);
    
    public static void outMap(int[][] m)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                System.out.print("| ");
                switch (m[i][j])
                {
                    case -1:
                    System.out.print("O ");
                    break;
                    case 1:
                    System.out.print("X ");
                    break;
                    case 0:
                    System.out.print("- ");
                    break;
                }
            }
            System.out.println("|");
        }
    }

    public static boolean checkNoWin(int[][] m, String p1, String p2)
    {
        int h1 = 0, h2 = 0, h3 = 0, v1 = 0, v2 = 0, v3 = 0, d1 = 0, d2 = 0;
        for (int i = 0; i < 3; i++)
        {
            h1 += m[0][i];
            h2 += m[1][i];
            h3 += m[2][i];
            v1 += m[i][0];
            v2 += m[i][1];
            v3 += m[i][2];
            d1 += m[i][i];
            d2 += m[2 - i][i];
        }
        if (h1 == 3 || h2 == 3 || h3 == 3 || v1 == 3 || v2 == 3 || v3 == 3 || d1 == 3 || d2 == 3)
        {
            File f = new File("GameHisroty.txt");
            if (!f.exists())
                try
                {
                    f.createNewFile();
                }
                catch(IOException ex)
                {
                    System.out.println(ex.getMessage());
                }
            try 
            {
                FileWriter wr = new FileWriter(f, true);
                Date now = new Date();
                wr.write(now.toString() + " " + p1 + " won " + p2+ '\n');
                wr.close();
            }
            catch(IOException ex)
            {
                System.out.println(ex.getMessage());
            }
            System.out.println(p1 + " won!");
            return false;
        }
        if (h1 == -3 || h2 == -3 || h3 == -3 || v1 == -3 || v2 == -3 || v3 == -3 || d1 == -3 || d2 == -3)
        {
            File f = new File("GameHisroty.txt");
            if (!f.exists())
                try
                {
                    f.createNewFile();
                }
                catch(IOException ex)
                {
                    System.out.println(ex.getMessage());
                }
            try 
            {
                FileWriter wr = new FileWriter(f, true);
                Date now = new Date();
                wr.write(now.toString() + " " + p2 + " won " + p1+ '\n');
                wr.close();
            }
            catch(IOException ex)
            {
                System.out.println(ex.getMessage());
            }
            System.out.println(p2 + " won!");
            return false;
        }
        return true;
    }

    public static void startGame()
    {
        String name1, name2;
        int turns = 9;
        int[][] map = {{0,0,0},{0,0,0},{0,0,0}};
        System.out.println("Enter player 1 name:");
        name1 = scan.nextLine();
        System.out.println("Enter player 2 name:");
        name2 = scan.nextLine();
        System.out.println("Game started");
        while (turns > 0 && checkNoWin(map, name1, name2))
        {
            while (true)
            {
                System.out.println("Enter number from 1 to 9 (left up corner is 1, right up is 3, right down is 9)");
                outMap(map);
                int in = Integer.parseInt(scan.nextLine()) - 1;
                if (in < 9)
                {
                    if (map[in/3][in%3] == 0)
                    {
                        map[in/3][in%3] += -1 + (2 * (turns % 2));
                        turns--;
                        break;
                    }
                    else
                        System.out.println("Invalid input. Try again.");
                }
                else
                    System.out.println("Invalid input. Try again.");
            }
        }
        if (turns == 0)
        {
            System.out.println("Draw!");
            File f = new File("GameHisroty.txt");
            if (!f.exists())
                try
                {
                    f.createNewFile();
                }
                catch(IOException ex)
                {
                    System.out.println(ex.getMessage());
                }
            try 
            {
                FileWriter wr = new FileWriter(f, true);
                Date now = new Date();
                wr.write(now.toString() + " Draw between " + name1 + " and " + name2 + '\n');
                wr.close();
            }
            catch(IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void main(String args[])
    {
        while(true)
        {
            System.out.println("Start new game? (Y/N)");
            String s = scan.nextLine();
            if (s.equals("Y"))
                startGame();
            if (s.equals("N"))
                break;
            if (!s.equals("Y") && !s.equals("N"))
                System.out.println("Invalid input. Try again.");
            System.out.println();
        }
    }
}
