package gent.cyber.energymon.actions;

import com.opensymphony.xwork2.ActionSupport;
import gent.cyber.energymon.HibernateUtil;
import gent.cyber.energymon.models.MeterReading;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;

public class ReadingAction extends ActionSupport {
    private MeterReading meterReadingBean;
    @Override
    public String execute() {
        if (meterReadingBean != null) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                session.save(meterReadingBean);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
            return "saved";
        }
        return SUCCESS;
    }

    public void validate() {
        if (meterReadingBean == null) return;
        if (meterReadingBean.getReading() <= 0) {
            addFieldError("meterReadingBean.reading", "Invalid meter reading");
        }
        meterReadingBean.setDateTimeTaken(LocalDateTime.now());
    }

    public MeterReading getMeterReadingBean() {
        return meterReadingBean;
    }

    public void setMeterReadingBean(MeterReading meterReadingBean) {
        this.meterReadingBean = meterReadingBean;
    }
}
