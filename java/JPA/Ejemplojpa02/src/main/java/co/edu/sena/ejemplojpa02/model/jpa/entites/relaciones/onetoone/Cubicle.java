package co.edu.sena.ejemplojpa02.model.jpa.entites.relaciones.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cubicle {
    @Id
    private int idCubicle;
    private Employee residentEmployee;


    @OneToOne(mappedBy="assignedCubicle")
    public Employee getResidentEmployee() {
        return residentEmployee;
    }
    public void setResidentEmployee(Employee employee) {
        this.residentEmployee = employee;
    }

    public int getIdCubicle() {
        return idCubicle;
    }

    public void setIdCubicle(int idCubicle) {
        this.idCubicle = idCubicle;
    }
}
