/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kinggame;

import javax.swing.JLabel;

/**
 *
 * @author yehya_000
 */
public class Cards {
    
    public String path;
    public JLabel label;
    public int value;
    public void setimg()
    {
        path = "D:\\test\\Cards\\"+value+".png";
    }
}
