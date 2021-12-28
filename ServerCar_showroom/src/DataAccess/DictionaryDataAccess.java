package DataAccess;

import Tables.*;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import configuration.Configur;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDataAccess implements DictionaryDA_Car_showroomDB {

    private static final String ALL_GET_CLIENT = "SELECT * FROM client";
    private static final String GET_CLIENT = "SELECT client_id,surname,name_of_client,patronymic,passport_serial_and_number,telephone_number\n" +
            "From client\n";
    private static final String GET_CLIENT_ID = "SELECT client_id,surname,name_of_client,patronymic,passport_serial_and_number,telephone_number\n" +
            "From client\n" + "Where client_id=?";
    private static final String GET_CLIENT_Surname = "SELECT client_id,surname,name_of_client,patronymic,passport_serial,passport_number,telephone_number\n" +
            "From client\n" + "Where UPPER(surname) LIKE UPPER(?)";
    private static final String GET_CLIENT_Number = "SELECT client_id,surname,name_of_client,patronymic,passport_serial,passport_number,telephone_number\n" +
            "From client\n" + "Where UPPER(telephone_number) LIKE UPPER(?)";

    private static final String GET_CLIENT_NAME_AND_AUTO = "SELECT client.surname,client.name_of_client,client.patronymic,client.telephone_number,request_auto.request,request_auto.date_of_request,auto.mark\n" +
            "FROM client,request,request_auto,auto\n" +
            "WHERE client.client_id=request.client AND request.client=request_auto.request AND request_auto.auto=auto.number_id AND request_auto.date_of_request like(?)";
    private static final String GET_CLIENT_NAME_AUTO = "SELECT client.surname,client.name_of_client,client.patronymic,client.telephone_number,request_auto.request_auto_id,mark.naming,model.model_name\n" +
            "FROM client,request,request_auto,auto,mark,model\n" +
            "WHERE client.client_id=request.client AND request.request_id=request_auto.request AND request_auto.auto=auto.auto_id AND auto.mark=mark.mark_id AND auto.model=model.model_id ";
    private static final String GET_CLIENT_TAKEN_THE_AUTO = "SELECT client.surname,client.name_of_client,client.patronymic,client.telephone_number,request_auto.request_auto_id,mark.naming,model.model_name\n" +
            "FROM client,request,request_auto,auto,mark,model\n" +
            "WHERE client.client_id=request.client AND request.client=request_auto.request AND request_auto.auto=auto.auto_id AND auto.model=model.model_id AND model.model_id=? ";
    private static final String GET_CLIENT_NAME_DATE = "SELECT client.surname,client.name_of_client,client.patronymic,client.telephone_number,request_auto.request,request_auto.date_of_request,mark.naming,model.model_name\n" +
            "FROM client,request,request_auto,auto,mark,model\n" +
            "WHERE client.client_id=request.client AND request.request_id=request_auto.request AND request_auto.auto=auto.auto_id AND auto.mark=mark.mark_id AND auto.model=model.model_id  AND request_auto.date_of_request=?";
    private static final String GET_WHEELS = "SELECT wheels_id, radius, bolt_pattern, width\n" +
            "\tFROM wheels;";
    private static final String COMBINATION_CLIENT_CAR_EQUIPMENT = "SELECT client.surname,client.name_of_client,client.patronymic,client.telephone_number,request_auto.request,request_auto.date_of_request,mark.naming,\n" +
            "model.model_name,color.naming_col,auto.price,package_of_safe.description,wheels.radius,wheels.width,finishing_cabin.naming_f\n" +
            "FROM client,request_auto,auto,package_of_safe,wheels,finishing_cabin,option_of_auto,mark,model,color,request\n" +
            "WHERE client.client_id=request.client AND request.request_id=request_auto.request AND request_auto.auto=auto.auto_id AND auto.mark=mark.mark_id AND auto.model=model.model_id\n" +
            "AND auto.color=color.color_id AND auto.option_of_auto=option_of_auto.option_id AND option_of_auto.package_of_safe=package_of_safe.safe_id \n" +
            "AND option_of_auto.wheels= wheels.wheels_id AND option_of_auto.finishing_cab=finishing_cabin.cabin_id AND request_auto.request_auto_id=?";
    private static final String COMBINATION__CAR_EQUIPMENT = "SELECT mark.naming,model.model_name,finishing_cabin.naming_f,package_of_safe.description,wheels.radius,wheels.bolt_pattern,wheels.width\n" +
            "FROM mark,model,equipment,finishing_cabin,package_of_safe,wheels,auto,option_of_auto\n" +
            "WHERE auto.mark=mark.mark_id AND auto.model=model.model_id AND auto.equipment=equipment.equipment_id AND auto.option_of_auto=option_of_auto.option_id AND option_of_auto.finishing_cab=finishing_cabin.cabin_id\n" +
            "AND option_of_auto.package_of_safe=package_of_safe.safe_id AND  option_of_auto.wheels=wheels.wheels_id and auto.auto_id=?";
    private static final String QUANTITY_OF_CAR_BY_CLIENT="SELECT client.surname,client.name_of_client,client.patronymic,client.telephone_number,request.request_id,count(request_auto.auto) as autos\n" +
            "            FROM client,request_auto,request,auto\n" +
            "            WHERE client.client_id=request.client AND request.request_id=request_auto.request AND request_auto.auto=auto.auto_id \n" +
            "\t\t\tGROUP BY client.surname,client.name_of_client,client.patronymic,client.telephone_number,request.request_id\n" +
            "            HAVING count(request_auto.auto)>=2";

    private static final String UPDATE_STATUS_OF_REQUEST = "UPDATE request SET status =? WHERE request_id=? ";
    private Object equipment;

    private Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");//зарегистрировали класс в драйвер менеджере
        Connection conn = DriverManager.getConnection(Configur.getProperties(Configur.DB_URL), Configur.getProperties(Configur.DB_LOGIN), Configur.getProperties(Configur.DB_PASSWORD));
        return conn;
    }

    @Override
    public List<client> findClient(String pattern) throws Exception {
        List<client> result_of_query = new LinkedList<>();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(GET_CLIENT_Surname))//PreparedStatement для вствки в запрос определенного параметра
        {//для автоматического закрытия подключения, так как Connection автоматически закрывает подключение, если коннектион создастся, то попадем в блок try
            stmt.setString(1, "%" + pattern + "%");
            //stmt.setInt(1,Integer.parseInt(pattern));
            ResultSet rs = stmt.executeQuery();

         /*  Statement stmt = conn.createStatement();//для создания запроса
            ResultSet rs = stmt.executeQuery(GET_CLIENT_ID+pattern);*/


            while (rs.next()) {
                client client = new client(rs.getInt("client_id"), rs.getString("Surname"), rs.getString("name_of_client"), rs.getString("patronymic"),
                        rs.getInt("passport_serial"), rs.getInt("passport_number"),
                        rs.getString("telephone_number"));
                result_of_query.add(client);
            }

          /* if (result_of_query.size() == 0) {
               System.out.println("The table Client doesn't have data");
           }*/

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result_of_query;
    }

    @Override
    public List<client> findClientByNumber(String number) throws Exception {
        List<client> result_of_query = new LinkedList<>();

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(GET_CLIENT_Number)) {
            stmt.setString(1, "%" + number + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                client client = new client(rs.getInt("client_id"), rs.getString("surname"), rs.getString("name_of_client"), rs.getString("patronymic"),
                        rs.getInt("passport_serial"), rs.getInt("passport_number"),
                        rs.getString("telephone_number"));
                result_of_query.add(client);
            }

            /*if (result_of_query.size() == 0) {
                System.out.println("The table Client doesn't have data");
               // result_of_query.add(new client(0,"The table Client doesn't have data","","",0,0,""));
            }*/

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result_of_query;

    }

    @Override
    public List<auto> findAuto() throws Exception {
        List<auto> result_query = new LinkedList<>();
        try (Connection con = getConnection()) {
            Statement stmt = con.createStatement();


            ResultSet re = stmt.executeQuery("Select * from auto");


            while (re.next()) {

                auto car = new auto(re.getInt("auto_id"), re.getInt("mark"), re.getInt("model"), re.getInt("equipment"), re.getInt("option_of_auto"), re.getInt("color"), re.getDouble("price"));
                result_query.add(car);
            }

            if (result_query.size() == 0) {
                System.out.println("The table auto doesn't have data");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return result_query;
    }


    @Override
    public List<wheels> allWheels() throws Exception {
        List<wheels> result_query = new LinkedList<>();
        try (Connection con = getConnection()) {
            Statement stmt = con.createStatement();


            ResultSet re = stmt.executeQuery(GET_WHEELS);


            while (re.next()) {

                wheels wh = new wheels(re.getInt("wheels_id"), re.getInt("radius"), re.getString("bolt_pattern"), re.getInt("width"));
                result_query.add(wh);
            }

            if (result_query.size() == 0) {
                System.out.println("The table wheels doesn't have data");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return result_query;
    }


    @Override
    public List<equipment> allEquipment() throws Exception {
        List<equipment> eq = new LinkedList<>();

        try (Connection con = getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("Select * from equipment");

            while (res.next()) {
                equipment equ = new equipment(res.getInt("equipment_id"), res.getString("naming"));
                eq.add(equ);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return eq;
    }

    public List<String> findClientAUTO(/*String date*//*int date,int month,int year*/) throws Exception {
        List<String> result_of_query = new LinkedList<>();


        try (Connection conn = getConnection();) {
            Statement stmt = conn.createStatement();//для создания запроса
            ResultSet rs = stmt.executeQuery(GET_CLIENT_NAME_AUTO);

            while (rs.next()) {
                String str = new String(rs.getString("surname") + " " + rs.getString("name_of_client") + " " + rs.getString("patronymic") + " " + rs.getString("telephone_number")
                        + " Номер заявки: " + rs.getString("request_auto_id") + " " + "Автомобиль: " + rs.getString("naming") + " Модель " + rs.getString("model_name"));
                result_of_query.add(str);
            }

            if (result_of_query.size() == 0) {
                System.out.println("The table Client doesn't have data");
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result_of_query;
    }


    @Override
    public List<String> findClientByAuto(int model) throws Exception {
        List<String> clientAuto = new LinkedList<>();

        try (Connection con = getConnection(); PreparedStatement statement = con.prepareStatement(GET_CLIENT_TAKEN_THE_AUTO)) {
            statement.setInt(1, model);
            ResultSet rs = statement.executeQuery();

            /*"SELECT client.surname,client.name_of_client,client.patronymic,client.telephone_number,request_auto.request_auto_id,auto.mark\n" +
            "FROM client,request,request_auto,auto\n" +
            "WHERE client.client_id=request.client AND request.request_id=request_auto.request_auto_id AND request_auto.auto=auto.auto_id " ;*/

            while (rs.next()) {
                String str = new String(rs.getString("surname") + " " + rs.getString("name_of_client") + " " + rs.getString("patronymic") + " " + rs.getString("telephone_number")
                        + " " + rs.getString("request_auto_id") + " " + rs.getString("naming") + " " + rs.getString("model_name"));
                clientAuto.add(str);
            }
           /* if (clientAuto.size() == 0) {
                System.out.println("There aren't clients with this car");
            }*/

        } catch (SQLException exception) {
            System.out.println(exception);
        }
        return clientAuto;
    }

    public List<String> findClientDate(String date) throws Exception {
        List<String> result_of_query = new LinkedList<>();

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(GET_CLIENT_NAME_DATE))//PreparedStatement для вствки в запрос определенного параметра
        {//для автоматического закрытия подключения, так как Connection автоматически закрывает подключение, если коннектион создастся, то попадем в блок try

            stmt.setDate(1, Date.valueOf(date));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String str = new String("ФИО: " + rs.getString("surname") + " " + rs.getString("name_of_client") + " " + rs.getString("patronymic") + " Телефон: " + rs.getString("telephone_number")
                        + " Дата заявки: " + rs.getDate("date_of_request") /*rs.getString("date_of_request")*/ + " Автомобиль: " + rs.getString("naming") + " " + rs.getString("model_name"));

                result_of_query.add(str);
            }

            if (result_of_query.size() == 0) {
                System.out.println("The table Client doesn't have data");
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result_of_query;
    }

    public StringBuilder updateStatusRequest(Integer request, String status) throws Exception {
        StringBuilder str = null;
        boolean s = false;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_STATUS_OF_REQUEST, new String[]{"request_id"})) {

            stmt.setInt(2, request);
            stmt.setString(1, status);

            stmt.executeUpdate();//исполнение команды, которая меняет данные, возвр. int(число записей измененное данное командой,в данном случае меняем только у одной записи статус)
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                str = new StringBuilder("Заявка №" + rs.getString(1) + " обновлена на статус: " + status);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return str;
    }

    @Override
    public List<finishing_materials> allFinishing_materials() throws Exception {
        List<finishing_materials> materials = new LinkedList<>();

        try (Connection con = getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("Select * from finishing_materials");

            while (res.next()) {
                finishing_materials mat = new finishing_materials(res.getInt("materials_id"), res.getString("naming_of_rope"));
                materials.add(mat);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return materials;
    }

    @Override
    public List<color> allColor() throws Exception {
        List<color> color = new LinkedList<>();

        try (Connection con = getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("Select * from color");

            while (res.next()) {
                color col = new color(res.getInt("color_id"), res.getString("naming_col"));
                color.add(col);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return color;

    }

    @Override
    public List<finishing_cabin> allFinishingCabin() throws Exception {
        List<finishing_cabin> fincab = new LinkedList<>();

        try (Connection con = getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from finishing_cabin");

            while (rs.next()) {
                finishing_cabin cab = new finishing_cabin(rs.getInt("cabin_id"), rs.getInt("finishing_materials_fk"), rs.getString("naming_f"));
                fincab.add(cab);
            }


        }


        return fincab;
    }

    @Override
    public List<option_of_auto> allOption() throws Exception {

        List<option_of_auto> opt = new LinkedList<>();

        try (Connection con = getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from option_of_auto");

            while (rs.next()) {
                option_of_auto option = new option_of_auto(rs.getInt("option_id"), rs.getInt("finishing_cab"), rs.getInt("wheels"), rs.getInt("package_of_safe"));
                opt.add(option);
            }
        }

        return opt;

    }

    @Override
    public List<package_of_safe> allSafe() throws Exception {
        List<package_of_safe> safes = new LinkedList<>();

        try (Connection con = getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from package_of_safe");

            while (rs.next()) {
                package_of_safe pack = new package_of_safe(rs.getInt("safe_id"), rs.getString("description"));
                safes.add(pack);
            }
        }

        return safes;
    }

    @Override
    public List<request_auto> allRequest() throws Exception {

        List<request_auto> req = new LinkedList<>();

        try (Connection con = getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select *from request_auto");

            while (rs.next()) {
                request_auto au = new request_auto(rs.getInt("request_auto_id"), rs.getInt("request"), rs.getInt("auto"), rs.getString("date_of_request"));
                req.add(au);
            }
        }

        return req;

    }

    @Override
    public List<request> allRequestFromClient() throws Exception {
        List<request> req = new LinkedList<>();

        try (Connection con = getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from request");

            while (rs.next()) {
                request request = new request(rs.getInt("request_id"), rs.getInt("client"), rs.getString("status"));
                req.add(request);
            }
        }

        return req;
    }

    @Override
    public List<StringBuilder> combinationClientCarEquipment(int request) throws Exception {
        List<StringBuilder> req = new LinkedList<>();
        StringBuilder str;
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(COMBINATION_CLIENT_CAR_EQUIPMENT);
            stmt.setInt(1, request);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                str = new StringBuilder(rs.getString("surname") + " " + rs.getString("name_of_client") + " " + rs.getString("patronymic") + " Телефон: " +
                        rs.getString("telephone_number") + "; Заявка № " + rs.getInt("request") + "; Дата " + rs.getString("date_of_request") + "; Марка: " + rs.getString("naming") + "; Модель: " +
                        rs.getString("model_name") + "; Цвет: " + rs.getString("naming_col") + "; Цена автомобиля: " + rs.getInt("price") + "; Пакет безопасности: " + rs.getString("description") + "; Диаметр дисков: " + rs.getString("radius") + "; Ширина колес: " + rs.getString("width") + "; Комплектация: " + rs.getString("naming_f"));
                req.add(str);
            }
        }

        return req;
    }


    @Override
    public List<StringBuilder> combinationCarEquipmentInStore(int auto_id) throws Exception {
        List<StringBuilder> req = new LinkedList<>();
        StringBuilder str;
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(COMBINATION__CAR_EQUIPMENT);
            stmt.setInt(1, auto_id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                str = new StringBuilder(rs.getString("naming") + " " + rs.getString("model_name") + " " + " Отделка салона " +
                        rs.getString("naming_f") + "; Пакет безопасности " + rs.getString("description") + "; Диаметр диска " + rs.getString("radius") + "; Разболтовка: " + rs.getString("bolt_pattern") + "; Ширина колес: " +
                        rs.getString("width") );
                req.add(str);
            }
        }

        return req;

    }

    @Override
    public List<StringBuilder> quantityCarMoreThanOne() throws Exception {
        List<StringBuilder> req = new LinkedList<>();
        StringBuilder str;
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(QUANTITY_OF_CAR_BY_CLIENT);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                str = new StringBuilder(rs.getString("surname") + " " + rs.getString("name_of_client") + " "+ rs.getString("patronymic") + "; Телефон: " + rs.getString("telephone_number") +
                       "; Номер заявки "+ rs.getString("request_id") + "; Количество автомобилей: " + rs.getString("autos"));
                        req.add(str);
            }
        }

        return req;


    }
}
