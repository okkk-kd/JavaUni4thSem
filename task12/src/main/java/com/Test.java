package com;

import lombok.SneakyThrows;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import static com.Task12Application.__arg1;
import static com.Task12Application.__arg2;


public class Test {
    final File txt = new File(__arg1);
    final File hash = new File(__arg2);

    @SneakyThrows
    @PostConstruct
    public void st() {
        StringBuilder writ = new StringBuilder();
        if (txt.exists()) {
            FileReader reader = new FileReader(txt);
            while (reader.read() != -1) {
                writ.append(reader.getEncoding());
            }
            reader.close();
        } else
            writ = new StringBuilder("null");
        assert hash.exists() || hash.createNewFile();

        FileWriter writer = new FileWriter(hash);
        writer.write(String.valueOf(txt.exists() ? writ.toString().hashCode() : writ.toString()));
        writer.close();
    }

    // curl -X POST localhost:port/shutdownContext
    @PreDestroy
    public void destroy() {
        txt.delete();
    }
}
