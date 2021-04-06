
import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @Column(name = "commentID")
    private Integer commentId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "objectifId")
    private Integer objectifId;

    @Column(name = "coachId")
    private Integer coachId;

    public Integer getCommentId() {
        return this.commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getObjectifId() {
        return this.objectifId;
    }

    public void setObjectifId(Integer objectifId) {
        this.objectifId = objectifId;
    }

    public Integer getCoachId() {
        return this.coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }
}
