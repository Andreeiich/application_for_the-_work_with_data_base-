package Tables;

public class finishing_cabin {

    private int cabin_id;
    private int finishing_materials_fk;
    private String naming;

    public finishing_cabin(int number_id, int finishing_materials_fk, String naming) {
        this.cabin_id = number_id;
        this.finishing_materials_fk = finishing_materials_fk;
        this.naming = naming;
    }

    public int getCabin_id() {
        return cabin_id;
    }

    public void setCabin_id(int cabin_id) {
        this.cabin_id = cabin_id;
    }

    public int getFinishing_materials_fk() {
        return finishing_materials_fk;
    }

    public void setFinishing_materials_fk(int finishing_materials_fk) {
        this.finishing_materials_fk = finishing_materials_fk;
    }

    public String getNaming() {
        return naming;
    }

    public void setNaming(String naming) {
        this.naming = naming;
    }

    @Override
    public String toString() {
        return " id: " + cabin_id +
                " Идентификатор выбранной отделки: " + finishing_materials_fk +
                " Наименование: " + naming;
    }
}
