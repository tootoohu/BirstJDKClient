package com.infor.connect;

import com.infor.connect.DatabaseQuery;

import java.util.Map;

public final class DatabaseUtil {

    public static String getDriverName(String dbType){
        switch (dbType){
            case DatabaseQuery.MSSQL: return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            case DatabaseQuery.ORACLE: return "oracle.jdbc.OracleDriver";
            case DatabaseQuery.MYSQL: return "com.mysql.jdbc.Driver";
            case DatabaseQuery.ODBC:  return "sun.jdbc.odbc.JdbcOdbcDriver";
            default: return "sun.jdbc.odbc.JdbcOdbcDriver";
        }
    }

    public static String getConnectString(String driverName, String serverName, String databaseName, int port, String databaseType, String schema, boolean useTimeZone, String processingTZ) {

        if (driverName != null && !driverName.equals("com.microsoft.sqlserver.jdbc.SQLServerDriver")) {
            String connectStr;
            if (driverName.equals("com.mysql.jdbc.Driver")) {
                boolean isIB = databaseType != null && databaseType.equals("Infobright");
                connectStr = "";
                if (schema != null) {
                    connectStr = schema;
                } else if (databaseName != null) {
                    connectStr = databaseName;
                }

                String connectString = "jdbc:mysql://" + serverName + (port > 0 ? ":" + port : (isIB ? ":5029" : ":3306")) + "/" + connectStr;
                boolean isFirst = true;
                if (useTimeZone && processingTZ != null) {
                    connectString = connectString + "?useTimezone=true" + "&serverTimezone=" + processingTZ;
                    isFirst = false;
                }

                connectString = connectString + (isFirst ? "?" : "&") + "useUnicode=true&characterEncoding=utf8";
                return connectString;
            } else if (driverName.equals("oracle.jdbc.OracleDriver")) {
                return "jdbc:oracle:thin:@" + serverName + ":" + (port > 0 ? port : "1521") + ":" + databaseName;
            } else if (driverName.equals("sun.jdbc.odbc.JdbcOdbcDriver")) {
                return "jdbc:odbc:" + serverName;
            } else {
                if (driverName.equals("org.olap4j.driver.xmla.XmlaOlap4jDriver")) {
                    if (databaseType.equals("Microsoft Analysis Services (XMLA)")) {
                        return "jdbc:xmla:Server=http://" + serverName + ";Catalog=" + databaseName;
                    }

                    if (databaseType.equals("Pentaho (Mondrian) Analysis Services (XMLA)")) {
                        return "jdbc:xmla:Server=http://" + serverName + ";Catalog=" + databaseName;
                    }

                    if (databaseType.equals("SAP BW (XMLA)")) {
                        return "jdbc:xmla:Server=http://" + serverName + ";Catalog=" + databaseName + ";Provider=SAP_BW";
                    }

                    if (databaseType.equals("Hyperion Essbase (XMLA)")) {
                        return "jdbc:xmla:Server=http://" + serverName + ";Catalog=" + databaseName + ";Provider=Essbase";
                    }

                    if (databaseType.equals("Infor OLAP (XMLA)")) {
                        return "jdbc:xmla:Server=http://" + serverName + ";Catalog=" + databaseName + ";Provider=Infor";
                    }
                } else {
                    if (driverName.equals("com.vertica.Driver")) {
                        return "jdbc:vertica://" + serverName + (port > 0 ? ":" + port : "") + "/" + databaseName;
                    }

                    if (driverName.equals("com.teradata.jdbc.TeraDriver")) {
                        return "jdbc:teradata://" + serverName + "/database=" + databaseName + ",tmode=ANSI,charset=UTF8";
                    }

                    if (driverName.equals("org.postgresql.Driver")) {
                        return "jdbc:postgresql://" + serverName + ":" + (port > 0 ? port : "5432") + "/" + databaseName;
                    }

                    if (driverName.equals("com.sybase.jdbc4.jdbc.SybDriver")) {

                        connectStr = "jdbc:sybase:Tds:" + serverName + ":" + (port > 0 ? port : "2638");
                        if (databaseName != null && !databaseName.isEmpty()) {
                            connectStr = connectStr + "?ServiceName=" + databaseName;
                        }

                        return connectStr;
                    }

                    if (driverName.equals("com.paraccel.Driver")) {
                        connectStr = "jdbc:paraccel://" + serverName + ":" + (port > 0 ? port : "5439");
                        if (databaseName != null && !databaseName.isEmpty()) {
                            connectStr = connectStr + "/" + databaseName;
                        }

                        return connectStr;
                    }

                    short defaultport;
                    if (driverName.equals("org.apache.hadoop.hive.jdbc.HiveDriver")) {
                        defaultport = 10000;
                        connectStr = "jdbc:hive://" + serverName + ":" + (port > 0 ? port : defaultport);
                        if (databaseName != null && !databaseName.isEmpty()) {
                            connectStr = connectStr + "/" + databaseName;
                        } else {
                            connectStr = connectStr + "/default";
                        }

                        return connectStr;
                    }

                    if (driverName.equals("org.apache.hive.jdbc.HiveDriver")) {
                        defaultport = 21050;
                        connectStr = "jdbc:hive2://" + serverName + ":" + (port > 0 ? port : defaultport) + "/;auth=noSasl";
                        return connectStr;
                    }

                    if (driverName.equals("com.sap.db.jdbc.Driver")) {
                        defaultport = 30015;
                        connectStr = "jdbc:sap://" + serverName + ":" + (port > 0 ? port : defaultport);
                        return connectStr;
                    }

                    if (driverName.equals("memdb.jdbcclient.DBDriver")) {
                        return "inprocess://" + databaseName;
                    }
                }

                return null;
            }
        } else {
            return "jdbc:sqlserver://" + serverName + (port >= 0 ? ":" + port : "") + ";databaseName=" + databaseName;
        }
    }
}
