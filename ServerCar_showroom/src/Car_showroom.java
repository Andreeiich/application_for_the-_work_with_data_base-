import DataAccess.DictionaryDA_Car_showroomDB;
import DataAccess.DictionaryDataAccess;
import DataAccess.DictionaryDataDel;
import DataAccess.DictionaryDataInput;
import Tables.*;
import com.sun.xml.internal.bind.v2.TODO;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class Car_showroom {



    public static void main(String[] args) throws Exception {

        ServerSocket socket = new ServerSocket(25225);



        while (true) {
            Socket client = socket.accept();//сервер ждет сообщения
            new ServerThread(client).start();
        }

    }

}

     class ServerThread extends Thread {

         private Socket client = new Socket();

         ServerThread(Socket client) {
             this.client = client;

         }

         public void run() {
             try {
                 handleRequest(client);
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }


         private StringBuilder handleRequest(Socket client) throws Exception {
             BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
             BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

             StringBuilder sb = new StringBuilder();
             String request = buf.readLine();//читаем входящую строку
             StringBuilder stringBuilder = new StringBuilder();


             String[] str1 = request.split(" ");//распарсили строку

             int keyswitch = Integer.parseInt(str1[0]), max = 0;

             switch (keyswitch) {

                 case (1):

                     int keySel = Integer.parseInt(str1[1]);

                     switch (keySel) {
                         case (1):
                             String surname = str1[2];
                             List<client> clien = new DictionaryDataAccess().findClient(surname);
                             stringBuilder = new StringBuilder(clien.toString());
                             break;
                         case (2):
                             List<String> client_auto = new DictionaryDataAccess().findClientAUTO();//search for the car selected by the client
                             // Car_showroom.print(client_auto);
                             stringBuilder = new StringBuilder(client_auto.toString());
                             break;
                         case (3):
                             List<auto> car = new DictionaryDataAccess().findAuto();//The query gives all the strings from auto
                             stringBuilder = new StringBuilder(car.toString());
                             break;
                         case (4):
                             List<equipment> eq = new DictionaryDataAccess().allEquipment();//The query gives all the strings from equipment

                             stringBuilder = new StringBuilder(eq.toString());
                             break;
                         case (5):
                             String telNumber = str1[2];
                             List<client> clietnByNumber = new DictionaryDataAccess().findClientByNumber(telNumber);//search for the client with pattern for client's surname
                             // Car_showroom.print(clietnByNumber);
                             if (clietnByNumber.size() == 0) {
                                 String str = "The table Client doesn't have data";
                                 stringBuilder = new StringBuilder(str);
                             } else {
                                 stringBuilder = new StringBuilder(clietnByNumber.toString());
                             }
                             break;
                         case (6):
                             String model = str1[2];
                             int mod = Integer.parseInt(str1[2]);
                             List<String> clientByCar = new DictionaryDataAccess().findClientByAuto(mod);
                             //Car_showroom.print(clientByCar);
                             if (clientByCar.size() == 0) {
                                 String str = "There aren't clients with this car";
                                 stringBuilder = new StringBuilder(str);
                             } else {
                                 stringBuilder = new StringBuilder(clientByCar.toString());
                             }
                             break;

                         case (7):
                             // System.out.println("Вводить дату в формате 2021-11-07");
                             //String date = scannerString.nextLine();
                             String date = str1[2];
                             List<String> clientdate = new DictionaryDataAccess().findClientDate(date);
                             //Car_showroom.print(clientdate);
                             stringBuilder = new StringBuilder(clientdate.toString());
                             break;

                         case (8):
                             List<finishing_materials> finishing_materials = new DictionaryDataAccess().allFinishing_materials();
                             //Car_showroom.print(finishing_materials);
                             stringBuilder = new StringBuilder(finishing_materials.toString());
                             break;

                         case (9):
                             List<color> colorList = new DictionaryDataAccess().allColor();
                             //Car_showroom.print(colorList);
                             stringBuilder = new StringBuilder(colorList.toString());
                             break;

                         case (10):
                             List<finishing_cabin> fincab = new DictionaryDataAccess().allFinishingCabin();
                             // Car_showroom.print(fincab);
                             stringBuilder = new StringBuilder(fincab.toString());
                             break;
                         case (11):
                             List<wheels> wheels = new DictionaryDataAccess().allWheels();
                             stringBuilder = new StringBuilder(wheels.toString());

                             break;
                         case (12):
                             List<option_of_auto> opt = new DictionaryDataAccess().allOption();
                             stringBuilder = new StringBuilder(opt.toString());

                             break;
                         case (13):
                             List<package_of_safe> safes = new DictionaryDataAccess().allSafe();
                             stringBuilder = new StringBuilder(safes.toString());

                             break;
                         case (14):
                             List<request_auto> allRequest = new DictionaryDataAccess().allRequest();
                             stringBuilder = new StringBuilder(allRequest.toString());

                             break;
                         case (15):
                             List<request> allRequestClient = new DictionaryDataAccess().allRequestFromClient();
                             stringBuilder = new StringBuilder(allRequestClient.toString());
                             break;
                         case (16):
                             int req=Integer.parseInt(str1[2]);
                             List<StringBuilder> strBuild=new DictionaryDataAccess().combinationClientCarEquipment(req);
                             stringBuilder=new StringBuilder(strBuild.toString());
                             break;

                         case (17):
                             int auto_id=Integer.parseInt(str1[2]);
                             List<StringBuilder> strBuild1=new DictionaryDataAccess().combinationCarEquipmentInStore(auto_id);
                             stringBuilder=new StringBuilder(strBuild1.toString());
                             break;
                         case (18):
                             List<StringBuilder> autos=new DictionaryDataAccess().quantityCarMoreThanOne();
                             stringBuilder=new StringBuilder(autos.toString());
                             break;

                     }
                     break;
                 case (2):
                     int keyup = Integer.parseInt(str1[1]);

                     switch (keyup) {
                         case (1):
                             int req = Integer.parseInt(str1[2]);
                             String status = str1[3];
                             stringBuilder = new DictionaryDataAccess().updateStatusRequest(req, status);

                             break;
                     }
                     break;

                 case (3):

                     int keyins = Integer.parseInt(str1[1]);

                     switch (keyins) {
                         case (1):

                             if (str1.length == 2) {
                                 max = 0;
                                 List<auto> autos = new DictionaryDataAccess().findAuto();
                                 for (int i = 0; i < autos.size(); i++) {
                                     if (max < autos.get(i).getAuto_id()) {
                                         max = autos.get(i).getAuto_id();
                                     }
                                 }
                                 stringBuilder = new StringBuilder("Последний идентификатор автомобиля: " + max);

                                 bufw.write(stringBuilder.toString());
                                 bufw.newLine();
                                 bufw.flush();
                             } else {
                                 int id = Integer.parseInt(str1[2]);
                                 int mark = Integer.parseInt(str1[3]);
                                 int model = Integer.parseInt(str1[4]);
                                 int equip = Integer.parseInt(str1[5]);
                                 int options = Integer.parseInt(str1[6]);
                                 int colr = Integer.parseInt(str1[7]);
                                 double price = Double.parseDouble(str1[8]);

                                 auto au = new auto(id, mark, model, equip, options, colr, price);
                                 int input_id = new DictionaryDataInput().insertAuto(au);// так возможно с интерфейсом
                                 stringBuilder = new StringBuilder("ID Вставленного автомобиля в базу данных: " + input_id);
                             }
                             break;
                         case (2):

                             String surname = str1[2];
                             String name = str1[3];
                             String patronymic = str1[4];
                             int seria = Integer.parseInt(str1[5]);
                             int num = Integer.parseInt(str1[6]);
                             String telep = str1[7];

                             client cl = new client(0, surname, name, patronymic, seria, num, telep);
                             int client_id = new DictionaryDataInput().insertClient(cl);
                             stringBuilder = new StringBuilder("Клиент добавлен с номером идентификатора " + client_id);

                             break;
                         case (3):
                             if (str1.length == 2) {
                                 max = 0;
                                 List<equipment> equipBefore = new DictionaryDataAccess().allEquipment();
                                 for (int i = 0; i < equipBefore.size(); i++) {
                                     if (max < equipBefore.get(i).getEquipment_id()) {
                                         max = equipBefore.get(i).getEquipment_id();
                                     }
                                 }
                                 stringBuilder = new StringBuilder("Последний идентификатор комплектации: " + max);

                                 bufw.write(stringBuilder.toString());
                                 bufw.newLine();
                                 bufw.flush();
                             } else {
                                 int ideq = Integer.parseInt(str1[2]);
                            /*scanner.useDelimiter("\\n");
                            System.out.println("Введите название комплектации:");*/
                                 String equipment = str1[3];

                                 equipment eq = new equipment(ideq, equipment);
                                 int equipment_id = new DictionaryDataInput().insertEquipment(eq);
                                 stringBuilder = new StringBuilder("Комплектация добавлена с номером идентификатора " + equipment_id);
                             }

                             break;
                         case (4):

                             if (str1.length == 2) {
                                 max = 0;
                                 List<finishing_materials> finishing_materials = new DictionaryDataAccess().allFinishing_materials();
                                 for (int i = 0; i < finishing_materials.size(); i++) {
                                     if (max < finishing_materials.get(i).getNumber_id()) {
                                         max = finishing_materials.get(i).getNumber_id();
                                     }
                                 }
                                 stringBuilder = new StringBuilder("Номер последнего идентификатора отделки в базе данных: " + max);
                                 bufw.write(stringBuilder.toString());
                                 bufw.newLine();
                                 bufw.flush();
                             } else {
                                 int ideq = Integer.parseInt(str1[2]);
                                 String rope = str1[3];
                                 finishing_materials fin = new finishing_materials(ideq, rope);
                                 int materials_id = new DictionaryDataInput().insertFinishing_materials(fin);
                                 stringBuilder = new StringBuilder("Новый материал для отделки добавлен с номером идентификатора " + materials_id);


                             }

                             break;
                         case (5):
                             if (str1.length == 2) {
                                 List<color> colors = new DictionaryDataAccess().allColor();
                                 max = 0;
                                 for (int i = 0; i < colors.size(); i++) {
                                     if (max < colors.get(i).getColor_id()) {
                                         max = colors.get(i).getColor_id();
                                     }
                                 }

                                 stringBuilder = new StringBuilder("Номер последнего идентификатора в базе данных: " + max);
                                 bufw.write(stringBuilder.toString());
                                 bufw.newLine();
                                  bufw.flush();
                             } else {
                                 int idcol = Integer.parseInt(str1[2]);
                                 String co = str1[3];

                                 color col = new color(idcol, co);
                                 int color_id = new DictionaryDataInput().insertColor(col);
                                 stringBuilder = new StringBuilder("Новый цвет добавлен с номером идентификатора " + color_id);


                             }
                             break;
                         case (6):
                             if (str1.length == 2) {
                                 List<finishing_cabin> fincab = new DictionaryDataAccess().allFinishingCabin();
                                 max = 0;
                                 for (int i = 0; i < fincab.size(); i++) {
                                     if (max < fincab.get(i).getCabin_id()) {
                                         max = fincab.get(i).getCabin_id();
                                     }
                                 }
                                 stringBuilder = new StringBuilder("Последний идентификатор отделки салона " + max);
                             } else {
                                 int cab_id = Integer.parseInt(str1[2]);
                                 int fin_id = Integer.parseInt(str1[3]);
                                 String str = str1[4];
                                 finishing_cabin cab = new finishing_cabin(cab_id, fin_id, str);
                                 int idс = new DictionaryDataInput().insertFinishingCabin(cab);
                                 stringBuilder = new StringBuilder("Новая отделка добавлена с идентификатором " + idс);
                             }
                             break;
                         case (7):
                             if (str1.length == 2) {
                                 List<wheels> wheels = new DictionaryDataAccess().allWheels();
                                 max = 0;
                                 for (int i = 0; i < wheels.size(); i++) {
                                     if (max < wheels.get(i).getWheels_id()) {
                                         max = wheels.get(i).getWheels_id();
                                     }
                                 }
                                 stringBuilder = new StringBuilder("Последний идентификатор  " + max);
                             } else {
                                 int wheels_id = Integer.parseInt(str1[2]);
                                 int radius = Integer.parseInt(str1[3]);
                                 String str = str1[4];
                                 int width = Integer.parseInt(str1[5]);
                                 wheels wh = new wheels(wheels_id, radius, str, width);
                                 int idс = new DictionaryDataInput().insertWheels(wh);
                                 stringBuilder = new StringBuilder("Новый вид колес добавлен с индентификатором " + idс);

                             }
                             break;
                         case (8):
                             if (str1.length == 2) {
                                 List<option_of_auto> option = new DictionaryDataAccess().allOption();
                                 max = 0;
                                 for (int i = 0; i < option.size(); i++) {
                                     if (max < option.get(i).getOption_id()) {
                                         max = option.get(i).getOption_id();
                                     }
                                 }
                                 stringBuilder = new StringBuilder("Последний идентификатор  " + max);
                             } else {
                                 int option_id = Integer.parseInt(str1[2]);
                                 int finishing_cabin_id = Integer.parseInt(str1[3]);
                                 int wheels_id = Integer.parseInt(str1[4]);
                                 int safe_id = Integer.parseInt(str1[5]);

                                 option_of_auto option = new option_of_auto(option_id, finishing_cabin_id, wheels_id, safe_id);
                                 int idс = new DictionaryDataInput().insertOption(option);
                                 stringBuilder = new StringBuilder("Новый набор опций добавлен с индентификатором " + idс);

                             }
                             break;
                         case (9):
                             int clientReq_id = Integer.parseInt(str1[2]);
                             String status = str1[3];
                             request req = new request(clientReq_id, status);
                             int idс = new DictionaryDataInput().insertRequestClient(req);
                             stringBuilder = new StringBuilder("Заявка добавлена с идентификатором " + idс);

                             break;

                     }
                     break;

                 case (4):
                     int keyDel=Integer.parseInt(str1[1]);

                     switch (keyDel){
                         case (1):
                                int auto_id=Integer.parseInt(str1[2]);
                                stringBuilder= new StringBuilder(new DictionaryDataDel().delAuto(auto_id));
                                break;
                         case (2):
                           int request_auto_id=Integer.parseInt(str1[2]);
                           stringBuilder=new StringBuilder(new DictionaryDataDel().delRequest(request_auto_id));
                           break;

                     }

                     break;

             }


             bufw.write(stringBuilder.toString());
             bufw.newLine();
             bufw.flush();

             buf.close();
             bufw.close();

             client.close();
             return sb;
         }

     }

