package Car_dealership.Cars.Models;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Cars")
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "country")
    private String country;
    @Column(name = "model")
    private String model;
    @Column(name = "colour")
    private String colour;
    @Column(name = "price")
    private long price;
    @Column(name = "description")
    private String description;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "cars_and_cars_dealership", joinColumns = { @JoinColumn(name = "cars_id",referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "cars_dealership_id",referencedColumnName = "id") }
    )
    private List<Cars_dealership> cars_dealerships;
}