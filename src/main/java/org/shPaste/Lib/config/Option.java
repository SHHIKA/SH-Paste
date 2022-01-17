package org.shPaste.Lib.config;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Option implements Serializable {

    private Map<String, Data> list = new HashMap<>();

    public void LoadDef(){
        if(Config.Load("data.dat") != null) list = (Map<String, Data>) Config.Load("data.dat");
    }

    public void SaveDef(){
        Config.Save(list, "data.dat");
    }

    public Data getData(String index){
        return list.get(index);
    }

    public void setData(String index, Data data){
        list.put(index, data);
    }

    public Map<String, Data> getList() {
        return list;
    }
}
