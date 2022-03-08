package gent.cyber.energymon.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="payments")
public class EnergyPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "amount")
    private double amountPaid;

    @Column(name = "paidon")
    private LocalDateTime datePaymentMade;

    public EnergyPayment(double amountPaid, LocalDateTime datePaymentMade) {
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

    public LocalDateTime getDatePaymentMade() {
        return datePaymentMade;
    }

    public void setDatePaymentMade(LocalDateTime datePaymentMade) {
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
