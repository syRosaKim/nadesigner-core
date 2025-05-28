/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesw.inha;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 *
 * @author SeoyeonKim
 */
public class NeuromorphicHW {
    
    private static final int DE1 = 0;
    private static final int PYNQ = 1;
    private static final int LOIHI = 2;
    
    
    private String hw = "";
    private String Uacc = "";
    private String Ut = "";
    
    private static final String userDir = System.getenv("USERPROFILE");
    private static final String neuroModelDir = userDir + File.separatorChar + "Documents"+File.separatorChar+"NaDesigner"+File.separatorChar+"Libraries"+File.separatorChar+"model";
    
//    public NeuromorphicHW(){
//        
//    }
    
    public NeuromorphicHW(int arg0, String arg1, String arg2){
        hw = Integer.toString(arg0);
        Uacc = arg1; //Double.parseDouble(arg1);
        Ut = arg2; //Double.parseDouble(arg2);
        
        System.out.println("hw:"+arg0+",Uacc:"+arg1+",Ut:"+arg2+",, sykim2023");
//        getParam();
        
        
    }
    
    public String getParam() {//throws Exception{

        String neuroModel = neuroModelDir + File.separatorChar + "get_params.exe";
        System.out.println(neuroModel);
        String param = "";
        ProcessBuilder pb = new ProcessBuilder(neuroModel, hw, Uacc, Ut);
        try {
            Process p = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "euc-kr"));

            String line = "";
            while ((line = br.readLine()) != null) {
                System.out.println(line);
//                logger.debug("line = "+line);
//                System.out.println("sykim2023");
                param = line;
            }
            if (br != null) {
                br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return param;
    }

}

