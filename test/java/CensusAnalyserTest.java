import cencusanalyser.CensusAnalyser;
import cencusanalyser.CensusAnalyserException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;


public class CensusAnalyserTest {
        private static final String INDIA_CENSUS_CSV_FILEPATH = "IndiaStateCensusData.csv";
        private static final String WRONG_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
        @Test
        public void givenIndiaCensusCsvFile_ReturnsCorrectRecords() {
            try {
                CensusAnalyser censusAnalyser = new CensusAnalyser();
                int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILEPATH);
                Assertions.assertEquals(29, numOfRecords);
            }catch (CensusAnalyserException | IOException e){ }
        }
    @Test
    public void givenWrongIndiaCensusCsvFile_ReturnsException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(WRONG_FILE_PATH);
            Assertions.assertEquals(29, numOfRecords);
        }catch (CensusAnalyserException | IOException e){
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }
}

