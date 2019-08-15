package za.co.mkhabelalucas.simplerestfulapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import za.co.mkhabelalucas.simplerestfulapi.entity.NewsEntity;

@Component
@Repository
public interface NewsRepository extends JpaRepository<NewsEntity, Long> {

}
