package Tables;

public class package_of_safe {

    private int safe_id;
    private String description;

    public package_of_safe(int number_id, String description) {
        this.safe_id = number_id;
        this.description = description;
    }

    public int getSafe_id() {
        return safe_id;
    }

    public void setSafe_id(int safe_id) {
        this.safe_id = safe_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "package_of_safe{" +
                "number_id=" + safe_id +
                " description='" + description + '\'' +
                '}';
    }
}
