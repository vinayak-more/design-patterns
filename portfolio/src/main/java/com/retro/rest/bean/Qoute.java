package com.retro.rest.bean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"c", "c_fix", "ccol", "cp", "cp_fix", "e", "id", "l", "l_cur", "l_fix", "lt", "lt_dts", "ltt",
        "pcls_fix", "s", "t"})
public class Qoute {
    private static final Logger logger = LoggerFactory.getLogger(Qoute.class);
    @JsonProperty("c")
    private String c;
    @JsonProperty("c_fix")
    private String cFix;
    @JsonProperty("ccol")
    private String ccol;
    @JsonProperty("cp")
    private String cp;
    @JsonProperty("cp_fix")
    private String cpFix;
    @JsonProperty("e")
    private String e;
    @JsonProperty("id")
    private String id;
    @JsonProperty("l")
    private String l;
    @JsonProperty("l_cur")
    private String lCur;
    @JsonProperty("l_fix")
    private String lFix;
    @JsonProperty("lt")
    private String lt;
    @JsonProperty("lt_dts")
    private String ltDts;
    @JsonProperty("ltt")
    private String ltt;
    @JsonProperty("pcls_fix")
    private String pclsFix;
    @JsonProperty("s")
    private String s;
    @JsonProperty("t")
    private String t;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("c")
    public String getC() {
        return c;
    }

    @JsonProperty("c")
    public void setC(String c) {
        this.c = c;
    }

    @JsonProperty("c_fix")
    public String getCFix() {
        return cFix;
    }

    @JsonProperty("c_fix")
    public void setCFix(String cFix) {
        this.cFix = cFix;
    }

    @JsonProperty("ccol")
    public String getCcol() {
        return ccol;
    }

    @JsonProperty("ccol")
    public void setCcol(String ccol) {
        this.ccol = ccol;
    }

    @JsonProperty("cp")
    public String getCp() {
        return cp;
    }

    @JsonProperty("cp")
    public void setCp(String cp) {
        this.cp = cp;
    }

    @JsonProperty("cp_fix")
    public String getCpFix() {
        return cpFix;
    }

    @JsonProperty("cp_fix")
    public void setCpFix(String cpFix) {
        this.cpFix = cpFix;
    }

    @JsonProperty("e")
    public String getE() {
        return e;
    }

    @JsonProperty("e")
    public void setE(String e) {
        this.e = e;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("l")
    public String getL() {
        return l;
    }

    @JsonProperty("l")
    public void setL(String l) {
        this.l = l;
    }

    @JsonProperty("l_cur")
    public String getLCur() {
        return lCur;
    }

    @JsonProperty("l_cur")
    public void setLCur(String lCur) {
        this.lCur = lCur;
    }

    @JsonProperty("l_fix")
    public String getLFix() {
        return lFix;
    }

    @JsonProperty("l_fix")
    public void setLFix(String lFix) {
        this.lFix = lFix;
    }

    @JsonProperty("lt")
    public String getLt() {
        return lt;
    }

    @JsonProperty("lt")
    public void setLt(String lt) {
        this.lt = lt;
    }

    @JsonProperty("lt_dts")
    public String getLtDts() {
        return ltDts;
    }

    @JsonProperty("lt_dts")
    public void setLtDts(String ltDts) {
        this.ltDts = ltDts;
    }

    @JsonProperty("ltt")
    public String getLtt() {
        return ltt;
    }

    @JsonProperty("ltt")
    public void setLtt(String ltt) {
        this.ltt = ltt;
    }

    @JsonProperty("pcls_fix")
    public String getPclsFix() {
        return pclsFix;
    }

    @JsonProperty("pcls_fix")
    public void setPclsFix(String pclsFix) {
        this.pclsFix = pclsFix;
    }

    @JsonProperty("s")
    public String getS() {
        return s;
    }

    @JsonProperty("s")
    public void setS(String s) {
        this.s = s;
    }

    @JsonProperty("t")
    public String getT() {
        return t;
    }

    @JsonProperty("t")
    public void setT(String t) {
        this.t = t;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public StockQoute getStockQoute() {
        try {
            return new StockQoute(new Double(this.lFix), new Double(this.pclsFix), 0D);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            logger.error("Error parsing QouteData", e);
            return new StockQoute();
        }
    }
}
