import java.util.ArrayList;

class Heap {
	private ArrayList<Integer> list;

	public Heap() {
		list = new ArrayList<>();
	}

	public void Add(int item) {
		list.add(item);
		upheapify(list.size() - 1);
	}

	private void upheapify(int ci) {
		
		int pi = (ci - 1) / 2;
		if (list.get(pi) < list.get(ci)) {
			Swap(pi, ci);
			upheapify(pi);
		}
	}

	public void Swap(int pi, int ci) {
		int temp = list.get(pi);
		list.set(pi, list.get(ci));
		list.set(ci, temp);

	}

	public int remove() {
		int rv = list.get(0);
		Swap(0, list.size() - 1);
		list.remove(list.size() - 1);
		downheapify(0);
		return rv;

	}

	private void downheapify(int pi) {
		
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int mini = pi;
		if (lci < list.size() && list.get(lci) > list.get(mini)) {
			mini = lci;
		}
		if (rci < list.size() && list.get(rci) > list.get(mini)) {
			mini = rci;
		}
		if (mini != pi) {
			Swap(pi, mini);
			downheapify(mini);
		}

	}

    public int size(){
        return list.size();
    }

	public int get() {
		return list.get(0);
	}

	public void Display() {
		System.out.println(list);
	}

}

public class HeapSort {
	
    public static void heapSort(int[] salaries) {
        Heap heap = new Heap();

        
        for (int salary : salaries) {
            heap.Add(salary);
        }

        
        for (int i = salaries.length - 1; i >= 0; i--) {
            salaries[i] = heap.remove();
        }
    }

    public static void main(String[] args) {
        int[] salaries = {50000, 70000, 60000, 10000, 40000, 90000, 70000, 30000};

        System.out.println("Original Salaries: ");
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }
        System.out.println();

        heapSort(salaries); 

        System.out.println("\nSorted Salaries (Ascending Order): ");
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }
    }

}