package iuh.vn.edu.fit.repositories;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectDB {
    private static ConnectDB connectDB;
    private EntityManagerFactory emf;

    public ConnectDB(){
        emf = Persistence.createEntityManagerFactory("default");
    }

    public static ConnectDB getConnectDB() {
        if(connectDB == null){
            connectDB = new ConnectDB();
        }
        return connectDB;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }
}
