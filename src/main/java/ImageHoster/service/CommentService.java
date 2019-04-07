package ImageHoster.service;

import ImageHoster.repository.CommentRepository;
import ImageHoster.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ImageHoster.model.Image;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

//  call the getImage() method in the CommentRepository and returns Image
    public Image getImage(Integer imageId) {
        return commentRepository.getImage(imageId);
    }

}
