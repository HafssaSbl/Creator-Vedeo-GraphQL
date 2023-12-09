package ma.xproce.videoservice;

import jakarta.annotation.PostConstruct;
import ma.xproce.videoservice.Entity.Creator;
import ma.xproce.videoservice.Entity.Video;
import ma.xproce.videoservice.Repository.ICreator;
import ma.xproce.videoservice.Repository.IVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideoServiceApplication {
	@Autowired
	private ICreator creatorRepository;

	@Autowired
	private IVideo videoRepository;
	public static void main(String[] args) {

		SpringApplication.run(VideoServiceApplication.class, args);

	}
	@PostConstruct
	public void init() {
		// Création de créateurs
		Creator creator1 = new Creator();
		creator1.setName("John Doe");
		creator1.setEmail("john.doe@example.com");
		creatorRepository.save(creator1);

		Creator creator2 = new Creator();
		creator2.setName("Jane Smith");
		creator2.setEmail("jane.smith@example.com");
		creatorRepository.save(creator2);

		// Création de vidéos liées aux créateurs
		Video video1 = new Video();
		video1.setName("Introduction to Spring Boot");
		video1.setUrl("https://example.com/intro-spring-boot");
		video1.setCreator(creator1);
		videoRepository.save(video1);

		Video video2 = new Video();
		video2.setName("RESTful Web Services with Spring");
		video2.setUrl("https://example.com/restful-spring");
		video2.setCreator(creator2);
		videoRepository.save(video2);

}}
