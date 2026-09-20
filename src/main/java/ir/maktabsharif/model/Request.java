package ir.maktabsharif.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "requests")
public class Request extends BaseModel<Long>{

    @CreationTimestamp
    private LocalDateTime crateAt;

    @ManyToOne
    private User user;

    private String path;

    private String sessionId;

    public Request(User user, String path, String sessionId) {
        this.user = user;
        this.path = path;
        this.sessionId = sessionId;
    }

    public Request() {

    }

    public LocalDateTime getCrateAt() {
        return crateAt;
    }

    public void setCrateAt(LocalDateTime crateAt) {
        this.crateAt = crateAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "Request{" +
                "crateAt=" + crateAt +
                ", user=" + user +
                ", path='" + path + '\'' +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }
}
