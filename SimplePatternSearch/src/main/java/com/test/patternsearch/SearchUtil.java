package com.test.patternsearch;

/**
 * 
 * @author aryasindhusahu@gmail.com
 *
 */
public class SearchUtil<T> {

	public boolean search(T[] mainPattern, T[] searchPattern) {

		int searchNextIndex = 0;
		for (int index = 0; (index < mainPattern.length && searchNextIndex < searchPattern.length); index++) {
			T element = mainPattern[index];
			if (searchPattern[searchNextIndex].equals(element)) {
				searchNextIndex++;
			}
		}
		return (searchNextIndex == searchPattern.length);
	}

}
