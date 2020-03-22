package se.ec.johan.formbindingassignment.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static se.ec.johan.formbindingassignment.constants.messages.ValidationMessages.*;
import static se.ec.johan.formbindingassignment.constants.regex.RegexPatterns.*;

public class CustomerFormDto {

    @NotBlank(message = FIELD_REQUIRED_MESSAGE)
    @Email(regexp = EMAIL_REGEX, flags = Pattern.Flag.CASE_INSENSITIVE, message = EMAIL_FORMAT_MESSAGE)
    private String email;

    @NotBlank(message = FIELD_REQUIRED_MESSAGE)
    @Size(min = 2, max = 255, message = NAME_MESSAGE)
    private String name;

    private String streetAddress;

    @Pattern(regexp = ZIPCODE_REGEX, message = ZIPCODE_MESSAGE)
    private String zipCode;
    private String city;

    @NotBlank(message = FIELD_REQUIRED_MESSAGE)
    @Pattern(regexp = PHONE_REGEX, message = PHONE_MESSAGE)
    private String phoneNumber;

    @NotBlank(message = FIELD_REQUIRED_MESSAGE)
    @Pattern(regexp = PASSWORD_REGEX, flags = Pattern.Flag.CASE_INSENSITIVE, message = PASSWORD_MESSAGE)
    private String password;

    @NotBlank(message = FIELD_REQUIRED_MESSAGE)
    private String passwordConfirm;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
