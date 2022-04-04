package gent.cyber.megapp.energymon.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="payments")
public class EnergyPayment implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "amount")
    private double amountPaid;

    @Column(name = "paidon")
    private Date datePaymentMade;

    public EnergyPayment(double amountPaid, Date datePaymentMade) {
        this.amountPaid = amountPaid;
        this.datePaymentMade = datePaymentMade;
    }

    public EnergyPayment() {
    }

    public int getId() {
        return id;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Date getDatePaymentMade() {
        return datePaymentMade;
    }

    public void setDatePaymentMade(Date datePaymentMade) {
        this.datePaymentMade = datePaymentMade;
    }

    @Override
    public String toString() {
        return "EnergyPayment{" +
                "id=" + id +
                ", amountPaid=" + amountPaid +
                ", datePaymentMade=" + datePaymentMade +
                '}';
    }
}
