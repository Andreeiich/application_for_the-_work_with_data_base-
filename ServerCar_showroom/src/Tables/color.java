package Tables;

public class color {

    private int color_id;
    private String naming;


    public color(int color_id, String naming) {
        this.color_id = color_id;
        this.naming = naming;
    }

    public int getColor_id() {
        return color_id;
    }

    public void setColor_id(int color_id) {
        this.color_id = color_id;
    }

    public String getNaming() {
        return naming;
    }

    public void setNaming(String naming) {
        this.naming = naming;
    }

    @Override
    public String toString() {
        return "Цвет " +
                "id=" + color_id +
                " Наименование=" + naming;
    }
}
