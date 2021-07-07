package com.parser.fileparser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueryParserService {

    private final List<String> queryList;
    public final Integer listSize = 10;

    @Value("${thread.size}")
    Integer threadSize;

    @Autowired
    public QueryParserService(@Value("${query.file.path}") String filePath) throws IOException {
        File file = new File(filePath);
        queryList = Files.readAllLines(file.toPath());
    }

    public void parse() {
        BlockingQueue<Integer> responseTimeQueue = new LinkedBlockingQueue<>(listSize);


        //1-  thread run
        // calc waite time
        // call web service
        // calc response time
        // add to queue
        //

        // add response time
        responseTimeQueue.add(10);

        for (String s : queryList) {

        }
    }

}
