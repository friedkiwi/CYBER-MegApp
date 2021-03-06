package gent.cyber.megapp.energymon.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "readings")
public class MeterReading implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "value")
    private double reading;

    @Column(name = "moment", nullable = false)
    private Date dateTimeTaken;

    public Date getDateTimeTaken() {
        return dateTimeTaken;
    }

    public MeterReading() {

    }

    public MeterReading(double reading, Date dateTimeTaken) {
        this.reading = reading;
        this.dateTimeTaken = dateTimeTaken;
    }

    public double getReading() {
        return reading;
    }

    public void setReading(double reading) {
        this.reading = reading;
    }

    public void setDateTimeTaken(Date dateTimeTaken) {
        this.dateTimeTaken = dateTimeTaken;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MeterReading{" +
                "id=" + id +
                ", reading=" + reading +
                ", dateTimeTaken=" + dateTimeTaken +
                '}';
    }
}
