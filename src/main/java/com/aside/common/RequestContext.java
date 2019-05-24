package com.aside.common;

import java.util.HashMap;
import java.util.Map;

    /**
     * request 요청 정보
     *
     * @author 김동택
     */
    @SuppressWarnings("serial")
    public class RequestContext  {

        /**
         * Header: platform_kind, platform_ver, device_id, app_name, app_vers, device_model, device_type, network_type
         */
        private Map<String, String> header = new HashMap<String, String>();

        /**
         * 요청 주소
         */
        private String requestURL;

        /**
         * 요청 주소(이미지를 삭제한 주소)
         */
        private String requestURI;

        /**
         * 요청 메소드
         */
        private String requestMethod;

        /**
         * 접속 아이피
         */
        private String remoteAddr;

        /**
         * 요청 시간 (ms)
         */
        private long requestTime;

        private Integer resultCode;

        private String user_key;

        public RequestContext() {
            setRequestTime(System.currentTimeMillis());
        }

        /**
         * request 에서 설정한 값을 리턴.
         *
         * @param key
         *            키에는 다음과 같은 항목이 존재함. <br/>
         *            {@code platform_kind, platform_ver, device_id, app_name, app_vers, device_model, device_type, network_type}
         * @return 헤더에 설정된 값
         */
        public String getHeader(String key) {
            return header.containsKey(key) ? header.get(key) : null;
        }

        public void setHeader(String agent) {
            if (agent == null || "".equals(agent))
                return;

            String[] array = agent.split("\\;");
            for (String pair : array) {
                String[] duo = pair.split("=");
                if (duo == null || duo.length != 2)
                    continue;
                header.put(duo[0].trim(), duo[1].trim());
            }
        }

        public void addHeader(String param, String value){
            header.put(param.trim(), value.trim());
        }

        /**
         * @return the requestURL
         */
        public String getRequestURL() {
            return requestURL;
        }

        /**
         * @param requestURL
         *            the requestURL to set
         */
        public void setRequestURL(String requestURL) {
            this.requestURL = requestURL;
        }

        /**
         * @return the requestURI
         */
        public String getRequestURI() {
            return requestURI;
        }

        /**
         * @param requestURI
         *            the requestURI to set
         */
        public void setRequestURI(String requestURI) {
            this.requestURI = requestURI;
        }

        /**
         * @return the requestMethod
         */
        public String getRequestMethod() {
            return requestMethod;
        }

        /**
         * @param requestMethod
         *            the requestMethod to set
         */
        public void setRequestMethod(String requestMethod) {
            this.requestMethod = requestMethod;
        }

        /**
         * @return the remoteAddr
         */
        public String getRemoteAddr() {
            return remoteAddr;
        }

        /**
         * @param remoteAddr
         *            the remoteAddr to set
         */
        public void setRemoteAddr(String remoteAddr) {
            this.remoteAddr = remoteAddr;
        }

        /**
         * @return the requestTime
         */
        public long getRequestTime() {
            return requestTime;
        }

        /**
         * @param requestTime
         *            the requestTime to set
         */
        public void setRequestTime(long requestTime) {
            this.requestTime = requestTime;
        }

        // platform_kind, platform_ver, device_id, device_model, device_type, app_name, app_vers, network_type

        public final String getPlatform_kind() {
            return header.get(Constants.PLATFORM_KIND);
        }

        public final String getPlatform_ver() {
            return header.get(Constants.PLATFORM_VER);
        }

        public final String getDevice_id() {
            return header.get(Constants.DEVICE_ID);
        }

        public final String getDevice_model() {
            return header.get(Constants.DEVICE_MODEL);
        }

        public final String getDevice_type() {
            return header.get(Constants.DEVICE_TYPE);
        }

        public final String getApp_name() {
            return header.get(Constants.APP_NAME);
        }

        public final String getApp_vers() {
            return header.get(Constants.APP_VERS);
        }

        public final String getNetwork_type() {
            return header.get(Constants.NETWORK_TYPE);
        }

        public final Boolean isEmulator() {
            return Boolean.valueOf(header.get(Constants.EMULATOR_MODE));
        }

        public final String getDebug() {
            return header.get(Constants.DEBUG_MODE);
        }

        /**
         * debug의 값이 true, Y/y, 1 이라면 true
         *
         * @return
         */
        public final boolean isDebug() {
            if (isEmulator())
                return true;

            String debug = getDebug();
            return Boolean.valueOf(debug) || "y".equalsIgnoreCase(debug) || "1".equals(debug);
        }

        public final String toHeaderString() {
            return String.format("platform_kind=%s;platform_ver=%s;device_id=%s;device_model=%s;device_type=%s;app_name=%s;app_vers=%s;network_type=%s", getPlatform_kind(), getPlatform_ver(), getDevice_id(), getDevice_model(), getDevice_type(), getApp_name(), getApp_vers(), getNetwork_type());
        }



        public final String getUserKey() {
            return user_key;
        }

        public void setResultCode(int code) {
            // TODO Auto-generated method stub
            resultCode = code;
        }

        public Integer getResultCode() {
            // TODO Auto-generated method stub
            return resultCode ;
        }
    }


