package ma.xproce.ma.xproce;

import ma.xproce.ma.xproce.Entities.Creator;
import ma.xproce.ma.xproce.Entities.Video;
import ma.xproce.ma.xproce.Repository.CreatorRepository;
import ma.xproce.ma.xproce.Repository.VideoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

import static graphql.introspection.IntrospectionQueryBuilder.build;
@Configuration
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	CommandLineRunner start(CreatorRepository creatorRepository, VideoRepository videoRepository) {
		return args -> {
			List<Creator> creators = List.of(Creator.builder().name("x")
					.email("x@gmail.com").build(), Creator.builder().name("y")
					.email("y@gmail.com").build(), Creator.builder().name("z")
					.email("z@gmail.com").build());
			for (Creator creator : creators) {
				creatorRepository.save(creator);
			}
			List<Video> videos = List.of(Video.builder().name("vEducation")
					.url("vEducation.com").datePublication(new Date())
					.description("this is an educational video").creator(creators.get(1))
					.build(), Video.builder().name("vGaming").url("vEGaming.com")
					.datePublication(new Date()).description("this is a Gaming video")
					.creator(creators.get(0)).build(), Video.builder().name("vEntertainement")
					.url("vEntertainement.com").datePublication(new Date())
					.description("this is an entertainement video")
					.creator(creators.get(2)).build());
			for (Video video : videos) {
				videoRepository.save(video);
			}
		};
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
