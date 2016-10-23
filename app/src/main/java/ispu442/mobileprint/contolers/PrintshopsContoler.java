package ispu442.mobileprint.contolers;

import java.util.ArrayList;
import java.util.List;
import ispu442.mobileprint.models.Printshop;

public class PrintshopsContoler {

    public static List<Printshop> GetPrintshops()
    {
        List<Printshop> Printshops = new ArrayList<Printshop>();
        Printshops.add(new Printshop("ВосторгПринт", "ул. Рабфаковская 14", 1, 5));
        Printshops.add(new Printshop("FastPrint", "ул. 1-го мая 12", 2, 5));
        Printshops.add(new Printshop("Типография ИГЭУ", "ул. Рабфаковская 15", 3, 5));
        return Printshops;
    }
}
