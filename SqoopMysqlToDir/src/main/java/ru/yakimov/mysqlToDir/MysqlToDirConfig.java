package ru.yakimov.mysqlToDir;

/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

public class MysqlToDirConfig {

    private String hostDB;
    private String portDB;

    private String usernameDB;
    private String passDB;

    private String fromDbName;
    private String fromTableName;

    private String pathDirTo;

    private String primaryKeys;


    private MysqlToDirConfig(String hostDB,
                             String portDB,
                             String usernameDB,
                             String passDB,
                             String fromDbName,
                             String fromTableName,
                             String pathDirTo,
                             String primaryKeys) {
        this.hostDB = hostDB;
        this.portDB = portDB;
        this.usernameDB = usernameDB;
        this.passDB = passDB;
        this.fromDbName = fromDbName;
        this.fromTableName = fromTableName;
        this.pathDirTo = pathDirTo;
        this.primaryKeys = primaryKeys;
    }

    public static MysqlToDirConfig getConfig(String[] args) throws Exception {
        if(args.length < 8)
            throw new Exception("Args is not correct");
        String hostDB = args[0];
        String baseTo = args[1];

        String usernameDB = args[2];
        String passDB = args[3];

        String fromDbName = args[4];
        String fromTableName = args[5];

        String pathDirTo = args[6];
        String primaryKeys = args[7];

        return new MysqlToDirConfig(hostDB,baseTo,usernameDB, passDB, fromDbName, fromTableName, pathDirTo,primaryKeys);
    }

    public String getHostDB() {
        return hostDB;
    }

    public String getPortDB() {
        return portDB;
    }

    public String getUsernameDB() {
        return usernameDB;
    }

    public String getPassDB() {
        return passDB;
    }

    public String getFromDbName() {
        return fromDbName;
    }

    public String getFromTableName() {
        return fromTableName;
    }

    public String getPathDirTo() {
        return pathDirTo;
    }

    public String getPrimaryKeys() {
        return primaryKeys;
    }
}
