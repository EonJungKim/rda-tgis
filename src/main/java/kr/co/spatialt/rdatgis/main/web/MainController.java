package kr.co.spatialt.rdatgis.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : 김언중
 * @since : 2023. 07. 10.
 * <p>
 * == 수정사항 ==
 * ---------------------------------------
 * 2023. 07. 10.  김언중 최초 생성
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/main")
    public String main() {
        return "main/main";
    }

    @RequestMapping("/board")
    public String board() {
        return "board/board";
    }
}
