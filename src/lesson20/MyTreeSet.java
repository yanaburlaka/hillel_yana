package lesson20;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MyTreeSet implements Set<Integer> {

    private Node root;

    private class Node {

        Integer data;
        Node left;
        Node right;

    }

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
    public Iterator<Integer> iterator() {

        return new MyIterator(root);
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Integer integer) {
        if (root == null) {
            root = new Node();
            root.data = integer;
            return true;
        } else {
            appendToTree(root, integer);
            return true;
        }
    }

    private void appendToTree(Node appendTo, Integer integerToPut) {
        if (integerToPut < appendTo.data) {
            if (appendTo.left == null) {
                Node newNode = new Node();
                newNode.data = integerToPut;
                appendTo.left = newNode;
            } else {
                appendToTree(appendTo.left, integerToPut);
            }

        } else if (integerToPut > appendTo.data) {
            if (appendTo.right == null) {
                Node newNode = new Node();
                newNode.data = integerToPut;
                appendTo.right = newNode;
            } else {
                appendToTree(appendTo.right, integerToPut);
            }
        } else {
            appendTo.data = integerToPut;
        }
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
    public boolean addAll(Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    private class MyIterator implements Iterator<Integer> {

        Node currentNode;
        Node rootNode;
        Node rightNode;

        public MyIterator(Node root) {
            if (root == null) {
                return;
            }
            this.rootNode = root;
            currentNode = findMin(root);
            rightNode = findMax(root);

        }

        private Node findMax(Node root) {
            while (root.right != null) {
                root = root.right;
            }
            return root;
        }

        private Node findMin(Node root) {
            while (root.left != null) {
                root = root.left;
            }
            return root;
        }

        @Override
        public boolean hasNext() {
            if (currentNode != null && rightNode != null && currentNode.data <= rightNode.data) {
                return true;
            } else {
                return false;
            }
        }

        // Integer?
        @Override
        public Integer next() {
            Node tempNode = currentNode;
            currentNode = getNextNode();
            return tempNode.data;
        }

        private Node getNextNode() {
            if (!hasNext()) {
                System.out.println("You have nothing here");
                return null;
            }
            else {
                if (currentNode.right != null) {
                    return findMin(currentNode.right);
                }
            }
            Integer currentData = currentNode.data;
            Node parentNode = null;
            Node tempNode = rootNode;

            while (tempNode != null) {
                if (currentData < tempNode.data) {
                    parentNode = tempNode;
                    tempNode = tempNode.left;
                }
                else if (currentData > tempNode.data) {
                    tempNode = tempNode.right;
                }
                else {
                    currentNode = parentNode;
                    break;
                }
            }
            return parentNode;
        }
    }
}