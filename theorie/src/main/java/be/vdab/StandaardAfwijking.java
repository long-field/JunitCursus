package be.vdab;
import java.io.IOException;
import be.vdab.theorie.repositories.CSVPersoonRepository;
import be.vdab.theorie.services.PersoonService;
class StandaardAfwijking {
    public static void main(String[] args) {
        try {
            var service = new PersoonService(new CSVPersoonRepository());
            System.out.println(service.standaardAfwijkingWeddes());
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
}