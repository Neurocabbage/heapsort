import java.util.Arrays;

class Main
{
    // возвращает левую половину `A[i]`
    private static int LEFT(int i) {
        return (2*i + 1);
    }

    // возвращает правую половину  `A[i]`
    private static int RIGHT(int i) {
        return (2*i + 2);
    }

    // Функция для замены двух индексов в массиве
    private static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // Рекурсивный алгоритм Recursive heapify-down algorithm. The node at index `i` and
    // its two direct children violates the heap property
    private static void heapify(int[] A, int i, int size)
    {
        // получаем левый и правый узел с индексом i
        int left = LEFT(i);
        int right = RIGHT(i);

        int largest = i;

        // сравниваем `A[i]` с его левыми и правыми потомками
        // и находим наибольшее значение
        if (left < size && A[left] > A[i]) {
            largest = left;
        }

        if (right < size && A[right] > A[largest]) {
            largest = right;
        }

        // меняем с потомком с самым большим значением и
        // вызываем heapify для этого потомка
        if (largest != i)
        {
            swap(A, i, largest);
            heapify(A, largest, size);
        }
    }

    // Функция для удаления элемента с наивысшим приоритетом
    public static int pop(int[] A, int size)
    {
        // если у кучи нет элементов
        if (size <= 0) {
            return -1;
        }

        int top = A[0];

        // замена корня кучи с последним элементом массива
        A[0] = A[size-1];

        // вызываем heapify для корневого узла
        heapify(A, 0, size - 1);

        return top;
    }

    // Функция выполнения сортировки массива А с размером n
    public static void heapsort(int[] A)
    {

        int n = A.length;

          int i = (n - 2) / 2;
        while (i >= 0) {
            heapify(A, i--, n);
        }

        while (n > 0)
        {
            A[n - 1] = pop(A, n);
            n--;
        }
    }

    // Реализация сортировки
    public static void main(String[] args)
    {
        int[] A = { 6, 4, 7, 1, 9, -2 };

        // выполнить сортирвку массива А
        heapsort(A);

        System.out.println(Arrays.toString(A));
    }
}