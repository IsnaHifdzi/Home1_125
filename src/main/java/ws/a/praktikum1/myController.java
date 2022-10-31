/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.a.praktikum1;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author acer
 */

@Controller
public class myController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hai(
            @RequestParam (value = "varA") String isipertama,
            @RequestParam (value = "varB") String isikedua
          
            
    ){
        String rslt = " ";
        
        if(isipertama.equals("ami") && isikedua.equals("dia")){
            rslt = "couple";
        }else if(isipertama.equals("ami") && isikedua.equals("isna")){
            rslt = "family"; 
        }else if(isipertama.equals("ami") && isikedua.equals("hifdzi")){
            rslt = "??????";
        }else{
            rslt = "isi DoNG '''''''";
        }
        return rslt;
    }
    @RequestMapping ("/nexthalaman")
    
    public String next(
    @RequestParam (value = "varA") String isipertama,
    @RequestParam (value = "varB") String isikedua,
    @RequestParam (value = "foto" ) MultipartFile isiketiga,
            Model kurir
    )throws IOException{
       byte[]img = isiketiga.getBytes();
       String base64Image = Base64.encodeBase64String(img);
       String imglink = "data:image/png;base64,".concat(base64Image);
       kurir.addAttribute("paket1", isipertama);
        kurir.addAttribute("paket2", isikedua);
        kurir.addAttribute("paket3" , imglink);
        
        
        return "viewpage";
    }
    
        
    
    
}
