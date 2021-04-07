package com.example.projet_web.Model.entities;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "User.findUserBySubstr", query = "SELECT u FROM User u WHERE substring(u.firstName,1, length(:subStr) ) " +
                "= :subStr and u.coach.coachId = :coachId ")
        ,@NamedQuery(name = "User.findUserByCoachId", query = "SELECT u FROM User u WHERE u.coach.coachId = :coachId")
})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private String gender;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "coach_id", referencedColumnName = "coach_id")
    private Coach coach;

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Coach getCoach() { return this.coach; }

    public void setCoach(Coach coachId) {
        this.coach = coach;
    }
}
