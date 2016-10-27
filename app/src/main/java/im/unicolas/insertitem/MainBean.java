package im.unicolas.insertitem;

/**
 * Created by LeeQ on 2016-10-26.
 * Use :
 */

public class MainBean {
    String content;
    int position;

    public MainBean() {
    }

    public MainBean(String content, int position) {
        this.content = content;
        this.position = position;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
