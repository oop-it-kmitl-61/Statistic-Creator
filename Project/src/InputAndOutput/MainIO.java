/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputAndOutput;

import Engine.Main;
import Exception.FileException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Poowis
 */
public class MainIO {

    public static Main loadMain() throws FileException, FileNotFoundException, IOException, ClassNotFoundException {
        File file = new File("main.dat");
        Main main = null;
        if (file.exists()) {
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
                main = (Main) input.readObject();
            }
        } else {
            throw new FileException("File does not exist");
        }
        return main;
    }

    public static void saveMain(Main main) throws FileNotFoundException, IOException {
        String path = "main.dat";
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
            output.writeObject(main);
        }
    }

}
