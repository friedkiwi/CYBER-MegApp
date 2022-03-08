package gent.cyber.energymon.actions;

import com.opensymphony.xwork2.ActionSupport;
import gent.cyber.energymon.HibernateUtil;
import gent.cyber.energymon.models.MeterReading;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IndexAction extends ActionSupport {
    private transient Logger log = Logger.getLogger(this.getClass().getName());


    @Override
    public String execute() {
        return SUCCESS;
    }

    public MeterReading getLastMeterReading() {
        MeterReading lastMeterReading = new MeterReading();
        lastMeterReading.setReading(0);
        lastMeterReading.setDateTimeTaken(LocalDateTime.now());

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<MeterReading> meterReadings = session.createQuery("from MeterReading ", MeterReading.class).list();
            for (MeterReading meterReading : meterReadings) {
                if (meterReading.getReading() > lastMeterReading.getReading())
                    lastMeterReading = meterReading;
            }
        } catch (Exception e) {
            log.log(Level.SEVERE,"Error while querying meter reading database.", e);
        }

        return lastMeterReading;
    }
}
