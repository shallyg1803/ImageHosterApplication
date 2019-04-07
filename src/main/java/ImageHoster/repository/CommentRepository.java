package ImageHoster.repository;

import ImageHoster.model.Image;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

//The annotation is a special type of @Component annotation which describes that the class defines a data repository
@Repository
public class CommentRepository {
    //Get an instance of EntityManagerFactory from persistence unit with name as 'imageHoster'
    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    //The method creates an instance of EntityManager
    //Executes JPQL query to fetch the image from the database with corresponding imageId
    //Returns the image in case the image is found in the database
    //Returns null if no image is found in the database
    public Image getImage(Integer imageId) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Image> typedQuery = em.createQuery("SELECT i from Image i where i.id =:imageId", Image.class).setParameter("imageId", imageId);
            return typedQuery.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }



}
