package az.mycompany.turbodatabaseservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "USERS",schema = "turbodb")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String fatherName;
    @Column(name = "pin",nullable = false,unique = true)
    private String pin;
    @Column(nullable = false,unique = true)
    private String phone;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false,unique = true)
    private String userName;
    private String password;
    @Column(nullable = false)
    private Date createDateTime=new Date(System.currentTimeMillis());
    @Column(nullable = false)
    private Date updateDateTime=new Date(System.currentTimeMillis());
    @Column(nullable = false)
    private boolean status=true;

}
