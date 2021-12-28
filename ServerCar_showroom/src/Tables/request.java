package Tables;

public class request {
    private int request_id;
    private int client;
    private String status;

    public String getStatus() {
        return status;
    }

    public request(int number_id, int client, String status) {
        this.request_id = number_id;
        this.client = client;
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public request() {
    }

    public request(int client, String status) {
        this.client = client;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Заявка{" +
                "id= " + request_id +
                " Клиент= " + client +
                "Статус= " + status +
                '}';
    }




    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }


}
