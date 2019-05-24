package com.aside.common;

import java.util.regex.Pattern;

/**
 * 공통 상수 <br/>
 *
 */

public class Constants {

    public static final String ROOT_SERVER_PATH = "http://1.234.20.17:52013";
    public static final String ROOT_FILE_PATH = "/files/";

    public static String getServerImageInfo() {
        return ROOT_SERVER_PATH + ROOT_FILE_PATH;
    }

    public static final String STATUS = "status";
    public static final String EXIST = "exist";
    public static final String LIST = "list";

    public static final String INFO = "info";
    public static final String CATE_PHOTO = "cate_photo";
    public static final String CATE_MUSIC = "cate_music";
    public static final String CATE_VIDEO = "cate_video";

    /*
     * http request
     */
    public static final String START_TIME = "start_time";

    public static final String END_TIME = "end_time";

    public static final String SESSION = "session";

    public static final String SESSION_ID = "session_id";

    public static final String REQUEST_CONTEXT = "context";

    public static final String ACCESS_TOKEN = "access_token";

    /*
     * http request header: platform_kind, platform_ver, device_id, app_name,
     * app_vers, device_model, network_type
     */

    /**
     * 플랫폼의 종류 {@value} : 안드로이드 [android], 아이폰 [iphone], 윈도우폰 [wphone], 기타 [etc]
     */
    public static final String PLATFORM_KIND = "platform_kind";

    /**
     * 플랫폼 버전 {@value}
     */
    public static final String PLATFORM_VER = "platform_ver";

    /**
     * 단말기 아이디 {@value}
     */
    public static final String DEVICE_ID = "device_id";

    /**
     * 단말기 모델 {@value}
     */
    public static final String DEVICE_MODEL = "device_model";

    /**
     * 단말기 타입 {@value}
     */
    public static final String DEVICE_TYPE = "device_type";

    /**
     * 앱 이름 {@value}
     */
    public static final String APP_NAME = "app_name";

    /**
     * 앱 버전 {@value}
     */
    public static final String APP_VERS = "app_vers";

    /**
     * 네트워크 연결 종류 {@value} : Wifi, 3g, lan
     */
    public static final String NETWORK_TYPE = "network_type";

    /**
     * 에뮬레이터 여부 {@value}
     */
    public static final String EMULATOR_MODE = "emulator";

    /**
     * 디버그 여부 {@value}
     */
    public static final String DEBUG_MODE = "debug";

    /**
     * 플랫폼 종류: 윈도우 모바일 {@value}
     */
    public static final String PLATFORM_KIND_WINDOW_PHONE = "10";

    /**
     * 플랫폼 종류: 아이폰 {@value}
     */
    public static final String PLATFORM_KIND_IPHONE = "20";

    /**
     * 플랫폼 종류: 안드로이드 {@value}
     */
    public static final String PLATFORM_KIND_ANDROID = "30";

    /**
     * 플랫폼 종류: 윈도우 탭 {@value}
     */
    public static final String PLATFORM_KIND_WINDOW_TAB = "40";

    /**
     * 플랫폼 종류: iPad {@value}
     */
    public static final String PLATFORM_KIND_IPAD = "50";

    /**
     * 플랫폼 종류: 안드로이드 탭 {@value}
     */
    public static final String PLATFORM_KIND_TAB = "60";

    /**
     * 플랫폼 종류: 기타 {@value}
     */
    public static final String PLATFORM_KIND_ETC = "99";

    /*
     * 기타 상수
     */

    public static final String YES = "Y";

    public static final String NO = "N";
    /**
     * LifeOn user 에서 중복 아이디 사용이나 퇴사자로 프로시저상에서 처리된 사용자
     */
    public static final String USER_LifeOn_NO = "W";

    public static final String USER_PNS_TOKEN_DEL = "P";

    public static final String USER_DEVICE_ID = "D";

    /**
     * 프로필 이미지. Size 93x93
     */
    public static final int THUMBNAIL_SIZE_PROFILE = 93;

    /**
     * 클럽 대표이미지. Size 93x93
     */
    public static final int THUMBNAIL_SIZE_CLUB = 93;

    /**
     * 클럽 글 상세 이미지. Size 292x292
     */
    public static final int THUMBNAIL_SIZE_TOPTIC = 292;

    /**
     * charset set {@value}
     */
    public static final String ENCODING_CHARSET = "UTF-8";

    /**
     * &#64;ID 패턴, 캐스터 (\\uce90\\uc2a4\\ud130)
     */
    public static final Pattern AT_ID_PATTERN = Pattern
            .compile("(^|[^\\w])@((\\uce90\\uc2a4\\ud130)|([^@\\s]{2,15}))");

    /**
     * &#64;ID 패턴 그룹 카운트
     */
    public static final int AT_ID_PATTERN_GROUP_COUNT = 2;

    /**
     * 서비스 이용약관
     */
    public static final String TERMS_KIND_SERVICE = "10";

    /**
     * 개인정보 이용약관
     */
    public static final String TERMS_KIND_USER = "20";

    /**
     * 인증번호 {@value} 자리
     */
    public static final int LENGTH_AUTHORITY = 4;

    /*
     * 파일 구분
     */
    public static final String CHAT_MAKE_DIV_NOMAL = "000";

    public static final String CHAT_MAKE_DIV_IMG = "010";

    public static final String CHAT_MAKE_DIV_MOV = "020";

    public static final String CHAT_MAKE_DIV_SND = "030";

    public static final String CHAT_MAKE_DIV_ETC = "999";

    public static final String CHAT_MAKE_NAME_NOMAL = "일반";

    public static final String CHAT_MAKE_NAME_IMG = "사진";

    public static final String CHAT_MAKE_NAME_MOV = "영상";

    public static final String CHAT_MAKE_NAME_SND = "음성";

    public static final String CHAT_MAKE_NAME_ETC = "기타";

    public static final String DEFAULT_AUTH_LEVEL = "1";

}
