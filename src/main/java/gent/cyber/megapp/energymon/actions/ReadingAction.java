package gent.cyber.megapp.energymon.actions;

import gent.cyber.megapp.authentication.AuthenticatedActionSupport;
import gent.cyber.megapp.energymon.utils.HibernateUtil;
import gent.cyber.megapp.energymon.models.MeterReading;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Namespace("/energymon")
public class ReadingAction extends AuthenticatedActionSupport {
    private transient final Logger log = Logger.getLogger(this.getClass().getName());
    private MeterReading meterReadingBean;

    @Action(value = "reading", results = {
            @Result(name = SUCCESS, location = "/WEB-INF/energymon/reading.jsp"),
            @Result(name = "input", location = "/WEB-INF/energymon/reading.jsp"),
            @Result(name = "saved", type = "redirectAction", params = {"namespace", "/energymon", "actionName", "index"})
    })
    public String reading() {
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
