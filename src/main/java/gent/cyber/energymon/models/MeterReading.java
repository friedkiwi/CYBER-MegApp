package gent.cyber.energymon.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "readings")
public class MeterReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "value")
    private double reading;

    @Column(name = "moment", nullable = false)
    private LocalDateTime dateTimeTaken;

    public LocalDateTime getDateTimeTaken() {
        return dateTimeTaken;
    }

    public MeterReading() {

    }

    public MeterReading(double reading, LocalDateTime dateTimeTaken) {
        this.reading = reading;
        this.dateTimeTaken = dateTimeTaken;
    }

    public double getReading() {
        return reading;
    }

    public void setReading(double reading) {
        this.reading = reading;
    }

    public void setDateTimeTaken(LocalDateTime dateTimeTaken) {
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
