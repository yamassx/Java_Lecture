package homework4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class  MyStac <E>{
	private Collection<E> items;
	
	public MyStac(E elem){
		this.items.add(elem);
	}
	
	Collection<E> getItems() {
		return items;
	}

	public E push(E item) {
		this.items.add(item);
		return item;
	}
	
	public E pop() {
		E elem = items.stream()
					  .findFirst(e -> e.isEmpty == false);
		this.items.remove(0);
		return elem;
	}
	
	public E peek() {
		E elem = this.items.get(0);
		return elem;
	}
	
	public boolean empty() {
		return this.pop() != null ;
	}
	
	public int search(Object o) {
//		this.items.stream()
//				  .filter(e -> e.equals(o))
//				  .findFirst()
		int index ;
		for (Map.Entry <E, Integer> entry : this.items.entrySet()) {
			if(entry.getKey().equals(o)) {
				index = entry.getValue();
			}
		}
		return index;
	}
}
