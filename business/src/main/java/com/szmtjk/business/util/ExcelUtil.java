package com.szmtjk.business.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xiaohu on 2018/12/29.
 */
public class ExcelUtil {

    private static final Logger LOG = LoggerFactory.getLogger(ExcelUtil.class);

    private static final String SUFFIX_2003 = ".xls";
    private static final String SUFFIX_2007 = ".xlsx";

//    public static List<String> getItemListFromExcel (final MultipartFile excelFile) throws Exception {
//        // 入参检查
//        if(null == excelFile){
//            LOGGER.error("[ExcelUtils.getItemListFromExcel][excelFile is null]");
//            throw new IllegalArgumentException("excel文件未上传成功,请检查重试");
//        }
//        // 获得Workbook工作薄对象
//        Workbook workbook = getWorkBook(excelFile);
//        //  创建返回对象，部分商品优惠只有一行,行数据为items,顾解析后用list直接返回
//        if(null == workbook){
//            LOGGER.error("[ExcelUtils.getItemListFromExcel][get workbook failure][fileName={}]", excelFile.getOriginalFilename());
//            throw new IllegalArgumentException("excel文件解析失败,请检查模版");
//        }
//        if(workbook.getNumberOfSheets() != 1){
//            LOGGER.error("[ExcelUtils.getItemListFromExcel][workbook.getNumberOfSheets() != 1][fileName={},numberOfSheets={}]",
//                    excelFile.getOriginalFilename(), workbook.getNumberOfSheets());
//            throw new IllegalArgumentException("excel文件解析失败(sheet必须为1),请检查模版");
//        }
//        // 获得当前sheet工作表,仅获取
//        Sheet sheet = workbook.getSheetAt(0);
//        // 只识别第1行开始的第0列
//        List<String> result = Lists.newArrayList();
//        // 循环除了第一行的所有行
//        for(int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
//            //获得当前行
//            Row row = sheet.getRow(rowNum);
//            if(row == null){
//                continue;
//            }
//            // 获取第一列数据
//            String cellValue = getCellValue(row.getCell(0));
//            if(StringUtils.isNotBlank(cellValue)){
//                result.add(cellValue);
//            }
//        }
//        if(result.size() > 1000){
//            LOGGER.error("[ExcelUtils.getItemListFromExcel][sheet.getPhysicalNumberOfRows() > 1001][fileName={},physicalNumberOfRows={}]",
//                    excelFile.getOriginalFilename(), sheet.getPhysicalNumberOfRows());
//            throw new IllegalArgumentException("excel文件解析失败,最大支持1000条内容数据");
//        }
//        // 返回结果
//        return result;
//    }

//    public static List<DiscountExcelWrapper> getDiscountWrapperListFromExcel (final MultipartFile excelFile) throws Exception {
//        // 入参检查
//        if(null == excelFile){
//            LOGGER.error("[ExcelUtils.getDiscountWrapperListFromExcel][excelFile is null]");
//            throw new IllegalArgumentException("excel文件未上传成功,请检查重试");
//        }
//        // 获得Workbook工作薄对象
//        Workbook workbook = getWorkBook(excelFile);
//        // 创建返回对象，模版包含4列,分别为商品ID,优惠类型,优惠值,抹角抹分
//        if(null == workbook){
//            LOGGER.error("[ExcelUtils.getDiscountWrapperListFromExcel][get workbook failure][fileName={}]", excelFile.getOriginalFilename());
//            throw new IllegalArgumentException("excel文件解析失败,请检查模版");
//        }
//        if(workbook.getNumberOfSheets() != 1){
//            LOGGER.error("[ExcelUtils.getDiscountWrapperListFromExcel][workbook.getNumberOfSheets() != 1][fileName={},numberOfSheets={}]",
//                    excelFile.getOriginalFilename(), workbook.getNumberOfSheets());
//            throw new IllegalArgumentException("excel文件解析失败(sheet必须为1),请检查模版");
//        }
//        // 获得当前sheet工作表,仅获取
//        Sheet sheet = workbook.getSheetAt(0);
//        // 解析结果
//        List<DiscountExcelWrapper> result = Lists.newArrayList();
//        // 循环除了第一行的所有行
//        for(int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
//            //获得当前行
//            Row row = sheet.getRow(rowNum);
//            if(row == null){
//                continue;
//            }
//            // 获取第1,2,3,4列数据
//            String cellValue1 = getCellValue(row.getCell(0));
//            String cellValue2 = getCellValue(row.getCell(1));
//            String cellValue3 = getCellValue(row.getCell(2));
//            String cellValue4 = getCellValue(row.getCell(3));
//            if(StringUtils.isBlank(cellValue1) || StringUtils.isBlank(cellValue2) || StringUtils.isBlank(cellValue3)){
//                LOGGER.error("[ExcelUtils.getDiscountWrapperListFromExcel][cellValue is blank][fileName={},rowNum={},cellValue1={},cellValue2={},cellValue3={},cellValue4={}]",
//                        excelFile.getOriginalFilename(), rowNum, cellValue1, cellValue2, cellValue3, cellValue4);
//                continue;
//            }
//            result.add(new DiscountExcelWrapper(cellValue1.trim(), cellValue2.trim(), cellValue3.trim(), cellValue4 == null ? String.valueOf(FordConstant.DiscountPrecision.FEN) : cellValue4.trim()));
//        }
//        if(result.size() > 1000){
//            LOGGER.error("[ExcelUtils.getDiscountWrapperListFromExcel][sheet.getPhysicalNumberOfRows() > 1001][fileName={},physicalNumberOfRows={}]",
//                    excelFile.getOriginalFilename(), sheet.getPhysicalNumberOfRows());
//            throw new IllegalArgumentException("excel文件解析失败,最大支持1000条内容数据");
//        }
//        // 返回结果
//        return result;
//    }

//    private static  Workbook getWorkBook(final MultipartFile excelFile) throws Exception {
//        // 获得文件名
//        String fileName = excelFile.getOriginalFilename();
//        // 入参检查
//        if(StringUtils.isEmpty(fileName)){
//            LOGGER.error("[ExcelUtils.getWorkBook][fileName is empty]");
//            throw new IllegalArgumentException("filename is empty");
//        }
//        // 判断文件是否是excel文件
//        if(!fileName.endsWith(SUFFIX_2003) && !fileName.endsWith(SUFFIX_2007)){
//            LOGGER.error("[ExcelUtils.getWorkBook][file name is not excel file][fileName={}]", fileName);
//            throw new IllegalArgumentException("not a excel file");
//        }
//        //获取excel文件的io流
//        InputStream is = excelFile.getInputStream();
//        //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
//        if(fileName.endsWith(SUFFIX_2003)) {
//            //2003
//            return new HSSFWorkbook(is);
//        }else {
//            //2007 及2007以上
//            return new XSSFWorkbook(is);
//        }
//    }

//    private static String getCellValue(Cell cell) {
//        if(null == cell){
//            //LOGGER.error("[ExcelUtils.getCellValue][cell is null]");
//            return null;
//        }
//        // 判断当前Cell的Type
//        switch (cell.getCellType()) {
//            case Cell.CELL_TYPE_NUMERIC:    // 数值类型
//                if (DateUtil.isCellDateFormatted(cell)) {
//                    LOGGER.error("[ExcelUtils.getCellValue][cell type is date format]");
//                    throw new IllegalArgumentException("cell type not support date");
//                }
//                return String.valueOf(cell.getNumericCellValue());
//            case Cell.CELL_TYPE_STRING: // 字符串
//                return cell.getStringCellValue();
//            case Cell.CELL_TYPE_BLANK:// 空值
//                //LOGGER.error("[ExcelUtils.getCellValue][cell type blank]");
//                return "";
//            default:// 默认的Cell值
//                LOGGER.error("[ExcelUtils.getCellValue][cell type not default][cellType={}]", cell.getCellType());
//                throw new IllegalArgumentException("cell type not supported");
//        }
//    }
}