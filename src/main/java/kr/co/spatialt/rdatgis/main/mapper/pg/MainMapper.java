package kr.co.spatialt.rdatgis.main.mapper.pg;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;
import org.egovframe.rte.psl.dataaccess.util.EgovMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @파일제목 : MainMapper
 * @패키지명 : kr.co.spatialt.rdatgis.main.mapper
 * @프로젝트명 : rda-tgis
 * @소유 : (주)스패셜티
 * @생성자 : 김언중
 * @생성날짜 : 2023. 07. 07.
 * <p>
 * == 수정사항 ==
 * ---------------------------------------
 * 2023. 07. 07.  김언중 최초 생성
 */
@Mapper
public interface MainMapper {

    //int selectSample();
    EgovMap selectPgSample();
    List<EgovMap> selectPgSample1();
}
