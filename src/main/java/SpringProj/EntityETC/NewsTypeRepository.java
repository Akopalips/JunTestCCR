package SpringProj.EntityETC;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsTypeRepository extends CrudRepository<NewsType, Long> {
}
