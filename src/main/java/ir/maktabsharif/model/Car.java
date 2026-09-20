package ir.maktabsharif.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
public class Car extends BaseModel<Integer>{

    private String model;
    private String year;
    private String color;
    private Integer engin;


    public Car(String model, String year, String color, Integer engin) {
        this.model = model;
        this.year = year;
        this.color = color;
        this.engin = engin;
    }

    public Car() {

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getEngin() {
        return engin;
    }

    public void setEngin(Integer engin) {
        this.engin = engin;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + super.getId() + '\'' +
                "model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", color='" + color + '\'' +
                ", engin=" + engin +
                '}';
    }
}
