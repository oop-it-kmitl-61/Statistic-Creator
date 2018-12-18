/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Exception.FileException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Poowis
 */
public final class WorkSpace implements Serializable {

    private Data data;
    private String dataPath;
    private HashMap<String, Object> settings;

    public WorkSpace() {
    }

    public WorkSpace(String path) throws IOException, FileNotFoundException, FileException {
        importData(path);
    }

    public void importData(String path) throws IOException, FileNotFoundException, FileException {
        File file = new File(path);
        if (file.exists()) {
            data = new Data(path);
            this.dataPath = path;
        } else {
            throw new FileException("Data file can not be found");
        }
    }

    public void update() throws IOException, FileNotFoundException, FileException {
        File file = new File(dataPath);
        if (file.exists()) {
            data = new Data(dataPath);
        } else {
            throw new FileException("Data file is Missing");
        }
    }

    public Data getData() {
        return data;
    }

    public String getDataPath() {
        return dataPath;
    }

    public HashMap<String, Object> getSettings() {
        return settings;
    }

    public void setSettings(HashMap<String, Object> settings) {
        this.settings = settings;
    }

    @Override
    public String toString() {
        try {
            return new File(dataPath).getName();
        } catch(Exception ex) {
            return "Untitled";
        }
    }

}
