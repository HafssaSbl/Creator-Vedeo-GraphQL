package ma.xproce.ma.xproce.web;

import ma.xproce.ma.xproce.Entities.Creator;
import ma.xproce.ma.xproce.Entities.Video;
import ma.xproce.ma.xproce.Repository.CreatorRepository;
import ma.xproce.ma.xproce.Repository.VideoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VideoGraphQlController {
    private CreatorRepository creatorRepository;
    private VideoRepository videoRepository;
    private final ModelMapper modelMapper;

    VideoGraphQlController(CreatorRepository creatorRepository, VideoRepository videoRepository,ModelMapper modelMapper){
        this.creatorRepository = creatorRepository;
        this.videoRepository = videoRepository;
        this.modelMapper = modelMapper;
    }
    @QueryMapping
    public List<Video> videoList(){
        return videoRepository.findAll();
    }
    @QueryMapping
    public Creator creatorById(@Argument Long id) {
        return creatorRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Creator %s not found",id)));
    }
    @MutationMapping
    public Creator saveCreator(@Argument Creator creator){
    Creator creators =  modelMapper.map(creator, Creator.class);
        return creatorRepository.save(creator) ;
    }
    @MutationMapping
    public Video saveVideo(@Argument Video video){
        Video video1 = modelMapper.map(video, Video.class);
        return videoRepository.save(video) ;
    }

}
