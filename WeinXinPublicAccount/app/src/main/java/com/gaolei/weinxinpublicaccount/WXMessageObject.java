package com.gaolei.weinxinpublicaccount;

import java.util.List;

/**
 * Created by Administrator on 2015/12/10.
 */
public class WXMessageObject {

    private String media_id;
    private long  update_time;
    private Content content;


    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(long update_time) {
        this.update_time = update_time;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public static class Content {
        public List<NewsItemObject> news_item;

        public List<NewsItemObject> getNews_item() {
            return news_item;
        }

        public void setNews_item(List<NewsItemObject> news_item) {
            this.news_item = news_item;
        }
    }

    public class NewsItemObject {
        public String title, thumb_media_id, show_cover_pic, author, digest, content, url, content_source_url,update_time;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getThumb_media_id() {
            return thumb_media_id;
        }

        public void setThumb_media_id(String thumb_media_id) {
            this.thumb_media_id = thumb_media_id;
        }

        public String getShow_cover_pic() {
            return show_cover_pic;
        }

        public void setShow_cover_pic(String show_cover_pic) {
            this.show_cover_pic = show_cover_pic;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getContent_source_url() {
            return content_source_url;
        }

        public void setContent_source_url(String content_source_url) {
            this.content_source_url = content_source_url;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }
    }
}
