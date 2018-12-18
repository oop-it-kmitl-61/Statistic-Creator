/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Exception.FileException;
import InputAndOutput.DataIO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Poowis
 */
public class Data implements Iterable<ArrayList>, Serializable {

    protected ArrayList<String> metaInfo;
    protected ArrayList<Integer> dataSize;
    protected ArrayList<ArrayList<Object>> data;

    public Data() {
    }

    public Data(String path) throws IOException, FileNotFoundException, FileException {
        setData(path);
    }

    public final void setData(String path) throws IOException, FileNotFoundException, FileException {
        ArrayList<ArrayList<Object>> tmp = DataIO.getData(path);
        metaInfo = new ArrayList<>();
        for (Object value : tmp.get(0)) {
            String s = (String) value;
            metaInfo.add(s);
        }
        tmp.remove(0);
        data = tmp;
        dataSize = new ArrayList<>(2);
        dataSize.add(tmp.size());
        dataSize.add(metaInfo.size());

    }
    
    public Data(ArrayList<String> metaInfo, ArrayList<ArrayList<Object>> data) {
        this.data = data;
        this.metaInfo = metaInfo;
        dataSize = new ArrayList<>();
        dataSize.add(data.size());
        dataSize.add(metaInfo.size());
    }

    public ArrayList<String> getMetaInfo() {
        return metaInfo;
    }

    public String getMetaInfo(int index) {
        return metaInfo.get(index);
    }

    public ArrayList<Integer> getDataSize() {
        return dataSize;
    }

    public ArrayList<ArrayList<Object>> getAll() {
        return data;
    }

    public ArrayList<Object> get(int index) {
        return data.get(index);
    }
    
    public ArrayList<Object> getCol(int col) {
        ArrayList<Object> arr = new ArrayList<>();
        for (ArrayList<Object> row : data) {
            arr.add(row.get(col));
        }
        return arr;
    }

    public Object get(int row, int col) {
        return data.get(row).get(col);
    }

    @Override
    public Iterator iterator() {
        return data.iterator();
    }

}
