package DOM_Tree.builder.ifaces;

import DOM_Tree.builder.nodes.*;

public class HTMLDocument extends Document {
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getNode() {
        return root;
    }

    public void setRoot(String text, HTMLDocument parent) {
        Node n = new Node();
        n.setText(text);
        n.setParent(parent);
        this.root = n;
    }

    public void add(String text, HTMLDocument child) {
        Node node = new Node();
        node.setText(text);
        node.setParent(this);
        this.root.addChild(node);
    }
}

// public class HTMLDocument extends Document {
// private Node root;

// public void setRoot(Node root) {
// this.root = root;
// }

// public void setRoot(String text, HTMLDocument p) {
// Node n = new Node();
// n.setText(text);
// n.setParent(p);
// n.setChild(null);
// this.root = n;
// }

// public void add(String text, HTMLDocument child) {
// // call - html, child - head
// Node n = new Node();
// n.setText(text);
// n.setChild(child);
// }

// // public HTMLDocument getRoot() {
// // // return root;
// // }

// }
