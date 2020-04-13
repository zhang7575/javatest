package javatest;

import java.util.HashMap;

public class AlgorithmTest {
	
	
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() < 1)
            return 0;
        else if(s.length() == 1){
            return 1;
        }
        int j = 1;
        int max = 1;
        int cl = 1;
        int index =0;
        int lastSeen = 0;
        HashMap<Character,Integer> lookup = new HashMap<>();
        lookup.put(s.charAt(0),0);
        while(j<s.length()){
            char current = s.charAt(j);
            if(lookup.containsKey(current)){
                cl = j - lastSeen;
                index = lookup.get(current);
                lookup.put(current, j);
                if(cl>max)
                	max = cl;
                if(index >= lastSeen)
                	lastSeen = index+1;
            }
            else{
                lookup.put(s.charAt(j),j);
            }
            j++;
        }
        if((j - lastSeen)>max){
            max = j - lastSeen;
        }
        return max;
    }
    
    public void longestClient() {
    	String s = "aab";
    	int length = this.lengthOfLongestSubstring(s);
    	System.out.println("result:"+length);
    	
    }
	
	public <T> void revertChain(LinkList<T> l) {
		LinkNode<T> current = l.head;
		if(current == null)
			return;
		LinkNode<T> n = current.next;
		current.next = null;
		while(n!=null) {
			LinkNode<T> nn = n.next;
			n.next = current;
			current = n;
			n = nn;
		}
		l.head = current;		
	}
	
	public void revertChainClient() {
		LinkList<Integer> l = new LinkList<Integer>();
		int i = 1;
		LinkNode<Integer> head = new LinkNode<Integer>();
		head.value = i;
		l.head = head;
		LinkNode<Integer> node = head;
		i++;
		while(i<3) {	
			LinkNode<Integer> next = new LinkNode<Integer>();
			next.value = i;
			node.next = next;
			node = next;
			++i;
		}
		l.printMe();
		this.revertChain(l);
		System.out.println("\n----------------\n");
		l.printMe();
	}

	public int binarySearch(int[] source, int value) {

		if (source == null || source.length < 1)
			return -1;
		int left = 0;
		int right = source.length - 1;

		while (left <= right) {
			int middle = (left + right) / 2;
			int current = source[middle];
			if (current == value) {
				return middle;
			} else if (current > value) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		return -1;
	}
	
	public void binarySearchClient() {
		int[] target = new int[] { 1 };
		int index = this.binarySearch(target, 1);
		if (index >= 0)
			System.out.println(index + ":" + target[index]);
		else
			System.out.println("not found");
	}

	public void quickSort(int[] source, int begin, int end) {
		if (begin >= end || source == null || source.length < 1) {
			return;
		}
		int i = begin;
		int j = end;
		int value = source[begin];
		while (i < j) {
			while (source[i] < value) {
				i++;
			}
			while (source[j] > value) {
				j--;
			}
			if (i < j) {
				swap(source, i, j);
				i++;
				j--;
			} else if (i == j) {
				i++;
			}
		}
		quickSort(source,begin,j);
		quickSort(source,i,end);

	}
	
	public void quickSortClient() {
		int[] source = {4,3,6,7,-1,5,100,0};
		this.quickSort(source,0,source.length-1);
		for(int i = 0;i<source.length;i++) {
			System.out.println(source[i]);
		}
	}
	
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> lookup = new HashMap<Integer, Integer>();
		
		int[] ret = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int addup = target - nums[i];
			Integer index = lookup.get(nums[i]);
			if (index != null) {
				ret[0] = index;
				ret[1] = i;
				return ret;
			} else {
				lookup.put(addup, i);
			}

		}
		return null;
	}
	
	public void twoSumTest() {
		int[] array = {2, 7, 11, 15};
		int target = 9;
		twoSum(array,target);
	}
	
	
	public void heapSort(int[] source) {
		for(int i=source.length/2-1;i>=0;i--) {
			adjustHeap(source,i,source.length);
		}
		for(int j = source.length-1;j>0;j--) {
			swap(source,0,j);
			adjustHeap(source,0,j);
		}
				
	}
	private void adjustHeap(int[] source, int i, int length) {
		int j = 2*i+1;
		int value = source[i];
		while(j<length) {
			int k = j+1;
			if(k<length&&source[k]>source[j]) {
				j=k;
			}
			if(source[j]>value) {
				source[i] = source[j];
				i = j;
				j = 2*i+1;
				//swap(source[i],source[j]);
			}
			else
				break;
		}
		source[i] = value;
	}
	
	private void swap(int[] source,int i, int j) {
		int temp = source[i];
		source[i] = source[j];
		source[j] = temp;
	}
	
	public void heapSortClient() {
		int[] source = {4,3,6,7,-1,100,0};
		this.heapSort(source);
		for(int i = 0;i<source.length;i++) {
			System.out.println(source[i]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlgorithmTest at = new AlgorithmTest();
		//at.binarySearchClient();
		//at.heapSortClient();
		//at.quickSortClient();
		//at.twoSumTest();
		//at.revertChainClient();
		at.longestClient();
		
	}
}

class LinkNode<T>{
	public T value;
	public LinkNode<T> next;
}
class LinkList<T>{
	public LinkNode<T> head;
	public void printMe() {
		LinkNode<T> current = head;
		while(current!=null) {
			System.out.print(current.value+"->");
			current = current.next;
		}
	}
}
