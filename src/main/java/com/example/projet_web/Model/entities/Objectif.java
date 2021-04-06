
import javax.persistence.*;

@Entity
@Table(name = "objectif")
public class Objectif {
    @Id
    @Column(name = "objectifId")
    private Integer objectifId;

    @Column(name = "objectifName")
    private String objectifName;

    @Column(name = "startDate")
    private java.sql.Date startDate;

    @Column(name = "endDate")
    private java.sql.Date endDate;

    @Column(name = "isAchieved")
    private java.lang.Byte isAchieved;

    @Column(name = "categoryId")
    private Integer categoryId;

    @Column(name = "userId")
    private Integer userId;

    public Integer getObjectifId() {
        return this.objectifId;
    }

    public void setObjectifId(Integer objectifId) {
        this.objectifId = objectifId;
    }

    public String getObjectifName() {
        return this.objectifName;
    }

    public void setObjectifName(String objectifName) {
        this.objectifName = objectifName;
    }

    public java.sql.Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(java.sql.Date startDate) {
        this.startDate = startDate;
    }

    public java.sql.Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(java.sql.Date endDate) {
        this.endDate = endDate;
    }

    public java.lang.Byte getIsAchieved() {
        return this.isAchieved;
    }

    public void setIsAchieved(java.lang.Byte isAchieved) {
        this.isAchieved = isAchieved;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
