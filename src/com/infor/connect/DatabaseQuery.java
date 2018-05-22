package com.infor.connect;

import org.apache.log4j.Logger;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/*
for store the xml
 */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DatabaseQuery that = (DatabaseQuery) o;

        if (port != that.port) return false;
        if (serverName != null ? !serverName.equals(that.serverName) : that.serverName != null) return false;
        if (databaseName != null ? !databaseName.equals(that.databaseName) : that.databaseName != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (databaseType != null ? !databaseType.equals(that.databaseType) : that.databaseType != null) return false;
        if (query != null ? !query.equals(that.query) : that.query != null) return false;
        return queryName != null ? queryName.equals(that.queryName) : that.queryName == null;
    }

    @Override
    public int hashCode() {
        int result = serverName != null ? serverName.hashCode() : 0;
        result = 31 * result + (databaseName != null ? databaseName.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + port;
        result = 31 * result + (databaseType != null ? databaseType.hashCode() : 0);
        result = 31 * result + (query != null ? query.hashCode() : 0);
        result = 31 * result + (queryName != null ? queryName.hashCode() : 0);
        return result;
    }
}
