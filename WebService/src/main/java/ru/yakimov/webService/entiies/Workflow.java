package ru.yakimov.webService.entiies;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */
@Entity
@Table(name = "WORKFLOW")
public class Workflow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    @Column(name = "VERSION")
    private int version;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @OneToOne
    @JoinColumn(name ="TYPE_ID", referencedColumnName="id", nullable = false)
    private WFType type;

    @Column(name = "CREATE_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date createDate;

    @Column(name = "LAST_RUN_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date lastRunDate;

    @OneToMany(mappedBy = "workflow", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<LogFile> logFile = new HashSet<>();

    @OneToOne(mappedBy = "workflow", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public WFType getType() {
        return type;
    }

    public void setType(WFType type) {
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

    public WFConfig getWfConfig() {
        return wfConfig;
    }

    public void setWfConfig(WFConfig wfConfig) {
        this.wfConfig = wfConfig;
    }


    public Set<LogFile> getLogFile() {
        return logFile;
    }

    public void setLogFile(Set<LogFile> logPath) {
        this.logFile = logPath;
    }

    public boolean addLogFile(LogFile logFile){
        return this.logFile.add(logFile);
    }



}
