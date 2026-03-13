package se.sthlm.jfwsthlm.cernemos.decipher;

import java.util.Map;
import java.util.SortedMap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import se.sthlm.jfwsthlm.cernemos.cipher.SubstitutionCipher;

public class SubstitutionDecipherTest
{
    @Test
    void testDecipher()
    {
        SubstitutionCipher substitutionCipher = new SubstitutionCipher();
        String plainText = "DURING THE QUIET HOURS OF AN EARLY AUTUMN MORNING, THE OLD LIBRARY FELT ALMOST ALIVE, ITS FLICKERING " +
         "LAMPS CASTING GENTLE SHADOWS ACROSS SHELVES FILLED WITH STORIES WAITING FOR CURIOUS READERS TO DISCOVER THEM.";

        Map<Character, Character> substitutionKey = Map.ofEntries(
            Map.entry('A', 'Q'),
            Map.entry('B', 'W'),
            Map.entry('C', 'E'),
            Map.entry('D', 'R'),
            Map.entry('E', 'T'),
            Map.entry('F', 'Y'),
            Map.entry('G', 'U'),
            Map.entry('H', 'I'),
            Map.entry('I', 'O'),
            Map.entry('J', 'P'),
            Map.entry('K', 'A'),
            Map.entry('L', 'S'),
            Map.entry('M', 'D'),
            Map.entry('N', 'F'),
            Map.entry('O', 'G'),
            Map.entry('P', 'H'),
            Map.entry('Q', 'J'),
            Map.entry('R', 'K'),
            Map.entry('S', 'L'),
            Map.entry('T', 'Z'),
            Map.entry('U', 'X'),
            Map.entry('V', 'C'),
            Map.entry('W', 'V'),
            Map.entry('X', 'B'),
            Map.entry('Y', 'N'),
            Map.entry('Z', 'M')
        );

        String cipherText = substitutionCipher.cipher(plainText, substitutionKey);

        FrequencyAnalyser frequencyAnalyser = new FrequencyAnalyser();
        Map<Character, Integer> letterFrequency = frequencyAnalyser.countSymbols(cipherText);
        SubstitutionKeyBuilder substitutionKeyBuilder = new SubstitutionKeyBuilder();
        substitutionKeyBuilder.addMissingLettersToFrequencyMap(letterFrequency);
        Map<Character, Character> substitutionKeyFromFrequencyMap = substitutionKeyBuilder.buildKey(letterFrequency);
        String decipheredPlaintext = SubstitutionDecipher.decipher(cipherText, substitutionKeyFromFrequencyMap);

        assertEquals(plainText, decipheredPlaintext);
    }

    @Test
    void testFrequencyOnProvidedCipherText()
    {
        String plainText =
            "THROUGH MANY CENTURIES, PEOPLE HAVE EXAMINED THE PAST TO SEE HOW EARLIER SOCIETIES MADE CHOICES "
          + "AND FACED UNCERTAIN EVENTS. EARLY TOWNS BESIDE RIVERS AND COASTS BECAME PLACES WHERE FARMERS, "
          + "MAKERS, AND MERCHANTS MET TO EXCHANGE GOODS, NEWS, AND BELIEFS. THE EMERGENCE OF WRITING LET "
          + "LEADERS SET DOWN LAWS, TREATIES, AND DETAILED NOTES ON TAX, HARVEST, AND DEBTS, SO THAT LATER "
          + "READERS COULD TEST EACH CLAIM AGAINST EVIDENCE. IN MANY REGIONS, ELITES USED THESE RECORDS TO "
          + "DEFEND THEIR STATUS, YET THE SAME PAGES ALSO KEPT TRACES OF DISPUTES, FAILURES, AND APPEALS FROM "
          + "ORDINARY PEOPLE. GREEK THINKERS GAVE SPECIAL WEIGHT TO REASONED DEBATE, ASKING WHAT JUSTICE MEANT "
          + "AND HOW POWER OUGHT TO BE SHARED. THEIR TEXTS, COPIED MANY TIMES, FED DISCUSSION IN OTHER AGES. "
          + "ROMAN ENGINEERS TESTED METHODS IN STONE AND METAL, BUILDING ROADS, BRIDGES, AND AQUEDUCTS THAT "
          + "TIED FAR EDGES OF THE EMPIRE TO ITS CENTER AND HELPED KEEP TRADE ACTIVE EVEN WHEN WEATHER OR WAR "
          + "MADE TRAVEL HARD. EAST OF THE MEDITERRANEAN, SCHOLARS IN GREAT CITIES STUDIED THE HEAVENS, HEALING, "
          + "AND NUMBERS, PRESERVING EARLIER GREEK AND PERSIAN IDEAS WHILE ADDING THEIR OWN. THEY DEVELOPED "
          + "NEW TABLES, TREATED DISEASE WITH MORE SYSTEMATIC CARE, AND SET EXACTER STANDARDS FOR MEASURE. "
          + "IN PARTS OF AFRICA, EMERGING STATES LINKED DESERT ROUTES TO COASTAL EXCHANGE, SENDING METAL, SALT, "
          + "TEXTILES, AND GRAIN BETWEEN DISTANT MARKETS. CITIES IN THE AMERICAS DESIGNED TERRACES, CANALS, AND "
          + "RITUAL CENTERS THAT REFLECTED LOCAL NEEDS AND BELIEFS, EVEN THOUGH THEY NEVER MET THEIR EURASIAN "
          + "COUNTERPARTS. WHEN FAMINE, EPIDEMIC, OR INVADING ARMIES BROKE ESTABLISHED SYSTEMS, MANY COMMUNITIES "
          + "ADAPTED, MOVED, OR SOUGHT FRESH ALLIES RATHER THAN SIMPLY GIVE IN. LATER AGES LOOKED BACK ON THESE "
          + "EPISODES, SEEKING PATTERNS THAT MIGHT HELP EXPLAIN WHY SOME REALMS ENDURED WHILE OTHERS FELL AWAY. "
          + "WITH THE ARRIVAL OF PAPER AND THEN PRINTING PRESSES, TEXT COULD BE PRODUCED AT FAR LOWER COST. "
          + "TEACHERS COULD RELY ON THE SAME EDITION FOR ENTIRE CLASSES, AND READERS IN SEPARATE TOWNS COULD "
          + "EVALUATE THE SAME IDEAS ALMOST AT THE SAME TIME. THIS CHANGE HELPED SET THE STAGE FOR WIDER DEBATE "
          + "ABOUT RIGHTS, REPRESENTATION, AND RELIGIOUS TOLERANCE. MANY THINKERS ARGUED THAT NO RULER SHOULD "
          + "TREAT SUBJECTS AS MERE TOOLS, AND THAT EACH PERSON DESERVED AT LEAST A BASIC MEASURE OF DIGNITY AND "
          + "SECURITY. OVER TIME, THESE ARGUMENTS FED MOVEMENTS TO LIMIT ABSOLUTE POWER, TO END SOME FORMS OF "
          + "SLAVERY, AND TO EXTEND EDUCATION TO A BROADER PUBLIC. EVEN SO, PROGRESS WAS NEVER STEADY OR EVENLY "
          + "SHARED. EACH ERA LEFT BEHIND BOTH EXAMPLES OF ABUSE AND EVIDENCE OF CARE. BY STUDYING THESE MIXED "
          + "LEGACIES, PRESENT SOCIETIES GAIN A BETTER SENSE OF THE TASK THAT REMAINS. THE PAST DOES NOT TELL "
          + "US EXACTLY WHAT TO EXECUTE NEXT, YET IT DOES TEACH THAT ATTENTION, EVIDENCE, AND PATIENT, TESTED "
          + "ARGUMENT HELP PEOPLE BUILD FAIRER, STEADIER, AND MORE HUMANE COMMUNITIES OVER TIME.";




        FrequencyAnalyser frequencyAnalyser = new FrequencyAnalyser();
        Map<Character, Integer> letterFrequency = frequencyAnalyser.countSymbols(plainText);
        assertNotNull(letterFrequency);
    }
}
