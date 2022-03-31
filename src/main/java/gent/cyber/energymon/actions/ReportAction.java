package gent.cyber.energymon.actions;

import com.opensymphony.xwork2.ActionSupport;
import gent.cyber.energymon.PaymentsUtil;

public class ReportAction extends ActionSupport {
    @Override
    public String execute() {
        return SUCCESS;
    }

    public double getBalance() {
        return PaymentsUtil.getPaymentBalance();
    }
}
