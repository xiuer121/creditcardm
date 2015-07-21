package carss.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Texts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 	
		  Calendar calendar = Calendar.getInstance();
		  calendar.add(Calendar.MONTH, 1);
		  System.out.println(format.format(calendar.getTime()));
//		  long i =calendar.getTimeInMillis();
//		  System.out.println(calendar.getTimeInMillis());
//		  calendar.set(calendar.DATE, calendar.get(calendar.DATE)+2);
//		  System.out.println(calendar.get(calendar.DATE));
//		  System.out.println(calendar.getTimeInMillis());
//		  long j =calendar.getTimeInMillis();
//		  System.out.println(162230031/3600000);
//		try {
//			FileInputStream in = new FileInputStream(new File("d:/text2.xls"));
//			String sheetName="Sheet1";
//			
//			LinkedHashMap<String, String> fieldMap = new LinkedHashMap<String, String>();
//			fieldMap.put("服务器地址", "adUrl");
//			fieldMap.put("到期时间", "imgPaht");
//			fieldMap.put("价格", "id");
////			List<AdRoll> list=ExcelUtil.excelToList(in, sheetName, AdRoll.class, fieldMap , new String[]{"管理账号"});
////			for(AdRoll e:list){
////				System.out.println(e.getId());
////			}
//			
//		} catch (Exception e) {
//			 
//			e.printStackTrace();
//		}
// 
//		
//		Double d1 = new Double(45.23);
//
//		Double d2 = new Double(45.23);
//
//		int dou = d1.compareTo(d2);
//
//		System.out.println(dou);

	}

}
