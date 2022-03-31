package gent.cyber.energymon.actions;

import com.opensymphony.xwork2.ActionSupport;
import gent.cyber.energymon.HibernateUtil;
import gent.cyber.energymon.PaymentsUtil;
import gent.cyber.energymon.models.EnergyPayment;
import gent.cyber.energymon.models.MeterReading;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IndexAction extends ActionSupport {
    private transient final Logger log = Logger.getLogger(this.getClass().getName());


    @Override
    public String execute() {
        return SUCCESS;
    }

    public MeterReading getLastMeterReading() {
        try {
            return PaymentsUtil.getLastMeterReading();
        } catch (Exception e) {
            log.log(Level.SEVERE,"Error while querying meter reading database.", e);
            return new MeterReading();
        }
    }

    public EnergyPayment getLastEnergyPayment() {
        EnergyPayment lastEnergyPayment = new EnergyPayment();
        lastEnergyPayment.setAmountPaid(0.0);
        lastEnergyPayment.setDatePaymentMade(new Date(0));
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<EnergyPayment> energyPayments = session.createQuery("from EnergyPayment", EnergyPayment.class).list();
            for (EnergyPayment energyPayment: energyPayments) {
                if (energyPayment.getDatePaymentMade().getTime() > lastEnergyPayment.getDatePaymentMade().getTime()) {
                    lastEnergyPayment = energyPayment;
                }
            }
        } catch (Exception e) {
            log.log(Level.SEVERE,"Error while querying payment database.", e);
        }
        return lastEnergyPayment;
    }

    public double getBalance() {
        return PaymentsUtil.getPaymentBalance();
    }
}
