package cencusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CensusAnalyser {
    public int loadIndiaCensusData(String csvFilepath) throws CensusAnalyserException, IOException {
        try {

            Reader reader =null;
            CsvToBean<CensusCsv> csvToBean = new CsvToBeanBuilder(reader).withType(CensusCsv.class).withIgnoreLeadingWhiteSpace(true).build();
            Iterator<CensusCsv> censusCsvIterator = csvToBean.iterator();
            int numOfEntries = 0;

                while (censusCsvIterator.hasNext()) {
                    numOfEntries++;
                    CensusCsv censusData = censusCsvIterator.next();
                }
                return numOfEntries;
            } catch(RuntimeException e){
                throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUES);
            }
        }
    }


