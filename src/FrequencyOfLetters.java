import java.util.*;

public class FrequencyOfLetters {
    public static void main(String[] args)
    {
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        System.out.println("Enter your sentence: ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        for(int i = 0; i < input.length(); i++)
        {
            list.add(i, input.charAt(i));
        }
        while (list.size() != 0)
        {
            char aux = list.get(0);
            int counter = 1;
            list.remove(0);
            for(int i = 0; i < list.size(); i++)
            {
                if((list.get(i) == aux) || (list.get(i) == aux-32) || (list.get(i) == aux+32))
                {
                    counter++;
                    list.remove(i);
                    i--;
                }
            }
            map.put(aux, counter);
        }
        for(Character a : map.keySet())
        {
            if(a == ' ')
            {
                System.out.print("space -> " + map.get(a) + "\n");
            }
            else {
                if((int) a > 96)
                {
                    System.out.print((char) (a-32) + " -> " + map.get(a) + "\n");
                }
                else {
                    System.out.print(a + " -> " + map.get(a) + "\n");
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        int maxFre = 0;
        for(Character a : map.keySet())
        {
            result.add(map.get(a));
        }
        Collections.sort(result);
        maxFre = result.get(result.size()-1);
        for(Character a : map.keySet())
        {
            if(map.get(a) == maxFre) {
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
