import java.util.ArrayList;
import java.util.Comparator;
public class StudentSort {
    // generic method to sort an array of any generic type T using a comparator
    // Arraylist for elements
    public static <T> void selectionSort(ArrayList<T> arr, Comparator<? super T> c) {

        //get size of the arraylist
        int n = arr.size();

        //iterate over items in the arraylist
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // iterate over unsorted part of arraylist
            for (int j = i + 1; j < n; j++) {
                // If the element at index j is smaller than the element at minIndex, update minIndex to j

                if (c.compare(arr.get(j), arr.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            //Swap the element at minIndex with the element at index i

            T temp = arr.get(minIndex);
            arr.set(minIndex, arr.get(i));
            arr.set(i, temp);
        }
    }
}
