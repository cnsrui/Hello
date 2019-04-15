package FileTest;

import java.io.File;

/**
 * 利用 File 对文件和目录的操作
 */
public class FileDirOprate {

    public static void main(String[] args) {
        String strDirName = System.getProperty("user.dir");
        File dirName = new File(strDirName);
        showDir(dirName);
        File deleteDir = new File("resource/delDirTest");
        deleteFolder(deleteDir);
    }

    /**
     * 删除目录自己及其子目录，直接彻底删除了，并没有放入回收站
     */
    public static void deleteFolder(File dirName) {
        File deleteDir = dirName;
        File[] files = deleteDir.listFiles();
        if (files != null) {
            for (File file : files) {
                //如果是目录则递归
                if (file.isDirectory()) {
                    deleteFolder(file);
                } else {
                    file.delete();
                }
            }
        }
        // 删除自己
        dirName.delete();
    }

    /**
     * 遍历目录
     */
    public static void showDir(File dirName) {
        File file = dirName;
        if (file.isDirectory()) {
            System.out.println("目录 " + file.toString());
            // 获取当前目录的所有目录和文件列表
            String s[] = file.list();
            System.out.println("该目录共有 " + s.length + " 个目录或文件");
            for (int i = 0; i < s.length; i++) {
                File f = new File(s[i]);
                if (f.isDirectory()) {
                    System.out.println(s[i] + " 是一个目录");
                } else {
                    System.out.println(s[i] + " 是一个文件");
                }
            }
        } else {
            System.out.println(dirName.toString() + " 不是一个目录");
        }
    }

}
