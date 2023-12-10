package ch.codespin.java.swatchbeat;

import java.util.*;

public class SwatchBeat {
	 float _zeit;
	 Calendar _cal = new GregorianCalendar();
 
	 public float getHours(){
		 return _cal.get(Calendar.HOUR_OF_DAY)*3600;
	 }
	 
	 public float getMinutes(){
		 return _cal.get(Calendar.MINUTE)*60;
	 }  
	 
	 public float getSeconds(){
		 return _cal.get(Calendar.SECOND);
	 }  
	 
	public String getBeatTime(){
		 _zeit=getHours()+getMinutes()+getSeconds();
_zeit=_zeit*1000/86400;
		 return "@"+(int)_zeit;
	 } 
}

