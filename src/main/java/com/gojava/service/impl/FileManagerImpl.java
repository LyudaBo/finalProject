package com.gojava.service.impl;

import com.gojava.dao.Utils;
import com.gojava.dao.impl.DataStorage;
import com.gojava.service.FileManager;

import java.io.BufferedReader;

public class FileManagerImpl implements FileManager {


    @Override
    public DataStorage readData(String str) {
        DataStorage testFile = Utils.readFile(str);
        return testFile;
    }

    @Override
    public void writeData(DataStorage dataStorage, String str) {
        Utils.writeFile(str, dataStorage);
    }
}
