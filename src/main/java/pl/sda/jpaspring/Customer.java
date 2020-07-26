package pl.sda.jpaspring;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String surname;
    private String pesel;

    @OneToMany
    private List<Product> products;


    public Customer() {

    }

    public Customer(String firstName, String surname, String pesel, List<Product> products) {
        this.firstName = firstName;
        this.surname = surname;
        this.pesel = pesel;
        this.products = products;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", pesel='" + pesel + '\'' +
                ", products=" + products +
                '}';
    }
}
