package com.javapp.datastructures.queues;

import java.util.Queue;

/**
 * java.java.javapp.datastructures.queues
 * Created by lusinabrian on 26/12/16.
 * Description: Implementation of a queue data structure
 */
public class Queues<T> implements QueueInterface {

  private Queue<Object> queue;

  private Queues() {
  }

  @Override
  public void enqueue(Object element) {
    queue.add(element);
  }

  @Override
  public Object dequeue() {
    return queue.remove();
  }

  @Override
  public Object peek() {
    return queue.peek();
  }

  @Override
  public boolean isEmpty() {
    return queue.isEmpty();
  }

  @Override
  public boolean isFull() {
    return false;
  }
}
