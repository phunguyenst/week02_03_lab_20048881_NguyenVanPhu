package iuh.vn.edu.fit.test;

import iuh.vn.edu.fit.connect.ConnectDB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ConnectDBTest {
    public static void main(String[] args) {
        try {
            ConnectDB connectDB = ConnectDB.getConnectDB();
            EntityManager em = connectDB.getEmf().createEntityManager();
            EntityTransaction tr = em.getTransaction();
            tr.begin();
            try {
                tr.commit();
            }
            catch (Exception e){
                tr.rollback();

            }
            finally {
                em.close();
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
