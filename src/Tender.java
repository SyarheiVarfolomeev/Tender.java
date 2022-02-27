import java.math.BigDecimal;
import java.util.*;

import Exception.NoSuitableBrigadeException;

public class Tender {
   private LinkedHashMap<Skills, Integer> brigadeRequirements;

   public Tender() {
      this.brigadeRequirements = new LinkedHashMap<>();
   }

   public LinkedHashMap<Skills, Integer> getBrigadeRequirements() {
      return brigadeRequirements;
   }
   public void addEmployeeRequirements(Skills skill, Integer count) {
      brigadeRequirements.put(skill, count);
   }

   public Brigade chooseBrigade(ArrayList<Brigade> brigades) throws NoSuitableBrigadeException {
      BigDecimal lowestProposal = brigades.get(0).getPriceBrigade();
      int brigadeWinner = -1;
      for (int i = 0; i < brigades.size(); i++) {
         HashMap<Skills, Integer> brigadeCapabilities = brigadeCapabilitiesSummary(brigades, i);
         boolean check = brigadeCapabilitiesCheck(brigadeCapabilities, brigadeRequirements);
         if ((check) & ((brigades.get(i).getPriceBrigade().compareTo(lowestProposal) < 0)
                 | (brigades.get(i).getPriceBrigade().compareTo(lowestProposal) == 0))) {
            lowestProposal = brigades.get(i).getPriceBrigade();
            brigadeWinner = i;
         }
      }
      if (brigadeWinner == -1) throw new NoSuitableBrigadeException
              ("Проект закрыт в связи c отсутствием подходящих бригад");
      return brigades.get(brigadeWinner);
   }

   private HashMap<Skills, Integer> brigadeCapabilitiesSummary(ArrayList<Brigade> brigades, int i) {
      HashMap<Skills, Integer> brigadeCapabilities = new HashMap<>();
      for (Employee employee : brigades.get(i).getEmployeeBrigade()) {
         for (Skills skill : employee.getSkills()) {
            if (!brigadeCapabilities.containsKey(skill)) brigadeCapabilities.put(skill, 1);
            else brigadeCapabilities.put(skill, brigadeCapabilities.get(skill) + 1);
         }
      }
      return brigadeCapabilities;
   }

   private boolean brigadeCapabilitiesCheck
           (HashMap<Skills, Integer> brigadeCapabilities, LinkedHashMap<Skills, Integer> brigadeRequirements) {
      for (Map.Entry<Skills, Integer> entry : brigadeRequirements.entrySet()) {
         Skills key = entry.getKey();
         Integer value = entry.getValue();
         if (!brigadeCapabilities.containsKey(key)) return false;
         else {
            if (brigadeCapabilities.get(key) < value) {
               return false;
            }
         }
      }
      return true;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Tender tender = (Tender) o;
      return Objects.equals(brigadeRequirements, tender.brigadeRequirements);
   }

   @Override
   public int hashCode() {
      return Objects.hash(brigadeRequirements);
   }

}
