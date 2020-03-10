/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author alfarr
 */
public class FileIO {
    
    public static void saveToFile(ArrayList array, String name) throws Exception{
        File f = new File("data");
        if(!f.exists() && !f.mkdirs())
            throw new Exception("Erro ao criar pasta!");
        FileOutputStream fos = new FileOutputStream("data/" + name + ".mecb");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(array);
        oos.close();
        fos.close();
    }


    public static Object loadFromFile(String name) throws Exception{
        FileInputStream fis = new FileInputStream("data/" + name + ".mecb");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object res = ois.readObject();
        ois.close();

        return res;
    }
}
