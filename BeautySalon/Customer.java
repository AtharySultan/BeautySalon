
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer implements java.io.Serializable {

    @Id
    @Column(name="CustomerPhoneNumber")
    private int CustomerPhoneNumber;
    
    @Column(name="CustomerName")
    private String CustomerName;
    
     @Column(name="Service")
    private String Service;
      
     @Column(name="stylist")
    private String stylist;
       
     @Column(name="timeDate")
    private String timeDate;

    public Customer(String CustomerName, int CustomerPhoneNumber, String Service, String stylist, String timeDate) {
        this.CustomerName = CustomerName;
        this.CustomerPhoneNumber = CustomerPhoneNumber;
        this.Service = Service;
        this.stylist = stylist;
        this.timeDate = timeDate;
    }

    public Customer() {
    }
    
    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public void setCustomerPhoneNumber(int CustomerPhoneNumber) {
        this.CustomerPhoneNumber = CustomerPhoneNumber;
    }

    public void setService(String Service) {
        this.Service = Service;
    }

    public void setStylist(String stylist) {
        this.stylist = stylist;
    }

    public void setTimeDate(String timeDate) {
        this.timeDate = timeDate;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public int getCustomerPhoneNumber() {
        return CustomerPhoneNumber;
    }

    public String getService() {
        return Service;
    }

    public String getStylist() {
        return stylist;
    }

    public String getTimeDate() {
        return timeDate;
    }

     
    
}

    
