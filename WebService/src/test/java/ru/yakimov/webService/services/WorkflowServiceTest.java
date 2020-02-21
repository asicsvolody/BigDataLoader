package ru.yakimov.webService.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.yakimov.webService.entiies.*;
import ru.yakimov.webService.utils.DateFormatter;

import java.text.ParseException;
import java.util.Locale;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkflowServiceTest {

    @Autowired
    private IWorkflowService workflowService;

    @Autowired
    private DateFormatter formatter;

    @Autowired
    private IWFTypeService wfTypeService;

    @Autowired
    private ILotFileService logFileService;


    @Test
    public void getById() {
        Workflow workflow = workflowService.getAll().get(0);
        assertEquals(workflow.getTitle(), workflowService.getById(workflow.getId()).getTitle());
    }

    @Test
    public void getAll() {
        long count = workflowService.count();
        assertEquals(count, workflowService.getAll().size());
    }

    @Test
    public void save() throws ParseException {
        long workflowCount = workflowService.count();

        Workflow workflow = new Workflow();
        workflow.setTitle("My workflow");



        if (wfTypeService.count() == 0){
            WFType wfType = new WFType();
            wfType.setTitle("SqoopMysqlTpDir");
            wfType.setTypeClass("ru.yakimov.mysqlToDir.SqoopMysqlTpDir");
            wfTypeService.save(wfType);
        }
        workflow.setType(wfTypeService.getAll().get(0));
        workflow.setCreateDate(formatter.parse("2020-02-17", Locale.ENGLISH));
        workflow.setLastRunDate(formatter.parse("2020-02-17", Locale.ENGLISH));

        LogFile logFile = new LogFile();
        logFile.setFilePath("/logPath");
        logFile.setCreateDate(formatter.parse("2020-02-17", Locale.ENGLISH));

//        !!!
        logFile.setWorkflow(workflow);
        workflow.addLogFile(logFile);

        WFConfig wfConfig = new WFConfig();

        DirectoryFrom directoryFrom = new DirectoryFrom();
        directoryFrom.setPath("/tmp/tmp");

        wfConfig.addDirectoryFrom(directoryFrom);

//        !!!
        directoryFrom.setWfConfig(wfConfig);

        wfConfig.setDirTo("/path/path");

        PartitionColumn partitionColumn = new PartitionColumn();
        partitionColumn.setColumnName("USER_ID");
        partitionColumn.setType("int");

        wfConfig.addPartitionColumn(partitionColumn);

//        !!!
        partitionColumn.setWfConfig(wfConfig);

        TableConf tableConf = new TableConf();
        tableConf.setHost("localhost");
        tableConf.setPort("port");
        tableConf.setUsername("root");
        tableConf.setPassword("bhbyf.hnftdf");
        tableConf.setSchema("usersDb");
        tableConf.setTable("users");
        TablePrimaryKay tablePrimaryKay = new TablePrimaryKay();
        tablePrimaryKay.setTitlePrimaryKay("user_id");
        tablePrimaryKay.setType("int");
//        !!!
        tablePrimaryKay.setTableConf(tableConf);
        tableConf.addPrimaryKay(tablePrimaryKay);


        wfConfig.setTableConf(tableConf);
//        !!!
        tableConf.setWfConfig(wfConfig);

        workflow.setWfConfig(wfConfig);
//        !!!
        wfConfig.setWorkflow(workflow);

        Workflow savedWF = workflowService.save(workflow);

        assertEquals(++workflowCount, workflowService.count());

    }

    @Test
    public void update() {
        Workflow wf = workflowService.getAll().get(0);
        long id = wf.getId();
        String[] dataArr = new String[]{
                "New test title",
                "dir to",
                "new Partition column",
                "new user name"
        };

        wf.setTitle(dataArr[0]);
        wf.getWfConfig().setDirTo(dataArr[1]);
        wf.getWfConfig().getPartitions().iterator().next().setColumnName(dataArr[2]);
        wf.getWfConfig().getTableConf().setUsername(dataArr[3]);
        workflowService.save(wf);
        wf = workflowService.getById(id);

        assertArrayEquals(dataArr, new String[]{
                wf.getTitle(),
                wf.getWfConfig().getDirTo(),
                wf.getWfConfig().getPartitions().iterator().next().getColumnName(),
                wf.getWfConfig().getTableConf().getUsername()
        });


    }



    @Test
    public void deleteById() throws ParseException {
        Workflow workflow = new Workflow();
        workflow.setTitle("My workflow");

        workflow.setType(wfTypeService.getAll().get(0));

        workflow.setCreateDate(formatter.parse("2020-02-17", Locale.ENGLISH));
        workflow.setLastRunDate(formatter.parse("2020-02-17", Locale.ENGLISH));
        LogFile logFile = new LogFile();
        logFile.setFilePath("/logPath");
        logFile.setCreateDate(formatter.parse("2020-02-17", Locale.ENGLISH));

//        !!!
        logFile.setWorkflow(workflow);
        workflow.addLogFile(logFile);
        WFConfig wfConfig = new WFConfig();

        DirectoryFrom directoryFrom = new DirectoryFrom();
        directoryFrom.setPath("/tmp/tmp");

        wfConfig.addDirectoryFrom(directoryFrom);

//        !!!
        directoryFrom.setWfConfig(wfConfig);

        wfConfig.setDirTo("/path/path");

        PartitionColumn partitionColumn = new PartitionColumn();
        partitionColumn.setColumnName("USER_ID");
        partitionColumn.setType("int");

        wfConfig.addPartitionColumn(partitionColumn);

//        !!!
        partitionColumn.setWfConfig(wfConfig);

        TableConf tableConf = new TableConf();
        tableConf.setHost("localhost");
        tableConf.setPort("port");
        tableConf.setUsername("root");
        tableConf.setPassword("bhbyf.hnftdf");
        tableConf.setSchema("usersDb");
        tableConf.setTable("users");
        TablePrimaryKay tablePrimaryKay = new TablePrimaryKay();
        tablePrimaryKay.setTitlePrimaryKay("user_id");
        tablePrimaryKay.setType("int");
//        !!!
        tablePrimaryKay.setTableConf(tableConf);
        tableConf.addPrimaryKay(tablePrimaryKay);


        wfConfig.setTableConf(tableConf);
//        !!!
        tableConf.setWfConfig(wfConfig);

        workflow.setWfConfig(wfConfig);
//        !!!
        wfConfig.setWorkflow(workflow);

        Workflow savedWF = workflowService.save(workflow);

        Workflow wf = workflowService.getById(savedWF.getId());

        assertNotNull(wf);

        workflowService.deleteById(wf.getId());

        assertThrows(NoSuchElementException.class,
                ()->workflowService.getById(savedWF.getId())
        );


    }

    @Test
    public void delete() throws ParseException {

        Workflow workflow = new Workflow();
        workflow.setTitle("My workflow");

        workflow.setType(wfTypeService.getAll().get(0));

        workflow.setCreateDate(formatter.parse("2020-02-17", Locale.ENGLISH));
        workflow.setLastRunDate(formatter.parse("2020-02-17", Locale.ENGLISH));
        LogFile logFile = new LogFile();
        logFile.setFilePath("/logPath");
        logFile.setCreateDate(formatter.parse("2020-02-17", Locale.ENGLISH));

//        !!!
        logFile.setWorkflow(workflow);
        workflow.addLogFile(logFile);
        WFConfig wfConfig = new WFConfig();

        DirectoryFrom directoryFrom = new DirectoryFrom();
        directoryFrom.setPath("/tmp/tmp");

        wfConfig.addDirectoryFrom(directoryFrom);

//        !!!
        directoryFrom.setWfConfig(wfConfig);

        wfConfig.setDirTo("/path/path");

        PartitionColumn partitionColumn = new PartitionColumn();
        partitionColumn.setColumnName("USER_ID");
        partitionColumn.setType("int");

        wfConfig.addPartitionColumn(partitionColumn);

//        !!!
        partitionColumn.setWfConfig(wfConfig);

        TableConf tableConf = new TableConf();
        tableConf.setHost("localhost");
        tableConf.setPort("port");
        tableConf.setUsername("root");
        tableConf.setPassword("bhbyf.hnftdf");
        tableConf.setSchema("usersDb");
        tableConf.setTable("users");
        TablePrimaryKay tablePrimaryKay = new TablePrimaryKay();
        tablePrimaryKay.setTitlePrimaryKay("user_id");
        tablePrimaryKay.setType("int");
//        !!!
        tablePrimaryKay.setTableConf(tableConf);
        tableConf.addPrimaryKay(tablePrimaryKay);


        wfConfig.setTableConf(tableConf);
//        !!!
        tableConf.setWfConfig(wfConfig);

        workflow.setWfConfig(wfConfig);
//        !!!
        wfConfig.setWorkflow(workflow);

        Workflow savedWF = workflowService.save(workflow);

        Workflow wf = workflowService.getById(savedWF.getId());
        assertNotNull(wf);

        workflowService.delete(savedWF);

        assertThrows(NoSuchElementException.class,
                ()->workflowService.getById(savedWF.getId())
        );


    }

    @Test
    public void count() {
        assertEquals(workflowService.getAll().size() , workflowService.count());
    }
}