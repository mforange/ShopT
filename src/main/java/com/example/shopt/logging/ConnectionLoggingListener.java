package com.example.shopt.logging;

import net.ttddyy.dsproxy.listener.logging.AbstractQueryLoggingListener;
import net.ttddyy.dsproxy.listener.logging.DefaultQueryLogEntryCreator;

import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

// для логов обращения к БД (бин описан в DataSourceConf)
public class ConnectionLoggingListener extends AbstractQueryLoggingListener {

    private final static Logger LOG = Logger.getLogger(ConnectionLoggingListener.class.getCanonicalName());
    private final DefaultQueryLogEntryCreator creator;

    public ConnectionLoggingListener(DefaultQueryLogEntryCreator creator) {
        this.creator = creator;
        this.loggingCondition = () -> true;
        creator.setMultiline(true);
        setQueryLogEntryCreator(creator);
    }

    @Override
    protected void writeLog(String s) {
        LOG.log(INFO, s);
    }
}