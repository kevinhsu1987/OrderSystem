import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

public class OrderClient {
    private String username;
    private String password;
    OrderClient() {
        ;
    }
    boolean login(String username, String password) {
        //TODO:Encrypt
        String serverUsername;
        String serverPassword;
        serverUsername = "user"; serverPassword = "pwd";
        return username.equals(serverUsername) && password.equals(serverPassword);
    }
}
