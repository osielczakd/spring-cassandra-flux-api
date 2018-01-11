package nl.zwennesm.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("User")
public class User {

    @PrimaryKey
    private String userId;
    private String trigger;

    public User() {}

    @JsonCreator
    public User(@JsonProperty("userId") String userId, @JsonProperty("trigger") String trigger) {
        this.userId = userId;
        this.trigger = trigger;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    @Override
    public String toString() {
        return String.format("UserProfile[userId=%s, trigger=%s]", this.userId, this.trigger);
    }
}
