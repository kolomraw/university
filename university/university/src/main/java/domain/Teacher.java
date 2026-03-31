package domain;

public class Teacher {

    private int id;
    private int idChair;
    private int idPost;

    private String firstName;
    private String secondName;
    private String lastName;
    private String phone;
    private String email;

    private String chairName;
    private String postName;
    private String facultyName;

    public Teacher() {}

    public Teacher(int idChair, int idPost,
                   String firstName, String secondName, String lastName,
                   String phone, String email) {
        this.idChair = idChair;
        this.idPost = idPost;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public Teacher(int id, int idChair, int idPost,
                   String firstName, String secondName, String lastName,
                   String phone, String email) {
        this.id = id;
        this.idChair = idChair;
        this.idPost = idPost;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdChair() { return idChair; }
    public void setIdChair(int idChair) { this.idChair = idChair; }

    public int getIdPost() { return idPost; }
    public void setIdPost(int idPost) { this.idPost = idPost; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getSecondName() { return secondName; }
    public void setSecondName(String secondName) { this.secondName = secondName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getChairName() { return chairName; }
    public void setChairName(String chairName) { this.chairName = chairName; }

    public String getPostName() { return postName; }
    public void setPostName(String postName) { this.postName = postName; }

    public String getFacultyName() { return facultyName; }
    public void setFacultyName(String facultyName) { this.facultyName = facultyName; }
}