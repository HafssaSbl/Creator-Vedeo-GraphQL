package ma.xproce.videoservice.Repository;

import ma.xproce.videoservice.Entity.Creator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICreator extends JpaRepository<Creator,Long> {
}
