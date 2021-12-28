package Tables;

public class option_of_auto {

    private int option_id;
    private int finishing_cab;
    private int wheels;
    private int package_of_safe;

    public option_of_auto(int number_id, int finishing_cab, int wheels, int package_of_safe) {
        this.option_id = number_id;
        this.finishing_cab = finishing_cab;
        this.wheels = wheels;
        this.package_of_safe = package_of_safe;
    }

    public int getOption_id() {
        return option_id;
    }

    public void setOption_id(int option_id) {
        this.option_id = option_id;
    }

    public int getFinishing_cab() {
        return finishing_cab;
    }

    public void setFinishing_cab(int finishing_cab) {
        this.finishing_cab = finishing_cab;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public int getPackage_of_safe() {
        return package_of_safe;
    }

    public void setPackage_of_safe(int package_of_safe) {
        this.package_of_safe = package_of_safe;
    }

    @Override
    public String toString() {
        return "option_of_auto{" +
                "number_id=" + option_id +
                " finishing_cab=" + finishing_cab +
                " wheels=" + wheels +
                " package_of_safe=" + package_of_safe +
                '}';
    }
}
