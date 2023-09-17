package iuh.vn.edu.fit.models;

public enum EmployeeStatus {
    ACTIVE(1),
    INACTIVE(0),
    TERMINATE(-1);

    private int values;

     EmployeeStatus(int values) {
        this.values = values;
    }

    public int getValues() {
        return values;
    }
}
