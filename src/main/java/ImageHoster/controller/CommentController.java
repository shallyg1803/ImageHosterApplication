package ImageHoster.controller;

import ImageHoster.model.Image;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ImageService imageService;

    //This method is called when after logged in user adds comments on the image
    //it redirects to the "/images/{imageId}/{title}"
    @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
    public String createComment(@PathVariable("imageId") Integer imageId, @PathVariable("imageTitle") String imageTitle,@PathVariable("comments") String comments, Model model){
        Image image = commentService.getImage(imageId);
        model.addAttribute("image", image);
        model.addAttribute("tags", image.getTitle());
        model.addAttribute("tags", image.getTags());
//        model.addAttribute("tags", image.setText(comments));
        return "redirect: /images/{imageId}/{title}";


    }







}
