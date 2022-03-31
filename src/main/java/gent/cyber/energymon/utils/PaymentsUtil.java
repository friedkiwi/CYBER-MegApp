package gent.cyber.energymon.utils;

import gent.cyber.energymon.models.EnergyPayment;
import gent.cyber.energymon.models.MeterReading;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;


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

    public static EnergyPayment getLastEnergyPayment() {
        EnergyPayment lastEnergyPayment = new EnergyPayment();
        lastEnergyPayment.setAmountPaid(0.0);
        lastEnergyPayment.setDatePaymentMade(new Date(0));
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<EnergyPayment> energyPayments = session.createQuery("from EnergyPayment", EnergyPayment.class).list();
        for (EnergyPayment energyPayment: energyPayments) {
            if (energyPayment.getDatePaymentMade().getTime() > lastEnergyPayment.getDatePaymentMade().getTime()) {
                lastEnergyPayment = energyPayment;
            }
        }
        return lastEnergyPayment;
    }

    public static double getKwhPrice() {
        if (System.getenv("KWH_PRICE") != null) {
            String kwhPriceString = System.getenv("KWH_PRICE");
            return Double.parseDouble(kwhPriceString);
        }

        return 0.30;
    }

    public static double getPaymentBalance() {
        MeterReading lastMeterReading = ReadingsUtil.getLastMeterReading();
        double totalAmountPaid = getTotalAmountPaid();
        return totalAmountPaid - (getKwhPrice() * lastMeterReading.getReading());
    }
}
