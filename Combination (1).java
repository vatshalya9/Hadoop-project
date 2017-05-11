import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Collection;


public class Combination {
	/**
	 2 * If elements = { a, b, c, d },
	 3 * then findCollections(elements, 2) will return:
	 4 * { [a, b], [a, c], [a, d], [b, c], [b, d], [c, d] }
	 5 *
	 6 * and findCollections(elements, 3) will return:
	 7 * { [a, b, c], [a, b, d], [a, c, d], [b, c, d] }
	 8 *
	 9 */
	 public static <T extends Comparable<? super T>> List<List<T>>
	 findSortedCombinations(Collection<T> elements, int n) {
     List<List<T>> result = new ArrayList<List<T>>();
	
	 // handle initial step for recursion
	 if (n == 0) {
	 result.add(new ArrayList<T>());
	 return result;
	  }
	
	 // handle recursion for n-1
	 List<List<T>> combinations = findSortedCombinations(elements, n - 1);
	 for (List<T> combination: combinations) {
	 for (T element: elements) {
	
	 if (combination.contains(element)) {
	 continue;
	 }
	
	 List<T> list = new ArrayList<T>();
	 list.addAll(combination);
	
	 if (list.contains(element)) {
	 continue;
	 }
	
	 list.add(element);
	 // sort items to avoid duplicate items
	 // example: (a, b, c) and (a, c, b) might be counted as
	 // different items if not sorted
	 Collections.sort(list);

	 if (result.contains(list)) {
	 continue;
 }
	 result.add(list);
	 }
	 }
	 return result;
	 }

}
