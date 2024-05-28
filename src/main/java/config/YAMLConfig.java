package config;

import lombok.Data;

@Data
public class YAMLConfig {

    private Dictable dictable;
    private TimeConst timeConst;

    @Data
    public static class Dictable {
        private String url;
    }
    @Data
    public static class TimeConst {
        private int timeout;
        private int shortWait;
        private  int longWait;
    }
}
