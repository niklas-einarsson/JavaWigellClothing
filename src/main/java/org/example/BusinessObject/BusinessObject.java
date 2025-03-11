package org.example.BusinessObject;

public abstract class BusinessObject {

    private static int nextId = 1;
    protected int id;
    protected String name;

    public BusinessObject(int id, String name) {
        this.id = nextId++;
        this.name = name;
    }

    public BusinessObject() {
        this.id = nextId++;
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

    @Override
    public String toString() {
        return "BusinessObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
