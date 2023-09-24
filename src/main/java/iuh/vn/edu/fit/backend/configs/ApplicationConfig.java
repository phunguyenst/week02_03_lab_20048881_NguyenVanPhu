package iuh.vn.edu.fit.backend.configs;

import iuh.vn.edu.fit.backend.repositories.ConnectDB;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class ApplicationConfig extends Application {
    public ApplicationConfig(){
        ConnectDB.getConnectDB().getEmf();
    }
}
