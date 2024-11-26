package javalab.Factory.DBEntity.inst.nitjsr.hospitals.dblayer;

//interface implements
// public class Staff implements DBEntity {

//abstract class extends
public class Staff extends DBEntity {
    int id;
    String name;
    String designation;
    int room_number;

    public void setID(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setRoomNumber(int room_number) {
        this.room_number = room_number;
    }

    public void insert(DBEntity d) {
        // Staff st = (Staff) d;
        // st.setID(44);
        // st.setName("Apurba");
        // st.setDesignation("Neuro");
        // st.setRoomNumber(1);
        // System.out.println("Inserting staff with id: " + st.id);
        System.out.println("Inserting staff with id: " + id);
    }

    public void delete(int x) {
        System.out.println("Deleting staff with id: " + id);
    }

    public void update(int x, DBEntity d) {
        Staff st = (Staff) d;
        System.out.println("Updating staff with id: " + st.id);
    }
}
