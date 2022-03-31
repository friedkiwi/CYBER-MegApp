package gent.cyber.energymon;

import gent.cyber.energymon.models.EnergyPayment;
import gent.cyber.energymon.models.MeterReading;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;

public class PaymentsUtil {
    public static double getTotalAmountPaid() {
        double totalAmountPaid = 0.0;
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<EnergyPayment> energyPayments = session.createQuery("from EnergyPayment", EnergyPayment.class).list();
        for (EnergyPayment energyPayment: energyPayments) {
            totalAmountPaid += energyPayment.getAmountPaid();
        }

        return totalAmountPaid;
    }

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

    public static double getKwhPrice() {
        if (System.getenv("KWH_PRICE") != null) {
            String kwhPriceString = System.getenv("KWH_PRICE");
            return Double.parseDouble(kwhPriceString);
        }

        return 0.30;
    }

    public static double getPaymentBalance() {
        MeterReading lastMeterReading = getLastMeterReading();
        double totalAmountPaid = getTotalAmountPaid();
        return totalAmountPaid - (getKwhPrice() * lastMeterReading.getReading());
    }
}
