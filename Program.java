

/**
* task3:
* Реализовать алгоритм пирамидальной сортировки (HeapSort)
*/

/**
import java.util.Arrays;
import java.util.Random;

public class Program {
    public static void main(String[] args) {

        int[] arr = fillArray();
        System.out.println("Начальный массив: ");
        System.out.println(Arrays.toString(arr));

        HeapSort(arr);
        System.out.println("Отсортированный массив: ");
        System.out.println(Arrays.toString(arr));
    }

    public static int[] fillArray() {
        int[] array = new int[10];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(31) - 15;
        }
        return array;
    }

    public static void HeapSort(int[] arr) {
        int len = arr.length;

        for (int i = len - 1; i >= 0; i--) {
            heapify(arr, i, len);
        }

        for(int i = len - 1; i >= 0; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(arr, 0, i);
        }
    }

    public static void heapify(int[] arr, int i, int len){
        
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;

        if(left < len && arr[left] > arr[largest])
            largest = left;

        if(right < len && arr[right] > arr[largest])
            largest = right;

        if(i != largest){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, largest, len);
        }
    }
}
*/

/**
 * task2:
 * Написать программу, которая:
 * Найдет и выведет повторяющиеся имена в списке с количеством повторений.
 * Отсортировать по убыванию популярности.
 */

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.HashMap;
// import java.util.Map;

// public class Program {
//     /**
//      * @param args
//      */
//     public static void main(String[] args) {

//         ArrayList<String> listPeople = new ArrayList<>(Arrays.asList("Иван Иванов", "Светлана Петрова",
//                 "Кристина Белова", "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков",
//                 "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова",
//                 "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников",
//                 "Петр Петин", "Иван Ежов"));

//         ArrayList<String> listName = getName(listPeople);
//         HashMap<String, Integer> amountName = countName(listName);
//         System.out.println(amountName);

//         amountName.entrySet().stream()
//                 .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
//                 .forEach(System.out::println);

//     }

//     public static ArrayList<String> getName(ArrayList<String> list) {
//         ArrayList<String> listName = new ArrayList<>();

//         for (int i = 0; i < list.size(); i++) {
//             String name = list.get(i).split(" ")[0];
//             listName.add(name);
//         }
//         return listName;
//     }

//     public static HashMap<String, Integer> countName(ArrayList<String> list) {
//         HashMap<String, Integer> amountName = new HashMap<>();

//         for (int i = 0; i < list.size(); i++) {
//             int count = 0;
//             for (int j = 0; j < list.size(); j++) {
//                 if (list.get(i).equals(list.get(j))) {
//                     count++;
//                 }
//             }
//             amountName.putIfAbsent(list.get(i), count);
//         }
//         return amountName;
//     }
// }

/**
 * task1:
 * Реализуйте структуру телефонной книги с помощью HashMap,
 * учитывая, что 1 человек может иметь несколько телефонов
 */

// import java.util.HashMap;
// import java.util.Map;


// public class Program {

//     static Map<String, ArrayList<String>> phoneBook = new HashMap<>();
//     static Scanner scanner = new Scanner(System.in);

//     public static void main(String[] args) {
//         chooseOperation();
//         for (Map.Entry<String, ArrayList<String>> contact : phoneBook.entrySet()) {
//             System.out.printf("%s, %s\n", contact.getKey(), contact.getValue());
//         }
//     }

//     /**
//      * Выбор операции над телефонной книгой
//      */
//     private static void chooseOperation() {
//         System.out.println("""
//                 Выберите операцию:
//                 1 - новый контакт
//                 2 - добавить номер к существующему контакту
//                 3 - завершить работу""");

//         String choice = scanner.nextLine();
//         switch (choice) {
//             case "1" -> createNewContact();
//             case "2" -> editContact();
//             case "3" -> System.out.println("Работа завершена!");
//         }
//     }

//     private static void createNewContact() {
//         System.out.print("Введите ФИО: ");
//         String name = scanner.nextLine();

//         if (phoneBook.containsKey(name)) {
//             System.out.println("\nТакой контакт уже есть");
//         } else {
//             ArrayList<String> number = new ArrayList<>();
//             System.out.print("Введите новый номер или ! для возврата в меню: ");
//             String input = scanner.nextLine();

//             while (!input.equals("!")) {
//                 number.add(input);
//                 input = scanner.nextLine();
//             }
//             phoneBook.put(name, number);
//         }
//         chooseOperation();
//     }

//     private static void editContact() {
//         System.out.print("Введите контакт: ");
//         String name = scanner.nextLine();

//         if (!phoneBook.containsKey(name)) {
//             System.out.println("\nТакого контакта нет");
//             chooseOperation();
//         } else {
//             System.out.print("Введите новый номер или ! для возврата в меню: ");
//             String number = scanner.nextLine();

//             while (!number.equals("!")) {
//                 phoneBook.get(name).add(number);
//                 number = scanner.nextLine();
//             }
//             chooseOperation();
//         }
//     }
// }