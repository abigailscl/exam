package com.exam.cabascango.exam.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class ApplicationValues {
    final String user;
    final String pasword;
    final String cluster;
    final String dbname;

    ApplicationValues(@Value("${mongo.user}")String user, 
    @Value("${mongo.pasword}")String pasword,
    @Value("${mongo.cluster}")String cluster,
    @Value("${mongo.dbname}")String dbname){

        this.user = user;
        this.pasword = pasword;
        this.cluster = cluster;
        this.dbname = dbname;
    }
}
