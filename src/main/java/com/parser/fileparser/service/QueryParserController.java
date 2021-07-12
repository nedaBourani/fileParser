package com.parser.fileparser.service;


import com.parser.fileparser.help.TaskRunner;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/parser")
public class QueryParserController {

    QueryParserService queryParserService;
    private TaskRunner taskRunner;

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getStore(HttpServletRequest request) {
        taskRunner.start();
        queryParserService.parse();
        return null;
    }
}
