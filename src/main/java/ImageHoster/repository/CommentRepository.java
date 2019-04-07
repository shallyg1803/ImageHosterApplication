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

    public Image getImage(Integer imageId) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Image> typedQuery = em.createQuery("SELECT i from Image i where i.id =:imageId", Image.class).setParameter("imageId", imageId);
            return typedQuery.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

//    public void getImageByimageID() {
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction transaction = em.getTransaction();
//
//        try {
//            transaction.begin();
//            //persist() method changes the state of the model object from transient state to persistence state
//            em.persist(newComment);
//            transaction.commit();
//        } catch (Exception e) {
//            transaction.rollback();
//        }
//    }

}
