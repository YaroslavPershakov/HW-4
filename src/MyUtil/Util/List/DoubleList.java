package MyUtil.Util.List;

import MyUtil.Main;

public class DoubleList<Object> extends Main implements List<Object>{
    class Node {
        public Node(Object item) {
            this.data = item;
        }

        private Object data;
        private Node next, prev;
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
            Node tmp = getLastNode();
            tmp.next = p;
            p.prev = tmp;
        }
    }

    @Override
    public void add(Object data, int id) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Object get(int id) {
        return null;
    }
}
