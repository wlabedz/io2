package com.ioproject.carent;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.List;

@Document(collection="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private ObjectId id;
    private int userId;
    private String username;
    private String name;
    private String surname;
    private String email;
    private int phoneNumber;
    private int birthYear;
    private int birthMonth;
    private int birthDay;
    private int addressId;
    private String seriesDriverLicense;
    private boolean loggedIn;
    private String password;

    private Collection<Role> roles;

    public User(int user_id, String username, String name, String surname, String email, int phoneNumber, int birthYear, int birthMonth, int birthDay, String seriesDriverLicense, String password, List<Role> roles){
        setUserId(user_id);
        setUsername(username);
        setName(name);
        setSurname(surname);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setBirthDay(birthDay);
        setBirthMonth(birthMonth);
        setBirthYear(birthYear);
        setAddressId(user_id);
        setSeriesDriverLicense(seriesDriverLicense);
        setPassword(password);
        setLoggedIn(false);
        setRoles(roles);
        setId(new ObjectId());
    }


}
