package com.project.gong.memolist;

public class ValidResult extends BaseResult {
    private boolean vaild;

    public ValidResult(String message, boolean vaild) {
        super(message);
        this.vaild = vaild;
    }

    public boolean isVaild() {
        return vaild;
    }

    public void setVaild(boolean vaild) {
        this.vaild = vaild;
    }
}
