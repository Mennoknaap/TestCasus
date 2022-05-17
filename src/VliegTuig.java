public class VliegTuig {


    public boolean magVliegen(boolean toestemming, int gewicht, int windkracht) {
        if (!toestemming) {
            return false;
        } if (gewicht > 1000) {

            if (windkracht <= 50) {
                return false;
            }
        }
        return true;
    }

    public int landPrijs(int gewicht) {
        if (gewicht < 1000) {
            return 100;
        }
        if (gewicht >= 1000 && gewicht < 5000) {
            return 500;
        }
        return 2500;
    }

    public int prijsExtras(int prijs, int passagiers, boolean nl, boolean luchthavenAfhandelt) {
        if (passagiers > 2) {
            prijs *= 1.5;
        }
        if (luchthavenAfhandelt) {
            prijs += 800;
        } if (nl) {
            prijs *= 1.21;
        }
        return prijs;
    }
}
