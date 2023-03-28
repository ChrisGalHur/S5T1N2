package cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s05.t01.n02.S05T01N02GalvezHurtadoChristian.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "flowers")
public class FlowerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int pk_FlorID;
    @Column(name = "Name")
    private String nameFlower;
    @Column(name = "Country")
    private String countryFlower;

    public FlowerEntity() {
    }

    public FlowerEntity(String nameFlower, String countryFlower) {
        this.nameFlower = nameFlower;
        this.countryFlower = countryFlower;
    }

    public int getPk_FlorID() {
        return pk_FlorID;
    }

    public String getNameFlower() {
        return nameFlower;
    }

    public String getCountryFlower() {
        return countryFlower;
    }

    public void setPk_FlorID(int pk_FlorID) {
        this.pk_FlorID = pk_FlorID;
    }

    public void setNameFlower(String nameFlower) {
        this.nameFlower = nameFlower;
    }

    public void setCountryFlower(String countryFlower) {
        this.countryFlower = countryFlower;
    }

    @Override
    public String toString() {
        return "FlowerEntity{" +
                "pk_FlorID=" + pk_FlorID +
                ", nameFlower='" + nameFlower + '\'' +
                ", countryFlower='" + countryFlower + '\'' +
                '}';
    }
}
