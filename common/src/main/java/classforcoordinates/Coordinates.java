package classforcoordinates;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coordinates {

    @JsonProperty("ithem")
    private String ithem;

    public void setIthem(String ithem) {
        this.ithem = ithem;
    }

    @Override
    public String toString() {
        return "Coordinates{"+ ithem +"}";
    }
}
