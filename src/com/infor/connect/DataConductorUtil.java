package com.infor.connect;


import java.io.*;
import java.nio.charset.Charset;
import java.sql.*;
import java.text.SimpleDateFormat;

public class DataConductorUtil {

    public static File getTable(DatabaseQuery dq) throws SQLException, IOException {

        File file = null;
        try {
            file = File.createTempFile("shu_", (String)null);
            String dir = file.getAbsolutePath();
            file.delete();
            File dirFile = new File(dir);
            dirFile.mkdir();
        } catch (IOException e) {
            e.printStackTrace();
        }
        file = new File(file.getPath() + File.separator + dq.getQueryName().trim() + ".txt");

        StringBuilder message = new StringBuilder();
        long rowCount = 0L;
       // boolean dealwithUTF16BEFromEasySoft = false;
        Connection conn = null;
        String uName = dq.getUsername();

        if(dq.getUsername()!= null && dq.getPassword() != null && dq.getUsername().length() > 0){

            String driverName = DatabaseUtil.getDriverName(dq.getDatabaseType());
            try {
                Class.forName(driverName);
            } catch (ClassNotFoundException var16) {

            }

            try {
                Class.forName(driverName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            String connectString = DatabaseUtil.getConnectString(driverName, dq.getServerName(),dq.getDatabaseName(),dq.getPort(),dq.getDatabaseType(),null,false,null);

            conn = DriverManager.getConnection(connectString, dq.getUsername(), dq.getPassword());
            if (conn == null) {

                throw new SQLException(message.toString());
            }
            DatabaseMetaData dbMetaData = conn.getMetaData();
            if (dbMetaData != null && dbMetaData.supportsTransactions()) {
                conn.setAutoCommit(false);
            }

            Statement stmt = null;
            boolean isDbHiveImpala = driverName.equals("org.apache.hadoop.hive.jdbc.HiveDriver") || driverName.equals("org.apache.hive.jdbc.HiveDriver") || driverName.equals("org.apache.drill.jdbc.Driver");
            if (isDbHiveImpala) {
                stmt = conn.createStatement();
            } else {
                stmt = conn.createStatement(1003, 1007);
            }
            ResultSet rs = null;
            try {
                stmt.setFetchSize(1000);
            } catch (Exception var45) {

            }
            rs = stmt.executeQuery(dq.getQuery());
            BufferedWriter writer = null;

            try {
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
                ResultSetMetaData rsmd = rs.getMetaData();
                int numColumns = rsmd.getColumnCount();
                int[] columnTypes = new int[numColumns + 1];

                for(int i = 1; i <= numColumns; ++i) {
                    columnTypes[i] = rsmd.getColumnType(i);
                    if (i > 1) {
                        writer.write(124);
                    }

                    String label = rsmd.getColumnLabel(i);
                   // logger.debug(label + ", " + columnTypes[i]);
                    writer.write(label);
                }

                writer.write("\r\n");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                for(Charset utf16be = Charset.forName("UTF-16LE"); rs.next(); ++rowCount) {
                    for(int i = 1; i <= numColumns; ++i) {
                        if (i > 1) {
                            writer.write(124);
                        }

                        Object o = null;

                        String s;
                        int j;
                        try {
                            switch(columnTypes[i]) {
                                case -16:
                                case -15:
                                case -9:
                                case -8:
                                case -1:
                                case 1:
                                case 12:
                                    o = rs.getString(i);
//                                    if (dealwithUTF16BEFromEasySoft && o != null) {
//                                        s = o.toString();
//                                        byte[] rawBytes = new byte[s.length()];
//
//                                        for(j = 0; j < s.length(); ++j) {
//                                            rawBytes[j] = (byte)(s.charAt(j) & 255);
//                                        }
//
//                                        o = new String(rawBytes, utf16be);
//                                    }
                                    break;
                                case 93:
                                    if (isDbHiveImpala) {
                                        o = rs.getObject(i);
                                    } else {
                                        o = rs.getTimestamp(i);
                                    }
                                    break;
                                default:
                                    o = rs.getObject(i);
                            }
                        } catch (SQLException var46) {
                          //  logger.warn(var46.getMessage());
                        }

                        if (o != null) {
                            if (Timestamp.class.isInstance(o)) {
                                writer.write(sdf.format((Timestamp)o));
                            } else if (o instanceof Number) {
                                writer.write(o.toString());
                            } else {
                                s = o.toString();
                                if (s.indexOf(13) < 0 && s.indexOf(10) < 0 && s.indexOf(124) < 0 && s.indexOf(34) < 0 && s.indexOf(92) < 0) {
                                    writer.write(s);
                                } else {
                                    StringBuilder sb = new StringBuilder();

                                    for(j = 0; j < s.length(); ++j) {
                                        if (s.charAt(j) == '\\' || s.charAt(j) == '"' || s.charAt(j) == '|') {
                                            sb.append('\\');
                                        }

                                        sb.append(s.charAt(j));
                                    }

                                    writer.write('"' + sb.toString() + '"');
                                }
                            }
                        }
                    }

                    writer.write("\r\n");
//                    if (rowCount > 0L && rowCount % 10000L == 0L) {
//                        //
//                    }
                }

            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (writer != null) {
                    writer.close();
                }
                try {
                    if (conn != null) {
                        conn.close();
                    }

                } catch (Exception var44) {

                }

            }

        }
         return file;
    }

}
