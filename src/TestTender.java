import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EnumSet;

public class TestTender {
    public static void main(String[] args) {

        Employee as = new Employee(EnumSet.of(Skills.WELDER, Skills.ELECTRICIAN), new BigDecimal(3000));
        Employee bs = new Employee(EnumSet.of(Skills.ROOFER, Skills.ELECTRICIAN), new BigDecimal(1500));
        Employee cs = new Employee(EnumSet.of(Skills.PLASTERER, Skills.ROOFER), new BigDecimal(2500));
        Employee ds = new Employee(EnumSet.of(Skills.WELDER, Skills.ROOFER), new BigDecimal(1500));
        Employee es = new Employee(EnumSet.of(Skills.PLASTERER, Skills.BRICKLAYER), new BigDecimal(1000));
        Employee fs = new Employee(EnumSet.of(Skills.ELECTRICIAN, Skills.BRICKLAYER), new BigDecimal(2000));
        Employee gs = new Employee(EnumSet.of(Skills.ELECTRICIAN, Skills.ROOFER), new BigDecimal(2500));
        Employee hs = new Employee(EnumSet.of(Skills.PLASTERER, Skills.BRICKLAYER), new BigDecimal(1500));
        Employee is = new Employee(EnumSet.of(Skills.ROOFER, Skills.WELDER), new BigDecimal(1000));
        ArrayList<Employee> aaa = new ArrayList<>();
        aaa.add(as);
        aaa.add(bs);
        aaa.add(cs);
        ArrayList<Employee> bbb = new ArrayList<>();
        bbb.add(ds);
        bbb.add(es);
        bbb.add(fs);
        ArrayList<Employee> ccc = new ArrayList<>();
        ccc.add(gs);
        ccc.add(hs);
        ccc.add(is);
        Brigade ax = new Brigade(aaa);
        Brigade ux = new Brigade(bbb);
        Brigade ox = new Brigade(ccc);
        ArrayList<Brigade> dddd = new ArrayList<>();
        dddd.add(ux);
        dddd.add(ax);
        dddd.add(ox);

        Tender tender = new Tender();
        tender.addEmployeeRequirements(Skills.ROOFER, 1);
        tender.addEmployeeRequirements(Skills.PLASTERER, 1);
        tender.addEmployeeRequirements(Skills.WELDER, 1);
        tender.addEmployeeRequirements(Skills.ELECTRICIAN, 1);
        System.out.println(tender.chooseBrigade(dddd).toString());

    }
}
