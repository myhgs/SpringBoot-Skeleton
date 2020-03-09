package my.project.hong.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by kiseokhong on 2020/03/08.
 */
public class ExcelDown {

    public static void excelDownload(HttpServletResponse response, String fileName, Object obj, List<?> list) {
        try{
            //Excel Down 시작
            Workbook workbook = new HSSFWorkbook();
            //시트생성
            Sheet sheet = workbook.createSheet(fileName);

            //행, 열, 열번호
            Row row;
            Cell cell;
            int rowNo = 0;

            // 테이블 헤더용 스타일
            CellStyle headStyle = workbook.createCellStyle();

            // 가는 경계선을 가집니다.
            headStyle.setBorderTop(BorderStyle.THIN);
            headStyle.setBorderBottom(BorderStyle.THIN);
            headStyle.setBorderLeft(BorderStyle.THIN);
            headStyle.setBorderRight(BorderStyle.THIN);

            // 배경색은 노란색입니다.
            headStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.YELLOW.getIndex());
            headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // 데이터는 가운데 정렬합니다.
            headStyle.setAlignment(HorizontalAlignment.CENTER);

            // 데이터용 경계 스타일 테두리만 지정
            CellStyle bodyStyle = workbook.createCellStyle();
            bodyStyle.setBorderTop(BorderStyle.THIN);
            bodyStyle.setBorderBottom(BorderStyle.THIN);
            bodyStyle.setBorderLeft(BorderStyle.THIN);
            bodyStyle.setBorderRight(BorderStyle.THIN);

            row = sheet.createRow(rowNo++);

            //시퀀스 생성
            AtomicInteger cellNo = new AtomicInteger(0);

            //헤더 영역 생성
            Map<String,Object> headerMap = ObjectUtil.objectToMap(obj);
            for(String header : headerMap.keySet()){
                cell = row.createCell(cellNo.getAndIncrement());
                cell.setCellStyle(headStyle);
                cell.setCellValue(header);
            }

            // 데이터 부분 생성
            for(Object data : list) {
                row = sheet.createRow(rowNo++);

                //시퀀스 생성
                AtomicInteger dataNo = new AtomicInteger(0);
                Map<String,Object> dataMap = ObjectUtil.objectToMap(data);
                for(String getKey : dataMap.keySet()){
                    cell = row.createCell(dataNo.getAndIncrement());
                    cell.setCellStyle(headStyle);
                    cell.setCellValue(String.valueOf(dataMap.get(getKey)));
                }
            }

            // 컨텐츠 타입과 파일명 지정
            response.setContentType("ms-vnd/excel");
            response.setHeader("Content-Disposition", "attachment;filename="+fileName+".xls");

            // 엑셀 출력
            workbook.write(response.getOutputStream());
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
