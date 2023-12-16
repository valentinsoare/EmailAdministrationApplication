package io.emailadministration.customdatastructureandoperationsonthem.datastructures.binarysearchtree;

import lombok.Getter;

import java.util.*;
import java.util.function.Consumer;

@Getter
public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {

    private Node<T> rootNode;
    private int size;
    public BinarySearchTree() {}

    public BinarySearchTree(T element) {
        this.rootNode = new Node<>(element);
        this.size++;
    }

    public T getRootNode() {
        return rootNode.element;
    }

    public T min() {
        return getMin(rootNode);
    }

    private T getMin(Node<T> currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode.element;
    }

    public T max() {
        return getMax(rootNode);
    }

    private T getMax(Node<T> currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode.element;
    }

    public void rInsert(T element) {
        if (rootNode == null) {
            this.rootNode = new Node<>(element);
        } else {
            insertNodeWithRecursion(rootNode, element);
        }

        this.size++;
    }

    public void iterInsert(T element) {
        insertNodeWithIteration(rootNode, element);
        this.size++;
    }

    private Node<T> insertNodeWithRecursion(Node<T> currentNode, T elementToInsert) {
        if (currentNode == null) {
            return new Node<>(elementToInsert);
        }

        if (elementToInsert.equals(currentNode.element)) {
            currentNode.numberOfOccurrences++;
            return currentNode;
        }

        if (elementToInsert.compareTo(currentNode.element) > 0) {
            currentNode.left = insertNodeWithRecursion(currentNode.left, elementToInsert);
        } else {
            currentNode.right = insertNodeWithRecursion(currentNode.right, elementToInsert);
        }

        return currentNode;
    }

    private void insertNodeWithIteration(Node<T> currentNode, T elementToInsert) {
        if (elementToInsert == null) return;

        if (currentNode == null) {
            this.rootNode = new Node<>(elementToInsert);
        } else {
            Node<T> tmp = currentNode;
            Node<T> newNodeToBeAdded = new Node<>(elementToInsert);

            while (true) {
                if (elementToInsert.equals(tmp.element)) {
                    tmp.numberOfOccurrences++;
                    return;
                }

                if (elementToInsert.compareTo(tmp.element) > 0) {
                    if (tmp.left == null) {
                        tmp.left = newNodeToBeAdded;
                        return;
                    }

                    tmp = tmp.left;
                } else {
                    if (tmp.right == null) {
                        tmp.right = newNodeToBeAdded;
                        return;
                    }

                    tmp = tmp.right;
                }
            }
        }
    }

    public Node<T> delete(T element) {
        Node<T> toDelete = rDeleteNode(rootNode, element);

        if (toDelete == null) {
            return new Node<>();
        }

        return toDelete;
    }

    private Node<T> rDeleteNode(Node<T> subTreeRoot, T element) {
        if (subTreeRoot == null) return null;

        if (element.compareTo(subTreeRoot.element) > 0) {
            subTreeRoot.left = rDeleteNode(subTreeRoot.left, element);
        } else if ((element.compareTo(subTreeRoot.element)) < 0) {
            subTreeRoot.right = rDeleteNode(subTreeRoot.right, element);
        } else {
            if ((subTreeRoot.left == null) && (subTreeRoot.right == null)) {   // here is to remove a leafNode
                return null;
            } else if (subTreeRoot.left == null) {             // here to remove a node with only right child
                subTreeRoot = subTreeRoot.right;
            } else if (subTreeRoot.right == null) {            // to remove a node with only left child
                subTreeRoot = subTreeRoot.left;
            } else {                                           // to remove a node with two children
                T subTreeMin = getMin(subTreeRoot.right);
                subTreeRoot.element = subTreeMin;

                subTreeRoot.right = rDeleteNode(subTreeRoot.right, subTreeMin);
            }
        }

        return subTreeRoot;
    }

    public List<T> preOrderTraverse() {
        return traversePreOrderWithReturningAListOfNodes(rootNode);
    }

    private List<T> traversePreOrderWithReturningAListOfNodes(Node<T> currentNode) {
        List<T> preOrderList = new ArrayList<>();

        class Traverse {
            Traverse(Node<T> currentNode) {
                preOrderList.add(currentNode.getElement());

                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }

                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }

        new Traverse(currentNode);
        return preOrderList;
    }

    public List<T> inOrderTraverse() {
        return traverseInOrderWithReturningAListOfNodes(rootNode);
    }

    private List<T> traverseInOrderWithReturningAListOfNodes(Node<T> currentNode) {
        List<T> toReturn = new ArrayList<>();

        class Traverse {
            Traverse (Node<T> currentNode) {
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }

                toReturn.add(currentNode.getElement());

                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }

        new Traverse(currentNode);
        return toReturn;
    }

    public List<T> postOrderTraverse() {
        return traversePostOrderWithReturningAListOfNodes(rootNode);
    }

    private List<T> traversePostOrderWithReturningAListOfNodes(Node<T> currentNode) {
        List<T> elements = new ArrayList<>();

        class Traverse {
            Traverse (Node<T> currentNode) {
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }

                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }

                elements.add(currentNode.getElement());
            }
        }

        new Traverse(currentNode);
        return elements;
    }

    public boolean searchWithRecursion(T elementToSearch) {
        return recursiveSearch(rootNode, elementToSearch);
    }

    private boolean recursiveSearch(Node<T> currentNode, T element) {
        if (element == null) {
            return false;
        }

        if ((element.compareTo(currentNode.element)) > 0) {
            return recursiveSearch(currentNode.left, element);
        } else if ((element.compareTo(currentNode.element)) < 0) {
            return recursiveSearch(currentNode.right, element);
        }

        return true;
    }

    public boolean searchWithIteration(T elementToBeSearch) {
        return iterativeSearch(rootNode, elementToBeSearch);
    }

    private boolean iterativeSearch(Node<T> currentNode, T element) {
        Node<T> tmp = currentNode;

        while (tmp != null) {
            if (element.compareTo(tmp.element) > 0) {
                tmp = tmp.left;
            } else if (element.compareTo(tmp.element) < 0) {
                tmp = tmp.right;
            } else {
                return true;
            }
        }

        return false;
    }

    public Node<T> get(T element) {
        if (element == null) {
            return new Node<>();
        }

        return get(rootNode, element);
    }

    private Node<T> get(Node<T> currentNode, T element) {
        if (currentNode == null) {
            return new Node<>();
        } else if (currentNode.element.equals(element)) {
            return currentNode;
        }

        if (element.compareTo(currentNode.element) > 0) {
            return get(currentNode.left, element);
        } else {
            return get(currentNode.right, element);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new InOrderTraversalIterator(this);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);

        for (T e : this) {
            action.accept(e);
        }
    }

    //---------------------------Custom Iterator-------------------------//

    private class InOrderTraversalIterator implements Iterator<T> {

        private final Queue<T> storage;

        public InOrderTraversalIterator(BinarySearchTree<T> tree) {
            this.storage = new LinkedList<>(tree.inOrderTraverse());
        }

        @Override
        public boolean hasNext() {
            return !storage.isEmpty();
        }

        @Override
        public T next() {
            try {
                return storage.poll();
            } catch (NoSuchElementException e) {
                throw new NoSuchElementException();
            }
        }
    }

    //---------------------------Node----------------------------------- //

    @Getter
    public static class Node<T extends Comparable<T>> {

        private T element;

        private Node<T> left;
        private Node<T> right;

        private int numberOfOccurrences;

        private boolean isNull;

        public Node() {
            this.isNull = true;
        }

        private Node(T element) {
            this.element = element;
            this.isNull = false;
            this.numberOfOccurrences++;
        }

        public boolean isNull() {
            return isNull;
        }

        @Override
        public int hashCode() {
            return element.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node<?> node)) return false;

            return (node.element.equals(element));
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    //------------------------------------------------------------------//
}
