package ma.xproce.videoservice.Repository;

import ma.xproce.videoservice.Entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVideo extends JpaRepository<Video,Long> {
}
