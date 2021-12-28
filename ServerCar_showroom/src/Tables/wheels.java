package Tables;

public class wheels {

    private int wheels_id;
    private int radius;
    private String bolt_pattern;
    private int width;


    public wheels(int wheels_id, int radius, String bolt_pattern, int width) {
        this.wheels_id = wheels_id;
        this.radius = radius;
        this.bolt_pattern = bolt_pattern;
        this.width = width;
    }

    @Override
    public String toString() {
        return  "wheels_id= " + wheels_id +
                " radius= " + radius +
                " bolt_pattern= '" + bolt_pattern +
                " width= " + width;
    }

    public int getWheels_id() {
        return wheels_id;
    }

    public void setWheels_id(int wheels_id) {
        this.wheels_id = wheels_id;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getBolt_pattern() {
        return bolt_pattern;
    }

    public void setBolt_pattern(String bolt_pattern) {
        this.bolt_pattern = bolt_pattern;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
