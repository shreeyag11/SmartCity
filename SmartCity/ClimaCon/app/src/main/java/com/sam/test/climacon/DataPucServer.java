package com.sam.test.climacon;

/**
 * Created by sagar on 9/20/2017.
 */

public class DataPucServer {
    String id;
    String value1;
    String value2;
    String value3;
    String value4;
    String valueVehicleNo;
    String valueDate;
    String valuePucNo;

    public DataPucServer() {

    }

    public DataPucServer(String id, String value1, String value2, String value3, String value4, String valueVehicleNo, String valueDate, String valuePucNo) {
        this.id = id;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
        this.valueVehicleNo = valueVehicleNo;
        this.valueDate = valueDate;
        this.valuePucNo = valuePucNo;
    }

    public String getId() {
        return id;
    }

    public String getValue1() {
        return value1;
    }

    public String getValue2() {
        return value2;
    }
    public String getValue3() {
        return value3;
    }
    public String getValue4() {
        return value4;
    }
    public String getValuePucNo() {
        return valuePucNo;
    }
    public String getValueDate() {
        return valueDate;
    }
    public String getValueVehicleNo() {
        return valueVehicleNo;
    }
}

