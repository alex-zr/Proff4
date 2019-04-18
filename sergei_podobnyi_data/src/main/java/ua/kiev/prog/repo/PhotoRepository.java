package ua.kiev.prog.repo;

import org.springframework.data.repository.CrudRepository;
import ua.kiev.prog.domain.Photo;

public interface PhotoRepository extends CrudRepository<Photo, Long> {

}
