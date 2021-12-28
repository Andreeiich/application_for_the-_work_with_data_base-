package DataAccess;

import Tables.*;
import configuration.Configur;

import java.sql.*;

public class DictionaryDataInput implements DictionaryDI_Car_showroomDB {

    private static final String INSERT_AUTO = "INSERT INTO auto(auto_id, mark,model, equipment, option_of_auto, color, price) VALUES (?, ?,?, ?, ?, ?, ?);";
    private static final String INSERT_CLIENT = "INSERT INTO client(\n" +
            "\t surname, name_of_client, patronymic, passport_serial, passport_number, telephone_number)\n" +
            "\tVALUES (?, ?, ?, ?, ?, ?);";
    private static final String INSERT_EQUIPMENT = "INSERT INTO equipment(\n" +
            "\tequipment_id, naming)\n" +
            "\tVALUES (?, ?);";
    private static final String INSERT_FINISHING_MATERIAL = "INSERT INTO finishing_materials(\n" +
            "\tmaterials_id, naming_of_rope)\n" +
            "\tVALUES (?, ?);";
    private static final String INSERT_COLOR = " INSERT INTO color(color_id, naming)  VALUES (?, ?);";
    private static final String INSERT_FINISHING_CABIN="INSERT INTO finishing_cabin(\n" +
            "\tcabin_id, finishing_materials_fk, naming_f)\n" +
            "\tVALUES (?, ?, ?);";
    private static final String INSERT_WHEELS="INSERT INTO public.wheels(\n" +
            "\twheels_id, radius, bolt_pattern, width)\n" +
            "\tVALUES (?, ?, ?, ?);";
    public static final  String INSERT_OPTIONS="INSERT INTO public.option_of_auto(\n" +
            "\toption_id, finishing_cab, wheels, package_of_safe)\n" +
            "\tVALUES (?, ?, ?, ?);";
    public static final  String INSERT_REQUEST="INSERT INTO request(client, status) VALUES (?, ?);";


    private Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");//зарегистрировали класс в драйвер менеджере
        Connection conn = DriverManager.getConnection(Configur.getProperties(Configur.DB_URL), Configur.getProperties(Configur.DB_LOGIN), Configur.getProperties(Configur.DB_PASSWORD));
        return conn;
    }

    @Override
    public int insertAuto(auto autos) throws Exception {
        int res = 0;

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_AUTO, new String[]{"auto_id"})) {

            conn.setAutoCommit(false);//для самостоятельного управления транзакцией
            try {
                stmt.setInt(1, autos.getNumber_id());
                stmt.setInt(2, autos.getMark());
                stmt.setInt(3, autos.getModel());
                stmt.setInt(4, autos.getEquipment());
                stmt.setInt(5, autos.getOption_of_auto());
                stmt.setInt(6, autos.getColor());
                stmt.setDouble(7, autos.getPrice());

                stmt.executeUpdate();//исполнение команды, которая меняет данные, возвр. int(число записей измененное данное командой,в данном случае меняем только у одной записи статус)
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    res = rs.getInt(1);
                }
                conn.commit();//выполняется, если нет проблем
            } catch (SQLException ex) {
                conn.rollback();//выполняется, для удаления введенных неполноценных данных
                throw ex;
            }


        } catch (SQLException ex) {
            System.out.println(ex);
        }


        return res;
    }

    @Override
    public int insertClient(client cl) throws Exception {
        int rs = 0;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_CLIENT, new String[]{"client_id"})) {

            conn.setAutoCommit(false);
            try {
                stmt.setString(1, cl.getSurname());
                stmt.setString(2, cl.getName_of_client());
                stmt.setString(3, cl.getPatronymic());
                stmt.setInt(4, cl.getPassport_number());
                stmt.setInt(5, cl.getPassport_serial());
                stmt.setString(6, cl.getTelephone_number());
                stmt.executeUpdate();
                ResultSet res = stmt.getGeneratedKeys();
                while (res.next()) {
                    rs = res.getInt(1);
                }
                conn.commit();//выполняется, если нет проблем

            } catch (SQLException ex) {
                conn.rollback();//выполняется, для удаления введенных неполноценных данных
                throw ex;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return rs;
    }

    @Override
    public int insertEquipment(equipment eq) throws Exception {
        int res = 0;

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_EQUIPMENT, new String[]{"equipment_id"})) {

            conn.setAutoCommit(false);
            try {
                stmt.setInt(1, eq.getEquipment_id());
                stmt.setString(2, eq.getNaming());
                stmt.executeUpdate();
                ResultSet result = stmt.getGeneratedKeys();
                while (result.next()) {
                    res = result.getInt(1);
                }
                conn.commit();//выполняется, если нет проблем

            } catch (SQLException ex) {
                conn.rollback();//выполняется, для удаления введенных неполноценных данных
                throw ex;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }


        return res;
    }

    @Override
    public int insertFinishing_materials(finishing_materials fin) throws Exception {

        int res = 0;

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_FINISHING_MATERIAL, new String[]{"materials_id"})) {


            conn.setAutoCommit(false);
            try {
                stmt.setInt(1, fin.getNumber_id());
                stmt.setString(2, fin.getNaming_of_rope());
                stmt.executeUpdate();
                ResultSet result = stmt.getGeneratedKeys();
                while (result.next()) {
                    res = result.getInt(1);
                }
                conn.commit();//выполняется, если нет проблем
            } catch (SQLException ex) {
                conn.rollback();//выполняется, для удаления введенных неполноценных данных
                throw ex;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return res;
    }


    @Override
    public int insertColor(color col) throws Exception {

        int res = 0;

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_COLOR, new String[]{"color_id"})) {


            conn.setAutoCommit(false);
            try {
                stmt.setInt(1, col.getColor_id());
                stmt.setString(2, col.getNaming());
                stmt.executeUpdate();
                ResultSet result = stmt.getGeneratedKeys();
                while (result.next()) {
                    res = result.getInt(1);
                }
                conn.commit();//выполняется, если нет проблем
            } catch (SQLException ex) {
                conn.rollback();//выполняется, для удаления введенных неполноценных данных
                throw ex;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return res;


    }

    @Override
    public int insertFinishingCabin(finishing_cabin fc)throws Exception{
        int res=0;

        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(INSERT_FINISHING_CABIN, new String[]{"cabin_id"})) {

            con.setAutoCommit(false);
            try {
                stmt.setInt(1, fc.getCabin_id());
                stmt.setInt(2, fc.getFinishing_materials_fk());
                stmt.setString(3, fc.getNaming());
                stmt.executeUpdate();
                ResultSet result = stmt.getGeneratedKeys();
                while (result.next()) {
                    res = result.getInt("cabin_id");
                }
                con.commit();

            } catch (SQLException ex) {
                con.rollback();
                throw ex;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return res;
    }

 @Override
 public int insertWheels(wheels wh)throws Exception{
     int res=0;

     try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(INSERT_WHEELS, new String[]{"wheels_id"})) {

         con.setAutoCommit(false);
         try {
             stmt.setInt(1, wh.getWheels_id());
             stmt.setInt(2, wh.getRadius());
             stmt.setString(3, wh.getBolt_pattern());
             stmt.setInt(4,wh.getWidth());
             stmt.executeUpdate();
             ResultSet result = stmt.getGeneratedKeys();
             while (result.next()) {
                 res = result.getInt("wheels_id");
             }
             con.commit();

         } catch (SQLException ex) {
             con.rollback();
             throw ex;
         }
     } catch (SQLException ex) {
         System.out.println(ex);
     }

     return res;
 }

    @Override
    public int insertOption(option_of_auto option) throws Exception {
        int res=0;

        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(INSERT_OPTIONS, new String[]{"option_id"})) {

            con.setAutoCommit(false);
            try {
                stmt.setInt(1, option.getOption_id());
                stmt.setInt(2, option.getFinishing_cab());
                stmt.setInt(3, option.getWheels());
                stmt.setInt(4,option.getPackage_of_safe());
                stmt.executeUpdate();
                ResultSet result = stmt.getGeneratedKeys();
                while (result.next()) {
                    res = result.getInt("option_id");
                }
                con.commit();

            } catch (SQLException ex) {
                con.rollback();
                throw ex;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return res;
    }


    @Override
    public int insertRequestClient(request client) throws Exception {

        int res=0;

        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(INSERT_REQUEST, new String[]{"request_id"})) {

            con.setAutoCommit(false);
            try {
                stmt.setInt(1, client.getClient());
                stmt.setString(2, client.getStatus());
                stmt.executeUpdate();
                ResultSet result = stmt.getGeneratedKeys();
                while (result.next()) {
                    res = result.getInt("request_id");
                }
                con.commit();

            } catch (SQLException ex) {
                con.rollback();
                throw ex;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return res;




    }
}
