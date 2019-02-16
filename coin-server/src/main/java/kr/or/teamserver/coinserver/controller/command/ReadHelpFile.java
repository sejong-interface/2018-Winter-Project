package kr.or.teamserver.coinserver.controller.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadHelpFile {
    private final Logger logger = LoggerFactory.getLogger(ReadHelpFile.class);

    public List<String> getStringBuffer(String filename) {
        List help = new ArrayList();

        try {
            File file = new File(filename);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                logger.info("line={}", line);
                help.add(line);
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            logger.error("Cannot find file", e);
            help.clear();

        } catch (IOException e) {
            logger.error("Cannot open file", e);
            help.clear();
        }

        return help;
    }
}