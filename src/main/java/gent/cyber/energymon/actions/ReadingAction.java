package gent.cyber.energymon.actions;

import com.opensymphony.xwork2.ActionSupport;
import gent.cyber.energymon.HibernateUtil;
import gent.cyber.energymon.models.MeterReading;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadingAction extends ActionSupport {
    private transient Logger log = Logger.getLogger(this.getClass().getName());
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
                log.log(Level.SEVERE,"Error while storing meter reading in database.", e);
            }
            return "saved";
        }
        return SUCCESS;
    }

    @Override
    public void validate() {
        if (meterReadingBean == null) return;
        if (meterReadingBean.getReading() <= 0) {
            addFieldError("meterReadingBean.reading", "Invalid meter reading");
        }
        meterReadingBean.setDateTimeTaken( new Date());
    }

    public MeterReading getMeterReadingBean() {
        return meterReadingBean;
    }

    public void setMeterReadingBean(MeterReading meterReadingBean) {
        this.meterReadingBean = meterReadingBean;
    }
}
