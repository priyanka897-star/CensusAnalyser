package cencusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CensusAnalyser {
    public int loadIndiaCensusData(String csvFilepath) throws CensusAnalyserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilepath));
            CsvToBean<CensusCsv> csvToBean = new CsvToBeanBuilder(reader).withType(CensusCsv.class).withIgnoreLeadingWhiteSpace(true).build();
            Iterator<CensusCsv> censusCsvIterator = csvToBean.iterator();
            int numOfEntries = 0;
            while (censusCsvIterator.hasNext()){
                numOfEntries++;
                CensusCsv censusData = censusCsvIterator.next();
            }
            return numOfEntries;
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }
}

