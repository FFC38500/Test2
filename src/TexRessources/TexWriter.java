/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TexRessources;

import Helper.ExecCommand;
import Helper.SavedVariables;
import exerciceexplorer.Exercice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mbrebion
 */
public class TexWriter {

    public static void openPdf() {
        ExecCommand.execo(new String[]{SavedVariables.getOpenCmd(), "output/output.pdf"}, 0);
    }

    protected static void getExercicestoTex(Enumeration<Exercice> exercices, List<String> output, List<String> imports, boolean localLinks) {
        List<String> dummy = new ArrayList<>();
        TexWriter.getExercicestoTex(exercices, output, imports, localLinks, dummy, dummy);
    }

    protected static void getExercicestoTex(Enumeration<Exercice> exercices, List<String> output, List<String> imports, boolean localLinks, List<String> before, List<String> after) {
        int count = 0;
        while (exercices.hasMoreElements()) {
            count++;
            Exercice element = exercices.nextElement();

            output.add("\\resetQ");

            for (String s : before) {
                output.add(s.replace("##", String.valueOf(count)));
            }

            if (localLinks) {
                output.add("\\subimport{./" + element.getName() + "/}{sujet.tex}");
            } else {
                output.add("\\subimport{" + element.getPath() + "/}{sujet.tex}");
            }

            for (String s : after) {
                output.add(s.replace("##", String.valueOf(count)));
            }

            output.add("");
            output.add("");
            imports.addAll(element.getImports());
        }
    }

    public static String latexLog = "";

    public static boolean latexToPdf() {
        String[] out = ExecCommand.execo(new String[]{SavedVariables.getPdflatexCmd(), "-halt-on-error", "-output-directory=" + System.getProperty("user.dir") + "/output", "output/output.tex"}, 0);
        if (!out[0].equals("0")) {
            System.err.println("pdflatex could not latexize the texfile");
            latexLog = out[1];
        }
        return out[0].equals("0");
    }

    public static boolean writeTexFile(List<String> in) {

        File dir = new File("output");
        if (!dir.exists() && !dir.isDirectory()) {
            // create output dir if not existing
            dir.mkdir();

        }
        return writeToFile(in, "output/output.tex");
    }

    /**
     * Templates tex files are parsed and modified to include exercices
     * the path of raccourcis_communs is also updated if required
     * @param exercices the enumeration of exercices to include
     * @param kind the kind of output asked
     * @param localLinks if true, hard copies of exercices are created and pathes are updated
     * @param forceDefault if true, default templates are enforced (usefull to test all exercices)
     * @return 
     */
    public static List<String> outputTexFile(Enumeration<Exercice> exercices, String kind, boolean localLinks, boolean forceDefault) {
        
        List<String> output = new ArrayList<>(); // main file
        List<String> imports = new ArrayList<>(); // packages required by a specific exercice

        String fileName = "/DSmodel.tex";
        switch (kind) {
            case "DS":
                fileName = "/DSmodel.tex";
                break;
            case "DM":
                fileName = "/DMmodel.tex";
                break;
            case "TD":
                fileName = "/TDmodel.tex";
                break;
            case "Colle":
                fileName = "/Collemodel.tex";
                break;

        }
        File f; // template file
        if (!forceDefault) {
            f = new File(SavedVariables.getTexModelsPaths() + fileName);
        } else {
            f = new File(SavedVariables.getMainGitDir() + "/fichiers_utiles/defaultLatexTemplates" + fileName);
        }

        BufferedReader b;
        try {
            b = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException ex) {
            String errorMsg = SavedVariables.getTexModelsPaths() + fileName + " file not found. Please create this file and edit its path";
            System.err.println(errorMsg);
            output.clear();
            output.add(errorMsg);
            return output;
        }

        String readLine = "";
        boolean blockTokenFound = false;

        // template is parsed line by line
        try {
            while ((readLine = b.readLine()) != null) {
                
                if (readLine.trim().contains("usepackage{raccourcis_communs}")){
                    // On cherche ou se trouve exactement le fichier .sty contenant les raccoursis ; autre solution ; placer un lien symbolique dans $home/texmf/...
                    output.add("\\usepackage{"+SavedVariables.getMainGitDir()+"/fichiers_utiles/raccourcis_communs}");
                    continue;
                }
                
                if (readLine.trim().equals("[[")) {
                    // we need to store what's before ****, what's after **** and then send to getExercicetoTex
                    String nextLine;

                    List<String> before = new ArrayList<>();
                    List<String> after = new ArrayList<>();
                    nextLine = b.readLine();
                    while (!nextLine.trim().equals("****")) {
                        before.add(nextLine);
                        nextLine = b.readLine();
                    }
                    nextLine = b.readLine();
                    while (!nextLine.trim().equals("]]")) {
                        after.add(nextLine);
                        nextLine = b.readLine();
                    }
                    getExercicestoTex(exercices, output, imports, localLinks, before, after);
                    continue;
                }

                if (readLine.trim().equals("****") && !blockTokenFound) {
                    getExercicestoTex(exercices, output, imports, localLinks);
                    continue;
                }

                output.add(readLine);

            }
            // imports must be added before \begin{document}
            boolean found = false;
            int count = 0;
            while (!found) {
                found = output.get(count).contains("\\begin{document}");
                count += 1;

            }
            output.addAll(count - 1, imports);

        } catch (IOException ex) {
            String errorMsg = "Problem occured while parsing **model.tex";
            System.err.println(errorMsg);
            output.clear();
            output.add(errorMsg);
            System.err.println();
        }

        return output;
    }

    public static List<String> readFile(String path) {
        ArrayList<String> out = new ArrayList<>();
        File f = new File(path);
        BufferedReader b;
        try {
            b = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException ex) {
            return out;
        }

        String readLine = "";
        try {
            while ((readLine = b.readLine()) != null) {
                out.add(readLine);
            }
        } catch (IOException ex) {
            return out;
        }
        return out;

    }
    
    public static String readFileOneString(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException ex) {
            Logger.getLogger(TexWriter.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }

    }
    
    

    public static boolean appendToFile(List<String> in, String path) {

        File f = new File(path);
        BufferedWriter b;
        try {
            b = new BufferedWriter(new FileWriter(f, true));
            for (String line : in) {
                b.write(line);
                b.newLine();
            }
            b.close();

        } catch (IOException ex) {
            System.out.println(path + " file cannot be outputed");
            return false;
        }
        return true;
    }

    public static boolean writeToFile(List<String> in, String path) {

        File f = new File(path);
        BufferedWriter b;
        try {
            b = new BufferedWriter(new FileWriter(f));
            for (String line : in) {
                b.write(line);
                b.newLine();
            }
            b.close();

        } catch (IOException ex) {
            System.out.println(path + " file cannot be outputed");
            return false;
        }
        return true;
    }

   

}
