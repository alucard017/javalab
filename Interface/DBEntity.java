public interface DBEntity {
    void insert();
    void delete();

    String DB_PASS = "root";

    default void update() {
        System.out.println("Method under implementation");
    }
    // variables are by default public, static and final
    // methods are by default public
}
