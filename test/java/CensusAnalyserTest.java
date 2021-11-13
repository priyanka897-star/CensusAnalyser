import cencusanalyser.CensusAnalyser;
import cencusanalyser.CensusAnalyserException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class CensusAnalyserTest {
        private static final String INDIA_CENSUS_CSV_FILEPATH = "IndiaStateCensusData.csv";

        @Test
        public void givenIndiaCensusCsvFile_ReturnsCorrectRecords() {
            try {
                CensusAnalyser censusAnalyser = new CensusAnalyser();
                int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILEPATH);
                Assertions.assertEquals(29, numOfRecords);
            }catch (CensusAnalyserException e){ }
        }
    }

