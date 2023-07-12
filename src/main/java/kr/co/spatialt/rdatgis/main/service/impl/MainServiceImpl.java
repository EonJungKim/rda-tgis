package kr.co.spatialt.rdatgis.main.service.impl;

import kr.co.spatialt.rdatgis.main.mapper.pg.MainMapper;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainServiceImpl extends EgovAbstractServiceImpl {
    @Autowired
    private MainMapper mainMapper;

    public void testMapper() {

        System.out.println("==========TEST================");
        System.out.println("==========TEST================");
        System.out.println("==========TEST================");

        System.out.println("postgres " + mainMapper.selectPgSample().toString());

        System.out.println("==========TEST================");
        System.out.println("==========TEST================");
        System.out.println("==========TEST================");

        List<EgovMap> egovPgMap = mainMapper.selectPgSample1();
        for (EgovMap map : egovPgMap) {
            System.out.println("postgres : " + map.toString());
        }

        System.out.println("==========TEST================");
        System.out.println("==========TEST================");
        System.out.println("==========TEST================");

    }
}
