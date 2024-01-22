package ExamCorrections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

public class OurQueue<T> implements Queue<T> {

 private Stack<T> data;

 // the top of the stack is considered the head of this queue.

 public OurQueue() {
  data = new Stack<T>();
 }

 // peek returns the head of the queue. Returns null if empty.

 public T peek() {

  if (data.empty()) return null;

  return data.peek();

 }

 // poll removes the head of this queue.

 public T poll() {

  if (data.empty()) return null;

  return data.pop();

 }

 public boolean offer(T element) {
  Stack<T> reverseStack = new Stack<>();
  while (data.isEmpty() != true) { //this while loop reverses the stack
   reverseStack.push(data.pop());
  }
  reverseStack.push(element); // this adds the element to the front of reverseStack
  while (reverseStack.isEmpty() != true) { // reverses the Stack back
   data.push(reverseStack.pop());
  }
  return true;
 }

 @Override
 public T element() {
  return null;
 }

 // offer adds the given element to the tail of this queue.

 @Override
 public int size() {
  return 0;
 }

 @Override
 public boolean isEmpty() {
  return false;
 }

 @Override
 public boolean contains(Object o) {
  return false;
 }

 @Override
 public Iterator<T> iterator() {
  return null;
 }

 @Override
 public Object[] toArray() {
  return new Object[0];
 }

 @Override
 public <T1> T1[] toArray(T1[] a) {
  return null;
 }

 @Override
 public boolean add(T t) {
  return false;
 }

 @Override
 public boolean remove(Object o) {
  return false;
 }

 @Override
 public boolean containsAll(Collection<?> c) {
  return false;
 }

 @Override
 public boolean addAll(Collection<? extends T> c) {
  return false;
 }

 @Override
 public boolean removeAll(Collection<?> c) {
  return false;
 }

 @Override
 public boolean retainAll(Collection<?> c) {
  return false;
 }

 @Override
 public void clear() {

 }

 @Override
 public T remove() {
  return null;
 }
}


 