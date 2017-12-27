package test.demo2;

public class ConfigEntity {
    /**
     * 业务 id 号
     */
    private int id;
    /**
     * 源状态
     */
    private String source;
    /**
     * 目标状态
     */
    private String target;
    /**
     * 触发的事件
     */
    private String event;
    /**
     * 备注信息
     */
    private String info;

    /**
     * 业务类型
     */
    private int type;

    public ConfigEntity(int id, String source, String target, String event, String info, int type) {
        this.id = id;
        this.source = source;
        this.target = target;
        this.event = event;
        this.info = info;
        this.type = type;
    }

    public ConfigEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ConfigEntity{" +
                "id=" + id +
                ", source='" + source + '\'' +
                ", target='" + target + '\'' +
                ", event='" + event + '\'' +
                ", info='" + info + '\'' +
                ", type=" + type +
                '}';
    }
}
