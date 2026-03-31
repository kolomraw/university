package domain;

public class Post {

    private int id;
    private String namePost;

    public Post() {}

    public Post(String namePost) {
        this.namePost = namePost;
    }

    public Post(int id, String namePost) {
        this.id = id;
        this.namePost = namePost;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNamePost() { return namePost; }
    public void setNamePost(String namePost) { this.namePost = namePost; }
}