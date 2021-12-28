package Tables;

public class auto {

    private int auto_id;
    private int mark;
    private int model;
    private int equipment;
    private int option_of_auto;
    private int color;
    private double price;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public auto() {
    }

    @Override
    public String toString() {
        return "auto{" +
                "auto_id=" + auto_id +
                " mark='" + mark + '\'' +
                " model='" + model + '\'' +
                " equipment=" + equipment +
                " option_of_auto=" + option_of_auto +
                " color=" + color +
                " price=" + price +
                '}';
    }

    public int getAuto_id() {
        return auto_id;
    }

    public void setAuto_id(int auto_id) {
        this.auto_id = auto_id;
    }



    public int getNumber_id() {
        return auto_id;
    }

    public void setNumber_id(int number_id) {
        this.auto_id = number_id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }



    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public auto(int auto_id, int mark, int model, int equipment, int option_of_auto, int color, double price) {
        this.auto_id = auto_id;
        this.mark = mark;
        this.model = model;
        this.equipment = equipment;
        this.option_of_auto = option_of_auto;
        this.color = color;
        this.price = price;
    }

    public auto(int auto_id){
        this.auto_id = auto_id;
    }

    public int getOption_of_auto() {
        return option_of_auto;
    }

    public void setOption_of_auto(int option_of_auto) {
        this.option_of_auto = option_of_auto;
    }

    public int getEquipment() {
        return equipment;
    }

    public void setEquipment(int equipmen) {
        this.equipment=equipmen;
    }
}
