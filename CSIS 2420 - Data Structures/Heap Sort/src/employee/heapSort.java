package employee;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class heapSort {

	public static<T> List<T> heapSort(Collection<? extends T> collection,
										Comparator<? super T>comparator) 
	{
		if(collection == null || comparator == null)
		{
			return null;
		}
		Heap<T> heap = new ArrayMiniHeap<T>(collection, comparator);
		List<T> list = new ArrayList<T>();
		return list;
		
	}
}
