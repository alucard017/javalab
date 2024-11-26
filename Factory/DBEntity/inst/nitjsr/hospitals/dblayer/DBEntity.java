package javalab.Factory.DBEntity.inst.nitjsr.hospitals.dblayer;

// public interface DBEntity {

// public void insert(DBEntity d);

// public void delete(int x);

// public void update(int x, DBEntity d);

// public static DBEntity getEntity(String type) {
// DBEntity obj = null;
// if (type == "doctor")
// obj = new Doctor();
// else if (type == "staff")
// obj = new Staff();
// else if (type == "patient")
// obj = new Patient();
// return obj;
// }

// // can be invoked using concrete subclass objects in main
// default void alter() {
// System.out.println("Implementation in Progress");
// }
// }

//abstract class implementation
public abstract class DBEntity {

    public abstract void insert(DBEntity d);

    public abstract void delete(int x);

    public abstract void update(int x, DBEntity d);

    public static DBEntity getEntity(String type) {
        DBEntity obj = null;
        if (type == "doctor")
            obj = new Doctor();
        else if (type == "staff")
            obj = new Staff();
        else if (type == "patient")
            obj = new Patient();
        return obj;
    }

    // can be invoked using concrete subclass objects in main
    public void alter() {
        System.out.println("Implementation in Progress");
    }
}