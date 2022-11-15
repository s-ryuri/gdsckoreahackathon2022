package we_won.hackerton.user.infra;

import java.io.Serializable;

public class UserSentenceScrapID implements Serializable {

    private long user;
    private long sentence;

    public UserSentenceScrapID() {}

    public UserSentenceScrapID(long user, long sentence) {
        this.user = user;
        this.sentence = sentence;
    }
}
