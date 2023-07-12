package kr.co.spatialt.rdatgis.cmm.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author : 김언중
 * @since : 2023. 07. 10.
 * <p>
 * == 수정사항 ==
 * ---------------------------------------
 * 2023. 07. 10.  김언중 최초 생성
 */
public class FileUtil {

    private final static String FILE_SEPARATOR = "/";   // 파일 경로 구분자

    /**
      * 전달받은 경로(path)에 전달받은 폴더명(dirNm)과 일치하는 폴더의 존재여부를 반환
      *
      * @author 김언중
      * @since  2023-07-12
      * @param  path 존재여부를 확인할 폴더의 상위 경로
      * @param  dirNm 존재여부를 확인할 폴더명
      * @return boolean 존재여부
      */
    public static boolean chkDir(String path, String dirNm) {
        return chkDir(path + FILE_SEPARATOR + dirNm);
    }

    /**
      * 입력받은 경로(path)에 해당하는 폴더의 존재여부를 반환
      *
      * @author 김언중
      * @since  2023-07-10
      * @param  dirPath 존재여부를 확인할 폴더의 절대경로
      * @return boolean 존재여부
      */
    public static boolean chkDir(String dirPath) {
        if (StrUtil.chkNull(dirPath)) {
            return false;
        }

        File dir = new File(dirPath);
        return dir.exists() && dir.isDirectory();
    }

    /**
      * 전달받은 경로(path)에 전달받은 폴더명(dirNm)으로 폴더 생성
      *
      * @author 김언중
      * @since  2023-07-12
      * @param  path 생성할 폴더의 상위 경로
      * @param  dirNm 생성할 폴더명
      * @return boolean 생성여부
      */
    public static boolean mkDir(String path, String dirNm) {
        return mkDir(path + FILE_SEPARATOR + dirNm);
    }

    /**
      * content
      *
      * @author 김언중
      * @since  2023-07-12
      * @param  dirPath
      * @return boolean
      */
    public static boolean mkDir(String dirPath) {
        if (StrUtil.chkNull(dirPath)) {
            return false;
        }

        if (!chkDir(dirPath)) {
            File dir = new File(dirPath);
            return dir.mkdir();
        }

        return true;
    }

    /**
      * content
      *
      * @author 김언중
      * @since  2023-07-12
      * @param  dirPath
      * @return ArrayList<String>
      */
    public static ArrayList<String> getChildNmList(String dirPath) {
        return getChildNmList(dirPath, StrUtil.STR_EMPTY);
    }

    /**
      * content
      *
      * @author 김언중
      * @since  2023-07-12
      * @param  dirPath
      * @param  ext
      * @return ArrayList<String>
      */
    public static ArrayList<String> getChildNmList(String dirPath, String ext) {
        ArrayList<String> childNmList = new ArrayList<>();

        ArrayList<File> childList = getChildList(dirPath, ext);
        for (File file : childList) {
            childNmList.add(file.getName());
        }

        return childNmList;
    }

    /**
      * content
      *
      * @author 김언중
      * @since  2023-07-12
      * @param  dirPath
      * @return ArrayList<File>
      */
    public static ArrayList<File> getChildList(String dirPath) {
        return getChildList(dirPath, StrUtil.STR_EMPTY);
    }

    /**
      * content
      *
      * @author 김언중
      * @since  2023-07-12
      * @param  dirPath
      * @param  ext
      * @return ArrayList<File>
      */
    public static ArrayList<File> getChildList(String dirPath, String ext) {
        if (chkDir(dirPath)) {
            File dir = new File(dirPath);
            File[] childFileList = dir.listFiles((directory, name) -> name.endsWith(ext));
            return (ArrayList<File>) Arrays.asList(Objects.requireNonNull(childFileList));
        }

        return new ArrayList<>();
    }

    /**
      * content
      *
      * @author 김언중
      * @since  2023-07-12
      * @param  dirPath
      * @return ext
      */
    public static int getChildCnt(String dirPath, String ext) {
        if (chkDir(dirPath)) {
            File dir = new File(dirPath);
            return Objects.requireNonNull(dir.listFiles((directory, name) -> name.endsWith(ext))).length;
        }

        return 0;
    }

    public static boolean rmDir(String path, String dirNm) {
        return rmDir(path + FILE_SEPARATOR + dirNm);
    }

    public static boolean rmDir(String dirPath) {
        if (!chkDir(dirPath)) {
            return false;
        }

        File dir = new File(dirPath);
        File[] childList = dir.listFiles();

        for (File file : Objects.requireNonNull(childList)) {
            if (file.isDirectory()) {
                if (!rmDir(file.getAbsolutePath())) {
                    return false;
                }
            } else {
                if (!file.delete()) {
                    return false;
                }
            }
        }

        return dir.delete();
    }

    /**
      * 전달받은 절대경로(path)의 파일이 존재하는지 여부를 확인하여 반환
      *
      * @author 김언중
      * @since  2023-07-10
      * @param  path 존재 유무를 확인할 파일의 절대경로
      * @return boolean
      */
    public static boolean chkFile(String path) {
        return chkFile(new File(path));
    }

    /**
      * 전달받은 파일(file)이 존재하는지 여부를 확인하여 반환
      *
      * @author 김언중
      * @since  2023-07-10
      * @param  file 존재 유무를 확인할 파일
      * @return boolean
      */
    public static boolean chkFile(File file) {
        return file == null || !file.isFile();
    }

    /**
      * content
      *
      * @author 김언중
      * @since  2023-07-12
      * @param  path
      * @return boolean
      */
    public static boolean rmFile(String path) {
        return rmFile(new File(path));
    }

    /**
      * content
      *
      * @author 김언중
      * @since  2023-07-12
      * @param  file
      * @return boolean
      */
    public static boolean rmFile(File file) {
        if (chkFile(file)) {
            return file.delete();
        }

        return true;
    }
}
