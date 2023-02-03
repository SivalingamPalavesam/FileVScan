package com.filescan.dto;

import java.io.Serializable;

public class Ping implements Serializable
{
    long time ;
    boolean clamavAvailable ;

    private Ping() {}

    public long getTime() {
        return time;
    }

    public boolean isClamavAvailable() {
        return clamavAvailable;
    }


    public static final class PingBuilder {
        long time ;
        boolean clamavAvailable ;

        private PingBuilder() {
        }

        public static PingBuilder aPing() {
            return new PingBuilder();
        }

        public PingBuilder withTime(long time) {
            this.time = time;
            return this;
        }

        public PingBuilder withClamavAvailable(boolean clamavAvailable) {
            this.clamavAvailable = clamavAvailable;
            return this;
        }

        public Ping build() {
            Ping ping = new Ping();
            ping.clamavAvailable = this.clamavAvailable;
            ping.time = this.time;
            return ping;
        }
    }
}
