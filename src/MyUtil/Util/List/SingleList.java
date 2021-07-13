package MyUtil.Util.List;

import MyUtil.Main;

public class SingleList<Object> extends Main implements List<Object>{
    class Node {
        public Node(Object item) {
            this.data = item;
        }

        private Object data;
        private Node next;
    }

    private Node root;

    private boolean empty(Node p) {
        return (p == null);
    }

    @Override
    public int size() {
        int i;
        i = 0;
        Node p = root;

        while (p != null) {
            i++;
            p = p.next;
        }
        return i;
    }

    private Node getNode(int id) {
        if ((size() > id) && (id >= 0)) {
            int i;
            Node p = root;

            i = 0;
            while ((!empty(p.next)) && (i != id)) {
                i++;
                p = p.next;
            }
            return p;
        } else {
            return null;
        }
    }

    private Node getLastNode() {
        return getNode(size()-1);
    }

    @Override
    public void add(Object data) {
        Node p = new Node(data);

        if (empty(root)) {
            root = p;
        } else {
            getLastNode().next = p;
        }
    }

    @Override
    public void add(Object data, int i) {
        Node p = new Node(data);
        if ((i < size()) && (i >= 0)) {
            if (!empty(getNode(i-1))) {
                if (empty(getNode(i))) {
                    getNode(i-1).next = p;
                } else {
                    p.next = getNode(i);
                    getNode(i-1).next = p;
                }
            } else {
                p.next = root;
                root = p;
            }
        } else {
            error("SingleList","элемент " + i + " не найден!");
        }
    }

    @Override
    public void delete(int i) {
        if ((i < size()) && (i >= 0)) {
            if (!empty(getNode(i-1))) {
                if (!empty(getNode(i+1))) {
                    getNode(i-1).next = getNode(i+1);
                } else {
                    getNode(i-1).next = null;
                }
            } else {
                root = root.next;
            }
        } else {
            error("SingleList","элемент " + i + " не найден!");
        }
    }

    @Override
    public Object get(int i) {
        return getNode(i).data;
    }

}
