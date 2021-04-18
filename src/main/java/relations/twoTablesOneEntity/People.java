package relations.twoTablesOneEntity;

import javax.persistence.*;

@Entity
@Table(name = "people")
@SecondaryTable(name = "address")
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private int id;
    private String name;

    @Column(name = "city", table = "address")
    private String city;
    @Column(name = "street", table = "address")
    private String street;
    @Column(name = "number", table = "address")
    private String number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
