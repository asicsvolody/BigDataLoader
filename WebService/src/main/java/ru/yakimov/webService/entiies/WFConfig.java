package ru.yakimov.webService.entiies;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

@Entity
@Table(name = "WF_CONFIG")
public class WFConfig implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "VERSION")
    private int version;

    @OneToMany(mappedBy = "wfConfig", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<DirectoryFrom> dirFrom = new HashSet<>();

    @Column(name = "DIR_TO")
    private String dirTo;

    @OneToMany(mappedBy = "wfConfig", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<PartitionColumn> partitions = new HashSet<>();

    @OneToOne(mappedBy = "wfConfig", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private TableConf TableConf;

    @OneToOne
    @JoinColumn(name = "WORKFLOW_ID", referencedColumnName="id", nullable = false)
    private Workflow workflow;


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

    public Set<DirectoryFrom> getDirFrom() {
        return dirFrom;
    }

    public void setDirFrom(Set<DirectoryFrom> dirFrom) {
        this.dirFrom = dirFrom;
    }

    public String getDirTo() {
        return dirTo;
    }

    public void setDirTo(String dirTo) {
        this.dirTo = dirTo;
    }

    public Set<PartitionColumn> getPartitions() {
        return partitions;
    }

    public void setPartitions(Set<PartitionColumn> partitions) {
        this.partitions = partitions;
    }

    public ru.yakimov.webService.entiies.TableConf getTableConf() {
        return TableConf;
    }

    public void setTableConf(ru.yakimov.webService.entiies.TableConf tableConf) {
        TableConf = tableConf;
    }

    public Workflow getWorkflow() {
        return workflow;
    }

    public void setWorkflow(Workflow workflow) {
        this.workflow = workflow;
    }

    public boolean addPartitionColumn(PartitionColumn partitionColumn){
        return this.partitions.add(partitionColumn);
    }

    public boolean addDirectoryFrom(DirectoryFrom directoryFrom){
        return this.dirFrom.add(directoryFrom);
    }

    public List<DirectoryFrom> getDirFromList(){
        return new ArrayList<>(this.dirFrom);
    }

    public List<PartitionColumn> getPartitionsColumnList(){
        return new ArrayList<>(this.partitions);
    }

}
