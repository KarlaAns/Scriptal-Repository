/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.studentsystem.controller;

import java.text.MessageFormat;
import javax.swing.JTable;

/**
 *
 * @author Usuario
 */
public class PrintController {
        public static void printPDF(String title, javax.swing.JTable table) {
        MessageFormat header=new MessageFormat(title);
        MessageFormat footer=new MessageFormat("Page{0,number,integer}");
        
        try{
            table.print(JTable.PrintMode.NORMAL, header, footer);
        }catch(java.awt.print.PrinterException e){
            System.err.format("Cannot print %s%n",e.getMessage());
        }
    }
}
