package Homework.Map;

import ru.ifmo.base.Lesson15.User;

import java.security.Key;
import java.util.*;

public class MapTask {
    private static List<String> getPeopleByCity(HashMap<String, String> map, String city) {
        List<String> logins = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(city)) {
                logins.add(entry.getKey());
            }
        }
        return logins;
    }
    private static TreeMap<String,Integer> addMonth(ArrayList<String> list) {
        TreeMap<String,Integer> month = new TreeMap<>();
        int val = 0;
        for (int i=0;i<list.size();i++) {
            month.put(list.get(i),val);
        }
        for (int i=0;i<list.size();i++) {
        for (Map.Entry<String, Integer>entry:month.entrySet()){
            if (entry.getKey().equals(list.get(i))){
                entry.setValue(entry.getValue()+1);
            }//else {month.put(list.get(),1)}
          }
        }
        return month;
    }

    private static HashMap<String,Customer> addMap(HashMap<String,Customer> map,int from,int to) {
       HashMap<String,Customer> newHashMap = new HashMap<>();
        for (Map.Entry<String, Customer>entry:map.entrySet()){
            if (entry.getValue().getAge()>from && entry.getValue().getAge()<to){
                newHashMap.put(entry.getKey(),entry.getValue());
            }
        }
        return newHashMap;
    }

    private static Integer retWord(String text,String word){
        int count = 0;
        String[] splitText = text.split(" ");
        for (int i = 0; i < splitText.length; i++) {
            if (splitText[i].equals(word)){
                count++;
            }
        }
        return count;
    }
    //  2. написать метод, который собирает все слова в группы по количеству букв:
    //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
    private static Map<Integer,String> sortWord(String text){
        String[] splitText = text.split(" ");
        Map<Integer,String> sortW = new HashMap<>();
        for (int i = 0; i <splitText.length ; i++) {
            if (sortW.containsKey(splitText[i].length()) && !sortW.getOrDefault(splitText[i].length(),splitText[i]).equals(splitText[i])){
                sortW.replace(splitText[i].length(),sortW.get(splitText[i].length()),sortW.get(splitText[i].length())+" "+splitText[i]);
            }else
            sortW.put(splitText[i].length(),splitText[i]);
        }
        return sortW;
    }
    //  4. Вывести частоту встречаемости букв анг алфавита в данном тексте. Вывести в процентах для каждой буквы
    private static Map<Character,Integer> sortAlp(String text){
        char[] charText = text.toCharArray();
        Map<Character,Integer> characterMap = new TreeMap<>();
        for (int i = 0; i <charText.length ; i++) {
            if (characterMap.containsKey(charText[i])){
                characterMap.replace(charText[i],characterMap.get(charText[i]),characterMap.get(charText[i])+1);
            }else
            characterMap.put(charText[i],1);

        }
        return characterMap;
    }
    public static void main(String[] args) {
        // TODO:: написать статический метод, который приннимает на вход
        //  мапу (firstTaskMap) и город (city)
        //  и формирует список (List) логинов, которые соответствуют переданному городу

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        String city = "Тверь";

        System.out.println("Task 1: "+getPeopleByCity(firstTaskMap, city));


        // TODO:: дан список слов (words). Написать метод, который будет возвращать количество одинаковых слов с списке
        //  в виде Map<String, Integer>, где String - слово и Integer - количество повторений

        ArrayList<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");
        System.out.println("Task 2: "+addMonth(words));


        // TODO:: дана мапа (customerMap).
        //  Написать метод, который принимает на вход агрументы int from и int to и возвращает новую мапу,
        //  в которую войдут все покупатели, возраст которых находится в диапазоне [from, to)

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));

        System.out.println("Task 3: "+addMap(customerMap,18,65));


        // TODO:: Задания по тексту (text). На каждый пункт - минимум один метод:
        //  1. написать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова в тексте
        //  2. написать метод, который собирает все слова в группы по количеству букв:
        //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
        //  3. написать метод, который выводит в консоль топ 10 самых частых слов
        //  4. Вывести частоту встречаемости букв анг алфавита в данном тексте. Вывести в процентах для каждой буквы

        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like"; // !!! в тексте содержатся только буквы и пробельные символы !!!

        System.out.println("Task 4.1: "+retWord(text,"a"));
        System.out.println("Task 4.2: "+sortWord(text));
        System.out.println("Task 4.3: "+sortAlp(text));


    }

}

