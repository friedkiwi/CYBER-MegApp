package gent.cyber.energymon.actions;

import com.opensymphony.xwork2.ActionSupport;
import gent.cyber.energymon.utils.PaymentsUtil;
import gent.cyber.energymon.utils.ReadingsUtil;
import gent.cyber.energymon.models.EnergyPayment;
import gent.cyber.energymon.models.MeterReading;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.logging.Level;
import java.util.logging.Logger;

public class IndexAction extends ActionSupport {
    private transient final Logger log = Logger.getLogger(this.getClass().getName());


    @Override
    public String execute() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.warning("Username: " + userDetails.getUsername());
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
