package com.infor.connect;

import org.apache.log4j.Logger;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DatabaseQuery {

    public static final String MSSQL = "Microsoft SQL Server";
    public static final String MYSQL = "MySQL";
    public static final String INFOBRIGHT = "Infobright";
    public static final String ORACLE = "Oracle 11g";
    public static final String ORACLE_ODBC = "Oracle ODBC";
    public static final String MYSQL_ODBC = "MySQL ODBC";
    public static final String DB2_ODBC = "DB2 ODBC";
    public static final String MSSQL_ODBC = "Microsoft SQL Server ODBC";
    public static final String IMPALA = "Impala";
    public static final String MICROSOFT_ANALYSIS_SERVICES = "Microsoft Analysis Services (XMLA)";
    public static final String PENTAHO_MONDRIAN = "Pentaho (Mondrian) Analysis Services (XMLA)";
    public static final String HYPERIAN_ESSBASE = "Hyperion Essbase (XMLA)";
    public static final String SAP_BW = "SAP BW (XMLA)";
    public static final String INFOR_OLAP = "Infor OLAP (XMLA)";
    public static final String VERTICA = "Vertica";
    public static final String TERADATA = "Teradata";
    public static final String SYBASEIQ = "Sybase IQ";
    public static final String PARACCEL = "ParAccel";
    public static final String HIVE = "Hive/Hadoop";
    public static final String MEMDB = "In-memory Database";
    public static final String ODBC = "ODBC";
    public static final String POSTGRESQL = "PostgreSQL";
    public static final String REDSHIFT = "Redshift";
    public static final String HANA = "SAP Hana";


    private String serverName;
    private String databaseName;
    private String username;
    private String password;
    private int port;
    private String databaseType;
    private String query;
    private String queryName;

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }


}
