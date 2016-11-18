package ispu442.mobileprint.contolers;

import java.util.ArrayList;
import java.util.List;
import ispu442.mobileprint.models.Printshop;
import ispu442.mobileprint.network.PrintshopHelper;

public class PrintshopContoller {

    private static List<Printshop> Printshops = null;

    public static List<Printshop> GetPrintshops()
    {
        if (Printshops == null)
        {
            Printshops = PrintshopHelper.GetPrintshops();
        }
        return Printshops;
    }
}
