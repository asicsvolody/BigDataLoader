package ru.yakimov.webService.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

@Controller
@RequestMapping("/workflow")
public class WorkflowController {

    @RequestMapping
    public String list(Model uiModel){
        return "list";

    }
}
