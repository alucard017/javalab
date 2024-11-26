package DOM_Tree.builder.ifaces;

// import DOM_Tree.builder.Document.*;
import DOM_Tree.builder.nodes.Node;

// abstract public class Document extends DocumentBuilder {
//     // abstract public void add(String text, Document d);
//     abstract public void setRoot(String s);

//     abstract public void setRoot(Node n);
// }
public abstract class Document {
    abstract public void setRoot(Node n);

    abstract public Node getNode();
}
