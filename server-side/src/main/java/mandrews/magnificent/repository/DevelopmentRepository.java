package mandrews.magnificent.repository;

import mandrews.magnificent.model.Development;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "development", path = "development")
public interface DevelopmentRepository extends CrudRepository<Development, Integer> {
    List<Development> findByLevel(int level);
}
