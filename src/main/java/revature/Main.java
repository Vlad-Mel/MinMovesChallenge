package revature;

import java.util.*;

public class Main {
	
	
	public static void main(String[] args) {
		//Solution solution = new Solution();
		BinaryHeap heap = new BinaryHeap(1, 100);
		
		for (int i = 1; i < 100; i++) {
			try {
				heap.insert(i);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		//heap.printHeap();
		

		// min heap parent of every element is (i - 1)/2
		// max heap parent of every element is 2*i + 1
		int i = 0;
		int max = 98;
		
		int level = 0;
		int prevLevel = 0;
		int numInLevel = 0;
		boolean firstLevel = false;
		
		Deque<Integer> elementsThisLevel = new LinkedList<>();
		
		while(i < max) {
			int maxNumThisLevel = (int) Math.pow(2, level);
			
			//i = (i - 1)/2;
			
			
			//if (level == 0) firstLevel = true;
//			System.out.println("numInLevel " + numInLevel);
			if (numInLevel >= maxNumThisLevel) {
				System.out.println("numInLevel " + numInLevel);
				System.out.println("Spam " + maxNumThisLevel);
				int[] ints = heap.getHeap();
				elementsThisLevel.addLast(ints[i]);
				
				prevLevel = level;
				level++;
				numInLevel = 0;
			} else {
				int[] ints = heap.getHeap();
				elementsThisLevel.addLast(ints[i]);
				numInLevel++;
			}
			
			
			
			
			if (prevLevel < level || level == 0) {

				
				prevLevel++;
				while (!elementsThisLevel.isEmpty()) {
					//System.out.println(Arrays.toString(elementsThisLevel.toArray()));
					int val = elementsThisLevel.removeFirst();
					System.out.print(val + " ");
				}
				System.out.println();
			}
			i++;
			//if (level == 1) level++;
			/*
			 * if (numInLevel > level * 2 ) { level++; }
			 */
		}
		
//		int moves = 0;
		
//		while(i > min) {
//			i = (i - 1)/2;
//			moves++;
//		}
		
		
//		System.out.println(--moves);
		
	}
	
}

class Solution {
	
	int[] arr;
	
	private int x;
	private int y;
	
	public Solution(int x, int y) {
		this.x = x;
		this.y = y;
		
		int range = y - x;
		arr = new int [range];
	}
	
	public int getMinMoves() {
		int minMoves = 0;
		
		for (int i = x; i < y; i++) {
			
			for (; i < y; i *= i) {
				
			}
		}
		
		return minMoves;
	}
}

class BinaryHeap {
	int[] heap;
	int maxSize;
	int size;
	
	public BinaryHeap(int x, int y) {
		maxSize = y - x;
		heap = new int [maxSize];
		
		size = 0;
	}

	public int parent(int i) {
		//System.out.println(" index " + i + " parent " + ((i - 1) / 2));
		//System.out.println("Value " + heap[i] + " " + ((i - 1) / 2));
				//+ " | Left Child: " + heap[this.leftChild(i)] +" && Right Child: " + heap[this.rightChild(i)]);
		return (i - 1) / 2;
	}
	private int leftChild(int i) { return i + 1; }
	private int rightChild(int i) { return i * i; }
	
	public void insert(int value) throws Exception {
		if (size >= maxSize) {
			throw new Exception("Cannot insert in full binary heap");
		}
		// 500, size = 0 => heap[0] = 500
		heap[size] = value;
		fixHeapAbove(size);
		size++;
		
		
        // move up until the heap property satisfies
//        int i = size - 1;
//        while (i != 0 && heap[parent(i)] < heap[i]) {
//            int temp = heap[i];
//            heap[i] = heap[parent(i)];
//            heap[parent(i)] = temp;
//            i = parent(i);
//        }
	}
	
	public int minMoves() {
		int moves = 0;
		
		
		
		return moves;
	}
	
	private int getLevelNode(int i, int level) {
		if (i == 0) return 0;
		
		return 0;
	}
	
	
	private void fixHeapAbove(int index) {
        int newValue = heap[index];

        while (index > 0 && newValue < heap[parent(index)]) {
            heap[index] = heap[parent(index)];
            index = parent(index);
        }

        heap[index] = newValue;
    }
	
	public int[] getHeap() {
		return this.heap;
	}
	
	
	public void heapify(int i) {
		int left = this.leftChild(i);
		int right = this.rightChild(i);
		int largest = i;
		
		
		if (left <= size && heap[left] > heap[largest]) {
			largest = left;
		}
		
		if (right <= size && heap[right] > heap[largest]) {
			largest = right;
		}
		// 1 2 3 4 7 5 -> 1 2 3 4 5 7
		if (largest != i) {
			int temp = heap[i];
			heap[i] = heap[largest];
			heap[largest] = heap[temp];
			heapify(largest);
			
		}
	}
	
//	@Override
//	public String toString() {
//		String str = "";
//		for (int i = 0; i < heap.length; i++) {
//			System.out.println(heap[i]);
//			str += " " + heap[i];
//		}
//		
//		return str;
//	}
	
	public void printHeap () {
		for (int i = 0; i < heap.length; i++) {
			System.out.print(heap[i] + " ");
		}
	}
	
}














