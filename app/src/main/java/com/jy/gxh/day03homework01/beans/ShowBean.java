package com.jy.gxh.day03homework01.beans;

import java.util.List;

/**
 * Created by GXH on 2019/9/22.
 */

public class ShowBean {

    /**
     * body : {"result":[{"description":"介绍","teacherpowerid":"0"},{"description":"课程","teacherpowerid":1},{"description":"专题","teacherpowerid":"3"}]}
     * code : 200
     * message : Succes!
     */

    private BodyBean body;
    private int code;
    private String message;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class BodyBean {
        private List<ResultBean> result;

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class ResultBean {
            /**
             * description : 介绍
             * teacherpowerid : 0
             */

            private String description;
            private String teacherpowerid;

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getTeacherpowerid() {
                return teacherpowerid;
            }

            public void setTeacherpowerid(String teacherpowerid) {
                this.teacherpowerid = teacherpowerid;
            }
        }
    }
}
