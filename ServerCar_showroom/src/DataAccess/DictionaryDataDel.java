package DataAccess;

import Tables.auto;
import Tables.request_auto;
import configuration.Configur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDataDel implements DictionaryDDEL_Car_showroomDB {

     public final String DEL_AUTO="DELETE FROM auto\n" +
             "\tWHERE auto_id=?; ";
        public final String DEL_REQUEST_AUTO="DELETE FROM public.request_auto\n" +
                "\tWHERE request_auto_id=?";

    private Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");//зарегистрировали класс в драйвер менеджере
        Connection conn = DriverManager.getConnection(Configur.getProperties(Configur.DB_URL), Configur.getProperties(Configur.DB_LOGIN), Configur.getProperties(Configur.DB_PASSWORD));
        return conn;
    }

    @Override
    public StringBuilder delAuto(int auto_id) throws Exception {
        StringBuilder str=new StringBuilder();
        List<auto> autos=new LinkedList<>();

        try (Connection con=getConnection(); PreparedStatement stmt=con.prepareStatement(DEL_AUTO)){
            autos = new DictionaryDataAccess().findAuto();
            for (int i=0;i<autos.size();i++){
                   if(auto_id==autos.get(i).getAuto_id()){
                       stmt.setInt(1,auto_id);
                       stmt.executeUpdate();
                       ResultSet rs=stmt.getResultSet();
                       str=new StringBuilder(" Запись удалена с идентификатором "+ auto_id);
                       break;
                   }
                   if(auto_id!=autos.get(i).getAuto_id()){
                       str=new StringBuilder(" Записи c данным идентификатором нет в базе данных ");
                   }
               }

        }catch (Exception ex){
            str=new StringBuilder(ex.getMessage());
        }

        return str;
    }


    @Override
    public StringBuilder delRequest(int request_id) throws Exception {
        StringBuilder str=new StringBuilder();
        List<request_auto> request_autos=new LinkedList<>();

        try (Connection con=getConnection(); PreparedStatement stmt=con.prepareStatement(DEL_REQUEST_AUTO)){
            request_autos = new DictionaryDataAccess().allRequest();
            for (int i=0;i<request_autos.size();i++){
                if(request_id==request_autos.get(i).getRequest_auto_id()){
                    stmt.setInt(1,request_id);
                    stmt.executeUpdate();
                    ResultSet rs=stmt.getResultSet();
                    str=new StringBuilder(" Запись удалена с идентификатором "+ request_id);
                    break;
                }
                if(request_id!=request_autos.get(i).getRequest_auto_id()){
                    str=new StringBuilder(" Записи c данным идентификатором нет в базе данных ");
                }
            }

        }catch (Exception ex){
            str=new StringBuilder(ex.getMessage());
        }

        return str;
    }
}
