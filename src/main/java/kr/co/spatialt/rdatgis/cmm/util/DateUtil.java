package kr.co.spatialt.rdatgis.cmm.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author : 김언중
 * @since : 2023. 07. 10.
 * <p>
 * == 수정사항 ==
 * ---------------------------------------
 * 2023. 07. 10.  김언중 최초 생성
 */
public class DateUtil {

    public final static String SEPARATOR_EMPTY = "";    // 날짜 구분자 - 빈 문자
    public final static String SEPARATOR_SPACE = " ";   // 날짜 구분자 - 공백
    public final static String SEPARATOR_TIME = ":";    // 시간 구분자 - 콜론
    public final static String SEPARATOR_DASH = "-";    // 날짜 구분자 - 대시
    public final static String SEPARATOR_DOT = ".";     // 날짜 구분자 - 점

    public final static String PTN_YY = "yyyy"; // 날짜 변환 패턴 - 연
    public final static String PTN_MM = "MM";   // 날짜 변환 패턴 - 월
    public final static String PTN_DD = "dd";   // 날짜 변환 패턴 - 일
    public final static String PTN_HH = "hh";   // 날짜 변환 패턴 - 시
    public final static String PTN_MI = "mm";   // 날짜 변환 패턴 - 분
    public final static String PTN_SS = "ss";   // 날짜 변환 패턴 - 초

    /**
     * 전달받은 날짜(date)를 문자열로 변환하여 반환
     *
     * @author 김언중
     * @since  2023-07-10
     * @param  date 문자열로 변환할 날짜
     * @return String
     */
    public static String convDateToStr(LocalDate date) {
        return convDateToStr(date, SEPARATOR_EMPTY);
    }

    /**
     * 전달받은 날짜(date)를 전달받은 문자(chr)로 구분한 문자열로 변환하여 반환
     *
     * @author 김언중
     * @since  2023-07-10
     * @param  date 문자열로 변환할 날짜
     * @param  separator 날짜를 구분할 문자 ex) [SEPARATOR_EMPTY, SEPARATOR_SPACE, SEPARATOR_DASH, SEPARATOR_DOT]
     * @return String
     */
    public static String convDateToStr(LocalDate date, String separator) {
        String pattern = PTN_YY + separator + PTN_MM + separator + PTN_DD;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    /**
     * 전달받은 날짜(date)를 전달받은 연산년수(gap)로 연산한 결과를 문자열로 반환
     *
     * @author 김언중
     * @since  2023-07-10
     * @param  date 연산할 날짜
     * @param  gap 연산년수
     * @param  separator 날짜를 구분할 문자 ex) [SEPARATOR_EMPTY, SEPARATOR_SPACE, SEPARATOR_DASH, SEPARATOR_DOT]
     * @return String
     */



/**
  * content
  * 
  * @author 김언중
  * @since  2023-07-11
  * @param  
  * @return 
  */
    public static String calYear(LocalDate date, int gap, String separator) {
        date = gap >= 0 ? date.plusYears(gap) : date.minusYears(gap);
        return convDateToStr(date, separator);
    }

    /**
     * 전달받은 날짜(date)를 전달받은 연산월수(gap)로 연산한 결과를 문자열로 반환
     *
     * @author 김언중
     * @since  2023-07-10
     * @param  date 연산할 날짜
     * @param  gap 연산월수
     * @param  separator 날짜를 구분할 문자 ex) [SEPARATOR_EMPTY, SEPARATOR_SPACE, SEPARATOR_DASH, SEPARATOR_DOT]
     * @return String
     */
    public static String calMonth(LocalDate date, int gap, String separator) {
        date = gap >= 0 ? date.plusMonths(gap) : date.minusMonths(gap);
        return convDateToStr(date, separator);
    }

    /**
     * 전달받은 날짜(date)를 전달받은 연산일수(gap)로 연산한 결과를 문자열로 반환
     *
     * @author 김언중
     * @since  2023-07-10
     * @param  date 연산할 날짜
     * @param  gap 연산일수
     * @param  separator 날짜를 구분할 문자 ex) [SEPARATOR_EMPTY, SEPARATOR_SPACE, SEPARATOR_DASH, SEPARATOR_DOT]
     * @return String
     */
    public static String calDate(LocalDate date, int gap, String separator) {
        date = gap >= 0 ? date.plusDays(gap) : date.minusDays(gap);
        return convDateToStr(date, separator);
    }

    /**
     * 전달받은 문자열(str)을 날짜로 변환하여 반환
     *
     * @author 김언중
     * @since  2023-07-10
     * @param  str 날짜로 변환할 문자열 ex) 20230711
     * @return String
     */
    public static LocalDate getLocalDate(String str) {
        return LocalDate.parse(str, DateTimeFormatter.BASIC_ISO_DATE);
    }

    /**
     * 전달받은 분리자(separator)로 구분되어있는 전달받은 문자열(str)을 날짜로 변환하여 반환
     *
     * @author 김언중
     * @since  2023-07-10
     * @param  str 날짜로 변환할 문자열  ex) ["2023 07 11", "2023-07-11", "2023.07.11"]
     * @param  separator 문자열 구분자    ex) [SEPARATOR_SPACE, SEPARATOR_DASH, SEPARATOR_DOT]
     * @return String
     */
    public static LocalDate getLocalDate(String str, String separator) {
        return getLocalDate(str.replaceAll(separator, SEPARATOR_EMPTY));
    }

    /**
     * 전달받은 종료일자(strEnd)와 전달받은 시작일자(strStart) 사이의 일수를 계산하여 반환
     *
     * @author 김언중
     * @since  2023-07-10
     * @param  strStart 시작일자 ex) "20230710"
     * @param  strEnd 종료일자 ex) "20230711"
     * @return String
     */
    public static int calDiffDays(String strStart, String strEnd) {
        return calDiffDays(getLocalDate(strStart), getLocalDate(strEnd));
    }

    /**
     * 전달받은 종료일자(strEnd)와 전달받은 시작일자(strStart) 사이의 일수를 계산하여 반환
     *
     * @author 김언중
     * @since  2023-07-10
     * @param  strStart 시작일자 ex) ["2023 07 11", "2023-07-11", "2023.07.11"]
     * @param  strStartSep 시작일자 구분자 ex) [SEPARATOR_SPACE, SEPARATOR_DASH, SEPARATOR_DOT]
     * @param  strEnd 종료일자 ex) ex) ["2023 07 11", "2023-07-11", "2023.07.11"]
     * @param  strEndSep 종료일자 구분자 ex) [SEPARATOR_SPACE, SEPARATOR_DASH, SEPARATOR_DOT]
     * @return String
     */
    public static int calDiffDays(String strStart, String strStartSep, String strEnd, String strEndSep) {
        return calDiffDays(getLocalDate(strStart, strStartSep), getLocalDate(strEnd, strEndSep));
    }

    /**
     * 전달받은 종료일자(end)와 전달받은 시작일자(start) 사이의 일수를 계산하여 반환
     *
     * @author 김언중
     * @since  2023-07-10
     * @param  start 시작일자
     * @param  end 종료일자
     * @return String
     */
    public static int calDiffDays(LocalDate start, LocalDate end) {
        return end.compareTo(start);
    }

    /**
     * 전달받은 시간(time)을 문자열로 변환하여 반환
     *
     * @author 김언중
     * @since  2023-07-10
     * @param  time 문자열로 변환할 시간
     * @return String
     */
    public static String convTimeToStr(LocalDateTime time) {
        return convTimeToStr(time, SEPARATOR_DASH, SEPARATOR_EMPTY, SEPARATOR_TIME);
    }

    /**
     * 전달받은 시간(time)을 전달받은 문자(chr)로 구분한 문자열로 변환하여 반환
     *
     * @author 김언중
     * @since  2023-07-10
     * @param  time 문자열로 변환할 시간
     * @param  sepDate 날짜를 구분할 문자 ex) [SEPARATOR_EMPTY, SEPARATOR_SPACE, SEPARATOR_DASH, SEPARATOR_DOT]
     * @param  sepTime 시간을 구분할 문자 ex) [SEPARATOR_EMPTY, SEPARATOR_TIME]
     * @return String
     */
    public static String convTimeToStr(LocalDateTime time, String sepDate, String sepTime) {
        return convTimeToStr(time, sepDate, SEPARATOR_SPACE, sepTime);
    }

    /**
     * 전달받은 시간(time)을 전달받은 문자(chr)로 구분한 문자열로 변환하여 반환
     *
     * @author 김언중
     * @since  2023-07-10
     * @param  time 문자열로 변환할 시간
     * @param  sepDate 날짜를 구분할 문자 ex) [SEPARATOR_EMPTY, SEPARATOR_SPACE, SEPARATOR_DASH, SEPARATOR_DOT]
     * @param  sepDateTime 날짜와 시간 사이를 구분할 문자 ex) [SEPARATOR_EMPTY, SEPARATOR_SPACE]
     * @param  sepTime 시간을 구분할 문자 ex) [SEPARATOR_EMPTY, SEPARATOR_TIME]
     * @return String
     */
    public static String convTimeToStr(LocalDateTime time, String sepDate, String sepDateTime, String sepTime) {
        String pattern = PTN_YY + sepDate + PTN_MM + sepDate + PTN_DD + sepDateTime
                        + PTN_HH + sepTime + PTN_MI + sepTime + PTN_SS;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return time.format(formatter);
    }
}
