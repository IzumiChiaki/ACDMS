package com.chiaki.acdms;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

@MapperScan("com.chiaki.acdms.mapper")
@SpringBootApplication

public class AcdmsApplication {
    private static Map<String, Socket> clients=new LinkedHashMap<String, Socket>();
    static PrintWriter pw = null;
    static FileWriter fw = null;

    public static void main(String[] args) {
        SpringApplication.run(AcdmsApplication.class, args);
        int port = 8234;
        try {
            ServerSocket server = new ServerSocket(port);

            while (true) {

                // 获得客户端连接
                // 阻塞式方法
                System.out.println("准备阻塞...");
                final Socket client = server.accept();
                System.out.println("阻塞完成...");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            InputStream is = client.getInputStream();
                            //获取输出流 给客户端写数据
                            OutputStream os = client.getOutputStream();
                            byte[] buffer = new byte[1024];
                            int len = -1;
                            System.out.println("------start reading------");
                            while ((len = is.read(buffer)) != -1) {
                                String text=new String(buffer,0,len,"GBK");
                                System.out.println(text);
                                System.out.println("------finish reading------");

                                if(text.startsWith("#"))
                                {
                                    clients.put(text, client);
                                    os.write(("---Successfully Request---").getBytes());
                                }else{
                                    os.write(("---Already Received---").getBytes());
                                    // 关联文件
                                    File file = new File("123.txt");
                                    if(!file.exists()){
                                        // 判断文件不存在就new新文件,写数据
                                        try {
                                            file.createNewFile();
                                            // java IO流和文件关联
                                            pw = new PrintWriter(file);
                                            pw.print(text + "\t");
                                            pw.println();
                                            pw.flush();
                                        } catch (IOException e) {
                                            // TODO Auto-generated catch block
                                            e.printStackTrace();
                                        }

                                    }else{
                                        // 判断文件存在,就以FileWriter文件追加的方式写文件
                                        try {
                                            fw = new FileWriter("123.txt",true);
                                            fw.write(text + "\r\n");
                                            fw.flush();
                                        } catch (IOException e) {
                                            // TODO Auto-generated catch block
                                            e.printStackTrace();
                                        }
                                    }
                                    //字符串处理
                                    //int s0 = text.indexOf(42);
                                    //int s1 = text.indexOf(64);
                                    //String a0 = text.substring((s0+1),s1);
                                    //System.out.println(a0);
                                    String [] str = text.split("@");
                                    //for(String res : str){
                                    //    System.out.println(res);
                                    //}

                                    //数据库配置及数据导入
                                    String driverClass="com.mysql.jdbc.Driver";
                                    String url="jdbc:mysql://localhost:3306/acdb_chiaki?useSSL=false";
                                    String user="root";
                                    String password="admin";
                                    Connection conn;
                                    Class.forName(driverClass).newInstance();
                                    conn = DriverManager.getConnection(url,user,password);
                                    Statement stmt=conn.createStatement();
                                    Timestamp time= new Timestamp(System.currentTimeMillis());
                                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                    String date = df.format(time);
                                    String sql = "insert into corrosion_data (location_name,areaname,deviceid,probeid," +
                                            "u1,u2,temp_high,temp_low,humidity_high,humidity_low,date) values " +
                                            "('"+str[0]+"','"+str[1]+"','"+str[2]+"','"+str[3]+"','"+str[4]+"'," +
                                            "'"+str[5]+"','"+str[6]+"','"+str[7]+"','"+str[8]+"','"+str[9]+"','"+date+"')";
                                    stmt.execute(sql);
                                }
                            }
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                            run();
                        }
                    }
                }).start();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}