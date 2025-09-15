package models;

public class Reader {
    private int id;
    private String name;
    private int user_id;

    public Reader(String name, int user_id) {
        this.name = name;
        this.user_id = user_id;
    }

    public Reader(int id, String name, int user_id) {
        this.id = id;
        this.name = name;
        this.user_id = user_id;
    }

    public Reader() {
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

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

}
