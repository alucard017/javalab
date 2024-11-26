package javalab.Factory.DBEntity.inst.nitjsr.hospitals.dblayer;

//interface implements
// public class Doctor implements DBEntity {

//abstract class extends
public class Doctor extends DBEntity {
    int id;
    String name;
    String specialisation;
    int chamber_floor;

    public void setID(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public void setChamberFloor(int chamber_floor) {
        this.chamber_floor = chamber_floor;
    }

    public void insert(DBEntity d) {
        // Doctor doc = (Doctor) d;
        // doc.setID(32);
        // doc.setName("Apurba");
        // doc.setSpecialisation("Neuro");
        // doc.setChamberFloor(1);
        // System.out.println("Inserting doctor with id: " + doc.id + " into the
        // database");
        System.out.println("Inserting Doctor with id: " + id + " into the database");
    }

    public void delete(int x) {
        System.out.println("Deleting doctor with id: " + id);
    }

    public void update(int x, DBEntity d) {
        Doctor doc = (Doctor) d;
        // doc.insert(doc);
        System.out.println("Updating doctor with id: " + doc.id);
    }
}
