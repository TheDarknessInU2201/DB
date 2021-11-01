package com.media;


import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;


public class searchnewfiles {

    public Map<Integer, String> listDrives() {
        FileSystemView fsv = FileSystemView.getFileSystemView();
        Map<Integer, String> drives = new HashMap<>();
        File[] roots = File.listRoots();
        System.out.println("Found " + roots.length + " roots ");
        for (int i = 0; i < roots.length; i++) {
            System.out.println(roots[i].toString() + " exists = " + roots[i].exists() + ", type = " + fsv.getSystemTypeDescription(roots[i]));
            if (fsv.getSystemTypeDescription(roots[i]).equals("Lokaler Datenträger")) {
                if (!roots[i].toString().equals("F:\\")) {
                    drives.put(i, roots[i].toString());
                }
            }
        }
//        System.out.print(drives);
        return drives;
    }

    public Boolean searchMedia() {
        Boolean refreshed = false;
        Map<Integer, String> drives = listDrives();
//        System.out.println(drives);
        for (int i = 0; i < drives.size(); i++) {
            String dirLocation = drives.get(i);
//            System.out.println(dirLocation);
            try {
                Files.walkFileTree(Path.of(dirLocation), new FindMediaFilesVisitor());
            } catch (IOException e) {
                e.printStackTrace();
            }
            refreshed = true;
        }
        return refreshed;


    }

    static class FindMediaFilesVisitor extends SimpleFileVisitor<Path> {
        private long filesCount;

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            if (file.toString().endsWith("mp4")) {
                System.out.println(file.toAbsolutePath()/*+" "+file.getFileName()*/);
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        public long getFilesCount() {
            return filesCount;
        }
    }
}