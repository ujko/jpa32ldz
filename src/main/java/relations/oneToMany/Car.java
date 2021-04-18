package relations.oneToMany;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue
    @Column(name = "car_id")
    private int carId;
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private CarOwner carOwner;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarOwner getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(CarOwner carOwner) {
        this.carOwner = carOwner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", name='" + name + '\'' +
                '}';
    }
}
