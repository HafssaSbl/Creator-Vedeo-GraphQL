package ma.xproce.videoservice.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
@Entity
public class Creator {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String email;
   @OneToMany(mappedBy = "creator")
   private Collection<Video> videos;
}
