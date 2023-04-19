package main.java.ru.otus.dao;

public class MethodRunResult {
    private MethodRunStatus status;
    private String errorName;

    public MethodRunResult() {
        status = MethodRunStatus.NoRun;
    }

    public MethodRunStatus getStatus() {
        return status;
    }

    public void setStatus(MethodRunStatus status) {
        this.status = status;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    @Override
    public String toString() {
        return  "status=" + status +
                ", errorName=" + errorName;
    }
}
