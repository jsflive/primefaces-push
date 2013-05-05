package at.jsflive.examples.primefacespush;


import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Michael Kurz
 */
@ApplicationScoped
public class ChatUsers implements Serializable {
    private final Set<String> users;

    public ChatUsers() {
        this.users = new HashSet<String>();
    }

    public boolean login(String user) {
        synchronized (users) {
            return users.add(user);
        }
    }

    public void logout(String user) {
        synchronized (users) {
            users.remove(user);
        }
    }

}
