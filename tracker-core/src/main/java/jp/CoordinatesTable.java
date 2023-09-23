package jp;

import javax.persistence.*;

import static javafx.scene.layout.BorderWidths.AUTO;

@Entity
@Table(name="COORD")
public class CoordinatesTable {

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
