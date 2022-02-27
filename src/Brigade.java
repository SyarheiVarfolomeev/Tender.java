import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;


public class Brigade {
   private ArrayList<Employee> employeeBrigade;
   private BigDecimal priceBrigade;

    public Brigade(ArrayList<Employee> employeeBrigade) {
        this.employeeBrigade = employeeBrigade;
        this.priceBrigade = getBrigadePrice(employeeBrigade);
    }

    public ArrayList<Employee> getEmployeeBrigade() {
        return employeeBrigade;
    }

    public BigDecimal getPriceBrigade() {
        return priceBrigade;
    }

    private BigDecimal getBrigadePrice(ArrayList<Employee> employeeBrigade) {
        BigDecimal result = new BigDecimal(0);
        for (int i = 0; i < employeeBrigade.size(); i++){
          result = result.add(employeeBrigade.get(i).getPriceEmployee());
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brigade brigade = (Brigade) o;
        return Objects.equals(employeeBrigade, brigade.employeeBrigade) && Objects.equals(priceBrigade, brigade.priceBrigade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeBrigade, priceBrigade);
    }

    @Override
    public String toString() {
        return "Brigade{" +
                "employeeBrigade=" + employeeBrigade +
                ", priceBrigade=" + priceBrigade +
                '}';
    }
}
