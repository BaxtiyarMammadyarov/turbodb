package az.mycompany.turbodatabaseservice.repository;



import az.mycompany.turbodatabaseservice.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Integer> {
    @Query(value = "select * from turbo.model where model.name=?1",nativeQuery = true)
    Optional<ModelEntity> findByName(String name);
    @Query(value = "select * from turbo.model where model.brand_id=?1",nativeQuery = true)
    Optional<ModelEntity> findByBrandId(Integer id);
}



