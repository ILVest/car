package Car_dealership.Cars.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Cars_dealership")
public class Cars_dealership{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "address")
    private String address;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private Long phone;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToMany(mappedBy = "cars_dealerships", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Cars> carss;

}