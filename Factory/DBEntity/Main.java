package javalab.Factory.DBEntity;

// import inst.nitjsr.hospitals.dblayer.*;
import javalab.Factory.DBEntity.inst.nitjsr.hospitals.dblayer.*;

public class Main {
    public static void main(String[] args) {
        // DBEntity d1 = new Doctor();
        // d1.insert(d1);
        // d1.delete(1);
        // d1.update(2, d1);

        // DBEntity s1 = new Staff();
        // s1.insert(s1);
        // s1.delete(1);
        // s1.update(2, s1);

        // DBEntity p1 = new Patient();
        // p1.insert(p1);
        // p1.delete(1);
        // p1.update(2, p1);

        Doctor d = (Doctor) DBEntity.getEntity("doctor");
        Staff s = (Staff) DBEntity.getEntity("staff");
        Patient p = (Patient) DBEntity.getEntity("patient");
        d.setID(100);
        d.setName("Apurba");
        d.setChamberFloor(2);
        d.setSpecialisation("Cardiology");
        d.insert(d);
        d.alter();
        p.alter();
        s.alter();
    }
}
