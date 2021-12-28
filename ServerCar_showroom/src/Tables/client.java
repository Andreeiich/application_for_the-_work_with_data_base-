package Tables;

public class client {



    private Integer client_id;
    private String Surname;
    private String name_of_client;
    private String patronymic;
    private int passport_serial;
    private int passport_number;
    private String telephone_number;


    public client() {
    }


    public client(Integer client_id, String surname, String name_of_client, String patronymic,int passport_number, int passport_serial,  String telephone_number) {
        this.client_id = client_id;
        Surname = surname;
        this.name_of_client = name_of_client;
        this.patronymic = patronymic;
        this.passport_number = passport_number;
        this.passport_serial = passport_serial;
        this.telephone_number = telephone_number;
    }

    @Override
    public String toString() {
        return "Клиент{" +
                "ID:=" + client_id +
                  " " + Surname + '\'' +
                " " + name_of_client + '\'' +
                " " + patronymic + '\'' +
                " Паспорт Серия: " + passport_serial +
                " Паспорт номер: " + passport_number +
                " Номер телефона: '" + telephone_number + '\'' +
                '}';
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getName_of_client() {
        return name_of_client;
    }

    public void setName_of_client(String name_of_client) {
        this.name_of_client = name_of_client;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getPassport_serial() {
        return passport_serial;
    }

    public void setPassport_serial(int passport_serial) {
        this.passport_serial = passport_serial;
    }

    public int getPassport_number() {
        return passport_number;
    }

    public void setPassport_number(int passport_number) {
        this.passport_number = passport_number;
    }

    public String getTelephone_number() {
        return telephone_number;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }
}
