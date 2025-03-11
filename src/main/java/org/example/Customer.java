package org.example;

public class Customer extends BusinessObject {

    private static int nextId = 1;
    String address;
    String email;

    public Customer(int id, String name, String address, String email) {
        this.id = nextId++;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public Customer() {
        this.id = nextId++;
        System.out.println("Ny customer skapad med id " + id);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "address='" + address + '\'' +
                ", email='" + email + '\'' +
                "} " + super.toString();
    }
}
