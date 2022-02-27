import java.math.BigDecimal;
import java.util.EnumSet;
import java.util.Objects;


public class Employee {

    private EnumSet<Skills> Skills;
   private BigDecimal priceEmployee;


    public Employee(EnumSet<Skills> skills, BigDecimal priceEmployee) {
        Skills = skills;
        this.priceEmployee = priceEmployee;
    }

    public EnumSet<Skills> getSkills() {
        return Skills;
    }

    public BigDecimal getPriceEmployee() {
        return priceEmployee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(Skills, employee.Skills) && Objects.equals(priceEmployee, employee.priceEmployee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Skills, priceEmployee);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Skills=" + Skills +
                ", priceEmployee=" + priceEmployee +
                '}';
    }
}
