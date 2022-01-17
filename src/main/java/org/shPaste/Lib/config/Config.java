package org.shPaste.Lib.config;

import java.io.*;

public class Config{

    public static void Save(Object data, String path){
        try(FileOutputStream f = new FileOutputStream(path);
            BufferedOutputStream b = new BufferedOutputStream(f);
            ObjectOutputStream out = new ObjectOutputStream(b)){

            out.writeObject(data);
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    public static Object Load(String path){
        if(!(new File(path).exists())) Save(null, path);

        try(FileInputStream f = new FileInputStream(path);
            BufferedInputStream b = new BufferedInputStream(f);
            ObjectInputStream in = new ObjectInputStream(b)){

            return in.readObject();
        } catch ( IOException | ClassNotFoundException e ) {
            e.printStackTrace();
        }
        return null;
    }
}
