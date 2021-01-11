package com.hfxt.tools;

import java.util.ArrayList;
import java.util.List;

public class Pager<T> {
    // 当前页面数
    private int currentPage;

    // 一页中的数量
    private int pageSize;

    // 数据库中的记录总数
    private int total;

    // 总页数
    private int pageCount;

    // 我们开始记录的号码
    private int startRecord;

    // 是否有上一页
    private boolean hasPreviousPage;

    // 是否有下一页
    private boolean hasNextPage;

    // 是否只有一页
    private boolean onlyOnePage;

    // 页面设计记录
    private List<T> pageRecords;

    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * 构造方法，只构造空页.
     */
    public Pager() {
        this(1, 0, 12, new ArrayList());
    }

    /**
     * 构造方法，只构造空页.
     */
    public Pager(int currentPage,int pageSize) {
        this(currentPage, 0, pageSize, new ArrayList());
    }

    /**
     * 默认构造方法.
     *
     * @param currentPage
     *            本页数据在数据库中的起始位置
     * @param totalSize
     *            数据库中总记录条数
     * @param pageSize
     *            本页容量
     * @param data
     *            本页包含的数据
     */
    public Pager(int currentPage, int totalSize, int pageSize, List data) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.total = totalSize;
        this.pageRecords = data;
    }

    /**
     * 确保页面在总页面范围内
     *
     * @param currentPage
     *            current page
     */
    public void setCurrentPage(int currentPage) {
        /*if (currentPage < 1) {
            this.currentPage = 1;
            return;
        }
        if (currentPage > getPageCount()) {
            this.currentPage = getPageCount();
            return;
        }*/
        this.currentPage = currentPage;
    }

    /**
     * 获取每页数量
     *
     * @return page size number
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置每页数量
     *
     * @param pageSize
     *            page size number
     */
    public void setPageSize(int pageSize) {
        if (pageSize <= 0) {
            this.pageSize = 1;
        } else {
            this.pageSize = pageSize;
        }
    }

    /**
     * 得到总记录
     *
     * @return total record's number
     */
    public int getTotal() {
        return total;
    }

    /**
     * 设置总记录
     *
     * @param totalRecords
     *            total record number
     */
    public void setTotal(int totalRecords) {
        this.total = totalRecords;
    }

    /**
     * 获取页面的总数
     *
     * @return count number
     */
    public int getPageCount() {
        // If there is no data in database.
        if (total == 0) {
            pageCount = 1;
            return pageCount;
        }
        boolean isZero = total % pageSize == 0;
        pageCount = total / pageSize;
        pageCount = isZero ? pageCount : pageCount + 1;
        return pageCount;
    }

    /**
     * First record of one page
     * 一页的第一条记录
     *
     * @return start records
     */
    public int getStartRecord() {
        startRecord = ((currentPage - 1) * pageSize);
        return startRecord;
    }

    /**
     * Whether has previous page
     * 是否有上一页
     *
     * @return if previous page's is exist,return true else not
     */
    public boolean isHasPreviousPage() {
        hasPreviousPage = (currentPage == 1) ? false : true;
        return hasPreviousPage;
    }

    /**
     * Whether has next page
     * 是否有下一页
     *
     * @return if next page's is exist,return true else not
     */
    public boolean isHasNextPage() {
        hasNextPage = (currentPage == getPageCount()) ? false : true;
        return hasNextPage;
    }

    /**
     * Whether is only one page
     *
     * @return if only one page,return true else not
     */
    public boolean isOnlyOnePage() {
        onlyOnePage = ((getPageCount() == 1) ? true : false);
        return onlyOnePage;
    }


    /**
     * 查询到的所有的记录
     * @return the pageRecords
     */
    public List<T> getPageRecords() {
        return pageRecords;
    }

    public void setPageRecords(List<T> pageRecords) {
        this.pageRecords = pageRecords;
    }
}
