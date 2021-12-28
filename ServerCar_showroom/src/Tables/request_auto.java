package Tables;

public class request_auto {
private int request_auto_id;
private int request;

    @Override
    public String toString() {
        return "{" +
                "request_auto_id=" + request_auto_id +
                " request=" + request +
                " auto=" + auto +
                " date_of_request='" + date_of_request + '\'' +
                '}';
    }

    private int auto;
    private String date_of_request;

    public request_auto(int number_id, int request, int auto, String date) {
        this.request_auto_id = number_id;
        this.request = request;
        this.auto = auto;
        this.date_of_request = date;
    }

    public int getRequest_auto_id() {
        return request_auto_id;
    }

    public void setRequest_auto_id(int request_auto_id) {
        this.request_auto_id = request_auto_id;
    }

    public int getRequest() {
        return request;
    }

    public void setRequest(int request) {
        this.request = request;
    }

    public int getAuto() {
        return auto;
    }

    public void setAuto(int auto) {
        this.auto = auto;
    }

    public String getDate_of_request() {
        return date_of_request;
    }

    public void setDate_of_request(String date_of_request) {
        this.date_of_request = date_of_request;
    }
}
