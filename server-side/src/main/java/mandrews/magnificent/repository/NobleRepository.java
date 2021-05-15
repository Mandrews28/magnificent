package mandrews.magnificent.repository;

import mandrews.magnificent.model.Noble;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "noble", path = "noble")
public interface NobleRepository extends CrudRepository<Noble, Integer> {
}
