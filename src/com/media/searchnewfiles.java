package com.media;

<<<<<<< HEAD
<<<<<<< HEAD

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class searchnewfiles {
    public Map<String, Boolean> listDrives() {
        FileSystemView fsv = FileSystemView.getFileSystemView();
        Map<String, Boolean> drives = new HashMap<>();
        File[] roots = File.listRoots();
        System.out.println("Found " + roots.length + " roots ");
        for (int i = 0; i < roots.length; i++) {
//            fsv.getSystemTypeDescription(roots[i]);
            System.out.println(roots[i].toString() + " exists= " + roots[i].exists()+"type"+fsv.getSystemTypeDescription(roots[i]));
        }
        return drives;
    }
=======
public class searchnewfiles {
>>>>>>> parent of 2ca55ad... File Search and Insert Query
=======
public class searchnewfiles {
>>>>>>> parent of 2ca55ad... File Search and Insert Query
}
