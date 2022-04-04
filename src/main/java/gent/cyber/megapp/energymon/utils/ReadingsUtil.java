package gent.cyber.megapp.energymon.utils;

import gent.cyber.megapp.energymon.models.MeterReading;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

public class ReadingsUtil {
    public static MeterReading getLastMeterReading() {
        MeterReading lastMeterReading = new MeterReading();
        lastMeterReading.setReading(0);
        lastMeterReading.setDateTimeTaken(new Date());
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<MeterReading> meterReadings = session.createQuery("from MeterReading ", MeterReading.class).list();
        for (MeterReading meterReading : meterReadings) {
            if (meterReading.getReading() > lastMeterReading.getReading())
                lastMeterReading = meterReading;
        }

        return lastMeterReading;
    }

    public static List<MeterReading> getAllMeterReadings() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        return session.createQuery("from MeterReading ", MeterReading.class).list();
    }
}
