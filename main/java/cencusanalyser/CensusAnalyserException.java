package cencusanalyser;

    public class CensusAnalyserException extends Exception {

        public  ExceptionType type;

        public enum ExceptionType {
                CENSUS_FILE_PROBLEM, CSV_FILE_INTERNAL_ISSUES;
            }

         public CensusAnalyserException(String message, ExceptionType type) {
                    super(message);
                    this.type = type;
         }
  }

