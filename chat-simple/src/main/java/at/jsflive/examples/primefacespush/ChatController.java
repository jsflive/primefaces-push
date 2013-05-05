package at.jsflive.examples.primefacespush;

import org.primefaces.push.PushContext;
import org.primefaces.push.PushContextFactory;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;

/**
 * @author Michael Kurz
 */
@ApplicationScoped
public class ChatController implements Serializable {
    private static final String CHANNEL = "/chat";

    private final PushContext pushContext = PushContextFactory.getDefault().getPushContext();

    public void join(String userName) {
        sendMessage(userName + " joined the chat.");
    }

    public void sendMessage(String userName, String message) {
        sendMessage(userName + ": " + message);
    }

    public void leave(String userName) {
        sendMessage(userName + " left the chat.");
    }

    private void sendMessage(String message) {
        pushContext.push(CHANNEL, message);
    }
}
