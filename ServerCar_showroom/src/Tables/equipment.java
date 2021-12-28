package Tables;

public class equipment {

    private int equipment_id;
    private String naming;

    @Override
    public String toString() {
        return "equipment{" +
                "number_id=" + equipment_id +
                " naming='" + naming + '\'' +
                '}';
    }

    public equipment() {
    }

    public equipment(int number_id, String naming) {
        this.equipment_id = number_id;
        this.naming = naming;
    }

    public int getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(int equipment_id) {
        this.equipment_id = equipment_id;
    }

    public String getNaming() {
        return naming;
    }

    public void setNaming(String naming) {
        this.naming = naming;
    }
}
