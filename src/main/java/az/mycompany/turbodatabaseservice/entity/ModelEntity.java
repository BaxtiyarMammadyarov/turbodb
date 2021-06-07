package az.mycompany.turbodatabaseservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "model", schema = "turbodb")
public class ModelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false, length = 15)
    private String name;
    @ManyToOne(targetEntity = BrandEntity.class)
    @JoinColumn(name = "Brand_id", referencedColumnName = "id")
    private BrandEntity brandEntity;
    private boolean ststus=true;
}
