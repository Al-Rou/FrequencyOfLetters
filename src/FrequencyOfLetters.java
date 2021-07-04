import java.util.*;

public class FrequencyOfLetters {
    public static void main(String[] args)
    {
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        //Prompt the user to enter their sentence
        System.out.println("Enter your sentence: ");
        Scanner in = new Scanner(System.in);
        //Take the entered sentence
        String input = in.nextLine();
        //Separate all letters and store them one by one in a list
        for(int i = 0; i < input.length(); i++)
        {
            list.add(i, input.charAt(i));
        }
        //Count letters' frequency
        while (list.size() != 0)
        {
            char aux = list.get(0);
            int counter = 1;
            list.remove(0);
            for(int i = 0; i < list.size(); i++)
            {
                //No matter if small or capital letters
                if((list.get(i) == aux) || (list.get(i) == aux-32) || (list.get(i) == aux+32))
                {
                    counter++;
                    list.remove(i);
                    i--;
                }
            }
            //Store any letter with its occurrence
            map.put(aux, counter);
        }
        //Print results out
        for(Character a : map.keySet())
        {
            //If it is space, print "space" out instead " "!
            if(a == ' ')
            {
                System.out.print("space -> " + map.get(a) + "\n");
            }
            else {
                //Print out just letters in capital form
                if((int) a > 96)
                {
                    System.out.print((char) (a-32) + " -> " + map.get(a) + "\n");
                }
                else {
                    System.out.print(a + " -> " + map.get(a) + "\n");
                }
            }
        }
        //Find the letter with maximum occurrence
        List<Integer> result = new ArrayList<>();
        int maxFre = 0;
        //Take all values from the map, which are in fact the keys' occurrences
        for(Character a : map.keySet())
        {
            result.add(map.get(a));
        }
        //Sort the occurrences
        Collections.sort(result);
        //Take the maximum
        maxFre = result.get(result.size()-1);
        for(Character a : map.keySet())
        {
            //Show the letters with the maximum occurrence
            if(map.get(a) == maxFre) {
                //If space, go for the second maximal occurrence
                if(a == ' ')
                {
                    maxFre = result.get(result.size()-2);
                    continue;
                }
                else {
                    System.out.println("Maximum frequency is " + maxFre + " on letters below:");
                    if ((int) a > 96) {
                        System.out.print((char) (a - 32) + " -> " + map.get(a) + "\n");
                    } else {
                        System.out.print(a + " -> " + map.get(a) + "\n");
                    }
                }
            }
        }
    }
}
