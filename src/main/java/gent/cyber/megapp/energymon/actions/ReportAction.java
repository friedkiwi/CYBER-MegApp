package gent.cyber.megapp.energymon.actions;


import gent.cyber.megapp.authentication.AuthenticatedActionSupport;
import gent.cyber.megapp.energymon.models.EnergyPayment;
import gent.cyber.megapp.energymon.models.MeterReading;
import gent.cyber.megapp.energymon.utils.PaymentsUtil;
import gent.cyber.megapp.energymon.utils.ReadingsUtil;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;

@Namespace("/energymon")
public class ReportAction extends AuthenticatedActionSupport {
    private transient final Logger log = Logger.getLogger(this.getClass().getName());

    @Action(value = "report", results = {
            @Result(name = SUCCESS, location = "/WEB-INF/energymon/report.jsp"),
    })
    public String execute() {
        return SUCCESS;
    }

    public double getBalance() {
        return PaymentsUtil.getPaymentBalance();
    }

    public MeterReading getLastMeterReading() {
        try {
            return ReadingsUtil.getLastMeterReading();
        } catch (Exception e) {
            log.log(Level.SEVERE,"Error while querying meter reading database.", e);
            return new MeterReading();
        }
    }

    public List<MeterReading> getMeterReadings() {
        return ReadingsUtil.getAllMeterReadings();
    }

    public List<EnergyPayment> getPayments() {
        return PaymentsUtil.getAllPayments();
    }
}
