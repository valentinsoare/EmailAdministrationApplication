package io.emailadministration.customdatastructureandoperationsonthem.datastructures.customlinkedlist;

import io.emailadministration.customdatastructureandoperationsonthem.datastructures.GenericComparator;
import io.emailadministration.customdatastructureandoperationsonthem.datastructures.SortOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Consumer;

@Getter
@Setter
@NoArgsConstructor
public class EnhancedDoubleLinkedLinkedList<E extends Comparable<E>> extends AbstractList<E>
        implements Iterable<E> {
    private int size;

    private Node<E> head;
    private Node<E> tail;

    public EnhancedDoubleLinkedLinkedList(E e) {
        this.head = this.tail = new Node<>(e);
        this.size++;
    }

    public EnhancedDoubleLinkedLinkedList(Collection<? extends E> c) {
        this();
        addAllIAtTheBack(c);
    }

    public EnhancedDoubleLinkedLinkedList(EnhancedDoubleLinkedLinkedList<E> enhancedDoubleLinkedList) {
        this();
        addAllIAtTheBack(enhancedDoubleLinkedList);
    }

    public EnhancedDoubleLinkedLinkedList<E> getANewInstanceOf(EnhancedDoubleLinkedLinkedList<E> enhancedDoubleLinkedList) {
        return new EnhancedDoubleLinkedLinkedList<>(enhancedDoubleLinkedList);
    }


    //---------------------customIterator---------------------//

    private class EnhancedListIterator implements Iterator<E> {

        private int nextIndex;
        private Node<E> lastReturnedNode;
        private Node<E> currentNode;
        private Node<E> nextNode;

        public EnhancedListIterator() {
            this.nextIndex = 0;
        }

        public EnhancedListIterator(int index) {
            if (index >= 0 && index < size) {
              this.nextNode = getTheNodeFromPosition(index);
              this.nextIndex = index;
            } else {
                this.nextIndex = 0;
            }
        }

        private Node<E> getTheNodeFromPosition(int locationIndex) {
            Node<E> x;

            if (locationIndex < (size / 2)) {
                x = head;

                for (int i = 0; i < locationIndex; i++) {
                    x = x.getNext();
                }
            } else {
                x = tail;

                for (int i = size - 1; i > locationIndex; i--) {
                    x = x.getPrevious();
                }
            }

            return x;
        }

        @Override
        public boolean hasNext() {
            return (currentNode != null);
        }

        @Override
        public E next() {
            return getNextElement();
        }

        private E getNextElement() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            this.lastReturnedNode = this.nextNode;
            this.nextNode = nextNode.getNext();
            this.nextIndex++;

            return this.lastReturnedNode.getItem();
        }
    }

    //------------------Node---------------------------//

    @Getter
    @Setter
    public static class Node<E> {
        private E item;

        private Node<E> next;
        private Node<E> previous;

        public Node(Node<E> previous, E item, Node<E> next) {
            this.previous = previous;
            this.item = item;
            this.next = next;
        }

        public Node(E item) {
            this.item = item;
        }
    }

    //--------------------------------------------------//

    public boolean addInFront(E e) {
        if (e == null) return false;

        Node<E> node = new Node<>(e);

        if (size == 0) {
            this.tail = node;
        } else {
            node.setNext(head);
            this.head.setPrevious(node);
        }

        this.head = node;
        this.size++;

        return true;
    }

    public boolean addAtTheBack(E e) {
        if (e == null) return false;

        Node<E> node = new Node<>(e);

        if (size == 0) {
            this.head = node;
        } else {
            node.setPrevious(this.tail);
            this.tail.setNext(node);
        }

        this.tail = node;
        this.size++;

        return true;
    }

    public boolean addAllIAtTheBack(Collection<? extends E> c) {
        int itemsAdded = 0;
        if (c.isEmpty()) return false;

        for (E e : c) {
            itemsAdded += (addAtTheBack(e)) ? 1 : 0;
        }

        return itemsAdded != 0;
    }

    public E removeFromTheFront() {
        if (size == 0) return null;

        Node<E> tempNode = this.head;

        if (size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = head.getNext();
            this.head.setPrevious(null);
            tempNode.setNext(null);
        }

        this.size--;
        return tempNode.getItem();
    }

    public E removeFromTheBack() {
        if (size == 0) return null;

        Node<E> temp = this.tail;

        if (this.size == 1) {
            this.tail = null;
            this.head = null;
        } else {
            this.tail = tail.getPrevious();
            this.tail.setNext(null);
            temp.setPrevious(null);
        }

        this.size--;
        return temp.getItem();
    }

    @Override
    public boolean isEmpty() {
        return (head == null && tail == null);
    }

    public void clearTheList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private boolean validateIndexForInsertion(int index) {
        return ((index >= 0) && (index <= size));
    }

    public boolean insertObjectAtAnIndexMoveElementsRight(int index, E e) {
        if (!validateIndexForInsertion(index)) {
            return false;
        } else if (index == 0) {
            this.addInFront(e);
            return true;
        } else if (index == size) {
            this.addAtTheBack(e);
            return true;
        }

        Node<E> newNode = new Node<>(e);

        int parseIndex = 0;
        Node<E> left, nodeFromTheIndex;

        for (left = head; left != null; left = left.getNext()) {
            if (parseIndex == (index - 1)) {
                nodeFromTheIndex = left.getNext();

                left.setNext(newNode);
                newNode.setPrevious(left);

                newNode.setNext(nodeFromTheIndex);
                nodeFromTheIndex.setPrevious(newNode);
                this.size++;
            }

            parseIndex++;
        }

        return true;
    }

    public int searchForElementAndReturnedIndex(E e) {
        Objects.requireNonNull(e);

        Node<E> searchForNode = new Node<>(e);
        Node<E> node;
        int index = 0;

        for (node = head; node != null; node = node.getNext()) {
            if (node.equals(searchForNode)) {
                return index;
            }

            index++;
        }

        return -1;
    }

    public boolean addBefore(E newE, E oldE) {
        int indexAfterSearch = searchForElementAndReturnedIndex(oldE);

        if ((head == null) || (indexAfterSearch == -1)) {
            return false;
        } else if (indexAfterSearch == 0) {
            addInFront(newE);
            return true;
        }

        Node<E> newNode = new Node<>(newE);
        Node<E> existentNode = new Node<>(oldE);

        Node<E> currentNode = head, tempNode;

        while ((currentNode = currentNode.getNext()) != null) {
            tempNode = currentNode.getNext();

            if (tempNode.equals(existentNode)) {
                currentNode.setNext(newNode);
                newNode.setPrevious(currentNode);

                newNode.setNext(tempNode);
                tempNode.setPrevious(newNode);
                this.size++;

                return true;
            }
        }

        return false;
    }

    public boolean addAfter(E newE, E oldE) {
        if (isEmpty()) return false;

        Node<E> currentNode = head, tempNode;

        Node<E> newNode = new Node<>(newE);
        Node<E> existentNode = new Node<>(oldE);

        if (size == 1 && existentNode.equals(head)) {
            addAtTheBack(newE);
            return true;
        }

        while ((currentNode = currentNode.getNext()) != null) {
            if (currentNode.equals(existentNode)) {
                tempNode = currentNode.getNext();

                newNode.setNext(tempNode);
                tempNode.setPrevious(newNode);

                currentNode.setNext(newNode);
                newNode.setPrevious(currentNode);

                this.size++;
                return true;
            }
        }

        return false;
    }

    public void insertElementInSortedOrder(E e) {
        if (size == 0) {
            this.head = new Node<>(e);
            this.tail = this.head;
            this.size++;
        } else {
            Node<E> newNode = new Node<>(e);

            if (e.compareTo(head.getItem()) < 0) {
                addInFront(newNode.getItem());
            } else {
                Node<E> current = head.getNext();

                while (current != null) {
                    if (e.compareTo(current.getItem()) <= 0) {
                        addBefore(newNode.getItem(), current.getItem());
                        return;
                    }

                    current = current.getNext();
                }

                this.tail.setNext(newNode);
                newNode.setPrevious(this.tail);
                this.tail = newNode;
                this.size++;
            }
        }
    }

    public void customSortingInAscendingOrder() {
        EnhancedDoubleLinkedLinkedList<E> unsortedOriginal = getANewInstanceOf(this);
        this.clearTheList();

        for (E e : unsortedOriginal) {
            this.insertElementInSortedOrder(e);
        }

        unsortedOriginal.clearTheList();
    }

    public void customSorting(SortOrder typeOfOrder) {
        if (typeOfOrder == SortOrder.ASC) {
            customSortingInAscendingOrder();
        } else {
            Comparator<E> descendingComparator = new GenericComparator<>(true);
            this.sort(descendingComparator);
        }
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        int currIndex = 0;
        Node<E> currentNode = head;

        while ((currentNode = currentNode.getNext()) != null) {
            if (index == currIndex) {
                return currentNode.getItem();
            }

            currIndex++;
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        return new EnhancedListIterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);

        for (E e : this) {
            action.accept(e);
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder output = new StringBuilder("[");

        Node<E> currentNode = head;
        output.append(currentNode.getItem()).append(", ");

        while (((currentNode = currentNode.getNext()) != null) &&
                currentNode != tail) {
            output.append(currentNode.getItem()).append(", ");
        }

        output.append(currentNode).append("]");
        return output.toString();
    }
}
