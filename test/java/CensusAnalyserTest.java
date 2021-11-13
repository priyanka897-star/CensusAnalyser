import cencusanalyser.CensusAnalyser;
import cencusanalyser.CensusAnalyserException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;


public class CensusAnalyserTest {
        private static final String INDIA_CENSUS_CSV_FILEPATH = "IndiaStateCensusData.csv";
        private static final String WRONG_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
        private static final String INDIA_CENSUS_CSV_WRONGDELIMITER = "./src/test/resources/IndiaStateCensusDataWrongDelimiter.csv";
        private static final String STATE_CODE_CSV = "IndiaStateCode.csv";
        private static final String WRONG_STATE_CODE_CSV_FILE = "./src/main/resources/IndiaStateCode.csv";
         private static final String STATECODECSV_WRONGDELIMITER = "./src/test/resources/IndiaStateCodeWrongDelimiter.csv";

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
    @Test
    public void givenIncorrectCsvHeader_ShouldReturnCustomException(){
        try{
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_WRONGDELIMITER);
        }catch (CensusAnalyserException | IOException e){
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUES,e.type);
        }
    }
    @Test
    public void givenStateCodeFile_ReturnsCorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadStateCodeData(STATE_CODE_CSV);
            Assertions.assertEquals(37, numOfRecords);
        }catch (CensusAnalyserException e){ }
    }
    public void givenWrongStateCodePath_ReturnsCustomException(){
        try{
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadStateCodeData(WRONG_STATE_CODE_CSV_FILE);
            Assertions.assertEquals(37, numOfRecords);
        }catch (CensusAnalyserException e){
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }
    @Test
    public void givenStateCodeWrongDelimiter_ReturnCustomException(){
        try{
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(STATECODECSV_WRONGDELIMITER);
        }catch (CensusAnalyserException | IOException e){
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUES,e.type);
        }
    }
}




