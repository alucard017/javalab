package javalab.Factory.DBEntity.inst.nitjsr.hospitals.dblayer;

//interface implements
// public class Patient implements DBEntity {

//abstract class extends
public class Patient extends DBEntity {
    int id;
    String name;
    String department;
    int hall_number;

    public void setID(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setHallNumber(int hall_number) {
        this.hall_number = hall_number;
    }

    public void insert(DBEntity d) {
        // Patient pt = (Patient) d;
        // pt.setID(90);
        // pt.setName("Apurba");
        // pt.setDepartment("Baba_Hakeem");
        // pt.setHallNumber(1);
        // System.out.println("Inserting patient with id: " + pt.id);
        System.out.println("Inserting patient with id: " + id);
    }

    public void delete(int x) {
        System.out.println("Deleting patient with id: " + id);
    }

    public void update(int x, DBEntity d) {
        System.out.println("Updating patient with id: " + id);
    }
}
