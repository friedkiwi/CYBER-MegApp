package gent.cyber.energymon.actions;

import com.opensymphony.xwork2.ActionSupport;
import gent.cyber.energymon.models.EnergyPayment;

import java.util.Date;
import java.util.logging.Logger;

public class PaymentAction extends ActionSupport {
    private transient Logger log = Logger.getLogger(this.getClass().getName());
    private EnergyPayment energyPaymentBean;

    @Override
    public String execute() {
        return SUCCESS;
    }

    @Override
    public void validate() {
        super.validate();

        if (energyPaymentBean.getAmountPaid() <= 0) {
            addFieldError("energyPaymentBean.amountPaid", "Invalid payment amount specified.");
        }
        energyPaymentBean.setDatePaymentMade(new Date());
    }

    public EnergyPayment getEnergyPaymentBean() {
        return energyPaymentBean;
    }

    public void setEnergyPaymentBean(EnergyPayment energyPaymentBean) {
        this.energyPaymentBean = energyPaymentBean;
    }
}
