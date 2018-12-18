/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputAndOutput;

import Engine.WorkSpace;
import Exception.FileException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Poowis
 */
public class WorkSpaceIO {

    public static WorkSpace ImportWorkSpace(String path) throws FileException, FileNotFoundException, IOException, ClassNotFoundException {
        File file = new File(path);
        WorkSpace ws = null;
        if (file.exists()) {
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
                ws = (WorkSpace) input.readObject();
            }
        } else {
            throw new FileException("File does not exist");
        }
        return ws;
    }

    public static void ExportWorkSpace(String path, WorkSpace ws) throws FileNotFoundException, IOException {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path+".ws"))) {
            output.writeObject(ws);
        }
    }

}
