package manager.impl;

import manager.FileSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {

    String directoryName;
    List<FileSystem> fileSystemList;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        fileSystemList = new ArrayList<>();
    }

    @Override
    public void ls() {
        System.out.println("DirectoryName : " + directoryName);
        for (FileSystem fs : fileSystemList) {
            fs.ls();
        }
    }

    public void add(FileSystem fs) {
        this.fileSystemList.add(fs);
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public List<FileSystem> getFileSystemList() {
        return fileSystemList;
    }
}
