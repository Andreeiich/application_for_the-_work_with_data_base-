package DataAccess;

import Tables.*;

import java.util.List;

public interface DictionaryDA_Car_showroomDB {
    List<client> findClient(String pattern) throws Exception;

    List<client> findClientByNumber(String number) throws Exception;

    List<auto> findAuto() throws Exception;

    List<equipment> allEquipment() throws Exception;

    List<String> findClientByAuto(int mark) throws Exception;

    List<finishing_materials> allFinishing_materials() throws Exception;

    List<color> allColor() throws Exception;

    List<finishing_cabin> allFinishingCabin() throws Exception;

    List<wheels> allWheels() throws Exception;

    List<option_of_auto> allOption() throws Exception;

    List<package_of_safe> allSafe() throws Exception;

    List<request_auto> allRequest()throws Exception;

    List<request> allRequestFromClient()throws Exception;

    List<StringBuilder> combinationClientCarEquipment(int request) throws Exception;

    List<StringBuilder> combinationCarEquipmentInStore(int auto_id) throws Exception;
    List<StringBuilder> quantityCarMoreThanOne() throws Exception;
}
