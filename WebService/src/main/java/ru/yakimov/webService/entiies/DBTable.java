package ru.yakimov.webService.entiies;

import com.sun.javafx.beans.IDProperty;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import java.util.List;

/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

@Entity
@Table(name = "BD_TABLE")
public class DBTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "VERSION")
    private int version;

    @Column(name = "HOST")
    private String host;

    @Column(name = "PORT")
    private String port;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "SCHEMA")
    private String schema;

    @Column(name = "TABLE")
    private String table;

    @OneToMany(mappedBy = "PRIMARY_KAY", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<PrimaryKay> primaryKeys;

    @OneToOne
    @JoinColumn(name = "WF_CONFIG_ID")
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

    public List<PrimaryKay> getPrimaryKeys() {
        return primaryKeys;
    }

    public void setPrimaryKeys(List<PrimaryKay> primaryKeys) {
        this.primaryKeys = primaryKeys;
    }

    public WFConfig getWfConfig() {
        return wfConfig;
    }

    public void setWfConfig(WFConfig wfConfig) {
        this.wfConfig = wfConfig;
    }
}
