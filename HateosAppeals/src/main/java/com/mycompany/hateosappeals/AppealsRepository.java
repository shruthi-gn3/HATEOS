/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hateosappeals;

import java.util.HashMap;

/**
 *
 * @author shruthign3
 */
public class AppealsRepository {
      private static HashMap<Integer, AppealRepresentation> appeals = new HashMap<Integer, AppealRepresentation>();
      
      public static HashMap<Integer, AppealRepresentation> getAppeals(){
    return appeals;
    }
    
    public static void setAppeals(int id , AppealRepresentation appeal){
      appeals.put(id, appeal);
    }
      
}
