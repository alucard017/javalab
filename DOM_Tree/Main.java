package DOM_Tree;

import DOM_Tree.builder.ifaces.*;
import DOM_Tree.builder.nodes.Node;

public class Main {
    public static void main(String[] args) {
        HTMLDocument html = DocumentBuilder.getDocument();
        html.setRoot("html", null);
        HTMLDocument head = new HTMLDocument();
        head.setRoot("head", html);
        html.add("head", head);
        // System.out.println("Root: " + html.getRoot().getName());
        // for (Node child : html.getRoot().getChildren()) {
        // System.out.println("Child: " + child.getName());
        // }

        HTMLDocument body = new HTMLDocument();
        body.setRoot("body", html);
        html.add("body", body);
        // System.out.println("Root: " + html.getRoot().getName());
        // for (Node child : html.getRoot().getChildren()) {
        // System.out.println("Child: " + child.getName());
        // }

        HTMLDocument title = new HTMLDocument();
        HTMLDocument link = new HTMLDocument();
        link.setRoot("link", head);
        title.setRoot("title", head);
        head.add("title", title);
        head.add("link", link);
        // for (Node it : head.getNode().getChildren())
        // System.out.println(it.getName());
        System.out.println("Root: " + html.getNode().getName());
        for (Node it : html.getNode().getChildren()) {
            System.out.println("Child Level 1: " + it.getName());
            Node var = it;
            if (var.getChildren() == null || var.getChildren().isEmpty())
                System.out.println("NO children");
            else {
                for (Node it2 : var.getChildren()) {
                    System.out.println("hello");
                    System.out.println("Child Level 2: " + it2.getName());
                }
            }
        }

    }
}
