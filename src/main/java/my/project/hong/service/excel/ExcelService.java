package my.project.hong.service.excel;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by kiseokhong on 2020/03/09.
 */
public interface ExcelService {

    void excelDownload(HttpServletResponse response, String type);

}
