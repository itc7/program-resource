package pers.fpj.util;

import java.io.Serializable;

/**
 *
 * Created by fpj on 2017/11/15 14:28.
 */
public class ResultUtils<T> implements Serializable {

    /**
     * 业务状态码
     */
    private int code;
    /**
     * 数据
     */
    private T data;
    /**
     * 结果描述
     */
    private String msg;

    public ResultUtils() {
    }

    private ResultUtils(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static DataBuilder ok() {
        return new DataBuilder<>(State.OK.code());
    }

    public static DataBuilder created() {
        return new DataBuilder<>(State.CREATED.code());
    }

    public static ResultUtils notFound() {
        return new SimpleBuilder<>()
                .setCode(State.NOT_FOUND.code())
                .setData(null)
                .setMsg(State.NOT_FOUND.phrase())
                .build();
    }

    public static MsgBuilder clientError(int code) {
        return new MsgBuilder<>(code);
    }

    public static MsgBuilder serverError(int code) {
        return new MsgBuilder<>(code);
    }

    public static class MsgBuilder<T> extends Builder<T> {
        public MsgBuilder(int code) {
            this.code = code;
        }

        public ResultUtils<T> msg(String msg) {
            return new SimpleBuilder<T>()
                    .setCode(this.code)
                    .setData(null)
                    .setMsg(msg)
                    .build();
        }
    }

    public static class DataBuilder<T> extends Builder<T> {

        public DataBuilder(int code) {
            this.code = code;
        }

        public ResultUtils<T> data(T data) {
            return new SimpleBuilder<T>()
                    .setCode(this.code)
                    .setData(data)
                    .setMsg(null)
                    .build();
        }
    }

    public static class SimpleBuilder<T> extends Builder<T> {

        public SimpleBuilder<T> setCode(int code) {
            super.code = code;
            return this;
        }

        public SimpleBuilder<T> setData(T data) {
            super.data = data;
            return this;
        }

        public SimpleBuilder<T> setMsg(String msg) {
            super.msg = msg;
            return this;
        }

        public ResultUtils<T> build() {
            return new ResultUtils<T>(code, data, msg);
        }
    }

    private static abstract class Builder<T> {
        int code;
        T data;
        String msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public enum State {
        OK(200, "执行成功"),
        CREATED(201, "创建成功"),
        CLIENT_ERROR(400, "请求失败"),
        NOT_FOUND(404, "资源不存在"),
        SERVER_ERROR(500, "处理失败");

        /**
         * 状态码
         */
        private final int code;
        /**
         * 短语
         */
        private final String phrase;

        State(int code, String phrase) {
            this.code = code;
            this.phrase = phrase;
        }

        public int code() {
            return this.code;
        }
        public String phrase() {
            return this.phrase;
        }
    }
}
