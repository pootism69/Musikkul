/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Imran
 */
public class Model_Filter_Musik extends FileFilter{
    private final String extension;
    private final String description;
    
    // Constructor Method
    public Model_Filter_Musik(String extension, String description){
        // Set Contructor Values
        this.extension = extension;
        this.description = description;
    }
    
    @Override
    public boolean accept(File file) {
        // If File Is Returning Directory
        if(file.isDirectory()){
            return true;
        }
        // Return File Name with Extension
        return file.getName().endsWith(extension);
    }

    @Override
    public String getDescription() {
        // Return To Display File Type and Description
        return description + String.format(" (*%s)", extension);
    }
}
