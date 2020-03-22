package se.ec.johan.formbindingassignment.entity;

import java.util.Objects;
import java.util.UUID;

public class CustomerDetails {

    private String detailsId;
    private String name;
    private String streetAddress;
    private String zipCode;
    private String city;
    private String phoneNumber;

    public CustomerDetails(){}

    public CustomerDetails(String name, String streetAddress, String zipCode, String city, String phoneNumber) {
        this.detailsId = UUID.randomUUID().toString();
        this.name = name;
        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    public String getDetailsId() {
        return detailsId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDetails that = (CustomerDetails) o;
        return Objects.equals(detailsId, that.detailsId) &&
                Objects.equals(streetAddress, that.streetAddress) &&
                Objects.equals(zipCode, that.zipCode) &&
                Objects.equals(city, that.city) &&
                Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detailsId, streetAddress, zipCode, city, phoneNumber);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomerDetails{");
        sb.append("detailsId='").append(detailsId).append('\'');
        sb.append(", streetAddress='").append(streetAddress).append('\'');
        sb.append(", zipCode='").append(zipCode).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
