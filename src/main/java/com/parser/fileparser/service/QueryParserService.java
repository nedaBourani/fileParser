package com.parser.fileparser.service;

import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class QueryParserService {

    public List<String> queryList;
    private Long indexOfQueryList = 0L;

    @Value("${query.file.path}")
    String filePath;

    @Autowired
    public QueryParserService(@Value("${query.file.path}") String filePath) throws IOException {
        readFile();
    }

    private void readFile() throws IOException {
        File file = new File(filePath);
        queryList = Files.readAllLines(file.toPath());
    }

    @Synchronized
    public void parse() {
        getQuery();
    }

    private synchronized String getQuery() {
        indexOfQueryList++;
        return queryList.get(indexOfQueryList.intValue());
    }

}