import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class VliegTuigTest {
    // condition en desicion testen
    @ParameterizedTest
    @CsvSource({"true, 600, 60, true", "false, 10000, 2, false"})
    void condition(boolean toestemming, int gewicht, int wind, boolean expected) {
        VliegTuig vliegTuig = new VliegTuig();
        assertEquals(expected, vliegTuig.magVliegen(toestemming, gewicht, wind));
    }

    @ParameterizedTest
    @CsvSource({"false, 600, 1, false", "true, 10000, 100, true"})
    void decision(boolean toestemming, int gewicht, int wind, boolean expected) {
        VliegTuig vliegTuig = new VliegTuig();
        assertEquals(expected, vliegTuig.magVliegen(toestemming, gewicht, wind));
    }

    @ParameterizedTest
    @CsvSource({"true, 600, 100, true", "false, 10000, 1, false"})
    void conditiondecision(boolean toestemming, int gewicht, int wind, boolean expected) {
        VliegTuig vliegTuig = new VliegTuig();
        assertEquals(expected, vliegTuig.magVliegen(toestemming, gewicht, wind));
    }

    @ParameterizedTest
    @CsvSource({"true, 600, 100, true", "false, 600, 100, false", "true, 10000, 1, false", "true, 600, 1, true", "true, 10000, 100, true"})
    void modifiedconditiondecision(boolean toestemming, int gewicht, int wind, boolean expected) {
        VliegTuig vliegTuig = new VliegTuig();
        assertEquals(expected, vliegTuig.magVliegen(toestemming, gewicht, wind));
    }

    @ParameterizedTest
    @CsvSource({"true, 600, 100, true", "false, 600, 100, false", "false, 10000, 100, false", "false, 10000, 1, false", "true, 600, 1, true", "true, 10000, 1, false", "true, 10000, 100, true", "false, 600, 1, false"})
    void multiplecondition(boolean toestemming, int gewicht, int wind, boolean expected) {
        VliegTuig vliegTuig = new VliegTuig();
        assertEquals(expected, vliegTuig.magVliegen(toestemming, gewicht, wind));
    }

    //equivalentieklasse test
    @ParameterizedTest
    @CsvSource({"1, 100", "999, 100", "1000, 500", "1001, 500", "4999, 500", "5000, 2500", "5001, 2500" })
    void equivalentclass(int gewicht, int expected) {
        VliegTuig vliegTuig = new VliegTuig();
        assertEquals(expected, vliegTuig.landPrijs(gewicht));
    }

    @ParameterizedTest
    @CsvSource({"5000, 0, true, true, 3993", "5000, 3, false, false, 3750", "1000, 0, true, true, 1573", "1000, 3, false, false, 750", "1, 0, true, true, 1089", "1, 3, false, false, 150"})
    void pairwise(int gewicht, int passagiers, boolean afgehandeld, boolean nl, int expected) {
        VliegTuig vliegTuig = new VliegTuig();
        assertEquals(expected,vliegTuig.prijsExtras(vliegTuig.landPrijs(gewicht), passagiers, nl, afgehandeld));
    }

}