package ma.xproce.videoservice.Entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;
    @ManyToOne
    private Creator creator;
}
