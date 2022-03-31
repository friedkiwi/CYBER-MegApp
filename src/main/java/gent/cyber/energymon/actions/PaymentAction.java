package gent.cyber.energymon.actions;

import com.opensymphony.xwork2.ActionSupport;
import gent.cyber.energymon.HibernateUtil;
import gent.cyber.energymon.models.EnergyPayment;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaymentAction extends ActionSupport {
    private transient Logger log = Logger.getLogger(this.getClass().getName());
    private EnergyPayment energyPaymentBean;

    @Override
    public String execute() {
        if (energyPaymentBean != null) {
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                session.save(energyPaymentBean);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                log.log(Level.SEVERE,"Error while storing energy payment in database.", e);
            }
            return "saved";
        }
        return SUCCESS;
    }

    @Override
    public void validate() {
        super.validate();
        if (energyPaymentBean == null) return;
        if (energyPaymentBean.getAmountPaid() <= 0) {
            addFieldError("energyPaymentBean.amountPaid", "Invalid payment amount specified.");
        }
        energyPaymentBean.setDatePaymentMade(new Date());
    }

    public EnergyPayment getEnergyPaymentBean() {
        return energyPaymentBean;
    }

    public void setEnergyPaymentBean(EnergyPayment energyPaymentBean) {
        this.energyPaymentBean = energyPaymentBean;
    }
}
