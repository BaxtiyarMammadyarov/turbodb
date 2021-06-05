package az.mycompany.turbodatabaseservice.repository;


import az.mycompany.turbodatabaseservice.entity.ContactInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfoEntity,Integer> {
}
