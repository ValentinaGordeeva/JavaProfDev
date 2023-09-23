package jp;

import javax.persistence.*;

@Entity
@Table(name="COORDSC")
public class CoordinatTableSC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Integer id;

    @Column(name = "MODEL")
    String model;

    public String toString() {
        return "id=" + id + ", model=" + model;
    }


    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}
