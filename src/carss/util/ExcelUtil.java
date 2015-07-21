package carss.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * @author : WH
 * @group : tgb8
 * @Date : 2014-1-2 ����9:13:21
 * @Comments : ���뵼��Excel������
 * @Version : 1.0.0
 */

public class ExcelUtil {

	/**
	 * @MethodName : listToExcel
	 * @Description : ����Excel�����Ե����������ļ�ϵͳ��Ҳ���Ե���������������Զ��幤�����С��
	 * @param list
	 *            ����Դ
	 * @param fieldMap
	 *            ���Ӣ�����Ժ�Excel�е����������Ķ�Ӧ��ϵ �����Ҫ�������ö�������ԣ���Ӣ������ʹ��������EL���ʽ�ĸ�ʽ
	 *            �磺list�д�ŵĶ���student��student������college���ԣ���������ҪѧԺ���ƣ����������д
	 *            fieldMap.put("college.collegeName","ѧԺ����")
	 * @param sheetName
	 *            �����������
	 * @param sheetSize
	 *            ÿ���������м�¼��������
	 * @param out
	 *            ������
	 * @throws ExcelException
	 */
	public static <T> void listToExcel(List<T> list,
			LinkedHashMap<String, String> fieldMap, String sheetName,
			int sheetSize, OutputStream out) throws ExcelException {

		if (list.size() == 0 || list == null) {
			throw new ExcelException("����Դ��û���κ�����");
		}

		if (sheetSize > 65535 || sheetSize < 1) {
			sheetSize = 65535;
		}

		// ���������������͵�OutputStreamָ���ĵط�
		WritableWorkbook wwb;
		try {
			wwb = Workbook.createWorkbook(out);

			// ��Ϊ2003��Excelһ����������������65536����¼����ȥ��ͷʣ��65535��
			// ���������¼̫�࣬��Ҫ�ŵ�����������У���ʵ���Ǹ���ҳ�Ĺ���
			// 1.����һ���ж��ٸ�������
			double sheetNum = Math.ceil(list.size()
					/ new Integer(sheetSize).doubleValue());

			// 2.������Ӧ�Ĺ��������������������
			for (int i = 0; i < sheetNum; i++) {
				// ���ֻ��һ������������
				if (1 == sheetNum) {
					WritableSheet sheet = wwb.createSheet(sheetName, i);
					fillSheet(sheet, list, fieldMap, 0, list.size() - 1);

					// �ж������������
				} else {
					WritableSheet sheet = wwb.createSheet(sheetName + (i + 1),
							i);

					// ��ȡ��ʼ�����ͽ�������
					int firstIndex = i * sheetSize;
					int lastIndex = (i + 1) * sheetSize - 1 > list.size() - 1 ? list
							.size() - 1 : (i + 1) * sheetSize - 1;
					// ��乤����
					fillSheet(sheet, list, fieldMap, firstIndex, lastIndex);
				}
			}

			wwb.write();
			wwb.close();

		} catch (Exception e) {
			e.printStackTrace();
			// �����ExcelException����ֱ���׳�
			if (e instanceof ExcelException) {
				throw (ExcelException) e;

				// ���������쳣��װ��ExcelException���׳�
			} else {
				throw new ExcelException("����Excelʧ��");
			}
		}

	}

	/**
	 * @MethodName : listToExcel
	 * @Description : ����Excel�����Ե����������ļ�ϵͳ��Ҳ���Ե�������������������СΪ2003֧�ֵ����ֵ��
	 * @param list
	 *            ����Դ
	 * @param fieldMap
	 *            ���Ӣ�����Ժ�Excel�е����������Ķ�Ӧ��ϵ
	 * @param out
	 *            ������
	 * @throws ExcelException
	 */
	public static <T> void listToExcel(List<T> list,
			LinkedHashMap<String, String> fieldMap, String sheetName,
			OutputStream out) throws ExcelException {

		listToExcel(list, fieldMap, sheetName, 65535, out);

	}

	/**
	 * @MethodName : listToExcel
	 * @Description : ����Excel��������������������Զ��幤����Ĵ�С��
	 * @param list
	 *            ����Դ
	 * @param fieldMap
	 *            ���Ӣ�����Ժ�Excel�е����������Ķ�Ӧ��ϵ
	 * @param sheetSize
	 *            ÿ���������м�¼��������
	 * @param response
	 *            ʹ��response���Ե����������
	 * @throws ExcelException
	 */
	public static <T> void listToExcel(List<T> list,
			LinkedHashMap<String, String> fieldMap, String sheetName,
			int sheetSize, HttpServletResponse response) throws ExcelException {

		// ����Ĭ���ļ���Ϊ��ǰʱ�䣺������ʱ����
		String fileName = new SimpleDateFormat("yyyyMMddhhmmss").format(
				new Date()).toString();

		// ����responseͷ��Ϣ
		response.reset();
		response.setContentType("application/vnd.ms-excel"); // �ĳ����excel�ļ�
		response.setHeader("Content-disposition", "attachment; filename="
				+ fileName + ".xls");

		// ���������������͵������
		try {

			OutputStream out = response.getOutputStream();
			listToExcel(list, fieldMap, sheetName, sheetSize, out);

		} catch (Exception e) {
			e.printStackTrace();

			// �����ExcelException����ֱ���׳�
			if (e instanceof ExcelException) {
				throw (ExcelException) e;

				// ���������쳣��װ��ExcelException���׳�
			} else {
				throw new ExcelException("����Excelʧ��");
			}
		}
	}

	/**
	 * @MethodName : listToExcel
	 * @Description : ����Excel���������������������Ĵ�С��2003֧�ֵ����ֵ��
	 * @param list
	 *            ����Դ
	 * @param fieldMap
	 *            ���Ӣ�����Ժ�Excel�е����������Ķ�Ӧ��ϵ
	 * @param response
	 *            ʹ��response���Ե����������
	 * @throws ExcelException
	 */
	public static <T> void listToExcel(List<T> list,
			LinkedHashMap<String, String> fieldMap, String sheetName,
			HttpServletResponse response) throws ExcelException {

		listToExcel(list, fieldMap, sheetName, 65535, response);
	}

	/**
	 * @MethodName : excelToList
	 * @Description : ��Excelת��ΪList
	 * @param in
	 *            ��������Excel��������
	 * @param sheetIndex
	 *            ��Ҫ����Ĺ��������
	 * @param entityClass
	 *            ��List�ж�������ͣ�Excel�е�ÿһ�ж�Ҫת��Ϊ�����͵Ķ���
	 * @param fieldMap
	 *            ��Excel�е�������ͷ�����Ӣ�����ԵĶ�Ӧ��ϵMap
	 * @param uniqueFields
	 *            ��ָ��ҵ��������ϣ�����������������Щ�е���ϲ����ظ�
	 * @return ��List
	 * @throws Exception 
	 */
	public static <T> List<T> excelToList(InputStream in, String sheetName,
			Class<T> entityClass, LinkedHashMap<String, String> fieldMap,
			String[] uniqueFields) throws Exception {

		// ����Ҫ���ص�list
		List<T> resultList = new ArrayList<T>();

		try {

			// ����Excel����Դ����WorkBook
			Workbook wb = Workbook.getWorkbook(in);
			// ��ȡ������
			Sheet sheet = wb.getSheet(sheetName);

			// ��ȡ���������Ч����
			int realRows = 0;
			for (int i = 0; i < sheet.getRows(); i++) {

				int nullCols = 0;
				for (int j = 0; j < sheet.getColumns(); j++) {
					Cell currentCell = sheet.getCell(j, i);
					if (currentCell == null
							|| "".equals(currentCell.getContents().toString())) {
						nullCols++;
					}
				}

				if (nullCols == sheet.getColumns()) {
					break;
				} else {
					realRows++;
				}
			}

			// ���Excel��û����������ʾ����
			if (realRows <= 1) {
				throw new ExcelException("Excel�ļ���û���κ�����");
			}

			Cell[] firstRow = sheet.getRow(0);

			String[] excelFieldNames = new String[firstRow.length];

			// ��ȡExcel�е�����
			for (int i = 0; i < firstRow.length; i++) {
				excelFieldNames[i] = firstRow[i].getContents().toString()
						.trim();
			}

			// �ж���Ҫ���ֶ���Excel���Ƿ񶼴���
			boolean isExist = true;
			List<String> excelFieldList = Arrays.asList(excelFieldNames);
			for (String cnName : fieldMap.keySet()) {
				if (!excelFieldList.contains(cnName)) {
					isExist = false;
					break;
				}
			}

			// ��������������ڣ����׳��쳣����ʾ����
			if (!isExist) {
				throw new ExcelException("Excel��ȱ�ٱ�Ҫ���ֶΣ����ֶ���������");
			}

			// ���������кŷ���Map��,����ͨ�������Ϳ����õ��к�
			LinkedHashMap<String, Integer> colMap = new LinkedHashMap<String, Integer>();
			for (int i = 0; i < excelFieldNames.length; i++) {
				colMap.put(excelFieldNames[i], firstRow[i].getColumn());
			}

			// �ж��Ƿ����ظ���
			// 1.��ȡuniqueFieldsָ������
			Cell[][] uniqueCells = new Cell[uniqueFields.length][];
			for (int i = 0; i < uniqueFields.length; i++) {
				int col = colMap.get(uniqueFields[i]);
				uniqueCells[i] = sheet.getColumn(col);
			}

			// 2.��ָ������Ѱ���ظ���
			for (int i = 1; i < realRows; i++) {
				int nullCols = 0;
				for (int j = 0; j < uniqueFields.length; j++) {
					String currentContent = uniqueCells[j][i].getContents();
					Cell sameCell = sheet.findCell(currentContent,
							uniqueCells[j][i].getColumn(),
							uniqueCells[j][i].getRow() + 1,
							uniqueCells[j][i].getColumn(),
							uniqueCells[j][realRows - 1].getRow(), true);
					if (sameCell != null) {
						nullCols++;
					}
				}

				if (nullCols == uniqueFields.length) {
					throw new ExcelException("Excel�����ظ��У�����");
				}
			}

			// ��sheetת��Ϊlist
			for (int i = 1; i < realRows; i++) {
				// �½�Ҫת���Ķ���
				T entity = entityClass.newInstance();

				// �������е��ֶθ�ֵ
				for (Entry<String, String> entry : fieldMap.entrySet()) {
					// ��ȡ�����ֶ���
					String cnNormalName = entry.getKey();
					// ��ȡӢ���ֶ���
					String enNormalName = entry.getValue();
					// ���������ֶ�����ȡ�к�
					int col = colMap.get(cnNormalName);

					// ��ȡ��ǰ��Ԫ���е�����
					String content = sheet.getCell(col, i).getContents()
							.toString().trim();
					content = content.replaceAll(" ", "");

					// ������ֵ
					setFieldValueByName(enNormalName, content, entity);
				}

				resultList.add(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		
			// �����ExcelException����ֱ���׳�
			if (e instanceof ExcelException) {
				throw (ExcelException) e;

				// ���������쳣��װ��ExcelException���׳�
			} else {
				e.printStackTrace();
//				throw (Exception) e;
//				throw new ExcelException("����Excelʧ��");
			}
			throw (Exception) e;
		}
		return resultList;
	}

	/*
	 * <-------------------------������˽�з���------------------------------------------
	 * ----->
	 */
	/**
	 * @MethodName : getFieldValueByName
	 * @Description : �����ֶ�����ȡ�ֶ�ֵ
	 * @param fieldName
	 *            �ֶ���
	 * @param o
	 *            ����
	 * @return �ֶ�ֵ
	 */
	private static Object getFieldValueByName(String fieldName, Object o)
			throws Exception {

		Object value = null;
		Field field = getFieldByName(fieldName, o.getClass());

		if (field != null) {
			field.setAccessible(true);
			value = field.get(o);
		} else {
			throw new ExcelException(o.getClass().getSimpleName() + "�಻�����ֶ��� "
					+ fieldName);
		}

		return value;
	}

	/**
	 * @MethodName : getFieldByName
	 * @Description : �����ֶ�����ȡ�ֶ�
	 * @param fieldName
	 *            �ֶ���
	 * @param clazz
	 *            �������ֶε���
	 * @return �ֶ�
	 */
	private static Field getFieldByName(String fieldName, Class<?> clazz) {
		// �õ�����������ֶ�
		Field[] selfFields = clazz.getDeclaredFields();

		// ��������д��ڸ��ֶΣ��򷵻�
		for (Field field : selfFields) {
			if (field.getName().equals(fieldName)) {
				return field;
			}
		}

		// ���򣬲鿴�������Ƿ���ڴ��ֶΣ�������򷵻�
		Class<?> superClazz = clazz.getSuperclass();
		if (superClazz != null && superClazz != Object.class) {
			return getFieldByName(fieldName, superClazz);
		}

		// �������͸��඼û�У��򷵻ؿ�
		return null;
	}

	/**
	 * @MethodName : getFieldValueByNameSequence
	 * @Description : ���ݴ�·���򲻴�·������������ȡ����ֵ
	 *              �����ܼ�����������userName�ȣ��ֽ��ܴ�·��������������student.department.name��
	 * 
	 * @param fieldNameSequence
	 *            ��·�������������������
	 * @param o
	 *            ����
	 * @return ����ֵ
	 * @throws Exception
	 */
	private static Object getFieldValueByNameSequence(String fieldNameSequence,
			Object o) throws Exception {

		Object value = null;

		// ��fieldNameSequence���в��
		String[] attributes = fieldNameSequence.split("\\.");
		if (attributes.length == 1) {
			value = getFieldValueByName(fieldNameSequence, o);
		} else {
			// ������������ȡ���Զ���
			Object fieldObj = getFieldValueByName(attributes[0], o);
			String subFieldNameSequence = fieldNameSequence
					.substring(fieldNameSequence.indexOf(".") + 1);
			value = getFieldValueByNameSequence(subFieldNameSequence, fieldObj);
		}
		return value;

	}

	/**
	 * @MethodName : setFieldValueByName
	 * @Description : �����ֶ�����������ֶθ�ֵ
	 * @param fieldName
	 *            �ֶ���
	 * @param fieldValue
	 *            �ֶ�ֵ
	 * @param o
	 *            ����
	 */
	private static void setFieldValueByName(String fieldName,
			Object fieldValue, Object o) throws Exception {

		Field field = getFieldByName(fieldName, o.getClass());
		if (field != null) {
			field.setAccessible(true);
			// ��ȡ�ֶ�����
			Class<?> fieldType = field.getType();

			// �����ֶ����͸��ֶθ�ֵ
			System.out.println(fieldType); 
			System.out.println(fieldValue.toString().length());
			if(fieldValue!=null&&fieldValue.toString().length()>0){
				if (String.class == fieldType) {
					field.set(o, String.valueOf(fieldValue));
				} else if ((Integer.TYPE == fieldType)
						|| (Integer.class == fieldType)) {
					field.set(o, Integer.parseInt(fieldValue.toString()));
				} else if ((Long.TYPE == fieldType) || (Long.class == fieldType)) {
					field.set(o, Long.valueOf(fieldValue.toString()));
				} else if ((Float.TYPE == fieldType) || (Float.class == fieldType)) {
					field.set(o, Float.valueOf(fieldValue.toString()));
				} else if ((Short.TYPE == fieldType) || (Short.class == fieldType)) {
					field.set(o, Short.valueOf(fieldValue.toString()));
				} else if ((Double.TYPE == fieldType)
						|| (Double.class == fieldType)) {
					field.set(o, Double.valueOf(fieldValue.toString()));
				} else if (Character.TYPE == fieldType) {
					if ((fieldValue != null)
							&& (fieldValue.toString().length() > 0)) {
						field.set(o,
								Character.valueOf(fieldValue.toString().charAt(0)));
					}
				} else if (Date.class == fieldType) {
					field.set(o, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
							.parse(fieldValue.toString()));
				} else {
					field.set(o, fieldValue);
				}
			}

		} else {
			throw new ExcelException(o.getClass().getSimpleName() + "�಻�����ֶ��� "
					+ fieldName);
		}
	}

	/**
	 * @MethodName : setColumnAutoSize
	 * @Description : ���ù������Զ��п�����мӴ�
	 * @param ws
	 */
	private static void setColumnAutoSize(WritableSheet ws, int extraWith) {
		// ��ȡ���е����Ԫ��Ŀ��
		for (int i = 0; i < ws.getColumns(); i++) {
			int colWith = 0;
			for (int j = 0; j < ws.getRows(); j++) {
				String content = ws.getCell(i, j).getContents().toString();
				int cellWith = content.length();
				if (colWith < cellWith) {
					colWith = cellWith;
				}
			}
			// ���õ�Ԫ��Ŀ��Ϊ�����+������
			ws.setColumnView(i, colWith + extraWith);
		}

	}

	/**
	 * @MethodName : fillSheet
	 * @Description : ���������������
	 * @param sheet
	 *            ������
	 * @param list
	 *            ����Դ
	 * @param fieldMap
	 *            ��Ӣ���ֶζ�Ӧ��ϵ��Map
	 * @param firstIndex
	 *            ��ʼ����
	 * @param lastIndex
	 *            ��������
	 */
	private static <T> void fillSheet(WritableSheet sheet, List<T> list,
			LinkedHashMap<String, String> fieldMap, int firstIndex,
			int lastIndex) throws Exception {

		// ������Ӣ���ֶ����������ֶ���������
		String[] enFields = new String[fieldMap.size()];
		String[] cnFields = new String[fieldMap.size()];

		// �������
		int count = 0;
		for (Entry<String, String> entry : fieldMap.entrySet()) {
			enFields[count] = entry.getKey();
			cnFields[count] = entry.getValue();
			count++;
		}
		// ����ͷ
		for (int i = 0; i < cnFields.length; i++) {
			Label label = new Label(i, 0, cnFields[i]);
			sheet.addCell(label);
		}

		// �������
		int rowNo = 1;
		for (int index = firstIndex; index <= lastIndex; index++) {
			// ��ȡ��������
			T item = list.get(index);
			for (int i = 0; i < enFields.length; i++) {
				Object objValue = getFieldValueByNameSequence(enFields[i], item);
				String fieldValue = objValue == null ? "" : objValue.toString();
				Label label = new Label(i, rowNo, fieldValue);
				sheet.addCell(label);
			}

			rowNo++;
		}

		// �����Զ��п�
		setColumnAutoSize(sheet, 5);
	}

 
}