import iuh.vn.edu.fit.backend.repositories.ConnectDB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class Mapping {
    public static void main(String[] args) {
        EntityManager em = ConnectDB.getConnectDB().getEmf().createEntityManager();
        EntityTransaction tr = em.getTransaction();

        try{
            tr.begin();
            tr.commit();
        }catch (Exception e){
            tr.rollback();
        }
    }
}
