/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciceexplorer;

import Helper.OsRelated;
import Helper.SavedVariables;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author mbrebion
 */
public class KeyWords {

    protected List<String> keywords;
    protected static KeyWords instance = null;
    protected static Set<JComboBox> jcbs = new HashSet<>();
    protected static String mainKeywordStart = "";

    public static void updateKeywordsList() {
        getInstance().rescanKeyWords();

    }

    public static DefaultComboBoxModel<String> getDefaultComboBoxModelModel(JComboBox jcb) {
        // add the jComboBox to the set of comboboxes which uses this model
        jcbs.add(jcb);

        // create the model
        DefaultComboBoxModel<String> out = new DefaultComboBoxModel<>();
        getInstance().keywords.stream().forEach((kw) -> {
            out.addElement(kw);
        });
        
        for (String kw : OsRelated.readFile(SavedVariables.getMainGitDir()+"/fichiers_utiles/motsclesPrincipaux.txt")){
            out.addElement(kw);
        }
        return out;
    }

    public static String getMainKeywordStart() {
        return mainKeywordStart;
    }
    
    
    
    public static DefaultComboBoxModel<String> getMainComboBoxModelModel() {      
        DefaultComboBoxModel<String> out = new DefaultComboBoxModel<>();
        for (String kw : OsRelated.readFile(SavedVariables.getMainGitDir()+"/fichiers_utiles/motsclesPrincipaux.txt")){
            out.addElement(kw.split(":")[1]);
            mainKeywordStart=kw.split(":")[0]+":";
        }
        // create the model
        
        return out;
    }

    public static boolean exists(String key) {
        return getInstance().keywords.contains(key);
    }

    public static void addNewKeywords(List<String> keys) {
        getInstance().addKeywords(keys);
    }

    /**
     * @return the keywords
     */
    public static List<String> getKeywords() {
        return getInstance().keywords;
    }

    /////////////////////////////////////////////////////////////////////////////
    protected static KeyWords getInstance() {
        if (instance == null) {
            new KeyWords();
        }
        return instance;
    }

    private KeyWords() {
         instance = this;
        this.keywords = new ArrayList<>();
        this.rescanKeyWords();

    }

    protected void addKeywords(List<String> keys) {
        //  add the new keywords, sort, write down and update jcomboboxes

        // mix all keywords (check for duplicate)
        for (String key : keys) {
            if (!keywords.contains(key)) {
                keywords.add(key);
            }
        }

        // sort all key words
        this.sortKeyWords();

        // update comboboxes
        for (JComboBox jcb : jcbs) {
            jcb.setModel(getDefaultComboBoxModelModel(jcb));
        }

    }

    protected void sortKeyWords() {
        Collator frCollator = Collator.getInstance(Locale.FRENCH);
        frCollator.setStrength(Collator.PRIMARY);
        Collections.sort(keywords, frCollator);
    }

    protected void rescanKeyWords() {

        this.keywords.clear();

        // a set is used to deal with duplicates
        Set<String> set = new HashSet<>();
        // we read all exercices and add every keywords once
        for (Exercice e : ExerciceFinder.getExercices()) {
            for (String kw : e.getKeywords()) {
                set.add(kw);

            }
        }

        this.keywords.addAll(set);
        this.sortKeyWords();

        // remove blank keywords (if any, they should be first elements in the sorted list)
        
        while (keywords.size()>0 && keywords.get(0).trim().isEmpty()) {
            keywords.remove(0);
        }

         // update comboboxes
        for (JComboBox jcb : jcbs) {
            //jcb.setModel(getDefaultComboBoxModelModel(jcb));
            DefaultComboBoxModel<String> model = getDefaultComboBoxModelModel(jcb);
            jcb.setModel(model);
        }
        

    }

}
