package io.emailadministration.dbutils;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class NumberOfRecordsPerEachTable {
    private String name;
    private Long number;

    public NumberOfRecordsPerEachTable(String name, Long number) {
        this.name = name;
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumberOfRecordsPerEachTable that)) return false;

        if (!name.equals(that.name)) return false;
        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + number.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("{ tableName: %s, numberOfRecords: %s }",
                name, number);
    }
}
