package com.jy.entiy.function.marketingFunction.votingManagement;

public class Votedetails {
    private Long id;

    private Long accountid;

    private Integer voteoptionid;

    private String remark;

    private Integer voteid;

    private Integer voteitemid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountid() {
        return accountid;
    }

    public void setAccountid(Long accountid) {
        this.accountid = accountid;
    }

    public Integer getVoteoptionid() {
        return voteoptionid;
    }

    public void setVoteoptionid(Integer voteoptionid) {
        this.voteoptionid = voteoptionid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getVoteid() {
        return voteid;
    }

    public void setVoteid(Integer voteid) {
        this.voteid = voteid;
    }

    public Integer getVoteitemid() {
        return voteitemid;
    }

    public void setVoteitemid(Integer voteitemid) {
        this.voteitemid = voteitemid;
    }
}