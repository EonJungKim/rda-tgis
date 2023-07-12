package kr.co.spatialt.rdatgis.cmm.util;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author : 김언중
 * @since : 2023. 07. 10.
 * <p>
 * == 수정사항 ==
 * ---------------------------------------
 * 2023. 07. 10.  김언중 최초 생성
 */
@Slf4j
public class StrUtil {

    public final static String STR_EMPTY = "";

    /**
      * 문자열이 null 또는 빈 문자열인지 여부를 반환
      *
      * @author 김언중
      * @since  2023-07-10
      * @param  str Null 또는 빈 문자열 여부를 체크할 변수
      * @return boolean
      */
    public static boolean chkNull(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
      * 문자열이 "null"인 경우 빈 문자열로 변환하여 반환
      * 
      * @author 김언중
      * @since  2023-07-10
      * @param  str Null 또는 빈 문자열 여부를 체크할 변수
      * @return String
      */
    public static String convNullStr(String str) {
        return chkNull(str) ? STR_EMPTY : str;
    }

    /**
      * 입력받은 객체(obj)가 "Null"인 경우 빈 문자열을, 그 외의 경우 문자열로 변환하여 반환
      *
      * @author 김언중
      * @since  2023-07-10
      * @param  obj 문자열로 변환할 객체
      * @return String
      */
    public static String toStr(Object obj) {
        return obj == null ? STR_EMPTY : obj.toString();
    }

    /**
      * 문자열이 null 또는 빈 문자열인 경우 0, 그 외의 경우 정수로 변환하여 반환
      *
      * @author 김언중
      * @since  2023-07-10
      * @param  str 정수로 변환할 문자열
      * @return int
      */
    public static int toInt(String str) {
        return chkNull(str) ? 0 : Integer.parseInt(str);
    }

    /**
      * 문자열이 null 또는 빈 문자열인 경우 0.0, 그 외의 경우 실수로 변환하여 반환
      *
      * @author 김언중
      * @since  2023-07-10
      * @param str 실수로 변환할 문자열
      * @return double
      */
    public static double toDbl(String str) {
        return chkNull(str) ? 0.0 : Double.parseDouble(str);
    }

    /**
      * 문자열이 null 또는 빈 문자열인 경우 0.0, 그 외의 경우 Bool 값으로 변환하여 반환
      *
      * @author 김언중
      * @since  2023-07-10
      * @param  str Bool 값으로 변환할 문자열
      * @return boolean
      */
    public static boolean toBool(String str) {
        return !chkNull(str) && Boolean.parseBoolean(str);
    }

    /**
      * 문자열(str)을 입력받아 다음을 수행하여 전달받은 길이(len)의 문자열로 반환
      *  1. 문자열의 길이가 전달받은 길이(len)보다 길거나 같은 경우
      *   -> 맨 앞에서 전달받은 길이(len)만큼을 잘라서 반환
      *  2. 문자열의 길이가 전달받은 길이(len)보다 작은 경우
      *   -> 문자열의 왼쪽에 전달받은 문자(chr)을 길이만큼 삽입하여 반환
      *
      * @author 김언중
      * @since  2023-07-10
      * @param  str 길이를 고정할 문자열
      * @param  len 문자열의 길이
      * @param  chr 문자열의 왼쪽에 삽입할 문자
      * @return String
      */
    public static String lPad(String str, int len, String chr) {
        str = convNullStr(str);
        int length = str.length();
        if (length >= len) {
            str = str.substring(0, len);
        } else {
            str = String.valueOf(chr).repeat(Math.max(0, (len - length))) + str;
        }

        return str;
    }

    /**
     * 문자열(str)을 입력받아 다음을 수행하여 전달받은 길이(len)의 문자열로 반환
     *  1. 문자열의 길이가 전달받은 길이(len)보다 길거나 같은 경우
     *   -> 맨 앞에서 전달받은 길이(len)만큼을 잘라서 반환
     *  2. 문자열의 길이가 전달받은 길이(len)보다 작은 경우
     *   -> 문자열의 오른쪽에 전달받은 문자(chr)을 길이만큼 삽입하여 반환
     *
     * @author 김언중
     * @since  2023-07-10
     * @param  str 길이를 고정할 문자열
     * @param  len 문자열의 길이
     * @param  chr 문자열의 오른쪽에 삽입할 문자
     * @return String
     */
    public static String rPad(String str, int len, String chr) {
        str = convNullStr(str);
        int length = str.length();
        if (length >= len) {
            str = str.substring(0, len);
        } else {
            str += String.valueOf(chr).repeat(Math.max(0, (len - length)));
        }

        return str;
    }

    /**
      * 전달받은 문자열(str)을 UTF-8 형식으로 인코딩하여 반환
      * 
      * @author 김언중
      * @since  2023-07-10
      * @param  str UTF-8 형식으로 인코딩할 문자열
      * @return String
      */
    public static String encode(String str) {
        return URLEncoder.encode(convNullStr(str), StandardCharsets.UTF_8);
    }

    /**
      * 전달받은 문자열(str)을 전달받은 형식(charSet)으로 인코딩하여 반환
      * 전달받은 형식(charSet)이 지원하지 않는 인코딩 형식인 경우,
      * encode(String str) 메소드를 호출하여 그 결과를 반환
      * 
      * @author 김언중
      * @since  2023-07-10
      * @param  str 인코딩할 문자열
      * @param  charSet 인코딩 형식
      * @return String
      */
    public static String encode(String str, String charSet) {
        try {
            return URLEncoder.encode(convNullStr(str), charSet);
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage());
            return encode(str);
        }
    }

    /**
      * 전달받은 문자열(str)을 UTF-8 형식으로 디코딩하여 반환
      * 
      * @author 김언중
      * @since  2023-07-10
      * @param  str UTF-8 형식으로 디코딩할 문자열
      * @return String
      */
    public static String decode(String str) {
        return URLDecoder.decode(convNullStr(str), StandardCharsets.UTF_8);
    }

    /**
      * 전달받은 문자열(str)을 전달받은 형식(charSet)으로 디코딩하여 반환
      * 전달받은 형식(charSet)이 지원하지 않는 디코딩 형식인 경우,
      * decode(String str) 메소드를 호출하여 그 결과를 반환
      *
      * @author 김언중
      * @since  2023-07-10
      * @param  str 디코딩할 문자열
      * @param  charSet 디코딩 형식
      * @return String
      */
    public static String decode(String str, String charSet) {
        try {
            return URLDecoder.decode(convNullStr(str), charSet);
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage());
            return decode(str);
        }
    }
}
