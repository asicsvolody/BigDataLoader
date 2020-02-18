package ru.yakimov.webService.entiies;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

@Entity
@Table(name = "TABLE_CONF")
public class TableConf implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "VERSION")
    private int version;

    @Column(name = "TABLE_CONF_HOST")
    private String host;

    @Column(name = "TABLE_CONF_PORT")
    private String port;

    @Column(name = "TABLE_CONF_USERNAME")
    private String username;

    @Column(name = "TABLE_CONF_PASSWORD")
    private String password;

    @Column(name = "TABLE_CONF_SCHEMA")
    private String schema;

    @Column(name = "TABLE_CONF_TABLE")
    private String table;

    @OneToMany(mappedBy = "tableConf", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<TablePrimaryKay> primaryKeys = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "WF_CONFIG_ID", referencedColumnName="id", nullable = false)
    private WFConfig wfConfig;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
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

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public Set<TablePrimaryKay> getPrimaryKeys() {
        return primaryKeys;
    }

    public void setPrimaryKeys(Set<TablePrimaryKay> primaryKeys) {
        this.primaryKeys = primaryKeys;
    }

    public WFConfig getWfConfig() {
        return wfConfig;
    }

    public void setWfConfig(WFConfig wfConfig) {
        this.wfConfig = wfConfig;
    }

    public boolean addPrimaryKay(TablePrimaryKay tablePrimaryKay){
        return this.primaryKeys.add(tablePrimaryKay);
    }
}
