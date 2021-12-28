package DataAccess;

import Tables.*;


public interface DictionaryDI_Car_showroomDB {
    public int insertAuto(auto autos) throws Exception;

    public int insertClient(client cl) throws Exception;

    public int insertEquipment(equipment eq) throws Exception;

    public int insertFinishing_materials(finishing_materials fin) throws Exception;

    public int insertColor(color col) throws Exception;

    public int insertFinishingCabin(finishing_cabin fc)throws Exception;

    public int insertWheels(wheels wh)throws Exception;

    public int insertOption(option_of_auto option)throws Exception;
    public int insertRequestClient(request client) throws Exception;

}
