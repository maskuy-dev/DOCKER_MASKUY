/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package msiwms.lib.dto;

import java.util.Map;

/**
 *
 * @author magnaadmin
 */
public class DefaultDtoPagingParams {

    private int offset;
    private int limit;
    // field yang akan diurutkan
    private String sort;

    //descending atau ascending
    private String order;
    private Map<String, Object> search;
    private int maxId;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Map<String, Object> getSearch() {
        return search;
    }

    public void setSearch(Map<String, Object> search) {
        this.search = search;
    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int maxId) {
        this.maxId = maxId;
    }
    
}
