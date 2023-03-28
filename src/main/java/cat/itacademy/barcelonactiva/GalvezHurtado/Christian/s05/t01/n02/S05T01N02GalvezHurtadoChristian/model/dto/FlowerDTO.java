package cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s05.t01.n02.S05T01N02GalvezHurtadoChristian.model.dto;

import java.util.Arrays;

public class FlowerDTO {

    private int pk_FlorID;
    private String nameFlower;
    private String countryFlower;
    private String typeFlower;
    private String[] EUCountries = {"Germany", "Austria", "Belgium", "Bulgaria",
            "Cyprus", "Croatia", "Denmark", "Spain", "Slovakia", "Slovenia", "Estonia", "Finland", "France",
            "Greece", "Hungary", "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg", "Malt", "Netherlands",
            "Poland", "Portugal", "Czech Republic", "Romania", "Sweden"};

    public FlowerDTO() {
    }

    public FlowerDTO(int pk_FlorID, String nameFlower, String countryFlower) {
        this.pk_FlorID = pk_FlorID;
        this.nameFlower = nameFlower;
        this.countryFlower = countryFlower;
        this.typeFlower = checkEUMember(countryFlower);
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

    public String getTypeFlower() {
        return typeFlower;
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

    public void setTypeFlower(String typeFlower) {
        this.typeFlower = typeFlower;
    }

    @Override
    public String toString() {
        return "FlowerDTO{" +
                "pk_FlorID=" + pk_FlorID +
                ", nameFlower='" + nameFlower + '\'' +
                ", countryFlower='" + countryFlower + '\'' +
                ", typeFlower='" + typeFlower + '\'' +
                '}';
    }

    private String checkEUMember(String euVerifier) {
        boolean belongs = Arrays.stream(EUCountries)
                .anyMatch(v -> v.equalsIgnoreCase(euVerifier));
        if (belongs){
            return "EU";
        }else{
            return "NOT UE";
        }
    }
}
