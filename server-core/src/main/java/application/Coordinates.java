package application;

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
 /*
  private double latitude;
    private double longitude;
    private double azimuth;
    private double speed;


    @Override
    public String toString() {

        return "Coordinates{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", azimuth=" + azimuth +
                ", speed=" + speed +
                '}';
        }
        */
