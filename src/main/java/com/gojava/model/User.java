package com.gojava.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Simple JavaBean domain object that represents a Room in a hotel.
 *
 * @author Firsov
 * @version 1.0
 */

public class User implements Serializable, HaveId {

    private static final long serialVersionUID = 1L;

    private long id;
    private String firstName;
    private String lastName;
    private Set<Long> ids;

    public User(String firstName, String lastName) {
        id = IdGenerator.getRandomId();
        this.firstName = firstName;
        this.lastName = lastName;
        ids = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Long> getRooms() {
        return ids;
    }

    public void setRooms(Set<Long> ids) {
        this.ids = ids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        return ids != null ? ids.equals(user.ids) : user.ids == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (ids != null ? ids.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", room ids=" + ids.toArray().toString() +
                '}';
    }
}
