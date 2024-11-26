package DOM_Tree.builder.ifaces;

// abstract public class DocumentBuilder {
//     private static final Document obj = new HTMLDocument();

//     public static Document getDocument() {
//         Document d = new HTMLDocument();
//         if (obj != null)
//             return obj;
//         else
//             return d;
//     }
// }
public abstract class DocumentBuilder {
    public static HTMLDocument getDocument() {
        return new HTMLDocument();
    }
}
