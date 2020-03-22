package se.ec.johan.formbindingassignment.entity;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Customer {

    private String customerId;
    private String email;
    private LocalDate regDate;
    private Boolean active;
    private CustomerDetails details;

    public Customer(){}

    public Customer(String email, CustomerDetails details) {
        this.customerId = UUID.randomUUID().toString();
        this.email = email;
        this.regDate = LocalDate.now();
        this.active = true;
        this.details = details;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public CustomerDetails getDetails() {
        return details;
    }

    public void setDetails(CustomerDetails details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(regDate, customer.regDate) &&
                Objects.equals(active, customer.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, email, regDate, active);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("customerId='").append(customerId).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", regDate=").append(regDate);
        sb.append(", active=").append(active);
        sb.append('}');
        return sb.toString();
    }
}
