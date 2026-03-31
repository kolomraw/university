package domain;

public class Faculty {

    private int id;
    private String nameFaculty;
    private String shortNameFaculty;

    public Faculty() {}

    public Faculty(String nameFaculty, String shortNameFaculty) {
        this.nameFaculty = nameFaculty;
        this.shortNameFaculty = shortNameFaculty;
    }

    public Faculty(int id, String nameFaculty, String shortNameFaculty) {
        this.id = id;
        this.nameFaculty = nameFaculty;
        this.shortNameFaculty = shortNameFaculty;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNameFaculty() { return nameFaculty; }
    public void setNameFaculty(String nameFaculty) { this.nameFaculty = nameFaculty; }

    public String getShortNameFaculty() { return shortNameFaculty; }
    public void setShortNameFaculty(String shortNameFaculty) { this.shortNameFaculty = shortNameFaculty; }
}