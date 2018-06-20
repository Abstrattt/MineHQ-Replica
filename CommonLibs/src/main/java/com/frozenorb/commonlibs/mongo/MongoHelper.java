package com.frozenorb.commonlibs.mongo;

import com.mongodb.MongoClient;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MongoHelper {

    private MongoClient client;

    public MongoHelper(MongoCredentials mongoCredentials) {

    }

}
