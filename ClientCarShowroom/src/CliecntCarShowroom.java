import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class CliecntCarShowroom {

    public static Scanner scanner = new Scanner(System.in);
    public static Scanner scannerString = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        int keyex = 0, keyswitch = 0;
        System.out.println("Выберите тип операции:\n 1-Запрос данных из базы данных.\n 2-Обновление данных в базе данных.\n 3-Вставка данных в базу данных.\n 4-Удаление данных из базы данных");
        keyswitch = scanner.nextInt();
        do {
            if (keyex == 1) {
                System.out.println("Выберите тип операции:\n 1-Запрос данных из базы данных.\n 2-Обновление данных в базе данных.\n 3-Вставка данных в базу данных\n 4-Удаление данных из базы данных");
                keyswitch = scanner.nextInt();
            }
            if (!(keyswitch >= 1 && keyswitch <= 4)) {
                System.out.println("Неверный ввод, повторите ввод ");
                keyswitch = scanner.nextInt();
            }


            do {
                if (!(keyswitch >= 1 && keyswitch <=4)) {
                    System.out.println("Неверный ввод, повторите ввод ");
                    keyswitch = scanner.nextInt();
                }
            } while (keyswitch != 1 && keyswitch != 2 && keyswitch != 3 && keyswitch!=4);

            switch (keyswitch) {

                case (1):

                    System.out.println("Выберите вид выборки данных");
                    System.out.println("Найти клиента по фамилии или определенным буквам в фамилии -1 ");
                    System.out.println("Автомобили, которые выбрали клиенты -2 ");
                    System.out.println("Показать все доступные к заказу автомобили -3 ");
                    System.out.println("Показать все виды комплектаций -4 ");
                    System.out.println("Найти клиента по номеру телефона -5");
                    System.out.println("Найти клиента по выбранному автомобилю -6");
                    System.out.println("Найти клиента по дате заявки -7");
                    System.out.println("Показать все виды отделки-8");
                    System.out.println("Показать все доступные к выбору цвета-9");
                    System.out.println("Показать все доступные комбинации отделки салона-10");
                    System.out.println("Показать все доступные варинаты колес-11");
                    System.out.println("Показать все существующие наборы опций-12");
                    System.out.println("Показать все существующие наборы пакетов безопасности-13");
                    System.out.println("Показать все существющие заявки на автомобили-14");
                    System.out.println("Показать все существющие входящие заявки на автомобили-15");
                    System.out.println("Комбинированный запрос Клиент-выбранный авто-16");
                    System.out.println("Комбинированный запрос Автомобиль оснащение-17");
                    System.out.println("Комбинированный запрос Заявка от клиента более чем на один автомобиль-18");
                    int keySel = scanner.nextInt();
                    int keySelx = 1;

                    if (!(keySel >= 1 && keySel <= 18)) {
                        do {
                            System.out.println("Неверный ввод,повторите ввод");
                            keySel = scanner.nextInt();
                        } while (!(keySel >= 1 && keySel <= 18));
                    }
                    switch (keySel) {

                        case (1):
                            System.out.println("Введите фамилию:");
                            String surname = scannerString.nextLine();

                            sendRequest(keyswitch, keySel, surname);


                            break;

                        case (2):
                            sendRequest(keyswitch, keySel);


                            break;

                        case (3):
                            sendRequest(keyswitch, keySel);

                            break;

                        case (4):
                            sendRequest(keyswitch, keySel);

                            break;

                        case (5):
                            System.out.println("Введите номер телефона или часть цифр содержащихся в номере");
                            String telNumber = scannerString.nextLine();

                            sendRequest(keyswitch, keySel, telNumber);
                            break;

                        case (6):
                            System.out.println("Введите ID Автомобиля :/n 1-Polo, 2-Jetta, 3-Passat, 4-Touareg, 5-Golf");
                            int mod = scanner.nextInt();

                            sendRequest(keyswitch, keySel, Integer.toString(mod));
                            break;

                        case (7):
                            System.out.println("Вводить дату в формате 2021-11-07");
                            String date = scannerString.nextLine();

                            sendRequest(keyswitch, keySel, date);

                            break;

                        case (8):

                            sendRequest(keyswitch, keySel);

                            break;

                        case (9):

                            sendRequest(keyswitch, keySel);
                            break;

                        case (10):

                            sendRequest(keyswitch, keySel);

                            break;
                        case (11):
                            sendRequest(keyswitch, keySel);
                            break;
                        case (12):
                            sendRequest(keyswitch, keySel);
                            break;
                        case (13):
                            sendRequest(keyswitch, keySel);
                            break;
                        case (14):
                            sendRequest(keyswitch, keySel);
                            break;
                        case (15):
                            sendRequest(keyswitch,keySel);
                            break;
                        case (16):
                            System.out.println("Введите номер заявки:");
                            int req=scanner.nextInt();
                            String request=Integer.toString(req);
                            sendRequest(keyswitch,keySel,request);
                            break;
                        case (17):
                            System.out.println("Введите идентификатор автомобиля:");
                            int auto_id=scanner.nextInt();
                            String auto=Integer.toString(auto_id);
                            sendRequest(keyswitch,keySel,auto);
                            break;
                        case (18):
                            sendRequest(keyswitch,keySel);
                            break;
                        default:
                    }

                    break;

                case (2):
                    System.out.println("Выберите данные которые необходимо обновить :");
                    System.out.println("Статус заявки -1");

                    int keyup = scanner.nextInt();
                    do {
                        if (keyup!=1) {
                            System.out.println("Неверный ввод, повторите ввод ");
                            keyup = scanner.nextInt();
                        }
                    } while (keyup!=1);

                    switch (keyup) {


                        case (1):
                            int put = 1;
                            while (put != 0) {
                                System.out.println("Введите номер заявки для изменения статуса");
                                int req = scanner.nextInt();
                                System.out.println("Выберите статус для обновления заявки");
                                System.out.println("1-Исполнена\n2-Уточняется\n3-Согласована\n4-Проверяется");
                                int result = scanner.nextInt();
                                String status = "";
                                switch (result) {
                                    case (1):
                                        status = Status.Исполнена.toString();
                                        // res = new DictionaryDataAccess().updateStatusRequest(req, Status.Исполнена.name());
                                        break;
                                    case (2):
                                        status = Status.Уточняется.toString();
                                        //res = new DictionaryDataAccess().updateStatusRequest(req, Status.Уточняется.name());
                                        break;
                                    case (3):
                                        status = Status.Согласована.toString();
                                        //res = new DictionaryDataAccess().updateStatusRequest(req, Status.Согласована.name());
                                        break;
                                    case (4):
                                        status = Status.Проверяется.toString();
                                        //res = new DictionaryDataAccess().updateStatusRequest(req, Status.Проверяется.name());
                                        break;
                                }
                                sendRequest(keyswitch, keyup, req, status);

                                System.out.println("Повторить ввод для обновления данных в заявках? Да-нажмите 1. Нет - нажмите 0");
                                //TODO
                                int putnew = scanner.nextInt();
                                while (putnew != 1 && putnew != 0) {
                                    System.out.println("Неверный ввод? Повторите попытку.");
                                    putnew = scanner.nextInt();
                                }
                                put = putnew;
                            }
                            break;

                    }
                     break;

                case (3):
                    //Вставка данных

                    System.out.println("Выберите тип данных который необходимо вставить :");
                    System.out.println("Автомобиль -1");
                    System.out.println("Клиент -2");
                    System.out.println("Комплектация -3");
                    System.out.println("Виды материалов для отделки салона -4");
                    System.out.println("Цвет -5");
                    System.out.println("Вид отделки салона-6");
                    System.out.println("Вид колес-7");
                    System.out.println("Набор опций-8");
                    System.out.println("Заявка-клиент-9");
                    int keyins = scanner.nextInt();

                    do {
                        if (!(keyins >= 1 && keyins <=9)) {
                            System.out.println("Неверный ввод, повторите ввод ");
                            keyins = scanner.nextInt();
                        }
                    } while (!(keyins >= 1 && keyins <=9));

                    switch (keyins) {
                        case (1):

                            sendRequest(keyswitch, keyins);

                            System.out.print("Введите новый идентификатор, он должен быть больше последнего идентификатора :");
                            int id = scanner.nextInt();
                            System.out.println();
                            System.out.print("Введите идентификтор марки автомобиля :");
                            int mark = scanner.nextInt();
                            System.out.println();
                            System.out.print("Введите модель автомобиля:");
                            int model = scanner.nextInt();
                            System.out.println();
                            System.out.print("Введите комплектацию автомобиля: ");
                            int equip = scanner.nextInt();
                            System.out.println();
                            System.out.print("Введите набор опций :");
                            int options = scanner.nextInt();
                            System.out.println();
                            System.out.print("Введите идентификатор цвета:");
                            int colr = scanner.nextInt();
                            System.out.println();
                            System.out.print("Введите цену");
                            double price = scanner.nextDouble();

                            sendRequest(keyswitch, keyins, id, mark, model, equip, options, colr, price);


                            break;
                        case (2):
                            //клиент
                            int finish = 0;
                            while (finish != 2) {
                                System.out.println("При добавлении нового клиента в базу данных, идентификатор записи вводить не нужно, идентификатор создается автоматически.");
                                System.out.println("Введите фамилию");
                                String surname = scannerString.nextLine();
                                System.out.println("Введите имя");
                                String name = scannerString.nextLine();
                                System.out.println("Введите отчество");
                                String patronymic = scannerString.nextLine();
                                System.out.println("Введите серию паспорта");
                                int seria = scanner.nextInt();
                                System.out.println("Введите номер паспорта");
                                int num = scanner.nextInt();
                                System.out.println("Введите номер телефона (ввод номера осуществляется только цифрами, без различных знаков)");
                                long number_of_tel = scanner.nextLong();
                                String telep = Long.toString(number_of_tel);
                                int step = 0;

                                while (telep.length() != step) {
                                    for (int i = 0; i < telep.length(); i++) {
                                        if (!Character.isDigit(telep.charAt(i))) {
                                            System.out.println("Повторите ввод номера телефона:");
                                            number_of_tel = scanner.nextInt();
                                            telep = Long.toString(number_of_tel);
                                        }
                                        step++;
                                    }

                                }
                                System.out.println("Вставить данные в базу данных? 1-ДА НЕТ-2");
                                int key = 0;
                                do {
                                    key = scanner.nextInt();
                                    if (key != 1 && key != 2) {
                                        System.out.println("Неверный ввод. Повторите ввод!");
                                    }
                                } while (key != 1 && key != 2);

                                if (key == 1) {

                                    sendRequest(keyswitch, keyins, surname, name, patronymic, seria, num, telep);

                                }
                                System.out.println("Ввести новые данные о клиентах? 1-Да. Завершить работу - 2.");
                                do {
                                    finish = scanner.nextInt();
                                    if (finish != 1 && finish != 2) {
                                        System.out.println("Неверный ввод. Повторите ввод!");
                                    }
                                } while (finish != 1 && finish != 2);

                            }
                            break;

                        //Вставка комплектации
                        case (3):
                            int finisheq = 0;
                            while (finisheq != 2) {
                                sendRequest(keyswitch, keyins);
                                System.out.println("Введите новый идентификатор, он должен быть больше последнего идентификатора");
                                int ideq = scanner.nextInt();
                                scanner.useDelimiter("\\n");
                                System.out.println("Введите название комплектации:");
                                String equipment = scannerString.nextLine();

                                System.out.println("Вставить данные в базу данных? 1-ДА НЕТ-2");
                                int key = 0;
                                do {
                                    key = scanner.nextInt();
                                    if (key != 1 && key != 2) {
                                        System.out.println("Неверный ввод. Повторите ввод!");
                                    }
                                } while (key != 1 && key != 2);

                                if (key == 1) {

                                    sendRequest(keyswitch, keyins, ideq, equipment);
                                }
                                System.out.println("Ввести новые данные о комплектациях? 1-Да. Завершить работу - 2.");
                                do {
                                    finisheq = scanner.nextInt();
                                    if (finisheq != 1 && finisheq != 2) {
                                        System.out.println("Неверный ввод. Повторите ввод!");
                                    }
                                } while (finisheq != 1 && finisheq != 2);

                            }
                            break;

                        case (4):
                            //вставка отделки
                            int finishmat = 0;
                            while (finishmat != 2) {

                                sendRequest(keyswitch, keyins);

                                System.out.println("Введите новый идентификатор, он должен быть больше последнего идентификатора");
                                int ideq = scanner.nextInt();
                                scanner.useDelimiter("\\n");
                                System.out.println("Введите название нити:");
                                String rope = scannerString.nextLine();

                                System.out.println("Вставить данные в базу данных? 1-ДА НЕТ-2");
                                int key = 0;
                                do {
                                    key = scanner.nextInt();
                                    if (key != 1 && key != 2) {
                                        System.out.println("Неверный ввод. Повторите ввод!");
                                    }
                                } while (key != 1 && key != 2);

                                if (key == 1) {

                                    sendRequest(keyswitch, keyins, ideq, rope);


                                }
                                System.out.println("Ввести новые данные о материалах отделки? 1-Да. Завершить работу - 2.");
                                do {
                                    finishmat = scanner.nextInt();
                                    if (finishmat != 1 && finishmat != 2) {
                                        System.out.println("Неверный ввод. Повторите ввод!");
                                    }
                                } while (finishmat != 1 && finishmat != 2);


                            }
                            ///Вставка цвета

                            int finishcol = 0;
                            while (finishcol != 2) {
                                sendRequest(keyswitch, keyins);

                                System.out.println("Введите новый идентификатор, он должен быть больше последнего идентификатора");
                                int idcol = scanner.nextInt();
                                scanner.useDelimiter("\\n");
                                System.out.println("Введите название цвета:");
                                String co = scannerString.nextLine();

                                System.out.println("Вставить данные в базу данных? 1-ДА НЕТ-2");
                                int key = 0;
                                do {
                                    key = scanner.nextInt();
                                    if (key != 1 && key != 2) {
                                        System.out.println("Неверный ввод. Повторите ввод!");
                                    }
                                } while (key != 1 && key != 2);

                                if (key == 1) {

                                    sendRequest(keyswitch, keyins, idcol, co);

                                }
                                System.out.println("Ввести новые данные о вариантах цвета? 1-Да. Завершить работу - 2.");
                                do {
                                    finishcol = scanner.nextInt();
                                    if (finishcol != 1 && finishcol != 2) {
                                        System.out.println("Неверный ввод. Повторите ввод!");
                                    }
                                } while (finishcol != 1 && finishcol != 2);
                            }
                            break;

                        case (6):
                            //вставка отделки салона

                            sendRequest(keyswitch, keyins);
                            finishcol = 0;

                            while (finishcol != 2) {
                                System.out.println("Введите новый идентификатор");
                                int cab_id = scanner.nextInt();
                                System.out.println("Введите идентификатор для выбора отделки");

                                int fin_id = scanner.nextInt();
                                System.out.println("Введите наименование");
                                String str = scannerString.nextLine();

                                System.out.println("Вставить данные в базу данных? 1-ДА НЕТ-2");
                                int key = 0;
                                do {
                                    key = scanner.nextInt();
                                    if (key != 1 && key != 2) {
                                        System.out.println("Неверный ввод. Повторите ввод!");
                                    }
                                } while (key != 1 && key != 2);

                                if (key == 1) {
                                    sendRequest(keyswitch, keyins, cab_id, fin_id, str);


                                }
                                System.out.println("Ввести новые данные о вариантах отделки салона? 1-Да. Завершить работу - 2.");
                                do {
                                    finishcol = scanner.nextInt();
                                    if (finishcol != 1 && finishcol != 2) {
                                        System.out.println("Неверный ввод. Повторите ввод!");
                                    }
                                } while (finishcol != 1 && finishcol != 2);
                            }
                            break;
                        case (7)://вставляем колесные диски

                            sendRequest(keyswitch, keyins);

                            finishcol = 0;
                            while (finishcol != 2) {
                                System.out.println("Введите новый идентификатор");
                                int wheel_id = scanner.nextInt();
                                System.out.println("Введите радиус");
                                int radius_id = scanner.nextInt();
                                System.out.println("Введите разболтовку диска в  виде: '5*112' ");
                                String str = scannerString.nextLine();
                                System.out.println("Введите ширину колеса: ");
                                int width = scanner.nextInt();

                                System.out.println("Вставить данные в базу данных? 1-ДА НЕТ-2");
                                int key = 0;
                                do {
                                    key = scanner.nextInt();
                                    if (key != 1 && key != 2) {
                                        System.out.println("Неверный ввод. Повторите ввод!");
                                    }
                                } while (key != 1 && key != 2);

                                if (key == 1) {
                                    sendRequest(keyswitch, keyins, wheel_id, radius_id, str, width);

                                }
                                System.out.println("Ввести новые данные о вариантах колес? 1-Да. Завершить работу - 2.");
                                do {
                                    finishcol = scanner.nextInt();
                                    if (finishcol != 1 && finishcol != 2) {
                                        System.out.println("Неверный ввод. Повторите ввод!");
                                    }
                                } while (finishcol != 1 && finishcol != 2);
                            }

                            break;

                        case (8)://вставляем опции
                            sendRequest(keyswitch, keyins);
                            finishcol = 0;
                            while (finishcol != 2) {
                                System.out.println("Введите новый идентификатор:");
                                int option_id = scanner.nextInt();
                                System.out.println("Выберите вид отделки салона из существующих:");

                                sendRequest(1, 10);
                                int finish_cab = scanner.nextInt();
                                System.out.println("Введите вид колес: ");
                                sendRequest(1, 11);
                                int wheel = scanner.nextInt();

                                System.out.println("Введите вид пакета безопасности: ");
                                sendRequest(1, 13);
                                int safe = scanner.nextInt();

                                System.out.println("Вставить данные в базу данных? 1-ДА НЕТ-2");
                                int key = 0;
                                do {
                                    key = scanner.nextInt();
                                    if (key != 1 && key != 2) {
                                        System.out.println("Неверный ввод. Повторите ввод!");
                                    }
                                } while (key != 1 && key != 2);

                                if (key == 1) {
                                    sendRequest(keyswitch, keyins, option_id, finish_cab, wheel, safe);

                                }
                                System.out.println("Ввести новые данные опций? 1-Да. Завершить работу - 2.");
                                do {
                                    finishcol = scanner.nextInt();
                                    if (finishcol != 1 && finishcol != 2) {
                                        System.out.println("Неверный ввод. Повторите ввод!");
                                    }
                                } while (finishcol != 1 && finishcol != 2);
                            }
                            break;

                        case (9):

                            //sendRequest(keyswitch, keyins);
                            finishcol = 0;
                            while (finishcol != 2) {
                                System.out.println("Идентификатор вводить не нужно - генерируется автоматически:");


                                System.out.println("Введите фамилию клиента для его поиска:");
                                String surname = scannerString.nextLine();
                                sendRequest(1, 1, surname);
                                System.out.println("Введите идентификатор клиента:");
                                int client=scanner.nextInt();

                                System.out.println("Выберите статус для обновления заявки");
                                System.out.println("1-Исполнена\n2-Уточняется\n3-Согласована\n4-Проверяется");
                                int result = scanner.nextInt();
                                String status = "";
                                switch (result) {
                                    case (1):
                                        status = Status.Исполнена.toString();
                                        // res = new DictionaryDataAccess().updateStatusRequest(req, Status.Исполнена.name());
                                        break;
                                    case (2):
                                        status = Status.Уточняется.toString();
                                        //res = new DictionaryDataAccess().updateStatusRequest(req, Status.Уточняется.name());
                                        break;
                                    case (3):
                                        status = Status.Согласована.toString();
                                        //res = new DictionaryDataAccess().updateStatusRequest(req, Status.Согласована.name());
                                        break;
                                    case (4):
                                        status = Status.Проверяется.toString();
                                        //res = new DictionaryDataAccess().updateStatusRequest(req, Status.Проверяется.name());
                                        break;
                                }

                                System.out.println("Вставить данные в базу данных? 1-ДА НЕТ-2");
                                int key = 0;
                                do {
                                    key = scanner.nextInt();
                                    if (key != 1 && key != 2) {
                                        System.out.println("Неверный ввод. Повторите ввод!");
                                    }
                                } while (key != 1 && key != 2);
                                if (key == 1) {
                                    sendRequest(keyswitch, keyins, client, status);
                                }
                                System.out.println("Ввести новые данные опций? 1-Да. Завершить работу - 2.");
                                do {
                                    finishcol = scanner.nextInt();
                                    if (finishcol != 1 && finishcol != 2) {
                                        System.out.println("Неверный ввод. Повторите ввод!");
                                    }
                                } while (finishcol != 1 && finishcol != 2);
                            }
                            break;
                    }
                    break;
                case(4):
                    System.out.println("Укажите раздел для удаления данных");
                    System.out.println("Удалить автомобиль-1");
                    System.out.println("Удалить заявку на автомобиль-2");
                    int key =scanner.nextInt();

                    do {
                        if (!(key >= 1 && key <=2)) {
                            System.out.println("Неверный ввод, повторите ввод ");
                            key = scanner.nextInt();
                        }
                    } while (!(key >= 1 && key <=2));

                    switch (key){
                        case (1):
                            System.out.println("Введите идентификатор автомобиля для удаления: ");
                            int auto_id=scanner.nextInt();
                            sendRequest(keyswitch,key,Integer.toString(auto_id));
                            break;
                        case (2):
                            System.out.println("Введите идентификатор заявки на автомобиль для удаления: ");
                            int request_id=scanner.nextInt();
                            sendRequest(keyswitch,key,Integer.toString(request_id));
                            break;
                    }


                    break;

            }

            System.out.print("Продолжить работу? 1-ДА, 2- Завершить работу: ");

            do {
                keyex = scanner.nextInt();
                if (keyex != 1 && keyex != 2) {
                    System.out.println("Неверный ввод,повторите ввод");
                    keyex = scanner.nextInt();
                }
            } while (keyex != 1 && keyex != 2);


        } while (keyex != 2);


    }


    private static void sendRequest(int keyswitch,int keyins,String surname,String status)throws Exception{

        Socket client = new Socket("127.0.0.1", 25225);

        BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        StringBuilder sb = new StringBuilder(keyswitch + " " + keyins + " " + surname + " " + status);
        bufw.write(sb.toString());
        bufw.newLine();
        bufw.flush();
        String str = buf.readLine();

        for (int i = 0; i < str.length(); i++) {

            if (i == 0) {
                System.out.print(" ");
            }
            if (str.charAt(i) == '[' || str.charAt(i) == ']') {
                continue;
            }
            System.out.print(str.charAt(i));

            if (str.charAt(i) == ',') {
                System.out.println();
            }
        }
        System.out.println();
        buf.close();
        bufw.close();

        client.close();


    }




    private static void sendRequest(int keyswitch, int keyins, int wheel_id, int radius_id, String string, int width) throws Exception {
        Socket client = new Socket("127.0.0.1", 25225);

        BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        StringBuilder sb = new StringBuilder(keyswitch + " " + keyins + " " + wheel_id + " " + radius_id + " " + string + " " + width);
        bufw.write(sb.toString());
        bufw.newLine();
        bufw.flush();
        String str = buf.readLine();

        for (int i = 0; i < str.length(); i++) {

            if (i == 0) {
                System.out.print(" ");
            }
            if (str.charAt(i) == '[' || str.charAt(i) == ']') {
                continue;
            }
            System.out.print(str.charAt(i));

            if (str.charAt(i) == ',') {
                System.out.println();
            }
        }
        System.out.println();
        buf.close();
        bufw.close();

        client.close();
    }

    private static void sendRequest(int keyswitch, int key, int id, int id2, String string) throws Exception {
        Socket client = new Socket("127.0.0.1", 25225);

        BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        StringBuilder sb = new StringBuilder(keyswitch + " " + key + " " + id + " " + id2 + " " + string);
        bufw.write(sb.toString());
        bufw.newLine();
        bufw.flush();
        String str = buf.readLine();

        for (int i = 0; i < str.length(); i++) {

            if (i == 0) {
                System.out.print(" ");
            }
            if (str.charAt(i) == '[' || str.charAt(i) == ']') {
                continue;
            }
            System.out.print(str.charAt(i));

            if (str.charAt(i) == ',') {
                System.out.println();
            }
        }
        System.out.println();
        buf.close();
        bufw.close();

        client.close();


    }

    private static void sendRequest(int keyswitch, int keyins, int id, int mark, int model, int equip, int options, int colr, double price) throws Exception {

        Socket client = new Socket("127.0.0.1", 25225);

        BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        StringBuilder sb = new StringBuilder(keyswitch + " " + keyins + " " + id + " " + mark + " " + model + " " + equip + " " + options + " " + colr + " " + price);
        bufw.write(sb.toString());
        bufw.newLine();
        bufw.flush();
        String str = buf.readLine();

        for (int i = 0; i < str.length(); i++) {

            if (i == 0) {
                System.out.print(" ");
            }
            if (str.charAt(i) == '[' || str.charAt(i) == ']') {
                continue;
            }
            System.out.print(str.charAt(i));

            if (str.charAt(i) == ',') {
                System.out.println();
            }
        }
        System.out.println();
        buf.close();
        bufw.close();

        client.close();
    }

    private static void sendRequest(int keyswitch, int keyup, int id, String string) throws Exception {
        Socket client = new Socket("127.0.0.1", 25225);

        BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

        StringBuilder sb = new StringBuilder(keyswitch + " " + keyup + " " + id + " " + string);
        bufw.write(sb.toString());
        bufw.newLine();
        bufw.flush();
        String str = buf.readLine();

        for (int i = 0; i < str.length(); i++) {

            if (i == 0) {
                System.out.print(" ");
            }
            if (str.charAt(i) == '[' || str.charAt(i) == ']') {
                continue;
            }
            System.out.print(str.charAt(i));

            if (str.charAt(i) == ',') {
                System.out.println();
            }
        }
        System.out.println();
        buf.close();
        bufw.close();

        client.close();

    }

    private static void sendRequest(int keyswitch, int keySel) throws Exception {
        Socket client = new Socket("127.0.0.1", 25225);

        BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        StringBuilder sb = new StringBuilder(keyswitch + " " + keySel + " ");

        bufw.write(sb.toString());
        bufw.newLine();
        bufw.flush();
        String str = buf.readLine();


        for (int i = 0; i < str.length(); i++) {

            if (i == 0) {
                System.out.print(" ");
            }
            if (str.charAt(i) == '[' || str.charAt(i) == ']') {
                continue;
            }
            System.out.print(str.charAt(i));

            if (str.charAt(i) == ',') {
                System.out.println();
            }
        }
        System.out.println();
        buf.close();
        bufw.close();

        client.close();

    }

    private static void sendRequest(int keyswitch, int keySel, String str) throws Exception {
        Socket client = new Socket("127.0.0.1", 25225);

        BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        StringBuilder sb = new StringBuilder(keyswitch + " " + keySel + " " + str);

        bufw.write(sb.toString());
        bufw.newLine();

        bufw.flush();


        String str1 = buf.readLine();

        for (int i = 0; i < str1.length(); i++) {

            if (i == 0) {
                System.out.print(" ");
            }
            if (str1.charAt(i) == '[' || str1.charAt(i) == ']') {
                continue;
            }
            System.out.print(str1.charAt(i));

            if (str1.charAt(i) == ',') {
                System.out.println();
            }
        }
        System.out.println();
        buf.close();
        bufw.close();

        client.close();

    }


    private static void sendRequest(int keyswitch, int keyins, int option_id, int finish_cab, int wheel, int safe) throws IOException {
        Socket client = new Socket("127.0.0.1", 25225);

        BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

        StringBuilder sb = new StringBuilder(keyswitch + " " + keyins + " " + option_id + " " + finish_cab + " " + wheel + " " + safe);
        bufw.write(sb.toString());
        bufw.newLine();
        bufw.flush();
        String str = buf.readLine();

        for (int i = 0; i < str.length(); i++) {

            if (i == 0) {
                System.out.print(" ");
            }
            if (str.charAt(i) == '[' || str.charAt(i) == ']') {
                continue;
            }
            System.out.print(str.charAt(i));

            if (str.charAt(i) == ',') {
                System.out.println();
            }
        }
        System.out.println();
        buf.close();
        bufw.close();

        client.close();


    }

    private static void sendRequest(int keyswitch, int keyins, String surname, String name, String patronymic, int seria, int num, String telep) throws Exception {

        Socket client = new Socket("127.0.0.1", 25225);

        BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        StringBuilder sb = new StringBuilder(keyswitch + " " + keyins + " " + surname + " " + name + " " + patronymic + " " + seria + " " + num + " " + telep);
        bufw.write(sb.toString());
        bufw.newLine();
        bufw.flush();
        String str = buf.readLine();

        for (int i = 0; i < str.length(); i++) {

            if (i == 0) {
                System.out.print(" ");
            }
            if (str.charAt(i) == '[' || str.charAt(i) == ']') {
                continue;
            }
            System.out.print(str.charAt(i));

            if (str.charAt(i) == ',') {
                System.out.println();
            }
        }
        System.out.println();
        buf.close();
        bufw.close();

        client.close();


    }


}
