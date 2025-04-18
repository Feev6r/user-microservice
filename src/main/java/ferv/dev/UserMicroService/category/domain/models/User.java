package ferv.dev.UserMicroService.category.domain.models;

import java.time.LocalDate;

public class User {

    private Long id;
    private Role role;
    private String firstname;
    private String lastname;
    private String identityNumber;
    private String phoneNumber;
    private LocalDate birthdate;
    private String email;
    private String password;

    public User(Long id, Role role, String firstname, String lastname, String identityNumber, String phoneNumber,
                LocalDate birthdate, String email, String password) {
        this.id = id;
        this.role = role;
        this.firstname = firstname;
        this.lastname = lastname;
        this.identityNumber = identityNumber;
        this.phoneNumber = phoneNumber;
        this.birthdate = birthdate;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {this.id = id;}
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getIdentityNumber() {
        return identityNumber;
    }
    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Role getRole() {return role;}
    public void setRole(Role role) {this.role = role;}
    public LocalDate getBirthdate() {return birthdate;}
    public void setBirthdate(LocalDate birthdate) {this.birthdate = birthdate;}

}
