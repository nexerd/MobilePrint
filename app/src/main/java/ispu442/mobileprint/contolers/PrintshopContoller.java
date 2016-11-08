package ispu442.mobileprint.contolers;

import java.util.ArrayList;
import java.util.List;
import ispu442.mobileprint.models.Printshop;

public class PrintshopContoller {

    public static List<Printshop> GetPrintshops()
    {
        List<Printshop> Printshops = new ArrayList<Printshop>();
        Printshops.add(new Printshop("ВосторгПринт", "ул. Рабфаковская 14", 1, 5));
        Printshops.add(new Printshop("FastPrint", "ул. 1-го мая 12", 2, 5));
        Printshops.add(new Printshop("Типография ИГЭУ", "ул. Рабфаковская 15", 3, 5));
        Printshops.add(new Printshop("Тестова типография 1", "ул. Несуществующая 1", 4, 5));
        Printshops.add(new Printshop("Тестова типография 2", "ул. Несуществующая 2", 5, 5));
        Printshops.add(new Printshop("Тестова типография 3", "ул. Несуществующая 3", 6, 5));
        Printshops.add(new Printshop("Тестова типография 4", "ул. Несуществующая 4", 7, 5));
        Printshops.add(new Printshop("Тестова типография 5", "ул. Несуществующая 5", 8, 5));
        Printshops.add(new Printshop("Тестова типография 6", "ул. Несуществующая 6", 9, 5));
        Printshops.add(new Printshop("Тестова типография 7", "ул. Несуществующая 7", 10, 5));
        Printshops.add(new Printshop("Тестова типография 8", "ул. Несуществующая 8", 11, 5));
        Printshops.add(new Printshop("Тестова типография 8", "ул. Несуществующая 9", 12, 5));
        Printshops.add(new Printshop("Тестова типография 10", "ул. Несуществующая 10", 13, 5));
        return Printshops;
    }
}
