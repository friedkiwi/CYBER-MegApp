package gent.cyber.megapp.energymon.actions;

import com.opensymphony.xwork2.ActionSupport;
import gent.cyber.megapp.energymon.utils.PaymentsUtil;
import gent.cyber.megapp.energymon.utils.ReadingsUtil;
import gent.cyber.megapp.energymon.models.EnergyPayment;
import gent.cyber.megapp.energymon.models.MeterReading;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import java.util.logging.Level;
import java.util.logging.Logger;

@Namespace("/energymon")
public class IndexAction extends ActionSupport {
    private transient final Logger log = Logger.getLogger(this.getClass().getName());


    @Override
    public String execute() {
        return SUCCESS;
    }

    @Action(value = "index", results = {
            @Result(name = SUCCESS, location = "/WEB-INF/energymon/index.jsp")
    })
    public String index() {
        return SUCCESS;
    }

    public MeterReading getLastMeterReading() {
        try {
            return ReadingsUtil.getLastMeterReading();
        } catch (Exception e) {
            log.log(Level.SEVERE,"Error while querying meter reading database.", e);
            return new MeterReading();
        }
    }

    public EnergyPayment getLastEnergyPayment() {
        try {
            return PaymentsUtil.getLastEnergyPayment();
        } catch (Exception e) {
            log.log(Level.SEVERE,"Error while querying meter reading database.", e);
            return new EnergyPayment();
        }
    }

    public double getBalance() {
        return PaymentsUtil.getPaymentBalance();
    }
}
