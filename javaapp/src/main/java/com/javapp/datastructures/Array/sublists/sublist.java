package com.javapp.datastructures.Array.sublists;

import java.util.stream.IntStream;

/**
 * Package: java.java.javapp.datastructures.Array.sublists
 * Created by lusinabrian on 09/09/16 or 09 Sep of 2016,
 * Time: 09:19.
 * Project: JxProjects
 * Description:
 */
public class sublist {

  public static int checkLists(int[] list1, int[] list2) {
    if (list1 == list2) {
      return sublist_checks.EQUAL;
    }
    if (contains(list1, list2)) {
      return sublist_checks.SUPERLIST;
    }
    if (contains(list2, list1)) {
      return sublist_checks.SUBLIST;
    }
    return sublist_checks.UNEQUAL;
  }

  /**
   * Checks if list1 contains list 2
   *
   * @param list1, the list which is assumed to be the superlist
   * @param list2 list with is assumed to be the sublist, until proven otherwise
   */
  private static boolean contains(int[] list1, int[] list2) {
    if (list2.length == 0) {
      return false;
    }
    if (list2.length > list1.length) {
      return false;
    }
    for (Integer x : IntStream.rangeClosed(0, list1.length - list2.length + 1).toArray()) {
      if (list1[x] != list2[0]) {
        continue;
      }
      for (Integer i : IntStream.rangeClosed(0, list2.length).toArray()) {
        if (list1[x + i] != list2[i]) {
          break;
        }
      }
      return true;
    }
    return false;
  }
}
