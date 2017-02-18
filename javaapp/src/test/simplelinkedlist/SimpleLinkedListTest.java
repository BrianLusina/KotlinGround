package test.simplelinkedlist;

import java.util.NoSuchElementException;

import main.datastructures.simplelinkedlist.SimpleLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class SimpleLinkedListTest {


    @Test
    public void aNewListIsEmpty() {
        SimpleLinkedList list = new SimpleLinkedList();
        Assert.assertEquals(list.size(), 0);
    }

    @Test
    public void canCreateFromArray() {
        Integer[] values = new Integer[]{1, 2, 3};
        SimpleLinkedList list = new SimpleLinkedList(values);
        Assert.assertEquals(list.size(),3);
    }

    @Test(expected = NoSuchElementException.class)
    public void popOnEmptyListWillThrow() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.pop();
    }

    @Test
    public void popReturnsLastAddedElement() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.push(9);
        list.push(8);
        Assert.assertEquals(list.size(),2);
        Assert.assertEquals(list.pop(),8);
        Assert.assertEquals(list.pop(),9);
        Assert.assertEquals(list.size(),0);
    }

    @Test
    public void reverseReversesList() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.push(9);
        list.push(8);
        list.push(7);
        list.push(6);
        list.push(5);
        list.reverse();
        Assert.assertEquals(list.pop(),9);
        Assert.assertEquals(list.pop(),8);
        Assert.assertEquals(list.pop(),7);
        Assert.assertEquals(list.pop(),6);
        Assert.assertEquals(list.pop(),5);
    }

    @Test
    public void canReturnListAsArray() {
        SimpleLinkedList list = new SimpleLinkedList();
        list.push(9);
        list.push(8);
        list.push(7);
        list.push(6);
        list.push(5);
        Integer[] expected = {5, 6, 7, 8, 9};
        Assert.assertArrayEquals(list.asArray(Integer.class), expected);
    }

    @Test
    public void canReturnEmptyListAsEmptyArray() {
        SimpleLinkedList list = new SimpleLinkedList();
        Object[] expected = {};
        Assert.assertArrayEquals(list.asArray(Object.class), expected);
    }

}
