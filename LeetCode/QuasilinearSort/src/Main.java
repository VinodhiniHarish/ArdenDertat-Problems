/**
 *  Homework 06 - Quasilinear Sorts
 *
 *  Problem 1: Quicksort
 *
 *  Prompt:    Given an unsorted array of integers, return the array
 *             sorted using quicksort.
 *
 *
 *  Input:     input {Array}
 *  Output:    {Array}
 *
 *  Example:   [3,9,1,4,7] --> [1,3,4,7,9]
 *
 *
 *  Problem 2: Mergesort
 *
 *  Prompt:    Given an unsorted array of integers, return the array
 *             sorted using mergesort.
 *
 *  Input:     {Array}
 *  Output:    {Array}
 *
 *  Example:   [3,9,1,4,7] --> [1,3,4,7,9]
 */

import java.util.*;


// Worse Time Complexity:
// Worse Auxiliary Space Complexity:
// Average Time Complexity:
// Average Auxiliary Space Complexity:
class Quicksort {

  public static int[] compute(int[] input) {
    return quickSort(input,0, input.length-1);
  }
  
  public static int[] quickSort(int[] input,int start, int end) {
	  if(start>=end)
		  return input;
	  int pIndex = partition(input, start, end);
	  quickSort(input, start, pIndex-1);
	  quickSort(input,pIndex+1,end);
	  return input;
  }
  
  public static int partition(int[] input,int start, int end) {
	  int pivot = input[end];
	  int pIndex = start;
	  for(int i=start;i<end;i++) {
		  if(input[i]<pivot) {
			  //swap input[i] with pIndex
			  input = swap(input,i,pIndex);
			  pIndex++;
		  }
	  }
	  input = swap(input, pIndex,end);
	  return pIndex;
  }

public static int[] swap(int[] input,int x, int y) {
	int temp = input[x];
	input[x] = input[y];
	input[y] = temp;
	return input;
}
}

// Worse Time Complexity:
// Worse Auxiliary Space Complexity:
// Average Time Complexity:
// Average Auxiliary Space Complexity:
class Mergesort{
  public static int[] compute(int[] input) {
    int n = input.length;
    if(n<=1)
    	return input;
    
    int mid = n/2;
    int[] left = new int[mid];
    int[] right = new int[n-mid];
    int i=0;
    for( i=0;i<mid;i++) {
    	left[i] = input[i];
    }
    int j=0;
    for(int k=i;k<input.length;k++) {
    	right[j++] = input[k];
    }
    
    left = compute(left);
    right = compute(right);
    return merge(left,right);
  }

  private static int[] merge(int[] array1, int[] array2){
    // YOUR CODE HERE
	  
	  int i=0,j=0,k=0;
	  int[] array3 = new int[array1.length + array2.length];
	  while(i<array1.length && j<array2.length) {
		  if(array1[i] <= array2[j]) {
			  array3[k++] = array1[i++];
		  }else {
			  array3[k++] = array2[j++];
		  }
	  }
	  
	  while(i < array1.length) {
		  array3[k++] = array1[i++];
	  }
	  
	  while(j< array2.length) {
		  array3[k++] = array2[j++]; 
	  }
	  
    return array3;
  }
}


////////////////////////////////////////////////////////////
///////////////  DO NOT TOUCH TEST BELOW!!!  ///////////////
////////////////////////////////////////////////////////////

// use the Main class to run the test cases
class Main {
  private int[] testCount;

  // an interface to perform tests
  public interface Test {
    public boolean execute();
  }

  public static void main(String[] args) {

    int[] testCount = {0, 0};
    System.out.println("Quick Sort Tests");

    assertTest(testCount, "should sort example input", new Test() {
      public boolean execute() {
        Quicksort quicksort = new Quicksort();
        return arraysEqual(quicksort.compute(new int[]{3, 9, 1, 4, 7}), new int[]{1, 3, 4, 7, 9});
      }
    });

    assertTest(testCount, "should return empty array for empty input", new Test() {
      public boolean execute() {
        Quicksort quicksort = new Quicksort();
        return arraysEqual(quicksort.compute(new int[]{}), new int[]{});
      }
    });

    assertTest(testCount, "should sort single-element input", new Test() {
      public boolean execute() {
        Quicksort quicksort = new Quicksort();
        return arraysEqual(quicksort.compute(new int[]{10}), new int[]{10});
      }
    });

    assertTest(testCount, "should sort moderate-sized input", new Test() {
      public boolean execute() {
        Quicksort quicksort = new Quicksort();
        int[] input = new int[1000];
        for (int i = 0 ; i < input.length ; i++) {
          input[i] = (int) Math.floor(Math.random() * 1000);
        }
        int[] inputSorted = new int[1000];

        System.arraycopy(input, 0, inputSorted, 0, input.length);

        int[] solution = new int[1000];
        System.arraycopy(input, 0, solution, 0, input.length);
        input = quicksort.compute(input);

        Arrays.sort(solution);
        return isSorted(input) && arraysEqual(input, solution);
      }
    });

    assertTest(testCount, "should sort large-sized input", new Test() {
      public boolean execute() {
        Quicksort quicksort = new Quicksort();
        int[] input = new int[1000000];
        for (int i = 0 ; i < input.length ; i++) {
          input[i] = (int) Math.floor(Math.random() * 1000000);
        }
        int[] inputSorted = new int[1000000];

        System.arraycopy(input, 0, inputSorted, 0, input.length);

        int[] solution = new int[1000000];
        System.arraycopy(input, 0, solution, 0, input.length);
        input = quicksort.compute(input);

        Arrays.sort(solution);
        return isSorted(input) && arraysEqual(input, solution);
      }
    });

    // print the result of tests passed for a module
    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");


    // instantiate the testing of each module by resetting count and printing title of module
    testCount[0] = 0;
    testCount[1] = 0;
    System.out.println("Merge Sort Tests");

    // tests are in the form as shown
    assertTest(testCount, "should sort example input", new Test() {
      public boolean execute() {
        Mergesort mergesort = new Mergesort();
        return arraysEqual(mergesort.compute(new int[]{3, 9, 1, 4, 7}), new int[]{1, 3, 4, 7, 9});
      }
    });

    assertTest(testCount, "should return empty array for empty input", new Test() {
      public boolean execute() {
        Mergesort mergesort = new Mergesort();
        return arraysEqual(mergesort.compute(new int[]{}), new int[]{});
      }
    });

    assertTest(testCount, "should sort single-element input", new Test() {
      public boolean execute() {
        Mergesort mergesort = new Mergesort();
        return arraysEqual(mergesort.compute(new int[]{10}), new int[]{10});
      }
    });

    assertTest(testCount, "should sort moderate-sized input", new Test() {
      public boolean execute() {
        Mergesort mergesort = new Mergesort();
        int[] input = new int[1000];
        for (int i = 0 ; i < input.length ; i++) {
          input[i] = (int) Math.floor(Math.random() * 1000);
        }
        int[] inputSorted = new int[1000];

        System.arraycopy(input, 0, inputSorted, 0, input.length);

        int[] solution = new int[1000];
        System.arraycopy(input, 0, solution, 0, input.length);
        input = mergesort.compute(input);

        Arrays.sort(solution);
        return isSorted(input) && arraysEqual(input, solution);
      }
    });

    assertTest(testCount, "should sort large-sized input", new Test() {
      public boolean execute() {
        Mergesort mergesort = new Mergesort();
        int[] input = new int[1000000];
        for (int i = 0 ; i < input.length ; i++) {
          input[i] = (int) Math.floor(Math.random() * 1000000);
        }
        int[] inputSorted = new int[1000000];

        System.arraycopy(input, 0, inputSorted, 0, input.length);

        int[] solution = new int[1000000];
        System.arraycopy(input, 0, solution, 0, input.length);
        input = mergesort.compute(input);

        Arrays.sort(solution);
        return isSorted(input) && arraysEqual(input, solution);
      }
    });

    // print the result of tests passed for a module
    System.out.println("PASSED: " + testCount[0] + " / " + testCount[1] + "\n\n");

  }

  // function for checking if arrays are equal
  private static boolean arraysEqual(int[] arr1, int[] arr2) {
    if (arr1.length != arr2.length) {
      return false;
    }

    for (int i = 0 ; i < arr1.length ; i++) {
      if (arr1[i] != arr2[i]) {
        return false;
      }
    }

    return true;
  }


  // checks if array is sorted in linear time
  private static boolean isSorted(int[] input) {
    if (input.length < 2) {
      return true;
    }

    for (int i = 1 ; i < input.length ; i++) {
      if (input[i-1] > input[i]) {
        return false;
      }
    }

    return true;
  }

  // do not edit below, this is to wrap the test and check for exceptions
  private static void assertTest(int[] count, String name, Test test) {
    String pass = "false";
    count[1]++;

    try {
      if (test.execute()) {
        pass = " true";
        count[0]++;
      }
    } catch(Exception e) {}
    String result = "  " + (count[1] + ")   ").substring(0, 5) + pass + " : " + name;
    System.out.println(result);
  }
}
