package com.store.db.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 通过实体类生成建表SQL语句实现方法
 * @author: fengjiawei
 * @date: 2022/7/18 23:04
**/
public class EntryToSqlUtils {


    public static void main(String[] args) {
        //实体类所在的package在磁盘上的绝对路径
        String packageName = "/Users/fengjiawei/Develop/code/department-store/service-db/src/main/java/com/store/db/entry";

        //生成sql的文件夹
        String filePath = "/Users/fengjiawei/Develop/code/department-store/service-db/src/main/resources/sql";
        //项目中实体类的路径
        String prefix = "com.store.db.entry.";
        String className = "";

        StringBuffer sqls = new StringBuffer();
        //获取包下的所有类名称
        List<String> list = getAllClasses(packageName);
        for (String str : list) {
            className = prefix + str.substring(0, str.lastIndexOf("."));
            String sql = generateSql(className, filePath);
            sqls.append(sql);
        }
        System.out.println(sqls.toString());
        StringToSql(sqls.toString(), filePath + "/allTable.sql");

    }
    /**
     * 根据实体类生成建表语句
     * @author
     * @date
     * @param className 全类名
     * @param filePath 磁盘路径  如 : d:/workspace/
     */
    public static String generateSql(String className,String filePath){
        try {
            Class<?> clz = Class.forName(className);
            className = camelToUnderline(clz.getSimpleName());
            Field[] fields = clz.getDeclaredFields();
            StringBuffer column = new StringBuffer();
            for (Field f : fields) {
                String varchar = getTableField(f) + " CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,";
                column.append(" \n `"+camelToUnderline(f.getName())+"`").append(varchar);
            }
            StringBuffer sql = new StringBuffer();
            sql.append("\n DROP TABLE IF EXISTS `"+className+"`; ")
                    .append(" \n CREATE TABLE `"+className+"`  (")
                    .append(" \n `id` int(11) NOT NULL AUTO_INCREMENT,")
                    .append(" \n "+column)
                    .append(" \n PRIMARY KEY (`id`) USING BTREE,")
                    .append("\n INDEX `id`(`id`) USING BTREE")
                    .append(" \n ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8_general_ci;");
            return sql.toString();
        } catch (ClassNotFoundException e) {
//            logger.debug("该类未找到！");
            return null;
        }

    }

    public static String getTableField(Field f){

        switch (f.getType().getName()){
            case "java.lang.String":
                return " varchar(255) ";
            case "int":
                return " int(11) ";
            case "java.lang.Integer":
                return " int(11) ";
            case "java.util.Date":
                return " datetime ";
            case "Double":
                return " decimal(2,10) ";
            case "java.lang.Double":
                return " decimal(2,10) ";
            case "boolean":
                return " tinyint(1) ";
            case "java.lang.Boolean":
                return " tinyint(1) ";
            default:
                return " varchar(255) ";
        }
    }

    /**
     * 获取包下的所有类名称,获取的结果类似于 XXX.java
     * @author
     * @date
     * @param packageName
     * @return
     */
    public static List<String> getAllClasses(String packageName){
        List<String> classList = new ArrayList<String>();
        String className="";
        File f = new File(packageName);
        if(f.exists() && f.isDirectory()){
            File[] files = f.listFiles();
            for (File file : files) {
                className = file.getName();
                classList.add(className);
            }
            return classList;
        }else{
//            logger.debug("包路径未找到！");
            return null;
        }
    }
    /**
     * 将string 写入sql文件
     * @author
     * @date
     * @param str
     * @param path
     */
    public static void StringToSql(String str,String path){
        byte[] sourceByte = str.getBytes();
        if(null != sourceByte){
            try {
                File file = new File(path);     //文件路径（路径+文件名）
                if (!file.exists()) {   //文件不存在则创建文件，先创建目录
                    File dir = new File(file.getParent());
                    dir.mkdirs();
                    file.createNewFile();
                }
                FileOutputStream outStream = new FileOutputStream(file);    //文件输出流用于将数据写入文件
                outStream.write(sourceByte);
                outStream.flush();
                outStream.close();  //关闭文件输出流
                System.out.println("生成成功");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 驼峰转下划线
     * @param line
     * @return
     */
    public static String camelToUnderline(String line){
        line=String.valueOf(line.charAt(0)).toUpperCase().concat(line.substring(1));
        StringBuffer sb=new StringBuffer();
        Pattern pattern=Pattern.compile("[A-Z]([a-z\\d]+)?");
        Matcher matcher=pattern.matcher(line);
        while(matcher.find()){
            String word=matcher.group();
            sb.append(word.toUpperCase());
            sb.append(matcher.end()==line.length()?"":"_");
        }
        return sb.toString().toLowerCase();
    }
}
