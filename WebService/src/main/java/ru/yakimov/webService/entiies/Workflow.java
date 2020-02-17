package ru.yakimov.webService.entiies;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */
@Entity
@javax.persistence.Table(name = "WORKFLOW")
public class Workflow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    @Column(name = "VERSION")
    private int version;

    @Column(name = "TITLE")
    private String title;

    @Column(name ="TYPE")
    private String type;

    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.DATE)
    private Date createDate;

    @Column(name = "LAST_RUN_DATE")
    @Temporal(TemporalType.DATE)
    private Date lastRunDate;

    @OneToOne
    @JoinColumn(name = "WF_CONFIG_ID")
    private DBTable config;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastRunDate() {
        return lastRunDate;
    }

    public void setLastRunDate(Date lastRunDate) {
        this.lastRunDate = lastRunDate;
    }

    public DBTable getConfig() {
        return config;
    }

    public void setConfig(DBTable config) {
        this.config = config;
    }
}
