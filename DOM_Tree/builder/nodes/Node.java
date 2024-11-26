package DOM_Tree.builder.nodes;

import java.util.ArrayList;
import java.util.List;
import DOM_Tree.builder.ifaces.HTMLDocument;

public class Node {
    private String name;
    private HTMLDocument parent;
    private List<Node> children = new ArrayList<>();

    public void setText(String s) {
        name = s;
    }

    public void setParent(HTMLDocument p) {
        parent = p;
    }

    public void addChild(Node n) {
        children.add(n);
    }

    public HTMLDocument getParent() {
        return parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }
}
