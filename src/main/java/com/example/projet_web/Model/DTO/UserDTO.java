package com.example.projet_web.Model.DTO;

public class UserDTO {
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String password;
    private Long coachId;

    public UserDTO(){};
    public UserDTO(Long userId, String firstName, String lastName, String email, String gender, String password, Long coachId) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.coachId = coachId;
    }

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

    public Long getCoachId() {
        return this.coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }
}
