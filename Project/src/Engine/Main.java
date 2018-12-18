/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import Exception.FileException;
import InputAndOutput.WorkSpaceIO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Poowis
 */
public class Main implements Serializable {

    private WorkSpace currentWS;
    private ArrayList<WorkSpace> recentWS;
    private final int MAX_WS = 10;

    public Main() {
        currentWS = new WorkSpace();
        recentWS = new ArrayList<>(MAX_WS);
    }

    public void newWS() throws IOException, FileNotFoundException, FileException {
        changeRecentWS();
        currentWS = new WorkSpace();
    }

    public void loadWS(int index) throws IOException, FileNotFoundException, FileException {
        WorkSpace tmp = recentWS.get(index);
        changeRecentWS();
        currentWS = tmp;
    }

    public void importWS(String path) throws IOException, FileNotFoundException, FileException, ClassNotFoundException {
        changeRecentWS();
        currentWS = WorkSpaceIO.ImportWorkSpace(path);
    }

    public void exportWS(String path) throws IOException, FileNotFoundException, FileException, ClassNotFoundException {
        WorkSpaceIO.ExportWorkSpace(path, currentWS);
    }

    public void changeRecentWS() throws IOException {
        if (recentWS.contains(currentWS)) {
            recentWS.remove(currentWS);
        }
        if (recentWS.size() == MAX_WS) {
            recentWS.remove(0);
        }
        recentWS.add(currentWS);

    }

    public WorkSpace getCurrentWS() {
        return currentWS;
    }

    public ArrayList<WorkSpace> getRecentWS() {
        return recentWS;
    }

    public void update() throws IOException, FileNotFoundException, FileException {
        currentWS.update();
    }

    public void importData(String path) throws IOException, FileNotFoundException, FileException {
        currentWS.importData(path);
    }

}
