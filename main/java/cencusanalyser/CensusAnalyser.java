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
    
    public int loadStateCodeData(String csvFilepath) throws CensusAnalyserException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilepath));
            CsvToBean<StateCodeCsv> csvToBean = new CsvToBeanBuilder(reader).withType(StateCodeCsv.class).withIgnoreLeadingWhiteSpace(true).build();
            Iterator<StateCodeCsv> censusCsvIterator = csvToBean.iterator();
            int numOfEntries = 0;
            while (censusCsvIterator.hasNext()) {
                numOfEntries++;
                StateCodeCsv censusData = censusCsvIterator.next();
            }
            return numOfEntries;
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        } catch (RuntimeErrorException e){
                throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.WRONG_FILE_EXTENSION);
        }catch (RuntimeException e){
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUES);
        }
    }
   }


