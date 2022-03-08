package gent.cyber.energymon.actions;

import com.opensymphony.xwork2.ActionSupport;
import gent.cyber.energymon.HibernateUtil;
import gent.cyber.energymon.models.MeterReading;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public class IndexAction extends ActionSupport {
    private MeterReading lastMeterReading;

    @Override
    public String execute() {
        return SUCCESS;
    }

    public MeterReading getLastMeterReading() {
        lastMeterReading = new MeterReading();
        lastMeterReading.setReading(0);
        lastMeterReading.setDateTimeTaken(LocalDateTime.now());

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<MeterReading> meterReadings = session.createQuery("from MeterReading ", MeterReading.class).list();
            for (MeterReading meterReading : meterReadings) {
                if (meterReading.getReading() > lastMeterReading.getReading())
                    lastMeterReading = meterReading;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return lastMeterReading;
    }
}
