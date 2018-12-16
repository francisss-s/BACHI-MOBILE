package cl.uach.inf.bachimovil;

public class Material {

    private int number;
    private String name;
    private String url;
    private String date;
    private String description;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

}
