package com.example.projet_web.Model.entities;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "coach")
@NamedQueries({
        @NamedQuery(name = "Coach.findAllCoach",query = "select c from Coach c")
        , @NamedQuery(name = "Coach.findCoachById",query = "select c from Coach c where c.coachId = :coachId")
        , @NamedQuery(name = "Coach.findAllCoachByFirstNameSubString",query = "select c from Coach c where substring(c.firstName, 1, length(:subStr)) = :subStr")
        , @NamedQuery(name = "Coach.findCoachsOrderByLeastUsed",query = "Select c from Coach c LEFT JOIN User u ON c.coachId = u.coach.coachId GROUP BY c.coachId Order By count(u.coach.coachId) asc")
})
@NoArgsConstructor //Lombok
@AllArgsConstructor
public class Coach implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coach_id")
    private Long coachId;

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

    @Column(name = "description")
    private String description;

    public Long getCoachId() {
        return this.coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
