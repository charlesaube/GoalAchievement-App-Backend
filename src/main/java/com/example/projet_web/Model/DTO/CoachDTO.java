package com.example.projet_web.Model.DTO;
public class CoachDTO {
    private Long coachId;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String password;
    private String description;
    public CoachDTO(){}

    public CoachDTO(Long coachId, String firstName, String lastName, String email, String gender, String password, String description) {
        this.coachId = coachId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.description = description;
    }

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
