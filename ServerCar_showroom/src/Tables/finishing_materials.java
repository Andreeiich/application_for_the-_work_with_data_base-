package Tables;

public class finishing_materials {
    private int number_id;
    private String naming_of_rope;




    public finishing_materials(int number_id, String naming_of_rope) {
        this.number_id = number_id;
        this.naming_of_rope = naming_of_rope;
    }


    @Override
    public String toString() {
        return "Материал отделки " +
                "id: " + number_id +
                " наименование нити:" + naming_of_rope;
    }
    public int getNumber_id() {
        return number_id;
    }

    public void setNumber_id(int number_id) {
        this.number_id = number_id;
    }

    public String getNaming_of_rope() {
        return naming_of_rope;
    }

    public void setNaming_of_rope(String naming_of_rope) {
        this.naming_of_rope = naming_of_rope;
    }
}
