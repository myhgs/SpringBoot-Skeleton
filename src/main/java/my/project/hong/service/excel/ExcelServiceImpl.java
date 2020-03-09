package my.project.hong.service.excel;

import my.project.hong.model.Member;
import my.project.hong.model.code.CommonConst;
import my.project.hong.service.member.mapper.MemberMapper;
import my.project.hong.util.ExcelDown;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by kiseokhong on 2020/03/09.
 */
@Service
public class ExcelServiceImpl implements ExcelService {

    private final MemberMapper memberMapper;

    public ExcelServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public void excelDownload(HttpServletResponse response, String type) {
        if(CommonConst.TYPE_MEMBER.equals(type)){
            ExcelDown.excelDownload(response, CommonConst.TYPE_MEMBER, new Member(), memberMapper.selectMemberList());
        }else{

        }
    }
}
