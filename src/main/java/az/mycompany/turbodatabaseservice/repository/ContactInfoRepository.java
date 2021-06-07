package az.mycompany.turbodatabaseservice.repository;


import az.mycompany.turbodatabaseservice.entity.ContactInfoEntity;
import az.mycompany.turbodatabaseservice.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfoEntity,Integer> {
    @Query(value = "select * from contact_info where status=true",nativeQuery = true)
    List<ContactInfoEntity> findAllByStatus();

}
