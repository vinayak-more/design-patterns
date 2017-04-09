package com.retro.web.bean;

/**
 * @author Vinayak More
 *
 * @date 09-Apr-2017
 */
public class Constants {
    public enum Market {
        NSE("NSE"), BSE("BSE");

        private String value;

        Market(String s) {
            this.value = s;
        }

        public String toString() {
            return value;
        }
    }
}
