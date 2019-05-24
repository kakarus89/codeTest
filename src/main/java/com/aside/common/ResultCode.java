package com.aside.common;

public enum ResultCode {
    /** 성공 */
    SUCCESS(0, "common.success")
    /** 성공 */

    ,FAIL(1, "common.fail")

    /*
     * Common errors (1xx)
     */

    /** 서버 내부 오류 */
    , INTERNAL_ERROR(100,  "common.internal")

    /** 알 수 없는 오류 */
    , RUNTIME_ERROR(101,  "common.unknown")

    /** 데이타베이스 접속 오류 */
    , DATABASE_ERROR(102, "common.database")

    /** 파라미터 오류 */
    , PARAMETER_ERROR(103,  "common.internal.parameter")

    /** 404 Not Found */
    , NOT_FOUND_ERROR(104,  "common.not_found")

    /** 인증 오류 */
    , UNAUTHORIZED_ERROR(105,  "common.unauthorized")

    /** 올바르지 않은 App-Agent */
    , INVALID_APP_AGENT_ERROR(106,  "common.invalid.app-agent")

    /** 데이타베이스 실행 오류 */
    , DATABASE_EXECUTE(107,  "common.database.execute")

    , NOT_SUPPORTED(108,  "common.not_supported")


    /*
     * 사용자  (2xx)
     */

    /** 동일한 사용자 정보가 존재합니다. */
    , USER_INFO_EXIST(201, "user.info.exist")

    /** 디바이스가 이미 등록되었습니다 */
    , USER_EXIST_DEVICE_NUM(202,  "user.exist.device.num")

    /** 아이디가 이미 존재 합니다 */
    , USER_ID_DUPLICATE(203, "user.id.duplicate")

    /** 없는 아이디 입니다 */
    , USER_ID_NOT_EXIST(204, "user.id.not.exist")

    /** 패스워드가 일치하지 않습니다 */
    , USER_PW_INCORRECT(205, "user.pw.incorrect")

    /** 이미 로그인 되어 있습니다. */
    , USER_EXIST_LOG_IN(206, "user.exist.log.in")

    /** 이미 친구 요청을 하였습니다. */
    , FRIEND_REQUEST_EXIST(207, "friend.request.exist")

    /** 이미 친구 입니다. */
    , FRIEND_EXIST(208, "friend.exist")

    /** 차단한 사용자 입니다. */
    , DEL_OTHER_USER(209, "del.other.user")

    /** 차단당한 사용자 입니다. */
    , BLOCKED_USER(210, "blocked.user")

    /** 이미 가입된 카페입니다.. */
    , JOIN_CAFE_EXIST(211, "join.cafe_exist")

    /** 사용자가 존재하지 않습니다 */
    , USER_NOT_EXIST(212,  "user.not.exist")

    /*
     * 마일리지 관련  (3xx)
     */

    /** 마일리지가 모자랍니다. */
    , SHORT_OF_MILES(301, "short.of.miles")
    /** 방장이 있습니다.	 */
    , OWNER_EXIST(302, "owner.exist")
    /** 이미 포인트를 보냈습니다. */
    , POINT_EXIST(303, "point.exist")

    /*
     * 대회 관련  (4xx)
     */

    /** 해당 기간에 다른 대회가 존재합니다. */
    , BATTLE_EXISTS(401, "battle_exists")

    /** 이미 참석중인 대회입니다. */
    , ATTENDING_BATTLE(402, "attending_battle")




    /*
     * 파일, 유틸리티  (9xx)
     */
    /** 매치가 되는 파일이 없습니다*/
    , FILE_TYPE_NOT_MATCH(900,  "file.type.not.match")

    /** 매치가 되는 파일이 없습니다*/
    , FAIL_FILE_UPLOAD(901,  "fail.file.upload")

    /** 매치가 되는 파일이 없습니다*/
    , FAIL_FILE_MAKE(902, "fail.file.make")

    /** 매치가 되는 파일이 없습니다*/
    , FILE_NOT_EXIST(903, "file.not.exist");


    /**
     * 결과 코드
     */
    private final int value;

    /**
     * 메시지 코드
     */
    private final String message;

    /**
     * 결과 코드
     */
    public int value() {
        return this.value;
    }

    /**
     * 메시지 코드
     */
    public String message() {
        return message;
    }

    private ResultCode(int value, String message) {
        this.value = value;
        this.message = message;
    }
}

