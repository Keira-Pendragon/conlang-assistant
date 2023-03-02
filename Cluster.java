import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cluster extends Def
{
    private ArrayList<String>[] onset_consonant_cluster;
    private ArrayList<String>[] midword_consonant_cluster;
    private ArrayList<String>[] coda_consonant_cluster;
    private ArrayList<String> mood_vowels;
    private ArrayList<String> tense_vowels;
    private ArrayList<String> genus_vowels;
    private ArrayList<String> ad_vowels;
    private ArrayList<String> adhesive_vowels;
    private ArrayList<String> onset_general_vowels;
    private ArrayList<String> midword_general_vowels;
    private ArrayList<String> coda_general_vowels;


    public void loadDataFromFile(String filePath) {
        Yaml yaml = new Yaml();
        try {
            Map<String, Object> data = yaml.load(new FileInputStream(filePath));
    
            // Onset consonant clusters
            LinkedHashMap<String, Object> onset = (LinkedHashMap<String, Object>) data.get("onset");
            onset_consonant_cluster = new ArrayList[3];
            onset_consonant_cluster[0] = parseConsonantList((LinkedHashMap<String, Object>) onset.get("voiceless"));
            onset_consonant_cluster[1] = parseConsonantList((LinkedHashMap<String, Object>) onset.get("neutral"));
            onset_consonant_cluster[2] = parseConsonantList((LinkedHashMap<String, Object>) onset.get("voiced"));
    
            // Mid-word consonant clusters
            LinkedHashMap<String, Object> mid_word = (LinkedHashMap<String, Object>) data.get("mid_word");
            midword_consonant_cluster = new ArrayList[3];
            midword_consonant_cluster[0] = parseConsonantList((LinkedHashMap<String, Object>) mid_word.get("voiceless"));
            midword_consonant_cluster[1] = parseConsonantList((LinkedHashMap<String, Object>) mid_word.get("neutral"));
            midword_consonant_cluster[2] = parseConsonantList((LinkedHashMap<String, Object>) mid_word.get("voiced"));
    
            // Coda consonant clusters
            LinkedHashMap<String, Object> coda = (LinkedHashMap<String, Object>) data.get("coda");
            coda_consonant_cluster = new ArrayList[3];
            coda_consonant_cluster[0] = parseConsonantList((LinkedHashMap<String, Object>) coda.get("voiceless"));
            coda_consonant_cluster[1] = parseConsonantList((LinkedHashMap<String, Object>) coda.get("neutral"));
            coda_consonant_cluster[2] = parseConsonantList((LinkedHashMap<String, Object>) coda.get("voiced"));
    
            // Vowels
            LinkedHashMap<String, ArrayList<String>> vowels = (LinkedHashMap<String, ArrayList<String>>) data.get("vowels");
            mood_vowels = vowels.get("mood");
            tense_vowels = vowels.get("tense");
            genus_vowels = vowels.get("genus");
            ad_vowels = vowels.get("ad");
            adhesive_vowels = vowels.get("adhesive");
    
            // General vowels
            LinkedHashMap<String, ArrayList<String>> general = (LinkedHashMap<String, ArrayList<String>>) data.get("general");
            onset_general_vowels = general.get("onset");
            midword_general_vowels = general.get("midword");
            coda_general_vowels = general.get("coda");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    private ArrayList<String> parseConsonantList(LinkedHashMap<String, Object> map) 
    {
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            ArrayList<String> sublist = (ArrayList<String>) entry.getValue();
            list.addAll(sublist);
        }
        return list;
    }
}
    