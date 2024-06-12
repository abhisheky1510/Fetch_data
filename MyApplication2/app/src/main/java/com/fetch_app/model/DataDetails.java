package com.fetch_app.model;

public class DataDetails {
    private int id;
    private int listId;
    private String name;

    public DataDetails(int id, int listId, String name) {
        this.id = id;
        this.listId = listId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getListId() {
        return listId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "DataDetails{" +
                "id=" + id +
                ", listId=" + listId +
                ", name='" + name + '\'' +
                '}';
    }
}
