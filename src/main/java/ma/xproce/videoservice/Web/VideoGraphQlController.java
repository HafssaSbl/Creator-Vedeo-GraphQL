package ma.xproce.videoservice.Web;

import ma.xproce.videoservice.Entity.Creator;
import ma.xproce.videoservice.Entity.Video;
import ma.xproce.videoservice.Repository.ICreator;
import ma.xproce.videoservice.Repository.IVideo;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VideoGraphQlController {
    private ICreator creatorRepository;
    private IVideo videoRepository;
    VideoGraphQlController(ICreator creatorRepository, IVideo videoRepository){
        this.creatorRepository = creatorRepository;
        this.videoRepository = videoRepository;
    }
    @QueryMapping
    public List<Video> videotList(){
        return videoRepository.findAll();
    }
    @QueryMapping
    public Creator creatorById(@Argument Long id) {
        return creatorRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Creator %s not found",id)));
    }
}
