package FileTest;

import java.io.*;

public class FileIOOprate {

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        String fileContent = new String("resource/000.txt");
        String fileIn = new String("resource/123.txt");
        String fileOut = new String("resource/456.txt");
		copyContent(fileIn, fileOut);
        byte[] content = new String("#####我就是插入的数据#####" + "\n").getBytes();
        //insertContent(fileOut, 42, content);
        insertContent(fileOut, 42, fileContent);
    }

    /**
     * 复制文件A的全部内容到B中
     *
     * @param fileIn  代表文件A
     * @param fileOut 代表文件B
     */
    public static void copyContent(String fileIn, String fileOut) {
        try (FileInputStream fis = new FileInputStream(fileIn);
             FileOutputStream fos = new FileOutputStream(fileOut);) {
            // 读取的数据保存在bbuf里
            byte[] bbuf = new byte[32];
            // 只保存读取字节数的数量
            int hasRead = 0;
            // 根据hasRead中保存读取字节数的数量，来输出bbuf中的实际字节数据
            while ((hasRead = fis.read(bbuf)) > 0) {
                fos.write(bbuf, 0, hasRead);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * 向文件中插入新数据，同时保留原始数据
     *
     * @param fileName      被插入文件
     * @param pos           插入位置
     * @param insertContent 被插入数据内容，字节数组
     */
    public static void insertContent(String fileName, int pos, byte[] insertContent) throws IOException {
        // 创建临时文件
        File tmp = File.createTempFile("tmp", null);
        // 退出时将临时文件一起删除
        tmp.deleteOnExit();
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
             // 使用临时文件来保存插入点后的数据
             FileOutputStream tmpOut = new FileOutputStream(tmp);
             FileInputStream tmpIn = new FileInputStream(tmp)) {
            // ------下面代码将插入点后的内容读入临时文件中保存------
            byte[] bbuf = new byte[64];
            // 用于保存实际读取的字节数
            int hasRead = 0;
            raf.seek(pos);
            // 使用循环方式读取插入点后的数据
            while ((hasRead = raf.read(bbuf)) > 0) {
                // 将读取的数据写入临时文件
                tmpOut.write(bbuf, 0, hasRead);
            }
            // ----------下面代码插入内容----------
            // 把文件记录指针重新定位到pos位置
            raf.seek(pos);
            // 追加需要插入的内容
            raf.write(insertContent);
            // 追加临时文件中的内容
            while ((hasRead = tmpIn.read(bbuf)) > 0) {
                raf.write(bbuf, 0, hasRead);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * 向文件中的内容插入到新文件中，同时保留原始数据
     *
     * @param fileName   被插入文件
     * @param pos        插入位置
     * @param insertFile 包含插入数据的文件，从文件中读取内容，字符串类型
     */
    public static void insertContent(String fileName, int pos, String insertFile) throws IOException {
        File tmp = File.createTempFile("tmp", null);
        tmp.deleteOnExit();
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
             // 文件内容
             FileInputStream file = new FileInputStream(insertFile);
             // 使用临时文件来保存插入点后的数据
             FileOutputStream tmpOut = new FileOutputStream(tmp);
             FileInputStream tmpIn = new FileInputStream(tmp)) {
            // ------下面代码将插入点后的内容读入临时文件中保存------
            byte[] bbuf = new byte[64];
            // 用于保存实际读取的字节数
            int hasRead = 0;

            raf.seek(pos);
            // 使用循环方式读取插入点后的数据
            while ((hasRead = raf.read(bbuf)) > 0) {
                // 将读取的数据写入临时文件
                tmpOut.write(bbuf, 0, hasRead);
            }

            // ----------下面代码插入内容----------
            // 把文件记录指针重新定位到pos位置
            raf.seek(pos);
            // 追加需要插入的文件内容
            while ((hasRead = file.read(bbuf)) > 0) {
                raf.write(bbuf, 0, hasRead);
            }

            // 追加临时文件中的内容
            while ((hasRead = tmpIn.read(bbuf)) > 0) {
                raf.write(bbuf, 0, hasRead);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
}