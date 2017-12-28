package test.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/4.
 */
public class PageInfo<T> extends ArrayList<T> {
    private Integer pageSize;

    private Integer currpageNo;

    private List<T> result;

    private Integer totalCount;

    private Integer totalPage;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrpageNo() {
        return currpageNo;
    }

    public void setCurrpageNo(Integer currpageNo) {
        this.currpageNo = currpageNo;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
